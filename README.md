# Тіркелу формасы — Servlet (Tomcat 10 / 11 (jakarta.servlet))

## 1-жол: compile.bat (Maven керек емес)
1. Tomcat папкасының жолын біліңіз (ішінде bin, lib, webapps бар папка).
2. compile.bat файлын екі рет басыңыз → Tomcat папкасының жолын енгізіңіз.
3. Tomcat-ты іске қосыңыз: `<Tomcat>\bin\startup.bat`
4. Браузерде: http://localhost:8080/registration/

## 2-жол: Maven
`mvn clean package` → `target/registration.war` файлын Tomcat/webapps ішіне көшіріңіз → Tomcat қосыңыз.

## Visual Studio Code
Папканы ашыңыз (File → Open Folder). Java Extension Pack + Community Server Connectors / Tomcat for Java
кеңейтулерін қойсаңыз, "Run on Tomcat" жасауға болады.
