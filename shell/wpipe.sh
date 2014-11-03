#!/bin/bash

pipe=/tmp/testpipe

if [[ ! -p $pipe ]]; then
    echo "Reader not running"
    exit 1
fi

if [[ "$1" ]]; then
    echo "$1" > $pipe
else
    # $$ is the pid of the current script
    echo "Hello from $$" > $pipe
fi
