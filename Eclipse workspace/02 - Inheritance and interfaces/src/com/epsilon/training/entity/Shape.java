package com.epsilon.training.entity;

import java.util.logging.Logger;

public abstract class Shape {
	
	Logger logger = Logger.getLogger(Shape.class.getName());
	
	private final double PI = 3.1416;

	public void info() {
		logger.info("Classname: Shape");
		logger.info("Created by: Vinod <vinod@vinod.co>");
	}
	
	public abstract void printArea();
}
