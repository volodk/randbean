package org.nicebean.junit;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import org.nicebean.Filter;
import org.nicebean.Nice;

public class NiceBeanRunner extends BlockJUnit4ClassRunner {
	
	private Set<Field> candidates = new LinkedHashSet<Field>();

  public NiceBeanRunner(Class<?> clazz) throws InitializationError {

  	super(clazz);
    
    for( Field f : clazz.getDeclaredFields()){
    	if( f.isAnnotationPresent(Nice.class) ){
    		candidates.add( f );
    	}
    }
    
  }
  
  @Override
  protected Statement classBlock(RunNotifier notifier) {
  	
  	makeItNice();  	
  	
  	return super.classBlock(notifier);
  }
  
  private void makeItNice(){
  	for ( Field f : candidates ){
  		if (Filter.canHandle( f.getType() ) ){
  			
  		}
  	}
  }
   

}
