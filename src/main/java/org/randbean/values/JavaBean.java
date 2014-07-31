package org.randbean.values;

import org.randbean.explorer.Builder;
import org.randbean.explorer.Explorer;
import org.randbean.types.Randomizable;

public class JavaBean implements Randomizable{

    private Class<?> clazz;
    
    public JavaBean(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object generate() {
        return Builder.newInstance( Explorer.explore(clazz) );
    }

}
