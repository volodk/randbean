package org.randomizedbean.junit;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import org.randomizedbean.Filter;
import org.randomizedbean.PopulationStrategy;
import org.randomizedbean.Randomized;

public class RandomizedBeanRunner extends BlockJUnit4ClassRunner {
	
	private Set<Field> candidates = new LinkedHashSet<Field>();

  public RandomizedBeanRunner(Class<?> clazz) throws InitializationError {

  	super(clazz);
    
    for( Field f : clazz.getDeclaredFields()){
    	if( f.isAnnotationPresent(Randomized.class) ){
    		candidates.add( f );
    	}
    }
    
  }
  
  @Override
  protected Statement classBlock(RunNotifier notifier) {
  	
  	populateWithRandomData();  	
  	
  	return super.classBlock(notifier);
  }
  
  private void populateWithRandomData(){
  	for ( Field f : candidates ){
  		if ( Filter.canHandle( f.getType() ) ){
  			PopulationStrategy ps = PopulationStrategy.resolve( f.getType(), f.getGenericType() );
  			
  			ps.apply(f);
  			
  		} else {
  			System.out.println("[Randomized bean] cannot handle reference of type : " + f.getType() );
  			// default behavior: java set there "null" value 
  		}
  	}
  }
   

}
