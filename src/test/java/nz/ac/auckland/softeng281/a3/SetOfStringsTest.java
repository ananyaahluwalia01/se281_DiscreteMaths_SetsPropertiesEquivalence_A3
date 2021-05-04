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

	// testing union method
	@Test
	public void testUnion() {

		set1.insertElement("a");
		set2.insertElement("b");

		SetOfStrings expected = new SetOfStrings();
		expected.insertElement("a");
		expected.insertElement("b");
		assertEquals(expected, set1.union(set2));
	}
	
	// testing union function for two sets containing the same element creating set with only one instance of the element.
	@Test
	public void testUnionSameElement() {
		set1.insertElement("a");
		set2.insertElement("a");
		
		assertEquals(set1.union(set2).size(), 1);
	}
	
	// testing union function for two empty sets creating another empty set
	@Test
	public void testUnionEmptySets() {
		assertEquals(set1.union(set2).size(), 0);
	}
	
	// testing intersection method
	@Test
	public void testIntersection() {

		set1.insertElement("a");
		set1.insertElement("b");
		set2.insertElement("b");
		set2.insertElement("c");

		SetOfStrings expected = new SetOfStrings();
		expected.insertElement("b");
		
		assertEquals(expected, set1.intersection(set2));
	}
	
	// testing intersection method for no overlapping elements
	@Test
	public void testIntersectionNoOverlap() {

		set1.insertElement("a");
		set1.insertElement("b");
		set2.insertElement("c");
		set2.insertElement("d");
			
		assertEquals(0, set1.intersection(set2).size());
	}
		
	// testing difference method
	@Test
	public void testDifference() {

		set1.insertElement("a");
		set1.insertElement("b");
		set1.insertElement("c");
		set2.insertElement("a");
			
		SetOfStrings expected = new SetOfStrings();
		expected.insertElement("b");
		expected.insertElement("c");
					
		assertEquals(expected, set1.difference(set2));
	}
		
	// testing difference method for all overlapping elements (e.g. 2 same sets)
	@Test
	public void testDifferenceNoDifference() {

		set1.insertElement("a");
		set1.insertElement("b");
		set1.insertElement("c");
		set2.insertElement("a");
		set2.insertElement("b");
		set2.insertElement("c");
			
					
		assertEquals(0, set1.difference(set2).size());
	}

}


