#first prepare the release 
mvn release:prepare 

tag=`cat release.properties |grep scm.tag|cut -f2 -d=|head -n1`

git checkout $tag

#then commit it to the maven repository and push that to github 
mvn -DaltDeploymentRepository=repo::default::file:/home/jlong/maven-repository/releases clean deploy
