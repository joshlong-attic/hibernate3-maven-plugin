package org.codehaus.mojo.hibernate3.processor;


import org.codehaus.mojo.hibernate3.processor.implementations.RequiredImportProcessor;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract public class ProcessorUtil {



    private static Pattern wsPattern = Pattern.compile("\\s+?");

    private static Pattern pkgImportPattern = Pattern.compile("package(.*?);");

    // for us to do our dirty work, we need to remove spaces...
    private static String compressCode(String in) {
        String matches[] = wsPattern.split(in);
        StringBuffer bu = new StringBuffer();
        for (String s : matches) {
            if (StringUtils.hasText(s)) {
                bu.append(s).append(" ");
            }
        }
        return bu.toString().trim();
    }

    public static String insertImportIntoClassDefinition(String importCode, String body) {
        StringBuffer buffer = new StringBuffer();
        Matcher matcher = pkgImportPattern.matcher(body);
        while (matcher.find()) {
            String replacement = matcher.group(0) + importCode;
            matcher.appendReplacement(buffer, replacement);
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }


    /**
     * Supports the retrieval of properties from the maven property.
     *
     * @param processorsProperty the property
     * @return the list containing the synthesized classes
     */
    public static List<Class<? extends GeneratedClassProcessor>> parseProcesssorsFromProperty(String delim, String processorsProperty) throws Throwable {
        List<Class<? extends GeneratedClassProcessor>> processorClasses = new ArrayList<Class<? extends GeneratedClassProcessor>>();
        if (StringUtils.hasText(processorsProperty)) {
            List<String> arrs = new ArrayList<String>();
            if (processorsProperty.contains(delim)) {
                String[] els = processorsProperty.split(delim);
                Collections.addAll(arrs, els);
            } else {
                arrs.add(processorsProperty);
            }
            for (String cn : arrs) {
                Class<? extends GeneratedClassProcessor> processorClazz = (Class<? extends GeneratedClassProcessor>) Class.forName(cn);
                processorClasses.add(processorClazz);
            }
        }
        // required for everything else, basically
        processorClasses.add(RequiredImportProcessor.class);
        return processorClasses;
    }

    public static List<GeneratedClassProcessor> buildProcessorsFromProperty(String delim, String processorsProperty) throws Throwable {

        List<Class<? extends GeneratedClassProcessor>> procs = parseProcesssorsFromProperty(delim, processorsProperty);
        List<GeneratedClassProcessor> processors = new ArrayList<GeneratedClassProcessor>(procs.size());


        for (Class<? extends GeneratedClassProcessor> c : procs) {
            GeneratedClassProcessor processObj = c.newInstance();
            processors.add(processObj);
        }
        return processors;
    }

    /**
     * Adds a defintion to a method right before the closing brace in the file. This assumes there's only one class definition in the file, of course.
     *
     * @param entityClassStringDefinition the definition of the class
     * @param addition                    the code that should be inserted into the class
     * @return the updated class file definition
     */
    public static String insertInClassDefinition(String entityClassStringDefinition, String addition) {

        if (StringUtils.hasText(entityClassStringDefinition)) {
            int lastPosForClosingBrace = entityClassStringDefinition.lastIndexOf("}");
            if (lastPosForClosingBrace != -1) {
                return entityClassStringDefinition.substring(0, lastPosForClosingBrace) + addition + "}";
            }
        }

        return entityClassStringDefinition;
    }
}
