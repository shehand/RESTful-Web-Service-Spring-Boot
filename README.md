# RESTful web services - Spring Boot

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/dbbfcfdb9a104711a3c008f86203f3e8)](https://app.codacy.com/app/shehand/RESTful-Web-Service-Spring-Boot?utm_source=github.com&utm_medium=referral&utm_content=shehand/RESTful-Web-Service-Spring-Boot&utm_campaign=Badge_Grade_Dashboard)

## Installation

Download the source code. You can either download it as a zip file and 
extract it or simply type the command in the terminal or bash or cmd,

`git clone 
https://github.com/shehand/RESTful-Web-Service-Spring-Boot.git`

change your directory into the project folder. And run the command,

`mvn install`

* For windows try this 
[link](https://www.mkyong.com/maven/how-to-install-maven-in-windows/) to 
install maven.
* for ubuntu you can use this 
[link](https://linuxize.com/post/how-to-install-apache-maven-on-ubuntu-18-04/) 
to install maven.

Next run the command,

`mvn spring-boot:run`

and the server will start automatically. Try to visit 
[this](http://localhost:8080/swagger-ui.html) url to see the api 
documentation.

> NOTE
> 
> If you failed to start the server try to configure your database 
details with the project. To update database details find the file 
located in **`src\main\resources`** and find the file 
**`application.properties`**. And update followind details.
> 
> `spring.datasource.username=<your database username>`
> `spring.datasource.password=<your database user's password>`
> 
>And then you will be good to go. Make sure to start the spring app when 
you are done editing the above mention file.

If you wan't to run the jar version of the spring app, locate to the 
folder `/target` which will be in your directory when you run the `mvn 
install command`, and in there you will see you .jar file.

To run the jar file, use the below code.

`java -jar mobile-app-ws-0.0.1-SNAPSHOT.jar`

PR's are welcome. Please submit any issue that you will face when 
developing your spring-boot application.

