package org.nicebean.explorer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.nicebean.utils.ArrayUtils;

/**
 * 
 * @author "Volodymyr Krasnikov" <vkrasnikov@gmail.com>
 *
 */
public final class JdkClassRegistry {
	private static final Set<Class<?>> registry = new HashSet<>();

	static {
		try {
			File f = new File(System.getProperty("java.home"), "lib/classlist");
			BufferedReader br = new BufferedReader(new FileReader(f));
			try {
				try {
					String str = null;
					while ((str = br.readLine()) != null) {
						if (! ( str.startsWith("#") || str.startsWith("sun")) ) {
							String className = str.replace('/', '.');
							try {
								Class<?> clazz = Class.forName(className);

								registry.add(clazz);

							} catch (ClassNotFoundException e) {
								System.err
										.println("Cannot find class definition, see more : "
												+ e.getMessage());
							} catch (Throwable e) {
								// ignore
							}
						}
					}
				} finally {
					br.close();
				}
			} catch (IOException e) {
				System.err.println("Cannot read from file, reason :"
						+ e.getMessage());
			}
		} catch (FileNotFoundException e) {
			System.err
					.println("Cannot find lib/classlist file. Please check your 'java.home' property");
		}
	}

	static {
		registry.add(boolean.class);
		registry.add(byte.class);
		registry.add(short.class);
		registry.add(char.class);
		registry.add(int.class);
		registry.add(float.class);
		registry.add(long.class);
		registry.add(double.class);
	}

	public static boolean isJdkClass(Class<?> clazz) {
		if(clazz != null) {
			boolean isJdkClass = false;
			if(clazz.isArray()){
				isJdkClass = registry.contains( ArrayUtils.getComponentType(clazz) );
			} else {
				isJdkClass = registry.contains(clazz);
			}
			return isJdkClass;
		} else {
			System.err.println("Argument class parameter is NULL");
			return false;
		}
	}
}
