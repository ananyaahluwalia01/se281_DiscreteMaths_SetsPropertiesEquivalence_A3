package nz.ac.auckland.softeng281.a3;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringRelationTest {

	private StringRelation relation;
	private SetOfStrings setMembers;

	@Before
	public void setUp() {
		setMembers = new SetOfStrings();
		relation = new StringRelation(setMembers);
	}

	@After
	public void tearDown() {

	}

	// testing reflexive method 
	@Test
	public void testReflexive() {
		relation.insertElement("1,1");
		setMembers.insertElement("1");
		assertTrue(relation.isReflexive());
	}

	// testing reflexive method for a relation thats not reflexive
	@Test
	public void testReflexiveFalse() {
		relation.insertElement("1,2");
		setMembers.insertElement("1");
		setMembers.insertElement("2");			
		assertTrue(!relation.isReflexive());
	}

	// testing reflexive method for a relation thats not reflexive, because one of the members doesn't have an edge to itself
	@Test
	public void testReflexiveFalseNotAll() {
		relation.insertElement("1,2");
		relation.insertElement("1,1");
		relation.insertElement("2,2");
		setMembers.insertElement("1");
		setMembers.insertElement("2");	
		setMembers.insertElement("3");	

		assertTrue(!relation.isReflexive());
	}

	// testing reflexive method for an empty R
	@Test
	public void testReflexiveEmpty() {
		setMembers.insertElement("1");
		setMembers.insertElement("2");	
		setMembers.insertElement("3");	

		assertTrue(!relation.isReflexive());
	}

	// testing symmetric method
	@Test
	public void testSymmetric() {
		relation.insertElement("1,2");
		relation.insertElement("2,1");
		setMembers.insertElement("1");
		setMembers.insertElement("2");	

		assertTrue(relation.isSymmetric());
	}

	// testing symmetric method false (relation isn't symmetric)
	@Test
	public void testSymmetricFalse() {
		relation.insertElement("1,2");
		relation.insertElement("2,1");
		relation.insertElement("3,1");
		setMembers.insertElement("1");
		setMembers.insertElement("2");	
		setMembers.insertElement("3");	

		assertTrue(!relation.isSymmetric());
	}

	// testing symmetric method for an empty R
	@Test
	public void testSymmetricEmpty() {
		setMembers.insertElement("1");
		setMembers.insertElement("2");	
		setMembers.insertElement("3");	

		assertTrue(relation.isSymmetric());
	}	

	// testing transitive method
	@Test
	public void testTransitive() {
		relation.insertElement("1,2");
		relation.insertElement("2,3");
		relation.insertElement("1,3");

		setMembers.insertElement("1");
		setMembers.insertElement("2");	
		setMembers.insertElement("3");	

		assertTrue(relation.isTransitive());
	}

	// testing transitive method true again
	@Test
	public void testTransitiveTrue2() {
		relation.insertElement("1,1");
		relation.insertElement("2,2");
		relation.insertElement("3,3");
		relation.insertElement("1,2");

		setMembers.insertElement("1");
		setMembers.insertElement("2");	
		setMembers.insertElement("3");	

		assertTrue(relation.isTransitive());
	}

	// testing transitive method false
	@Test
	public void testTransitiveFalse() {
		relation.insertElement("1,1");
		relation.insertElement("1,2");
		relation.insertElement("1,3");
		relation.insertElement("2,4");

		setMembers.insertElement("1");
		setMembers.insertElement("2");	
		setMembers.insertElement("3");
		setMembers.insertElement("3");

		assertTrue(!relation.isTransitive());
	}

	// testing transitive method for an empty R
	@Test
	public void testTransitiveEmpty() {
		setMembers.insertElement("1");
		setMembers.insertElement("2");	
		setMembers.insertElement("3");	

		assertTrue(relation.isTransitive());
	}

	// testing equivalence method
	@Test
	public void testEquivalence() {
		setMembers.insertElement("1");
		setMembers.insertElement("2");	
		setMembers.insertElement("3");
		relation.insertElement("1,1");
		relation.insertElement("2,2");
		relation.insertElement("3,3");
		relation.insertElement("1,2");
		relation.insertElement("2,1");
		relation.insertElement("1,3");
		relation.insertElement("3,1");
		relation.insertElement("2,3");
		relation.insertElement("3,2");


		assertTrue(relation.isEquivalence());
	}

	// testing equivalence class
	@Test 
	public void testComputeEqClass() {
		setMembers.insertElement("1");
		setMembers.insertElement("2");	
		setMembers.insertElement("3");
		relation.insertElement("1,1");
		relation.insertElement("2,2");
		relation.insertElement("3,3");
		relation.insertElement("1,2");
		relation.insertElement("2,1");
		relation.insertElement("1,3");
		relation.insertElement("3,1");
		relation.insertElement("2,3");
		relation.insertElement("3,2");

		SetOfStrings expected = new SetOfStrings();
		expected.insertElement("1");
		expected.insertElement("2");
		expected.insertElement("3");

		assertTrue(expected.equals(relation.computeEqClass("1")));
	}


}