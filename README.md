Spark Puppet Webapp Sample
==========================

The king of hello worlds.


For dev
```
mvn clean compile
mvn exec:java -Dexec.mainClass="com.puppet.sample.App"
```
  

For real
```
mvn clean package
java -jar target/puppet-webapp-<VERSION>.jar [-DappPort=XXXX]
```
  
  

Dependency projects
-------------------
[Java Webapp Polyglot](https://github.com/ipcrm/java_webapp_polyglot.git)



