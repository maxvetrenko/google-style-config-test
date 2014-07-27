package com.google.checkstyle.test.chapter4formatting.rule487modifiers;

strictfp final class ModifierOrderInput //worn
{
    static private boolean sModifierOrderVar = false; //worn

    /**
     * Illegal order of modifiers for methods. Make sure that the
     * first and last modifier from the JLS sequence is used.
     */
    strictfp private void doStuff() //worn
    {
    }

    /** Single annotation without other modifiers */
    @MyAnnotation2 void someMethod()
    {
    }

    /** Illegal order of annotation - must come first */
    private @MyAnnotation2 void someMethod2() //worn
    {
    }

    /** Annotation in middle of other modifiers otherwise in correct order */
    private @MyAnnotation2 strictfp void someMethod3() //worn
    {
    }

    /** Correct order */
    @MyAnnotation2 private strictfp void someMethod4()
    {
    }

    /** Annotation in middle of other modifiers otherwise in correct order */
    @MyAnnotation2 private static @MyAnnotation4 strictfp void someMethod5() //worn
    {
    }

    /** holder for redundant 'public' modifier check. */
    public static interface InputRedundantPublicModifier
    {
        public void a();

        void b();

        abstract void c();

        public float PI_PUBLIC = (float) 3.14;

        final float PI_FINAL = (float) 3.14;

        /** all OK */
        float PI_OK = (float) 3.14;
    }
    private final void method()
    {
    }
}

final class RedundantFinalClass
{
    public final void finalMethod()
    {
    }

    /** OK */
    public void method()
    {
    }
}

/** Holder for redundant modifiers of inner implementation */
interface InnerImplementation
{
    InnerImplementation inner =
        new InnerImplementation()
        {
            /** compiler requires 'public' modifier */
            public void method()
            {
            }
        };
    
    void method();
}

/** Holder for redundant modifiers of annotation fields/variables */
@interface Annotation
{
    public String s1 = "";
    final String s2 = "";
    static String s3 = "";
    String s4 = "";
    public String blah();
    abstract String blah2();
}

@interface MyAnnotation2 {
}

@interface MyAnnotation4 {
}
