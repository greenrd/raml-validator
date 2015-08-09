#! /bin/bash
if [ "$#" -ne 1 ]; then
    echo "Usage: $0 path_to_raml" >&2
    exit 1
else
    java -jar target/scala-2.11/raml-validator-assembly-1.0.jar -r $1 -v 
fi
