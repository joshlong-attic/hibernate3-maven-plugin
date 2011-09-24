/*
*
* Copyright 2011 Josh Long
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
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
