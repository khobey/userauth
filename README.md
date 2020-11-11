A restful application that demonstrates user authentication using credentials stored in database.

Hashing algorithm is meant have versions to re-hash passwords in case algorithm needs updating.

This project uses SpringBoot, JPA, Log4j2 and PostgreSQL. May be ran using embedded tomcat. 

Sample usage:

Registration
http://localhost:8080/register
{
    "firstName" : "Kitkat",
    "lastName" : "TheCat",
    "emailAddress" : "kitkat.thecat@gmail.com",
    "password" : "sleep",
    "passwordConfirm" :  "sleep"
}

http://localhost:8080/login
Login
{
    "username": "kitkat.thecat@gmail.com",
    "password" : "sleep"
}