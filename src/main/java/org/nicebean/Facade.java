package org.nicebean;

public class Facade {

  private static final FieldVisitor visitor = new FieldVisitor();

  @SuppressWarnings("unchecked")
  public static <T> T populatedInstance(Class<T> clazz) throws InstantiationException, IllegalAccessException {

    BeanModel model;
    if (Cache.contains(clazz)) {
      model = Cache.get(clazz);
    } else {
      model = Cache.saveAndGet(clazz, BeanModel.describe(clazz));
    }

    InstanceBuilder builder = InstanceBuilder.newInstanceBuilder(clazz);

    model.walk(visitor, builder);

    return (T) builder.build();
  }

}
