# Anorgate microservice project template generator

This project aims to simplify your project creation routine. It contains all production ready infrastructural code which
will let you start without carying about project setup

## Generation instructions

### To generate the microservice project do the following steps:

- Get the artifact via command: ***mvn dependency:get -Dartifact=uz.anorbank:ams:AMS_VERSION***
- Type the following command to generate your project: ***mvn archetype:generate "-DarchetypeGroupId=uz.anorbank" "
  -DarchetypeArtifactId=ams" "-DarchetypeVersion=AMS_VERSION" "-DgroupId=YOUR_GROUP_ID" "
  -DartifactId=YOUR_ARTEFACT_ID" "-Dversion=YOUR_INITIAL_VERSION" "-DinteractiveMode=false"***

> ***AMS_VERSION*** - means version of ams which you decided to use
> ***YOUR_GROUP_ID*** - group id of project which will be generated
> ***YOUR_ARTEFACT_ID***- artefact id of project which will be generated
> ***YOUR_INITIAL_VERSION*** - version of project which will be generated