package org.stackbox.test.res;

import javax.annotation.Resource;
import javax.inject.Named;

@Resource@Named("secondService")
public class AddServiceSecond implements AddService {

    public AddServiceSecond() {
        System.out.println("Default add service");
    }

    @Override
    public <T> void add(T t) {
        
    }

}
