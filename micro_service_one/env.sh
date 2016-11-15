#!/usr/bin/env bash

export SERVICE_NAME="micro_svc_one"
export SERVICE_IMAGE="docker_dx/${SERVICE_NAME}"
export SERVICE_DB_IMAGE=${SERVICE_IMAGE}-db
export SERVICE_DB_NAME=${SERVICE_NAME}-db
#export REGISTRY_URL=docker.studio.disney.com
