#sql2csv

The aim of this tool is to provide a fast way to create a CSV from a SQL result.
It writes to standard output so you can then use \*nix tools to customize report or do something else.

The specifications used to develop this software have been obtained [here](http://tools.ietf.org/html/rfc4180#page-2)

###Usage

```
java -classpath "ojdbc6-11.2.0.3.0.jar:sql2csv.jar" sql2csv.Sql2Csv 
    --jdbc-driver "oracle.jdbc.OracleDriver" 
    --jdbc-url jdbc:oracle:thin:@//mydb:1521/mysid 
    --username myuser 
    --password mypassword 
    --sql "SELECT province AS \"Province\", zone AS \"Zone\", description AS \"Description\" FROM province_zone" 
    --field-separator "|" 
    --header
```

output is:

```
Province|Zone|Description
AL|1|Alessandria
AN|3|Ancona
BO|2|Bologna
FI|3|Firenze
GE|1|Genova
LO|1|Lodi
MI|1|Milano
NU|3|Nuoro
PD|2|Padova
PG|3|Perugia
RM|3|Roma
TO|1|Torino
VA|1|Varese
```

###Help

The help says:

```
usage: java [-Dparameter=value]... -classpath "<JDBC_DRIVER_JAR>:sql2csv.jar"
            sql2csv.Sql2Csv [OPTIONS...]
  where <JDBC_DRIVER_JAR> is a jar containing the JDBC driver to use.
The software executes specified SQL and format results to standard output as a
CSV.
Binding parameters are supported using System properties (e.g. passing
-Dmyvalue=5 you can use that value in the SQL using :myvalue)
  -D,--jdbc-driver <CLASSNAME>  the JDBC driver
  -F,--field-separator <TEXT>   set field separator (default is ',')
  -H,--header                   show the header on first row (please use AS
                                statement with double quoted field names in
                                order to define header case. E.g. SELECT x AS
                                "MyField" etc...)
     --help                     show this help
  -P,--sql-file <PATH>          the path of a file containing the SQL to execute
  -p,--password <PASSWORD>      the password
  -S,--sql <SQL>                the SQL to execute
  -U,--jdbc-url <URL>           the JDBC url
  -u,--username <USERNAME>      the username
Exit status:
0  : if OK
1  : if an error occurs
2  : on a syntax error
Example:
java -Dsearch=n
-classpath "ojdbc6-11.2.0.3.0.jar:sql2csv.jar" sql2csv.Sql2Csv
--jdbc-driver "oracle.jdbc.OracleDriver"
--jdbc-url jdbc:oracle:thin:@//myhost:1521/mysid
--username myuser --password mypassword
--sql "SELECT province AS \"Province\", zone AS \"Zone\", description AS
\"Description\" FROM province_zone WHERE description LIKE '%' || :search || '%'"
```
