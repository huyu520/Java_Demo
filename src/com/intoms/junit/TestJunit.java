package com.intoms.junit;

import org.junit.Test;

import junit.framework.TestCase;

public class TestJunit {

	@Test
	public void test() {
		boolean flag = 3 > 2 ;
		TestCase.assertEquals(flag, true);
	}
	
}
