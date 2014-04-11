#! /bin/bash
if [ "$#" -ne 2 ]; then
    echo "Usage: ./validate.sh path_to_raml"
else
    java  -jar raml-validator-assembly-1.0.jar -r $1 -v 
fi
