package org.randbean.junit;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.randbean.core.CreationMode;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Randomize {
    CreationMode value() default CreationMode.DEEP;
}
