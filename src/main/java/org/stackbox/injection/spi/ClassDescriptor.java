package org.stackbox.injection.spi;

import java.lang.annotation.Annotation;

import javax.inject.Named;
import javax.inject.Singleton;

public class ClassDescriptor {
    
    
    private Class<?> clazz;
    private String clazzName;
    private boolean isSingleton;
    private String injectName;
    private Annotation qualifierAnnotation;
    
    public ClassDescriptor(Class<?> clazz) {
        this.clazz = clazz;
        this.clazzName = clazz.getName();
        if(clazz.isAnnotationPresent(Singleton.class)) {
            this.isSingleton = true;
        } else {
            this.isSingleton = false;
        }
        
        if(clazz.isAnnotationPresent(Named.class)) {
            Named nameAnnotation = clazz.getAnnotation(Named.class);
            this.injectName = nameAnnotation.value();
        } else {
            this.injectName = null;
        }
        /**
         * TODO: Resource annotation's value as injectName
         */
        
    }
    
    public Object newInstance() throws InstantiationException, IllegalAccessException {
        return clazz.newInstance();
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public boolean isSingleton() {
        return isSingleton;
    }

    public void setSingleton(boolean isSingleton) {
        this.isSingleton = isSingleton;
    }

    public String getInjectName() {
        return injectName;
    }

    public void setInjectName(String injectName) {
        this.injectName = injectName;
    }

    public Annotation getQualifierAnnotation() {
        return qualifierAnnotation;
    }

    public void setQualifierAnnotation(Annotation qualifierAnnotation) {
        this.qualifierAnnotation = qualifierAnnotation;
    }
    
    
}
