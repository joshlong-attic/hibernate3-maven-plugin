package org.codehaus.mojo.hibernate3.processor.implementations;


import org.codehaus.mojo.hibernate3.processor.GeneratedClassProcessor;
import org.codehaus.mojo.hibernate3.processor.ProcessorUtil;

import java.io.File;

public class VersionProcessor implements GeneratedClassProcessor {
    private String version = "\n" +
                                     "    private java.lang.Long version;\n" +
                                     "     @javax.persistence.Version   public java.lang.Long getVersion() { return version; }\n" +
                                     "    public void setVersion(java.lang.Long value) { this.version = value; }\n\n";

    @Override
    public String processClass(File fi, String contents) {
        return ProcessorUtil.insertInClassDefinition(contents, this.version);
    }
}
