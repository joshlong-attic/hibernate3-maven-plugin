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

import org.codehaus.mojo.hibernate3.processor.ComponentPropertiesAware;
import org.codehaus.mojo.hibernate3.processor.GeneratedClassProcessor;
import org.springframework.util.Assert;

import java.io.File;
import java.util.Map;

/**
 * Registers the an {@link javax.persistence.EntityListeners} by consulting the configured property for the Maven
 * plugin named "auditEntityListenerClass".
 *
 * @author Josh Long
 */
public class AuditingProcessor implements GeneratedClassProcessor, ComponentPropertiesAware {

    static public final String AUDIT_ENTITY_LISTENER_CLASS = "auditEntityListenerClass";

    private String auditListenerClass;

    @Override
    public String processClass(File fi, String contents) {
        return contents.replace("@Entity", String.format("@Entity @EntityListeners(%s.class)", this.auditListenerClass));
    }

    @Override
    public void setComponentProperties(Map<String, String> componentProperties) {
        this.auditListenerClass = componentProperties.get(AUDIT_ENTITY_LISTENER_CLASS);
        Assert.hasText(this.auditListenerClass, "the audit class component can't be null!");
    }
}
