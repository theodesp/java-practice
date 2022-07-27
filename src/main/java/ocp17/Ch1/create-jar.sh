#!/bin/bash

jar --create --verbose --file myNewFile.jar .

# Short format
# jar -cvf myNewFile.jar .

# specify a directory instead of using the current directory
# jar -cvf myNewFile.jar -C dir .
