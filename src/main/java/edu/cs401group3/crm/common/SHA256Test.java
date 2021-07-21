package edu.cs401group3.crm.common;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SHA256Test {
	//SHA256 value of "123" is "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3"
	@Test
	void test() {
		SHA256 test= new SHA256("123");
		assertEquals("a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3",test);
	}

}
