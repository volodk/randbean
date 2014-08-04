package org.randbean.values;

import org.randbean.types.Randomizable;
import org.randbean.utils.Preconditions;

// volodymyr_krasnikov1 <vkrasnikov@gmail.com> 1:52:56 PM 

class ProxiedObject implements Randomizable {

    private Class<?> clazz;

    public ProxiedObject(Class<?> clazz) {
        Preconditions.notNull(clazz);
        Preconditions.assertThat(clazz.isInterface(), new IllegalArgumentException("Is not an interface, class : "
                + clazz));
        this.clazz = clazz;
    }

    @Override
    public Object generate() {

        return null;
    }

}
