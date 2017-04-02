package com.cscnu.group13.CalCulate;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ParseTest extends TestCase
{
	public void testParse(){
		Parse ps = new Parse("10+4*(4+3)");
		ps.parseCalString();
		System.out.println(ps.list.toString());
	}
	
}
