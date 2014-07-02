rem install gradle to run this bat
rem http://www.gradle.org/docs/current/userguide/userguide_single.html#installation
@echo off

cd generator
call gradle :run -PmainClass=com.qyyl.hxfs.Main

set CS_OUT=generated\client\cs\*.cs
set CLIENT_CS_DIR=..\..\client\trunk\Assets\Scripts\HXFS\Config\Generated

set JSON_OUT=generated\client\json\*.json
set CLIENT_JSON_DIR=..\..\client\trunk\Assets\Resources\Config

:: move cs to client folder
cd ..

if not exist %CLIENT_CS_DIR% (md %CLIENT_CS_DIR%)
if not exist %CLIENT_JSON_DIR% (md %CLIENT_JSON_DIR%)

ECHO xcopy %CS_OUT% %CLIENT_CS_DIR%
xcopy /Q /S /Y  %CS_OUT% %CLIENT_CS_DIR%

ECHO xcopy %JSON_OUT% %CLIENT_JSON_DIR%
xcopy /Q /S /Y  %JSON_OUT% %CLIENT_JSON_DIR%

pause
