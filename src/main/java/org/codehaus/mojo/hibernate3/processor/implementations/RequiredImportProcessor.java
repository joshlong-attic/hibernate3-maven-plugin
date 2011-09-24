package org.codehaus.mojo.hibernate3.processor.implementations;


import org.codehaus.mojo.hibernate3.processor.ComponentPropertiesAware;
import org.codehaus.mojo.hibernate3.processor.GeneratedClassProcessor;
import org.codehaus.mojo.hibernate3.processor.ProcessorUtil;
import org.springframework.util.StringUtils;

import javax.persistence.EntityListeners;
import javax.persistence.Temporal;
import java.io.File;
import java.util.Date;
import java.util.Map;

/**
 * adds required imports into the class definition
 *
 * @author Josh Long
 */
public class RequiredImportProcessor implements GeneratedClassProcessor, ComponentPropertiesAware {

    private Map<String, String> componentProperties ;

    @Override
    public String processClass(File fi, String contents) {
        String auditClass = this.componentProperties.get( AuditingProcessor.AUDIT_ENTITY_LISTENER_CLASS );

        String revisions = contents;
        revisions = ProcessorUtil.insertImportIntoClassDefinition(Date.class, revisions);
        revisions = ProcessorUtil.insertImportIntoClassDefinition(Temporal.class, revisions);
        revisions = ProcessorUtil.insertImportIntoClassDefinition(EntityListeners.class, revisions);

        if(StringUtils.hasText(auditClass))
            revisions = ProcessorUtil.insertImportIntoClassDefinition( auditClass, revisions);
        return revisions;
    }

    @Override
    public void setComponentProperties(Map<String, String> componentProperties) {
     this.componentProperties = componentProperties;
    }
}
