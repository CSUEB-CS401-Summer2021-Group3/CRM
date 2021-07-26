package edu.cs401group3.crm.auth;

import static org.junit.jupiter.api.Assertions.*;
import edu.cs401group3.crm.common.SHA256;
import org.junit.Test;

public class SHA_test {

	@Test
	public void test() {
		assertEquals("a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3",new SHA256("123").getSHA());
	}

}
