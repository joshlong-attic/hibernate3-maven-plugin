package org.codehaus.mojo.hibernate3.processor.implementations;

import org.codehaus.mojo.hibernate3.processor.GeneratedClassProcessor;

import java.io.File;
import java.util.regex.Pattern;

/**
 * Attempts to find "int\\s*?id" and replace it with "Integer id", and updates the corresponding getter-method, as well.
 *
 * @author Josh Long
 */
public class NonPrimitiveIdProcessor implements GeneratedClassProcessor {

    private Pattern longIdVarPattern = Pattern.compile("long\\s*?id");
    private Pattern longIdGetterPattern = Pattern.compile("public long getId");

    private Pattern intIdVarPattern = Pattern.compile("int\\s*?id");
    private Pattern intIdGetterPattern = Pattern.compile("public int getId");

    @Override
    public String processClass(File fi, String contents) {
        return fixIdGetter( fixIdVariable(contents));
    }

    protected String fixIdGetter(String in) {
        if (intIdGetterPattern.matcher(in).find()) {
            String[] split = intIdGetterPattern.split(in);
            return split[0] + " public Integer getId " + split[1];
        }

        if (longIdGetterPattern.matcher(in).find()) {
            String[] split = longIdGetterPattern.split(in);
            return split[0] + " public Long getId " + split[1];
        }

        return in;
    }

    protected String fixIdVariable(String in) {
        if (intIdVarPattern.matcher(in).find()) {
            return replaceAll(intIdVarPattern, in, " Integer id ");
        }

        if (longIdVarPattern.matcher(in).find()) {
            return replaceAll(longIdVarPattern, in, " Long id ");
        }
        return in;
    }

    private String replaceAll(Pattern m, String og, String replacement) {
        return m.matcher(og).replaceAll(replacement);
    }

}
