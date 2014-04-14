#! /bin/bash
if [ "$#" -ne 2 ]; then
    echo "Usage: ./compile.sh path_to_raml path_to_new_raml"
else
    java  -jar ../raml-validator-assembly-1.0.jar -r $1 -c $2 
fi

