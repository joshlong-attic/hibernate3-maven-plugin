package org.codehaus.mojo.hibernate3.processor;


import java.io.File;

/**
 * Simple hook to allow custom, arbitrary changes to be made to the
 * resulting classes that are generated before they're added to the compilation root.
 *
 * @author Josh Long
 */
public interface GeneratedClassDefinitionProcessor {
    String processClass(File fi, String contents  ) ;
}
