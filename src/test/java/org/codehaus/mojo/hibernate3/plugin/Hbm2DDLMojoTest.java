package org.codehaus.mojo.hibernate3.plugin;

public class Hbm2DDLMojoTest
    extends AbstractHibernate3MojoTestCase
{
    public void testAnnotationMojoExecution()
        throws Exception
    {
        deleteDirectory( "target/hibernate3/sql-ann" );
        getHibernateMojo( "hbm2ddl", "annotationconfiguration" ).execute();
        assertTrue( "can't find target/hibernate3/sql-ann/schema.sql",
                    checkExists( "target/hibernate3/sql-ann/schema.sql" ) );
    }

    public void testConfigurationMojoExecution()
        throws Exception
    {
        deleteDirectory( "target/hibernate3/sql-conf" );
        getHibernateMojo( "hbm2ddl", "configuration" ).execute();
        assertTrue( "can't find target/hibernate3/sql-conf/schema.sql",
                    checkExists( "target/hibernate3/sql-conf/schema.sql" ) );
    }

    public void testJdbcMojoExecution()
        throws Exception
    {
        deleteDirectory( "target/hibernate3/sql-jdbc" );
        getHibernateMojo( "hbm2ddl", "jdbcconfiguration" ).execute();
        assertTrue( "can't find target/hibernate3/sql-jdbc/schema.sql",
                    checkExists( "target/hibernate3/sql-jdbc/schema.sql" ) );
    }

    public void testJpaMojoExecution()
        throws Exception
    {
        deleteDirectory( "target/hibernate3/sql-jpa" );
        getHibernateMojo( "hbm2ddl", "jpaconfiguration" ).execute();
        assertTrue( "can't find target/hibernate3/sql-jpa/schema.sql",
                    checkExists( "target/hibernate3/sql-jpa/schema.sql" ) );
    }
}
