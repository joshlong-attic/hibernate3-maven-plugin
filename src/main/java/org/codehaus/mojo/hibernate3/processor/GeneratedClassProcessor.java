
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
package org.codehaus.mojo.hibernate3.processor;


import java.io.File;

/**
 * Simple hook to allow custom, arbitrary changes to be made to the
 * resulting classes that are generated before they're added to the compilation root.
 *
 * @author Josh Long
 */
public interface GeneratedClassProcessor {
    String processClass(File fi, String contents);
}
