package com.google.checkstyle.test.chapter5naming.rule525nonconstantfieldnames;

public class MemberNameInput
{
    public int mPublic; //warn
    protected int mProtected; //warn
    int mPackage; //warn
    private int mPrivate; //warn

    public int _public; //warn
    protected int _protected; //warn
    int _package; //warn
    private int _private; //warn
}
