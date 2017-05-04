#!/bin/sh

java -Dswarm.port.offset=100 \
     -Dkeycloak.migration.action=import \
     -Dkeycloak.migration.provider=singleFile \
     -Dkeycloak.migration.file=wildfly-swarm-keycloak-example-realm.json \
     -jar target/kc-server-swarm.jar
