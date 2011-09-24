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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Makes the @Id column generated in the code also have a matching GeneratedValue annotation
 *
 * @author Josh Long
 */
public class GeneratedValueIdProcessor implements GeneratedClassProcessor {

    private String generatedValue = " @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO) ";

    @Override
    public String processClass(File fi, String contents) {
         return contents.replace("@Id",  "@Id " + generatedValue + " "  );
    }

    static public void main(String[] a) throws Throwable {

        GeneratedValueIdProcessor generatedValueIdProcessor = new GeneratedValueIdProcessor();
        String result = generatedValueIdProcessor.processClass(null, " public class Customer {\n  @Id \n" +
                                                                             "    \n" +
                                                                             "    @Column(name=\"idPattern\", unique=true, nullable=false)\n" +
                                                                             "     public Long getId () {\n" +
                                                                             "        return this.idPattern;\n" +
                                                                             "    } }\n" +
                                                                             "     ");

        System.out.println("result: " + result);

    }
}
