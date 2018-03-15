-To run the backend application
"mvn spring-boot:run"
"mvn package && java -jar target/backend.war"
"mvn package && java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8080,suspend=n \-jar target/backend.war"

-JSON example to update
{"animal_name": "Stilton",
"animal_family": "cacatuidae",
"animal_race": "pappagallo",
"animal_descent": "cacatua",
"animal_legs": 2}

-JSON example to create
{"animal_name": "Stilton",

"animal_family": "cacatuidae",

"animal_race": "pappagallo",

"animal_descent": "cacatua",

"animal_legs": 2}