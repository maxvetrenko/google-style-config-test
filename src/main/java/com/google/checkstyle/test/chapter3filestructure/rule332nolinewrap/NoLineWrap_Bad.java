package com.google.checkstyle.test.chapter3filestructure.rule332nolinewrap; //ok

import com.google.common.annotations.Beta; //ok

import javax.accessibility.
    AccessibleAttributeSequence; //warn
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater; //ok

public class
    NoLineWrap_Bad {
    
	public void
	    fooMethod() {
		final int
		    foo = 0;
	}
}

enum
    FooFoo {
}

interface
    InterFoo {}


