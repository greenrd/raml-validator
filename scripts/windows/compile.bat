set argC=0
for %%x in (%*) do Set /A argC+=1

IF NOT %argC%==2 (
    java  -jar raml-validator-assembly-1.0.jar -r .\api.raml -c full_api.raml
)  ELSE (
    java  -jar ..\raml-validator-assembly-1.0.jar -r %1 -c %2 
)

pause