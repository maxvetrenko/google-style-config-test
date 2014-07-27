package com.google.checkstyle.test.chapter5naming.rule527localvariablenames;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

class InputOneCharInintVarName
{
    public void fooMethod()
    {
        for(int i = 1; i <10; i++) { //ok
            //some code
        }
        
        int i = 0; //warn
        
        for(int index = 1; index < 10; index++) { //ok
            //some code
        }
        
        for(int Index = 1; Index < 10; Index++) { //warn
            //some code
        }
        
        int index = 1;

        for(; index < 10; index++) { //ok  
            //some code
        }
        
        for(; i < 12; i++) { //ok
            //some code
        }
        
        Map<String, String> map = new HashMap<String, String>();
        
        for (Map.Entry<String, String> e : map.entrySet()) { //ok
            //some code
        }
        
        for (int a = 0, b[] = { 1 }, c[][] = { { 1 }, { 2 } }; a < 10; a++) { //ok
              // something
        }
    }
}
