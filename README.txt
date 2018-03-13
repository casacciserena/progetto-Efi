-To run the backend application
"mvn spring-boot:run"
"mvn package && java -jar target/backend.war"
"mvn package && java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8080,suspend=n \-jar target/backend.war"