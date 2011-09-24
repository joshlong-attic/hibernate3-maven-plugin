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

import java.io.File;

/**
 * No-op implementation of the processor
 *
 * @author Josh Long
 */
public class NoOpProcessor implements GeneratedClassProcessor {

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
