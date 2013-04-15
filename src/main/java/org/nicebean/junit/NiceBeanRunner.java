package org.nicebean.junit;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

public class NiceBeanRunner extends BlockJUnit4ClassRunner {

  public NiceBeanRunner(Class<?> clazz) throws InitializationError {
    super(clazz);
  }

}
