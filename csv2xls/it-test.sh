#! /bin/sh

java -Dapplication.launcher=csv2xls -jar target/csv2xls.jar --template src/test/resources/template.xls --output ~/Desktop/output.xls src/test/resources/employees.csv
