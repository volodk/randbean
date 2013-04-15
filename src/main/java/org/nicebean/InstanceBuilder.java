package org.nicebean;

class InstanceBuilder {

  static InstanceBuilder newInstanceBuilder(Class<?> clazz) throws InstantiationException, IllegalAccessException {
    Object emptyBean = clazz.newInstance();
    return new InstanceBuilder(emptyBean);
  }

  private Object bean;

  InstanceBuilder(Object bean) {
    this.bean = bean;
  }

  Object build() {
    return bean;
  }

}
