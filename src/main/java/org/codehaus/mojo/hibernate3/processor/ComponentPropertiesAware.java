package org.codehaus.mojo.hibernate3.processor;

import java.util.Map;

public interface ComponentPropertiesAware {
    void setComponentProperties(Map<String,String> componentProperties) ;
}
