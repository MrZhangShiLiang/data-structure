package com.zsl.class_loader;

/**
 * @author zsl
 * @date 2019/9/8
 */
public class ClassLoaderTest{

    ClassLoader classLoader = new ClassLoader() {
        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            return super.loadClass(name);
        }
    };
}
