////////////////////////////////////////////////////////////////////////////////
// Test case file for checkstyle.
// Created: 2001
////////////////////////////////////////////////////////////////////////////////
package com.google.checkstyle.test.chapter4formatting.rule462horizontalwhitespace;

import com.google.common.base.Function;
import com.google.common.base.Supplier;

class myFoo
{
	private void foo()
	{
		int i = 0;
		String[][] x = {{"foo"}};
		for (int first = 0; first < 5; first++) {}
		int j = 0;
		while (j == 1) {}
		do {} while (i == 1);
	}
}

interface SupplierFunction<T> extends Function<Supplier<T>, T> {}

class EmptyFoo {}

enum EmptyFooEnum {}
