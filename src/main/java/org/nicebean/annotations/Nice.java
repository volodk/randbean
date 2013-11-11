package org.nicebean.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.nicebean.types.GenerateStrategy;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Nice {
	GenerateStrategy value() default GenerateStrategy.DEEP;
}
