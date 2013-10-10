package org.nicebean.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.nicebean.types.ValueFactory.RandomValue.DetailLevel;

@Retention(RetentionPolicy.RUNTIME)
public @interface Nice {
	DetailLevel level() default DetailLevel.DEEP;
}
