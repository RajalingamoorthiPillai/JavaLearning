@echo off
set APP_ROOT=.

set SRC=%APP_ROOT%\src

set CLASSES=%APP_ROOT%\classes

set CP=%CLASSES%;%SRC%;.\thirdpartysrc

set DIST=%app_root%\dist

javac -d %CLASSES% -cp %CP%  %SRC%\in\conceptarchitect\app\FurnitureApp.java


md %dist%

cd %classes%

jar -cfe ..\dist\app.jar in.conceptarchitect.app.FurnitureApp .

cd %app_root%