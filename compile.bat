@echo off
setlocal

set CP=.;lib\gson-2.11.0.jar;lib\mysql-connector-j-8.4.0.jar
set OUT=out

mkdir %OUT%

javac -cp %CP% -d %OUT% com\sakila\models\*.java com\sakila\controllers\*.java com\sakila\util\*.java com\sakila\*.java

endlocal
