package org.randbean;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.randbean.samplebeans.MultiConstructorBean;
import org.randbean.utils.ReflectionUtils;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 11:02:05 AM 

public class MultiConstructorBeanTest {

    @Test
    public void test() {
        MultiConstructorBean bean = ReflectionUtils.newInstance(MultiConstructorBean.class);
        assertNotNull(bean);
        assertTrue( bean.getA() > 0 );
        assertTrue( bean.getB() > 0 );
        assertNotNull(bean.getC());
        assertTrue( bean.getC().length() > 0 );
    }
}
