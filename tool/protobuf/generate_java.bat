@echo off
setLocal EnableDelayedExpansion

set JAVA_OUT=..\\..\\src
echo "debug 1"
echo %JAVA_OUT%
rmdir /S /Q %JAVA_OUT%\\dota\\enums
echo "debug 2"
mkdir %JAVA_OUT%\\dota\\enums
echo "debug 3"
set PROTOC_CMD=protoc-2.5.0-win32\protoc -I=protos --java_out=%JAVA_OUT%
echo "debug 4"
for /D %%f in (protos/*) do (
  set PROTOC_CMD=!PROTOC_CMD! protos\%%f\*.proto
)

echo %PROTOC_CMD%
call %PROTOC_CMD%

pause