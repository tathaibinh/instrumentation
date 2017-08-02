/*
 * Copyright 2017 brutusin.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.brutusin.bctrace;

import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.brutusin.bctrace.utils.Helper;

/**
 *
 * @author Ignacio del Valle Alles idelvall@brutusin.org
 */
public class TestClass {

    public static long fact(long n) {
        if (n == 1) {
            return 1;
        } else {
            return fact(n - 1) * n;
        }
    }
    
    public static long factWrapper(Long n) {
        if (n == 1) {
            return 1;
        } else {
            return factWrapper(n - 1) * n;
        }
    }

    public static void main(String[] args) throws Exception {
        Class clazz = TestClass.class;
        String className = clazz.getCanonicalName();
        String resourceName = className.replace('.', '/') + ".class";
        InputStream is = clazz.getClassLoader().getResourceAsStream(resourceName);
        byte[] bytes = IOUtils.toByteArray(is);
        Helper.viewByteCode(bytes);
    }
}