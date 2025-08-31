#!/bin/bash

BROWSER=$1
if [ -z "$BROWSER" ]; then
  BROWSER="chrome"
fi

mvn clean test -DbrowserName=$BROWSER

