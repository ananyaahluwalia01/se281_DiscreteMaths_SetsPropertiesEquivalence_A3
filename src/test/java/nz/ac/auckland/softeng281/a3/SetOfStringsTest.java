package nz.ac.auckland.softeng281.a3;

// YOU SHOULD ADD NEW TEST CASES

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SetOfStringsTest {
	SetOfStrings set1, set2;

	@Before
	public void setUp() {
		set1 = new SetOfStrings();
		set2 = new SetOfStrings();
	}

	@After
	public void tearDown() {

	}

	@Test
	public void testUnion() {

		set1.insertElement("a");
		set2.insertElement("b");

		SetOfStrings expected = new SetOfStrings();
		expected.insertElement("a");
		expected.insertElement("b");
		assertEquals(expected, set1.union(set2));
	}

}
