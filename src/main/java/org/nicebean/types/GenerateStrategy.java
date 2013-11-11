package org.nicebean.types;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 5:24:13 PM 

public enum GenerateStrategy {
	
	SHALLOW(false, 10, 100), DEEP(true, 100, 1000);
	
	private int sizeLimit;
	private int intValueLimit;
	private boolean followReferences;
	
	private GenerateStrategy(boolean followReferences, int arrayLimit, int intValueLimit){
		this.followReferences = followReferences;
		this.sizeLimit = arrayLimit;
		this.intValueLimit = intValueLimit;
	}
	
	public boolean followReferences(){
		return followReferences;
	}
	
	public int getContainerSizeLimit() {
		return sizeLimit;
	}
	
	public int getIntegerRangeLimit() {
		return intValueLimit;
	}
}