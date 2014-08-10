package com.google.checkstyle.test.chapter4formatting.rule411bracesareused;

import java.io.*;
import javax.script.*;
import java.util.concurrent.*;
import java.nio.channels.*;
import java.awt.print.*;
import java.lang.management.*;
import javax.lang.model.element.*;

class NeedBracesInput
{
    /** @return helper func **/
    boolean condition()
    {
        return false;
    }

    /** Test do/while loops **/
    void testDoWhile()
    {
        // Valid
        do {
            testDoWhile();
        }
        while (condition());

        // Invalid
        do testDoWhile(); while (condition()); //warn
    }

    /** Test while loops **/
    void testWhile()
    {
        // Valid
        while (condition()) {
            testWhile();
        }

        // Invalid
        while(condition()); //warn
        while (condition()) //warn
            testWhile();
        while (condition()) //warn
            if (condition()) //warn
                testWhile();
    }

    /** Test for loops **/
    void testFor()
    {
        // Valid
        for (int i = 1; i < 5; i++) {
            testFor();
        }

        // Invalid
        for(int i = 1;i < 5;i++); //warn
        for (int i = 1; i < 5; i++) //warn
            testFor();
        for (int i = 1; i < 5; //warn
             i++)
            if (i > 2) //warn
                testFor();
    }

    /** Test if constructs **/
    public void testIf()
    {
        // Valid
        if (condition()) {
            testIf();
        }
        else if (condition()) {
            testIf();
        }
        else {
            testIf();
        }

        // Invalid
        if (condition()); //warn
        if (condition()) //warn
            testIf();
        if (condition()) //warn
            testIf();
        else //warn
            testIf();
        if (condition()) //warn
            testIf();
        else {
            testIf();
        }
        if (condition()) {
            testIf();
        }
        else //warn
            testIf();
        if (condition()) //warn
            if (condition()) //warn
                testIf();
    }

    void whitespaceAfterSemi()
    {
        //reject
        int i = 1;int j = 2;

        //accept
        for (;;) {
        }
    }

    /** Empty constructor block. **/
    public NeedBracesInput() {}
    
    /** Empty method block. **/
    public void emptyImplementation() {}
}
