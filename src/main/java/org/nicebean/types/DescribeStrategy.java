package org.nicebean.types;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 5:24:13 PM 

public enum DescribeStrategy {
	
	SHALLOW(1, false, 10, 100), FULL(10, true, 1000, Integer.MAX_VALUE);
	
	private int depth;
	private int sizeLimit;
	private int intValueLimit;
	private boolean followReferences;
	
	private DescribeStrategy(int depth, boolean followReferences, int arraySize, int intLimit){
		this.depth = depth;
		this.followReferences = followReferences;
		this.sizeLimit = arraySize;
		this.intValueLimit = intLimit;
	}
	
	public int depth(){
		return depth;
	}
	
	public boolean followReferences(){
		return followReferences;
	}
	
	public int getSizeLimit() {
		return sizeLimit;
	}
	
	public int getIntegerLimit() {
		return intValueLimit;
	}
}