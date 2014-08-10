package org.stackbox.injection;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

import javax.annotation.Resource;

import org.reflections.Reflections;
import org.stackbox.injection.spi.ClassDescriptor;

public class ApplicationContainer implements BeanFactory {

    private Map <String, ClassDescriptor> descriptorMap = new HashMap<String, ClassDescriptor>();
    
    
    /**
     * TODO: be able to inject with interface
     * 
     */
    
    public ApplicationContainer(String pkg) {
        Reflections reflections = new Reflections(pkg);
        Set <Class<?>> resources = reflections.getTypesAnnotatedWith(Resource.class);
        if(null != resources && resources.size() > 0) {
            for(Class<?> cls : resources) {
                descriptorMap.put(cls.getName(), new ClassDescriptor(cls));
            }
        }
    }



    @Override
    public <T> T getBean(Class<T> beanType) throws InstantiationException, IllegalAccessException {
        if(descriptorMap.get(beanType.getName()) != null) {
            return (T) descriptorMap.get(beanType.getName()).newInstance();
        }
        return null;
    }
    
}
