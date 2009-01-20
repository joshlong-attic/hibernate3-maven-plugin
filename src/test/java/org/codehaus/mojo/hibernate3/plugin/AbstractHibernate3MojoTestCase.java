package org.codehaus.mojo.hibernate3.plugin;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.apache.maven.plugin.testing.stubs.MavenProjectStub;
import org.apache.maven.model.Build;
import org.apache.maven.project.MavenProject;
import org.codehaus.mojo.hibernate3.HibernateExporterMojo;
import org.codehaus.plexus.util.FileUtils;

public abstract class AbstractHibernate3MojoTestCase
    extends AbstractMojoTestCase
{
    protected boolean checkExists( String target )
    {
        return ( getTestFile( target ).exists() );
    }

    protected void deleteDirectory( String targetFolder )
        throws Exception
    {
        FileUtils.deleteDirectory( getTestFile( targetFolder ) );
    }

    protected HibernateExporterMojo getHibernateMojo( String goal, String implementation )
        throws Exception
    {
        copyFileToDirectory( "target/test-classes/jpaconfiguration/META-INF/persistence.xml",
                             "target/test-classes/META-INF" );

        String path = "target/test-classes/" + implementation + "/" + goal + "-config.xml";
        HibernateExporterMojo mojo = (HibernateExporterMojo) lookupMojo( goal, getTestFile( path ) );
        mojo.getLog().info( "executing: " + getTestFile( path ).getPath() );
        setVariableValueToObject( mojo, "project", getMavenProject() );
        return mojo;
    }

    protected void copyFileToDirectory( String from, String to )
        throws Exception
    {
        FileUtils.copyFileToDirectory( getTestFile( from ), getTestFile( to ) );
    }

    protected MavenProject getMavenProject()
    {
        final Build build = new Build();
        build.setDirectory( "target" );
        build.setOutputDirectory( "target/classes" );
        build.setTestOutputDirectory( "target/test-classes" );

        return new MavenProjectStub()
        {
            public Build getBuild()
            {
                return build;
            }
        };
    }
}
