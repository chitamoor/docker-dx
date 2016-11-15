#!/usr/bin/env bash

export SERVICE="primary_svc"
export SERVICE_IMAGE="docker_dx/${SERVICE}"
export DB_SERVICE=${SERVICE}-db
export DB_SERVICE_IMAGE=${SERVICE_IMAGE}-db
#export REGISTRY_URL=docker.studio.disney.com
