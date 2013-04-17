@/* VRaptor Demo FSH */;

new-project --named vraptordemo --topLevelPackage com.example.vraptordemo --type war;

@/* Installs VRaptor - Choose 3.4.1 */;
vraptor setup;

set ACCEPT_DEFAULTS true;

persistence setup --named default --provider HIBERNATE --container CUSTOM_NON_JTA --jndiDataSource java:jboss/datasources/ExampleDS;

entity --named Conference;
field string --named name;

entity --named Session;
field manyToOne --named conference --fieldType ~.model.Conference.java;
field string --named title;
field string --named description;

scaffold setup --scaffoldType vraptor --overwrite;
scaffold from-entity ~.model.*;

cd ~~;
build;

set ACCEPT_DEFAULTS false;

