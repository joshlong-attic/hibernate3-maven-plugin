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

    private Class[] processorsArr = {
                                            Asl2LicenseProcessor.class,
                                            RequiredImportProcessor.class,
                                            DateCreatedProcessor.class,
                                            DateModifiedProcessor.class,

                                            VersionProcessor.class,
                                            GeneratedValueIdProcessor.class,
                                            NonPrimitiveIdProcessor.class,
                                            CacheProcessor.class
    };

    public DefaultProcessor() throws Throwable {
        List<String> clzzNames = new ArrayList<String>();

        for (Class c : this.processorsArr) {
            clzzNames.add(c.getName());
        }

        String cds = StringUtils.arrayToCommaDelimitedString(clzzNames.toArray());
        System.out.println(cds);
        this.processors = ProcessorUtil.buildProcessorsFromProperty(",", cds);
    }


    @Override
    public List<GeneratedClassProcessor> getProcessors() {
        return this.processors;
    }
}
