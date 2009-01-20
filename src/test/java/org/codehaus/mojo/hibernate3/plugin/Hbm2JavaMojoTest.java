package org.codehaus.mojo.hibernate3.plugin;

public final class Hbm2JavaMojoTest
    extends AbstractHibernate3MojoTestCase
{
    public void testAnnotationMojoExecution()
        throws Exception
    {
        deleteDirectory( "target/hibernate3/generated-sources-ann" );
        getHibernateMojo( "hbm2java", "annotationconfiguration" ).execute();
        assertTrue( "can't find target/hibernate3/generated-sources-ann/annotationconfiguration/User.java",
                    checkExists( "target/hibernate3/generated-sources-ann/annotationconfiguration/User.java" ) );
    }

    public void testConfigurationMojoExecution()
        throws Exception
    {
        deleteDirectory( "target/hibernate3/generated-sources-conf" );
        getHibernateMojo( "hbm2java", "configuration" ).execute();
        assertTrue( "can't find target/hibernate3/generated-sources-conf/configuration/Location.java",
                    checkExists( "target/hibernate3/generated-sources-conf/configuration/Location.java" ) );
    }

    public void testJdbcMojoExecution()
        throws Exception
    {
        deleteDirectory( "target/hibernate3/generated-sources-jdbc" );
        getHibernateMojo( "hbm2java", "jdbcconfiguration" ).execute();
        assertTrue( "can't find target/hibernate3/generated-sources-jdbc/jdbcconfiguration/Categories.java",
                    checkExists( "target/hibernate3/generated-sources-jdbc/jdbcconfiguration/Categories.java" ) );
        assertTrue( "can't find target/hibernate3/generated-sources-jdbc/jdbcconfiguration/Forums.java",
                    checkExists( "target/hibernate3/generated-sources-jdbc/jdbcconfiguration/Forums.java" ) );
    }

    public void testJpaMojoExecution()
        throws Exception
    {
        deleteDirectory( "target/hibernate3/generated-sources-jpa" );
        getHibernateMojo( "hbm2java", "jpaconfiguration" ).execute();
        assertTrue( "can't find target/hibernate3/generated-sources-jpa/jpaconfiguration/Person.java",
                    checkExists( "target/hibernate3/generated-sources-jpa/jpaconfiguration/Person.java" ) );
    }
}