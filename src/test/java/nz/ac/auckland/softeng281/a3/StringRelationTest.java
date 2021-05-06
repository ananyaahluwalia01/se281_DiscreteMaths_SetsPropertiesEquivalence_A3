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
	
	

}