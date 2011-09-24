package org.codehaus.mojo.hibernate3.processor.implementations;

import org.codehaus.mojo.hibernate3.processor.ComponentPropertiesAware;
import org.codehaus.mojo.hibernate3.processor.GeneratedClassProcessor;
import org.springframework.util.Assert;

import java.io.File;
import java.util.Map;

/**
 * Registers the {@link }
 *
 * @author Josh Long
 */
public class AuditingProcessor implements GeneratedClassProcessor , ComponentPropertiesAware{

    static public final String AUDIT_ENTITY_LISTENER_CLASS= "auditEntityListenerClass" ;

    private String auditListenerClass;

    @Override
    public String processClass(File fi, String contents) {
        return contents.replace("@Entity", String.format("@Entity @EntityListeners(%s.class)",  this.auditListenerClass));
    }

    @Override
    public void setComponentProperties(Map<String, String> componentProperties) {
        this.auditListenerClass = componentProperties.get(AUDIT_ENTITY_LISTENER_CLASS);
        Assert.hasText(this.auditListenerClass, "the audit class component can't be null!");
    }
}
