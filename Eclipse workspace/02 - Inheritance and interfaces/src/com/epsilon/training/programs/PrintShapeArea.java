package com.epsilon.training.programs;

import com.epsilon.training.entity.Shape;
import com.epsilon.training.entity.Triangle;

public class PrintShapeArea {

	public static void main(String[] args) {
		
		
		// a variable of type Shape
		Shape s1;
		
		// object of a Shape type
		// s1 = new Shape(); // error; since Shape is abstract
		
		// up-casting; implicit
		s1 = new Triangle(12.5, 45.6);
		
		s1.info();
		s1.printArea();
	}
}
