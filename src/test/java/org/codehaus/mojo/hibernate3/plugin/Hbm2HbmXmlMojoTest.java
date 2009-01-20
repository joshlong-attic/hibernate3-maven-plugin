package org.codehaus.mojo.hibernate3.plugin;

public final class Hbm2HbmXmlMojoTest
    extends AbstractHibernate3MojoTestCase
{
    public void testAnnotationMojoExecution()
        throws Exception
    {
        deleteDirectory( "target/hibernate3/generated-mappings-ann" );
        getHibernateMojo( "hbm2hbmxml", "annotationconfiguration" ).execute();
        assertTrue( "can't find target/hibernate3/generated-mappings-ann/annotationconfiguration/User.hbm.xml",
                    checkExists( "target/hibernate3/generated-mappings-ann/annotationconfiguration/User.hbm.xml" ) );
    }

    public void testConfigurationMojoExecution()
        throws Exception
    {
        deleteDirectory( "target/hibernate3/generated-mappings-conf" );
        getHibernateMojo( "hbm2hbmxml", "configuration" ).execute();
        assertTrue( "can't find target/hibernate3/generated-mappings-conf/configuration/Location.hbm.xml",
                    checkExists( "target/hibernate3/generated-mappings-conf/configuration/Location.hbm.xml" ) );
    }

    public void testJdbcMojoExecution()
        throws Exception
    {
        deleteDirectory( "target/hibernate3/generated-mappings-jdbc" );
        getHibernateMojo( "hbm2hbmxml", "jdbcconfiguration" ).execute();
        assertTrue( "can't find target/hibernate3/generated-mappings-jdbc/jdbcconfiguration/Categories.hbm.xml",
                    checkExists( "target/hibernate3/generated-mappings-jdbc/jdbcconfiguration/Categories.hbm.xml" ) );
        assertTrue( "can't find target/hibernate3/generated-mappings-jdbc/jdbcconfiguration/Forums.hbm.xml",
                    checkExists( "target/hibernate3/generated-mappings-jdbc/jdbcconfiguration/Forums.hbm.xml" ) );
    }

    public void testJpaMojoExecution()
        throws Exception
    {
        deleteDirectory( "target/hibernate3/generated-mappings-jpa" );
        getHibernateMojo( "hbm2hbmxml", "jpaconfiguration" ).execute();
        assertTrue( "can't find target/hibernate3/generated-mappings-jpa/jpaconfiguration/Person.hbm.xml",
                    checkExists( "target/hibernate3/generated-mappings-jpa/jpaconfiguration/Person.hbm.xml" ) );
    }
}