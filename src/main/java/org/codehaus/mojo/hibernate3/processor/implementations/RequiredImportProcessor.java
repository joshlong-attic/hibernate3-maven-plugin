package org.codehaus.mojo.hibernate3.processor.implementations;


import org.codehaus.mojo.hibernate3.processor.GeneratedClassProcessor;
import org.codehaus.mojo.hibernate3.processor.ProcessorUtil;

import java.io.File;

/**
 * adds required imports into the class definition
 *
 *
 * @author Josh Long
 */
public class RequiredImportProcessor implements GeneratedClassProcessor {
    @Override
    public String processClass(File fi, String contents) {
        return ProcessorUtil.insertImportIntoClassDefinition("import java.util.*; \nimport javax.persistence.*; \n", contents);
    }
}
