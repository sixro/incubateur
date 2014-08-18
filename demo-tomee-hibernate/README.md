# TomEE with Hibernate (JPA)

This project represents a demo about TomEE with Hibernate as the JPA provider.

In order to create it, I have created the project with archetype provided by TomEE team. Then, I replaced OpenJPA with Hibernate.

The project provide a way to run it also on JBoss (see [How to run :: JBoss](#how-to-run-jboss)).


## How to run

### TomEE

Execute:

    mvn clean package tomee:run


Open a browser to [http://localhost:8080/demo](http://localhost:8080/demo)


### <a name="how-to-run-jboss"></a>JBoss

Download a JBoss version and extract it where you want. Then create a symbolic link ```jboss-as``` to the extracted dir or change in ```pom.xml``` the property ```jboss-as.home```.

Copy the file ```src/app-server/jboss-as/demo-ds.xml``` under the directory represented by ```<jboss-as.home>/standalone/deployments```.

Execute:

    mvn clean package jboss-as:run


Open a browser to [http://localhost:8080/demo](http://localhost:8080/demo)
