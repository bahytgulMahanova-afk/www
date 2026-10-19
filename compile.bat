@echo off
REM Maven-siz jiynau: Tomcat-tyn lib/servlet-api.jar paidalanylady
set /p TOMCAT_HOME=Tomcat papkasyn engizinis (mysaly C:\apache-tomcat-10.1.30): 
if exist build rmdir /s /q build
mkdir build\registration\WEB-INF\classes
javac -encoding UTF-8 -cp "%TOMCAT_HOME%\lib\servlet-api.jar" -d build\registration\WEB-INF\classes src\main\java\kz\edu\RegisterServlet.java
if errorlevel 1 (echo JAVAC KATE! & pause & exit /b 1)
xcopy /e /i /y src\main\webapp build\registration
xcopy /e /i /y build\registration "%TOMCAT_HOME%\webapps\registration"
echo.
echo Daiyn! Endi Tomcat-ty iske qosyniz: %TOMCAT_HOME%\bin\startup.bat
echo Brauzerde ashynyz: http://localhost:8080/registration/
pause
