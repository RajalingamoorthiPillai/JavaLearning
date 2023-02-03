@echo off
set APP_ROOT=.

set SRC=%APP_ROOT%\src

set CLASSES=%APP_ROOT%\classes

set CP=%CLASSES%;%SRC%;.\thirdpartysrc


javac -d %CLASSES% -cp %CP%  %SRC%\in\conceptarchitect\app\FurnitureApp.java