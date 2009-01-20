package org.codehaus.mojo.hibernate3.plugin;

public final class Hbm2DocMojoTest
    extends AbstractHibernate3MojoTestCase
{
    public void testAnnotationMojoExecution()
        throws Exception
    {
        deleteDirectory( "target/hibernate3/javadoc-ann" );
        getHibernateMojo( "hbm2doc", "annotationconfiguration" ).execute();
        assertTrue( "can't find target/hibernate3/javadoc-ann/entities/annotationconfiguration/User.html",
                    checkExists( "target/hibernate3/javadoc-ann/entities/annotationconfiguration/User.html" ) );
    }

    public void testConfigurationMojoExecution()
        throws Exception
    {
        deleteDirectory( "target/hibernate3/javadoc-conf" );
        getHibernateMojo( "hbm2doc", "configuration" ).execute();
        assertTrue( "can't find target/hibernate3/javadoc-conf/entities/configuration/Location.html",
                    checkExists( "target/hibernate3/javadoc-conf/entities/configuration/Location.html" ) );
    }

    public void testJdbcMojoExecution()
        throws Exception
    {
        // todo: research if hbm2doc can be used together with jdbcconfiguration. At the moment complains because it
        // can't find a hibernate mapping file (*.hbm.xml)
    }

    public void testJpaMojoExecution()
        throws Exception
    {
        deleteDirectory( "target/hibernate3/javadoc-jpa" );
        getHibernateMojo( "hbm2doc", "jpaconfiguration" ).execute();
        assertTrue( "can't find target/hibernate3/javadoc-jpa/entities/jpaconfiguration/Person.html",
                    checkExists( "target/hibernate3/javadoc-jpa/entities/jpaconfiguration/Person.html" ) );
    }
}