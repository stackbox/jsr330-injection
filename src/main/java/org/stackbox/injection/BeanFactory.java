package org.stackbox.injection;

public interface BeanFactory {

    default Object getbean(String name) {
        return null;
    }
    
    default <T> T getBean(Class<T> beanType) throws InstantiationException, IllegalAccessException {
        return null;
    }
}
