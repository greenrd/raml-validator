# Validator for raml documents

Directory /scripts contains scripts for both windows and linux.

## Windows scripts

You can validate a raml file using:

```
    .\validate.bat path_to_raml
```

and compile raml into one file with:

```
    .\compile.bat path_to_raml new_raml_file
```

alternatively you can put a script and jar file into directory with raml and double click it.
I assumes name raml file is called *api.raml*.

## Linux scripts

You can validate a raml file using:

```
    .\validate.sh path_to_raml
```

and compile raml into one file with:

```
    .\compile.sh path_to_raml new_raml_file
```

## Using jar file

To validate using the jar use:

```
    java -jar raml-validator-assembly-1.0.jar -r :path_to_raml: -v
```

and compile into one file with:

```
    java -jar raml-validator-assembly-1.0.jar -r :path_to_raml: -c :new_file_name:
```