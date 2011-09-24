package org.codehaus.mojo.hibernate3.processor.implementations;


import org.codehaus.mojo.hibernate3.processor.GeneratedClassProcessor;
import org.codehaus.mojo.hibernate3.processor.ProcessorUtil;

import java.io.File;

/**
 * adds a date modified field which can be used in an auditing interceptor
 *
 * @author Josh Long
 */
public class DateModifiedProcessor implements GeneratedClassProcessor {

    private String dateModified =         "   private java.util.Date dateModified;\n" +
                                          "   @Temporal(TemporalType.TIMESTAMP) @Column(name=\"date_modified\", nullable=false, length=10)\n" +
                                          "   public Date getDateModified() { return this.dateModified; }\n" +
                                          "   public void setDateModified(Date dc) { this.dateModified =dc; }\n";

    @Override
    public String processClass(File fi, String contents) {
        return ProcessorUtil.insertInClassDefinition(contents, dateModified);
    }
}
