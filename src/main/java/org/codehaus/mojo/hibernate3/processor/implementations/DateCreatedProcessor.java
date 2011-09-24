package org.codehaus.mojo.hibernate3.processor.implementations;

import org.codehaus.mojo.hibernate3.processor.GeneratedClassProcessor;
import org.codehaus.mojo.hibernate3.processor.ProcessorUtil;

import java.io.File;

/**
 * Adds a date created field which can be used with an auditing interceptor
 *
 * @author Josh Long
 */
public class DateCreatedProcessor implements GeneratedClassProcessor {

    private String dateCreatedJava = "   private java.util.Date dateCreated ; " +
                                             "   @Temporal(TemporalType.TIMESTAMP) @Column(name=\"date_created\", nullable=false, length=10) " +
                                             "   public Date getDateCreated() { return this.dateCreated; } " +
                                             "   public void setDateCreated(Date dc) { this.dateCreated = dc; }";


    @Override
    public String processClass(File fi, String contents) {
        return ProcessorUtil.insertInClassDefinition(contents, dateCreatedJava);
    }
}
