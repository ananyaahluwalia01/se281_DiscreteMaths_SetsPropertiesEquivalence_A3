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

}