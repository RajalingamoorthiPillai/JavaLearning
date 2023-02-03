
set APP_ROOT=.

set SRC=%APP_ROOT%\src

set CLASSES=%APP_ROOT%\classes

set CP=%CLASSES%\data;%CLASSES%\finance;%CLASSES%\furnitures

javac  -d %CLASSES%\data  %SRC%\data\*.java

javac -d %CLASSES%\finance  %SRC%\finance\*.java

javac  -d %CLASSES%\furnitures %SRC%\furnitures\*.java

javac -d %CLASSES% -cp %CP%  %SRC%\FurnitureApp.java