#!/bin/sh

USER=user1
PASS=password1
RESULT=`curl -s --data "grant_type=password&client_id=curl&username=${USER}&password=${PASS}" http://localhost:8180/auth/realms/wildfly-swarm-keycloak-example/protocol/openid-connect/token`
export TOKEN=`echo $RESULT | sed 's/.*access_token":"//g' | sed 's/".*//g'`


