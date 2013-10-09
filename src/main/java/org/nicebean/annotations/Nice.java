package org.nicebean.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.nicebean.types.ValueFactory.RandomValue;
import org.nicebean.types.ValueFactory.RandomValue.Size;

@Retention(RetentionPolicy.RUNTIME)
public @interface Nice {
	RandomValue.Size size() default Size.DEEP;
}
