package org.nicebean.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.nicebean.types.DescribeStrategy;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Nice {
	DescribeStrategy description() default DescribeStrategy.FULL;
}
