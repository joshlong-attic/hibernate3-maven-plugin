package org.codehaus.mojo.hibernate3.processor;

import java.util.List;

public interface CompositeProcessor   {
    List<GeneratedClassProcessor> getProcessors();
}
