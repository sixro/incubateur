csv2xls
=======

A simple tool to obtain excels from CSVs

## Usage

```
usage: java -jar csv2xls.jar [OPTIONS...]
java -jar csv2xls.jar 0.1-SNAPSHOT
Transform CSV to XLS. Input can be specified as files at the end of options,
otherwise standard input is used.
  -t,--template      Template of XLS to use
  -s,--sheet <arg>   Sheet index to process (default is 1)
  -o,--output <arg>  Excel output filepath
  -v,--version       Show version
  -?,--help          Show this help
Exit status:
0  : if OK
1  : if an error occurs
2  : on a syntax error
```
