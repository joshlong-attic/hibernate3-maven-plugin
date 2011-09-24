
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
package org.codehaus.mojo.hibernate3.processor;

import org.codehaus.mojo.hibernate3.processor.implementations.*;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Josh Long
 */
public class DefaultProcessor implements CompositeProcessor {
    private List<GeneratedClassProcessor> processors;

    public DefaultProcessor() throws Throwable {
        List<String> clzzNames = new ArrayList<String>();

        Class[] processorsArr = {
                                        Asl2LicenseProcessor.class,
                                        RequiredImportProcessor.class,
                                        DateCreatedProcessor.class,
                                        DateModifiedProcessor.class,
                                        VersionProcessor.class,
                                        GeneratedValueIdProcessor.class,
                                        NonPrimitiveIdProcessor.class,
                                        CacheProcessor.class
        };
        for (Class c : processorsArr) {
            clzzNames.add(c.getName());
        }

        String cds = StringUtils.arrayToCommaDelimitedString(clzzNames.toArray());
        this.processors = ProcessorUtil.buildProcessorsFromProperty(",", cds);
    }


    @Override
    public List<GeneratedClassProcessor> getProcessors() {
        return this.processors;
    }
}
