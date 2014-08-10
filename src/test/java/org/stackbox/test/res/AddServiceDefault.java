package org.stackbox.test.res;

import javax.annotation.Resource;

@Resource
public class AddServiceDefault implements AddService {
    
    public AddServiceDefault() {
        System.out.println("Default add service");
    }

    @Override
    public <T> void add(T t) {

    }
}
