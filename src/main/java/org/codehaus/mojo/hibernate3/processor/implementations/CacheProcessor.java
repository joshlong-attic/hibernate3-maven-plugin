package org.codehaus.mojo.hibernate3.processor.implementations;

import org.codehaus.mojo.hibernate3.processor.GeneratedClassProcessor;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * adds support for caching if required. In practice, this means add the correct
 * annotations to the entity class itself as well as to all the sets in the class.
 *
 * @author Josh Long
 */
public class CacheProcessor implements GeneratedClassProcessor {

    private String cacheAnnotationString = " @org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE) \n";

    private Pattern classPattern = Pattern.compile("public class (.*?)");

    private Pattern setPattern = Pattern.compile("public Set<(.*?)>");

    protected String placeSetCacheAnnotation(String contents) {
        StringBuffer buffer = new StringBuffer();
        Matcher matcher = setPattern.matcher(contents);
        while (matcher.find()) {
            String param = matcher.group();
            matcher.appendReplacement(buffer, cacheAnnotationString + " " + param);
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }

    protected String placeClassCacheAnnotation(String contents) {
        StringBuffer buffer = new StringBuffer();
        // class level
        Matcher matcher = classPattern.matcher(contents);
        while (matcher.find()) {
            String param = matcher.group();
            matcher.appendReplacement(buffer, cacheAnnotationString + " " + param);
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }

    @Override
    public String processClass(File fi, String contents) {
        return placeClassCacheAnnotation(placeSetCacheAnnotation(contents));
    }

  /*  public static void main(String[] args) throws Throwable {
        CacheProcessor cacheProcessor = new CacheProcessor();
        String updatedCode = cacheProcessor.processClass(null,
                                                                "public class Customer { \n" +
                                                                "   public Integer getId(){ ... } \n" +
                                                                "   public Set<Cat> getCats(){ ... } \n" +
                                                                "} ");
        System.out.println(updatedCode);
    }*/
}
