package aliyun.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class MathTest {

	@Test
	void testAdd() {
		TestCase.assertEquals(aliyun.util.Math.add(10, 20), 31);
	}

}
