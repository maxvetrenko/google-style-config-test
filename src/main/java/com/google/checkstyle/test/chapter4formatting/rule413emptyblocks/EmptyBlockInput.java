////////////////////////////////////////////////////////////////////////////////
// Test case file for checkstyle.
// Created: 2001
////////////////////////////////////////////////////////////////////////////////
package com.google.checkstyle.test.chapter4formatting.rule413emptyblocks;

import java.io.*; // star import for instantiation tests
import java.awt.Dimension; // explicit import for instantiation tests
import java.awt.Color;

class UpdateClass
{
	public void fooMethod()
	{
		UpdateClass r = new UpdateClass();
		int a = 1;
		if (a == 1) {} //is not OK 
		char[] s = {'1', '2'};
		int index = 2;
		if (doSideEffect() == 1) {} //is not OK, 
		IO in = new IO();
		while ((r = in.read()) != null) {} // is OK 
		for (; index < s.length && s[index] != 'x'; index++) {} // is OK
		if (a == 1) {} else {System.out.println("a");} // is not OK
	}
	
	public int doSideEffect()
	{
		return 1;
	}
}

class IO
{
	public UpdateClass read()
	{
		return new UpdateClass();
	}
}
