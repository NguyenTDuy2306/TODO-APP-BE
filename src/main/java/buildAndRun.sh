#!/bin/sh
mvn clean package
cp ./target/JPA-1.0-SNAPSHOT.war C:/Sun/wildfly-26.0.0.Final/standalone/deployments