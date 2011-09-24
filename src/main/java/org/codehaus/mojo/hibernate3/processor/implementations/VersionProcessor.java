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
