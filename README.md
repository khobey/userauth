<h1> Application Description </h1>
<p>A restful application that demonstrates user authentication using credentials stored in database.<br />

Hashing algorithm is meant have versions to re-hash passwords in case algorithm needs updating.<br />

This project uses SpringBoot, JPA, Log4j2 and PostgreSQL. May be ran using embedded tomcat. </p>

<hr />
<h2>Prerequisites</h2>
Set your database password as environment variable  POSTGRESQL_PW. <br/>
Run mvn spring-boot:run to run with Tomcat plugin.

<hr />
<h2>Sample usage</h2>

<b>Registration</b>	<br />

http://localhost:8080/register	<br />
{	<br />
&nbsp;&nbsp;&nbsp;&nbsp;	"firstName" : "Kitkat",	<br />
&nbsp;&nbsp;&nbsp;&nbsp;	"lastName" : "TheCat",	<br />
&nbsp;&nbsp;&nbsp;&nbsp;	"emailAddress" : "kitkat.thecat@gmail.com",	<br />
&nbsp;&nbsp;&nbsp;&nbsp;	"password" : "sleep",	<br />
&nbsp;&nbsp;&nbsp;&nbsp;	"passwordConfirm" :  "sleep"	<br />
}<br />
<br />

<b>Login</b>	<br />
<br />
http://localhost:8080/login	<br />
{	<br />
&nbsp;&nbsp;&nbsp;&nbsp;	"username": "kitkat.thecat@gmail.com",	<br />
&nbsp;&nbsp;&nbsp;&nbsp;	"password" : "sleep"	<br />
}