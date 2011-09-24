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
 * Makes the @Id column generated in the code also have a matching GeneratedValue annotation
 *
 * @author Josh Long
 */
public class GeneratedValueIdProcessor implements GeneratedClassProcessor {


    static public void main(String args[]) throws Throwable {
        String bad = "package a.b.c; \n import cat.dog.*; \npublic class Cat { \n              " +
                             "        private int id;            " +
                             "}";


    }

    @Override
    public String processClass(File fi, String contents) {
        //   String compressedBody =  (ProcessorUtil.insertImportIntoClassDefinition( contents ,  (bad)));

        return contents;

    }
}
