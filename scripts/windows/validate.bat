set argC=0
for %%x in (%*) do Set /A argC+=1

IF NOT %argC%==1 (
    java  -jar raml-validator-assembly-1.0.jar -r .\api.raml -v 
)  ELSE (
    java  -jar ..\raml-validator-assembly-1.0.jar -r %1 -v 
)

pause