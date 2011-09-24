#first prepare the release 
mvn release:prepare 

#then commit it to the maven repository and push that to github 
mvn -DaltDeploymentRepository=repo::default::file:/home/jlong/maven-repository/maven-repository/releases clean deploy
