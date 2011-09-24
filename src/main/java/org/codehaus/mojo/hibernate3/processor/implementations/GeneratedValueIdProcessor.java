package org.codehaus.mojo.hibernate3.processor.implementations;


import org.codehaus.mojo.hibernate3.processor.GeneratedClassProcessor;

import java.io.File;

/**
 * Makes the @Id column generated in the code also have a matching GeneratedValue annotation
 *
 * @author Josh Long
 */
public class GeneratedValueIdProcessor implements GeneratedClassProcessor {


    static public void main(String args[]) throws Throwable {
        String bad = "package a.b.c; \n import cat.dog.*; \npublic class Cat { \n              " +
                             "        private int id;            " +
                             "}";


    }

    @Override
    public String processClass(File fi, String contents) {
     //   String compressedBody =  (ProcessorUtil.insertImportIntoClassDefinition( contents ,  (bad)));

        return contents;

    }
}
