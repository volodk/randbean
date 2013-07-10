package org.nicebean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class Cache {

  private static final Map<Class<?>, BeanModel> MODELS = new ConcurrentHashMap<Class<?>, BeanModel>();

  static boolean contains(Class<?> clazz) {
    return MODELS.containsKey(clazz);
  }

  static BeanModel get(Class<?> clazz) {
    return MODELS.get(clazz);
  }

  static void save(Class<?> clazz, BeanModel model) {
    MODELS.put(clazz, model);
  }

}
