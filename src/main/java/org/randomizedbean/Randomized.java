package org.randomizedbean;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Randomized {
  int maxDepth() default 1;
  int maxSize() default 1;
}
