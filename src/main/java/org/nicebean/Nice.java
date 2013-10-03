package org.nicebean;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Nice {
	int recursiveDepth() default 3;
}
