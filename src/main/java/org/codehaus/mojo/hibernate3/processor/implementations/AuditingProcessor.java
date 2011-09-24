package org.codehaus.mojo.hibernate3.processor.implementations;

import com.joshlong.util.AuditingJpaEntityFieldListener;
import org.codehaus.mojo.hibernate3.processor.GeneratedClassProcessor;

import java.io.File;

/**
 * Registers the {@link }
 *
 * @author Josh Long
 */
public class AuditingProcessor implements GeneratedClassProcessor {
    @Override
    public String processClass(File fi, String contents) {
        return contents.replace("@Entity", String.format("@Entity @EntityListeners(%s)", AuditingJpaEntityFieldListener.class.getName()));
    }
}
