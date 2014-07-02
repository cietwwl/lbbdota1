rem install gradle to run this bat
rem http://www.gradle.org/docs/current/userguide/userguide_single.html#installation
cd generator
call gradle :run -PmainClass=com.lbb.dota.Main
xcopy ..\generated\server\java\dota\config\generated\*.java ..\..\..\src\dota\config\generated\ /Q /S /Y
xcopy ..\generated\server\json\*.json ..\..\..\resource /Q /S /Y
pause
