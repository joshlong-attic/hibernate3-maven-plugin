package org.codehaus.mojo.hibernate3.plugin;

public final class Hbm2CfgXmlMojoTest
    extends AbstractHibernate3MojoTestCase
{
    public void testAnnotationMojoExecution()
        throws Exception
    {
        deleteDirectory( "target/hibernate3/generated-mappings-ann" );
        getHibernateMojo( "hbm2cfgxml", "annotationconfiguration" ).execute();
        assertTrue( "can't find target/hibernate3/generated-mappings-ann/hibernate.cfg.xml",
                    checkExists( "target/hibernate3/generated-mappings-ann/hibernate.cfg.xml" ) );
    }

    public void testConfigurationMojoExecution()
        throws Exception
    {
        deleteDirectory( "target/hibernate3/generated-mappings-conf" );
        getHibernateMojo( "hbm2cfgxml", "configuration" ).execute();
        assertTrue( "can't find target/hibernate3/generated-mappings-conf/hibernate.cfg.xml",
                    checkExists( "target/hibernate3/generated-mappings-conf/hibernate.cfg.xml" ) );
    }

    public void testJdbcMojoExecution()
        throws Exception
    {
        deleteDirectory( "target/hibernate3/generated-mappings-jdbc" );
        getHibernateMojo( "hbm2cfgxml", "jdbcconfiguration" ).execute();
        assertTrue( "can't find target/hibernate3/generated-mappings-jdbc/hibernate.cfg.xml",
                    checkExists( "target/hibernate3/generated-mappings-jdbc/hibernate.cfg.xml" ) );
    }

    public void testJpaMojoExecution()
        throws Exception
    {
        deleteDirectory( "target/hibernate3/generated-mappings-jpa" );
        getHibernateMojo( "hbm2cfgxml", "jpaconfiguration" ).execute();
        assertTrue( "can't find target/hibernate3/generated-mappings-jpa/hibernate.cfg.xml",
                    checkExists( "target/hibernate3/generated-mappings-jpa/hibernate.cfg.xml" ) );
    }
}
