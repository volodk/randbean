package org.randbean.junit;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RandomizeRule implements TestRule {
	
	private Object test;
	
	public RandomizeRule(Object test) {
		this.test = test;
	}

	@Override
	public Statement apply(final Statement base, Description descr) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				Randomizer.populate(test);
				base.evaluate();
			}
		};
	}

}
