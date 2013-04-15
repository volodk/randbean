package org.nicebean;

import java.util.HashMap;
import java.util.Map;

class Cache {

  private static final Map<Class<?>, BeanModel> MODELS = new HashMap<Class<?>, BeanModel>();

  static boolean contains(Class<?> clazz) {
    return MODELS.containsKey(clazz);
  }

  static BeanModel get(Class<?> clazz) {
    return MODELS.get(clazz);
  }

  static BeanModel saveAndGet(Class<?> clazz, BeanModel model) {
    MODELS.put(clazz, model);
    return model;
  }

}
