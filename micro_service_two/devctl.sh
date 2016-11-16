#!/usr/bin/env bash
#
# Wrapper script that controls the developer workflow
#

if [ ! -f ./env.sh ]; then
    echo "env.sh file missing. Please create one!"
fi

source ./env.sh

stop-container() {
  local container=$1
  docker stop $container >/dev/null
}

remove-container() {
  local container=$1
  docker rm $container >/dev/null
}

remove-image() {
  local image=$1
  docker rmi $image >/dev/null
}

cleanup-images() {
  local images=$(docker images --filter dangling=true -q)
  for image in ${images[@]}; do
    echo "Removing dangling image: $image"
    remove-image $image
  done
}

fn-remove-non-running-containers() {
  declare desc="Removes all non-running containers"

  local containers=$(docker ps -a -q)
  for container in ${containers[@]}; do
    local state=$(docker inspect --format "{{.State.Running}}" $container)
    if [[ "$state" == "false" ]]; then
      remove-container $container
    fi
  done
}

fn-remove-image() {
  declare desc="Removes the image of a given service"
  IMAGE=${1-${SERVICE_IMAGE}}
  echo "Removing image: ${IMAGE}..."
  docker rmi $IMAGE
}


cmd-cleanup() {
  declare desc="Cleans up all non-running containers and images!"
  echo "Initiating clean up of containers and images"
  fn-remove-non-running-containers
  cleanup-images
}

cmd-init() {
  declare desc="Initialize the local dev env"
  echo "Initializing the Dev env..."
  # create necessary directories needed for the app
  if [ -f ./init.sh ]; then
    echo "Invoking project's init script"
    source ./init.sh
  fi
}

cmd-login() {
  declare desc="Login to to a given service's container. Uses 'primary' service by default"
  # get the name of the service dynamically
  SERVICE=${1-${SERVICE}}
  SERVICE_CONTAINER="docker_${SERVICE}_1"
  docker exec -it  ${SERVICE_CONTAINER}  /bin/bash
}

cmd-build-service() {
  declare desc="Builds the 'primary' service"
  SERVICE=${1-${SERVICE}}
  IMAGE=${2-${SERVICE_IMAGE}}
  cmd-stop-service ${SERVICE}
  fn-remove-non-running-containers
  fn-remove-image ${IMAGE}
  mvn package # or gradle build
  docker-compose -f ./docker/docker-compose.yml build ${SERVICE}
}

cmd-start-service() {
  declare desc="Starts a given service. Uses 'primary' service by default"
  SERVICE=${1-${SERVICE}}
  echo "Starting ${SERVICE}..."
  docker-compose -f ./docker/docker-compose.yml up -d ${SERVICE}
}

cmd-stop-service() {
  declare desc="Stops down a given service. Uses 'primary' service by default"
  SERVICE=${1-${SERVICE}}
  echo "Stopping ${SERVICE}..."
  docker-compose -f ./docker/docker-compose.yml stop ${SERVICE}
}

cmd-restart-service() {
  declare desc="Restarts a given service. Uses 'primary' service by default"
  SERVICE=${1-${SERVICE}}
  echo "Restarting ${SERVICE}..."
  docker-compose -f ./docker/docker-compose.yml restart ${SERVICE}
}

cmd-build-db() {
  declare desc="Builds the DB image required for the DB service"
  cmd-stop-service ${DB_SERVICE}
  fn-remove-non-running-containers
  fn-remove-image ${DB_SERVICE_IMAGE}
  docker-compose -f ./docker/docker-compose.yml build ${DB_SERVICE}

}

cmd-start-db() {
  declare desc="Starts the primary service's DB"
  cmd-start-service ${DB_SERVICE}
}

cmd-stop-db() {
  declare desc="Stops the primary service's DB"
  cmd-stop-service ${DB_SERVICE}
}

cmd-restart-db() {
  declare desc="Restarts the primary service's DB"
  cmd-restart-service ${DB_SERVICE}
}

cmd-push-image() {
  declare desc="Pushes the images to the Private Registry"
  VERSION=$1
  echo "Pushing Image: $SERVICE_IMAGE:${VERSION} to Private Repo: $REGISTRY_URL ...."
  docker tag ${SERVICE_IMAGE} ${SERVICE_IMAGE}:${VERSION}
  docker tag ${SERVICE_IMAGE}:${VERSION} ${REGISTRY_URL}/${SERVICE_IMAGE}:latest
  docker tag ${SERVICE_IMAGE}:${VERSION} ${REGISTRY_URL}/${SERVICE_IMAGE}:${VERSION}
  docker push ${REGISTRY_URL}/${SERVICE_IMAGE}:latest
  docker push ${REGISTRY_URL}/${SERVICE_IMAGE}:${VERSION}
}

cmd-start-stack() {
  declare desc="Starts the primary service and all the dependent services in the service stack. Launches separate DB instances"
  echo "Launching application stack with DB instances"
  docker-compose -f ./docker/docker-compose.yml up -d
}

cmd-stop-stack() {
  declare desc="Stops all the services in the service stack"
  echo "Stopping all services"
  docker-compose -f ./docker/docker-compose.yml stop
}

cmd-stop-stack-min() {
  declare desc="Stops all the services in the service stack"
  echo "Stopping all services"
  docker-compose -f ./docker/docker-compose-with-no-db.yml stop
}

cmd-restart-stack() {
  declare desc="Restarts all the services in the service stack"
  echo "Restarting all services"
  docker-compose -f ./docker/docker-compose.yml restart
}

cmd-ps() {
  declare desc="List all containers"
  docker ps -a
}

cmd-status() {
  declare desc="Status of all the services in the service stack"
  docker-compose -f ./docker/docker-compose.yml ps 
}

cmd-images() {
  declare desc="Lists all docker images"
  docker images
}

cmd-ports() {
  declare desc="Show port mappings for running containers"

  local containers=$(docker ps -q)
  for container in ${containers[@]}; do
    echo "Container $container: $(docker port $container)"
  done
}

cmd-help() {
  declare desc="Shows help information for a command"
  declare command="$1" showsource="${2:-true}"

  if [[ "$command" ]]; then
    echo "$command $(extract-args $command)"
    echo "  $(extract-desc $command)"
    echo
    if [[ "$showsource" = "true" ]]; then
      type cmd-$command | tail -n +2
      echo
    fi
  else
    echo; for cmd in $(list-cmds); do cmd-help $cmd false; done
  fi
}

extract-args() {
  local line=$(type cmd-$1 | grep declare | grep -v "declare desc" | head -1)
  echo -e "${line// /\\n}" | awk -F= '/=/{print "<"$1">"}' | tr "\n" " "
}

extract-desc() {
  eval "$(type cmd-$1 | grep desc | head -1)"; echo $desc
}

list-cmds() {
  declare -F | grep "\-f cmd-" | awk -Fcmd- '{print $2}'
}

main() {
  local cmd="$1"; shift || true
  if type cmd-$cmd &> /dev/null; then
    cmd-$cmd $@
  else
    if [[ -n $cmd ]]; then
      echo "No such command: $cmd"
      echo
    fi
    echo "Available commands:"
    list-cmds | sed "s/^/  /"
    echo
    exit 2
  fi
}

main $@

