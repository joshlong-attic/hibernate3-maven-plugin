package org.codehaus.mojo.hibernate3.processor;

import java.io.File;

/**
 * No-op implementation of the processor
 *
 * @author Josh Long
 */
public class NoOpGeneratedClassDefinitionProcessor implements GeneratedClassDefinitionProcessor {

    /**
     * the class definition will simply be written out to the target as it was generaed
     *
     * @param fi       the file
     * @param contents the contents of the file  fi
     * @return the new contents of the file (a .java file)
     */
    public String processClass(File fi, String contents) {
        return contents;
    }
}
