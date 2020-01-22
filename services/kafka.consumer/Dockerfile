FROM maven:3.6.3-jdk-8-openj9
CMD cd /root/consumer && mvn clean compile assembly:single && java -jar target/consumer-1.0-SNAPSHOT-jar-with-dependencies.jar