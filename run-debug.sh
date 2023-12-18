#!/bin/sh

java -Xms8192m -Xmx16384m -Xss4096k -agentlib:jdwp=transport=dt_socket,address=9999,server=y,suspend=n -jar target/books-server-0.0.1-SNAPSHOT.jar
