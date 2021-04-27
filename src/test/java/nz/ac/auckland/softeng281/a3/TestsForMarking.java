package nz.ac.auckland.softeng281.a3;

// YOU SHOULD NOT CHANGE THIS CLASS
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({

		TestsForMarking.Task1Test.class, //
		TestsForMarking.Task2Test.class, //
		TestsForMarking.Task3Test.class, //
		TestsForMarking.Task4Test.class, //
		TestsForMarking.Task5Test.class, //
		TestsForMarking.Task6Test.class,

})
public class TestsForMarking {

	/**
	 * 
	 * set of strings
	 *
	 */
	@FixMethodOrder(MethodSorters.JVM)
	public static class Task1Test {

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
		public void testUnion_a_b() {

			set1.insertElement("a");
			set2.insertElement("b");

			SetOfStrings expected = new SetOfStrings();
			expected.insertElement("a");
			expected.insertElement("b");
			assertEquals(expected, set1.union(set2));
		}

		@Test
		public void testIntersection_ab_b() {

			set1.insertElement("a");
			set1.insertElement("b");
			set2.insertElement("b");

			SetOfStrings expected = new SetOfStrings();
			expected.insertElement("b");
			assertEquals(expected, set1.intersection(set2));
		}

		@Test
		public void testDifference_ab_b() {

			set1.insertElement("a");
			set1.insertElement("b");
			set2.insertElement("b");

			SetOfStrings expected = new SetOfStrings();
			expected.insertElement("a");
			assertEquals(expected, set1.difference(set2));
		}

		@Test
		public void testUnion_ab_b() {

			set1.insertElement("a");
			set1.insertElement("b");
			set2.insertElement("b");

			SetOfStrings expected = new SetOfStrings();
			expected.insertElement("a");
			expected.insertElement("b");
			assertEquals(expected, set1.union(set2));
		}

		@Test
		public void testIntersection_ab_c() {

			set1.insertElement("a");
			set1.insertElement("b");
			set2.insertElement("c");

			SetOfStrings expected = new SetOfStrings();
			assertEquals(expected, set1.intersection(set2));
		}

		@Test
		public void testDifference_ab_c() {

			set1.insertElement("a");
			set1.insertElement("b");
			set2.insertElement("c");

			SetOfStrings expected = new SetOfStrings();
			expected.insertElement("a");
			expected.insertElement("b");
			assertEquals(expected, set1.difference(set2));
		}

	}

	/**
	 * 
	 * Reflexive relation
	 *
	 */
	@FixMethodOrder(MethodSorters.JVM)
	public static class Task2Test {

		ByteArrayOutputStream myOut;
		PrintStream origOut;

		@Before
		public void setUp() {
			origOut = System.out;
			myOut = new ByteArrayOutputStream();
			System.setOut(new PrintStream(myOut));
		}

		@After
		public void tearDown() {
			System.setOut(origOut);
			if (myOut.toString().length() > 1) {
				System.out.println(System.lineSeparator() + "the System.out.print was :" + System.lineSeparator()
						+ myOut.toString());
			}
		}

		private void runTest(String fileName, String command) {
			SetUI.scanner = new Scanner("open " + fileName + System.getProperty("line.separator") + "check " + command
					+ System.getProperty("line.separator") + "exit" + System.getProperty("line.separator"));
			SetControl controller = new SetControl();
			controller.execute();
		}

		@Test
		public void testReflexiveA() {
			runTest("a.txt", "-r");
			assertTrue("the relation should be reflexive", myOut.toString().contains("The relation is reflexive"));
		}

		@Test
		public void testReflexiveB() {
			runTest("b.txt", "-r");
			assertTrue("the relation should be reflexive", myOut.toString().contains("The relation is reflexive"));
		}

		@Test
		public void testReflexiveC() {
			runTest("c.txt", "-r");
			assertTrue("the relation should be reflexive", myOut.toString().contains("The relation is reflexive"));
		}

		@Test
		public void testReflexiveD() {
			runTest("d.txt", "-r");
			assertTrue("the relation should be reflexive", myOut.toString().contains("The relation is reflexive"));
		}

		@Test
		public void testReflexiveE() {
			runTest("e.txt", "-r");
			assertTrue("the relation should be reflexive", myOut.toString().contains("The relation is reflexive"));
		}

		@Test
		public void testReflexiveF() {
			runTest("f.txt", "-r");
			assertTrue("the relation should NOT be reflexive",
					myOut.toString().contains("The relation is NOT reflexive"));
		}

		@Test
		public void testReflexiveG() {
			runTest("g.txt", "-r");
			assertTrue("the relation should NOT be reflexive",
					myOut.toString().contains("The relation is NOT reflexive"));
		}

		@Test
		public void testReflexiveH() {
			runTest("h.txt", "-r");
			assertTrue("the relation should NOT be reflexive",
					myOut.toString().contains("The relation is NOT reflexive"));
		}

	}

	/**
	 * 
	 * Reflexive Symmetric
	 *
	 */
	@FixMethodOrder(MethodSorters.JVM)
	public static class Task3Test {

		ByteArrayOutputStream myOut;
		PrintStream origOut;

		@Before
		public void setUp() {
			origOut = System.out;
			myOut = new ByteArrayOutputStream();
			System.setOut(new PrintStream(myOut));
		}

		@After
		public void tearDown() {
			System.setOut(origOut);
			if (myOut.toString().length() > 1) {
				System.out.println(System.lineSeparator() + "the System.out.print was :" + System.lineSeparator()
						+ myOut.toString());
			}
		}

		private void runTest(String fileName, String command) {
			SetUI.scanner = new Scanner("open " + fileName + System.getProperty("line.separator") + "check " + command
					+ System.getProperty("line.separator") + "exit" + System.getProperty("line.separator"));
			SetControl controller = new SetControl();
			controller.execute();
		}

		@Test
		public void testSymmetricA() {
			runTest("a.txt", "-s");
			assertTrue("the relation should NOT be symmetric",
					myOut.toString().contains("The relation is NOT symmetric"));
		}

		@Test
		public void testSymmetricB() {
			runTest("b.txt", "-s");
			assertTrue("the relation should be symmetric", myOut.toString().contains("The relation is symmetric"));
		}

		@Test
		public void testSymmetricC() {
			runTest("c.txt", "-s");
			assertTrue("the relation should be symmetric", myOut.toString().contains("The relation is symmetric"));
		}

		@Test
		public void testSymmetricD() {
			runTest("d.txt", "-s");
			assertTrue("the relation should NOT be symmetric",
					myOut.toString().contains("The relation is NOT symmetric"));
		}

		@Test
		public void testSymmetricE() {
			runTest("e.txt", "-s");
			assertTrue("the relation should be symmetric", myOut.toString().contains("The relation is symmetric"));
		}

		@Test
		public void testSymmetricF() {
			runTest("f.txt", "-s");
			assertTrue("the relation should NOT be symmetric",
					myOut.toString().contains("The relation is NOT symmetric"));
		}

		@Test
		public void testSymmetricG() {
			runTest("g.txt", "-s");
			assertTrue("the relation should NOT be symmetric",
					myOut.toString().contains("The relation is NOT symmetric"));
		}

		@Test
		public void testSymmetricH() {
			runTest("h.txt", "-s");
			assertTrue("the relation should be symmetric", myOut.toString().contains("The relation is symmetric"));
		}

	}

	/**
	 * 
	 * Transitive relation
	 *
	 */
	@FixMethodOrder(MethodSorters.JVM)
	public static class Task4Test {

		ByteArrayOutputStream myOut;
		PrintStream origOut;

		@Before
		public void setUp() {
			origOut = System.out;
			myOut = new ByteArrayOutputStream();
			System.setOut(new PrintStream(myOut));
		}

		@After
		public void tearDown() {
			System.setOut(origOut);
			if (myOut.toString().length() > 1) {
				System.out.println(System.lineSeparator() + "the System.out.print was :" + System.lineSeparator()
						+ myOut.toString());
			}
		}

		private void runTest(String fileName, String command) {
			SetUI.scanner = new Scanner("open " + fileName + System.getProperty("line.separator") + "check " + command
					+ System.getProperty("line.separator") + "exit" + System.getProperty("line.separator"));
			SetControl controller = new SetControl();
			controller.execute();
		}

		@Test
		public void testTransitiveA() {
			runTest("a.txt", "-t");
			assertTrue("the relation should NOT be transitive",
					myOut.toString().contains("The relation is NOT transitive"));
		}

		@Test
		public void testTransitiveB() {
			runTest("b.txt", "-t");
			assertTrue("the relation should NOT be transitive",
					myOut.toString().contains("The relation is NOT transitive"));
		}

		@Test
		public void testTransitiveC() {
			runTest("c.txt", "-t");
			assertTrue("the relation should be transitive", myOut.toString().contains("The relation is transitive"));
		}

		@Test
		public void testTransitiveD() {
			runTest("d.txt", "-t");
			assertTrue("the relation should be transitive", myOut.toString().contains("The relation is transitive"));
		}

		@Test
		public void testTransitiveE() {
			runTest("e.txt", "-t");
			assertTrue("the relation should be transitive", myOut.toString().contains("The relation is transitive"));
		}

		@Test
		public void testTransitiveF() {
			runTest("f.txt", "-t");
			assertTrue("the relation should NOT be transitive",
					myOut.toString().contains("The relation is NOT transitive"));
		}

		@Test
		public void testTransitiveG() {
			runTest("g.txt", "-t");
			assertTrue("the relation should NOT be transitive",
					myOut.toString().contains("The relation is NOT transitive"));
		}

		@Test
		public void testTransitiveH() {
			runTest("h.txt", "-t");
			assertTrue("the relation should be transitive", myOut.toString().contains("The relation is transitive"));
		}

	}

	/**
	 * 
	 * Equivalent relation
	 *
	 */
	@FixMethodOrder(MethodSorters.JVM)
	public static class Task5Test {

		ByteArrayOutputStream myOut;
		PrintStream origOut;

		@Before
		public void setUp() {
			origOut = System.out;
			myOut = new ByteArrayOutputStream();
			System.setOut(new PrintStream(myOut));
		}

		@After
		public void tearDown() {
			System.setOut(origOut);
			if (myOut.toString().length() > 1) {
				System.out.println(System.lineSeparator() + "the System.out.print was :" + System.lineSeparator()
						+ myOut.toString());
			}
		}

		private void runTest(String fileName, String command) {
			SetUI.scanner = new Scanner("open " + fileName + System.getProperty("line.separator") + "check " + command
					+ System.getProperty("line.separator") + "exit" + System.getProperty("line.separator"));
			SetControl controller = new SetControl();
			controller.execute();
		}

		@Test
		public void testEquivalentA() {
			runTest("a.txt", "-e");
			assertTrue("the relation should NOT be an equivalent relation",
					myOut.toString().contains("The relation is NOT an equivalence relation"));
		}

		@Test
		public void testEquivalentB() {
			runTest("b.txt", "-e");
			assertTrue("the relation should NOT be an equivalent relation",
					myOut.toString().contains("The relation is NOT an equivalence relation"));
		}

		@Test
		public void testEquivalentC() {
			runTest("c.txt", "-e");
			assertTrue("the relation should be an equivalent relation",
					myOut.toString().contains("The relation is an equivalence relation"));
		}

		@Test
		public void testEquivalentD() {
			runTest("d.txt", "-e");
			assertTrue("the relation should NOT be an equivalent relation",
					myOut.toString().contains("The relation is NOT an equivalence relation"));
		}

		@Test
		public void testEquivalentE() {
			runTest("e.txt", "-e");
			assertTrue("the relation should be an equivalent relation",
					myOut.toString().contains("The relation is an equivalence relation"));
		}

		@Test
		public void testEquivalentF() {
			runTest("f.txt", "-e");
			assertTrue("the relation should NOT be an equivalent relation",
					myOut.toString().contains("The relation is NOT an equivalence relation"));
		}

		@Test
		public void testEquivalentG() {
			runTest("g.txt", "-e");
			assertTrue("the relation should NOT be an equivalent relation",
					myOut.toString().contains("The relation is NOT an equivalence relation"));
		}

		@Test
		public void testEquivalentH() {
			runTest("h.txt", "-e");
			assertTrue("the relation should NOT be an equivalent relation",
					myOut.toString().contains("The relation is NOT an equivalence relation"));
		}
	}

	/**
	 * 
	 * Equivalent relation
	 *
	 */
	@FixMethodOrder(MethodSorters.JVM)
	public static class Task6Test {

		ByteArrayOutputStream myOut;
		PrintStream origOut;

		@Before
		public void setUp() {
			origOut = System.out;
			myOut = new ByteArrayOutputStream();
			System.setOut(new PrintStream(myOut));
		}

		@After
		public void tearDown() {
			System.setOut(origOut);
			if (myOut.toString().length() > 1) {
				System.out.println(System.lineSeparator() + "the System.out.print was :" + System.lineSeparator()
						+ myOut.toString());
			}
		}

		private void runTest(String fileName, String command) {
			SetUI.scanner = new Scanner("open " + fileName + System.getProperty("line.separator") + "eqclass " + command
					+ System.getProperty("line.separator") + "exit" + System.getProperty("line.separator"));
			SetControl controller = new SetControl();
			controller.execute();
		}

		@Test
		public void testEquivalentClassA() {
			runTest("a.txt", "1");
			assertTrue("the relation should NOT be an equivalent relation",
					myOut.toString().contains("Can't compute equivalence class.. NOT an equivalence relation"));
		}

		@Test
		public void testEquivalentClassB() {
			runTest("b.txt", "1");
			assertTrue("the relation should NOT be an equivalent relation",
					myOut.toString().contains("Can't compute equivalence class.. NOT an equivalence relation"));
		}

		@Test
		public void testEquivalentClassC() {
			runTest("c.txt", "1");
			assertTrue("The equivalence class of node 1 should be : [1]={1,2,3}",
					myOut.toString().contains("The equivalence class : [1]={1,2,3}"));
		}

		@Test
		public void testEquivalentClassD() {
			runTest("d.txt", "1");
			assertTrue("the relation should NOT be an equivalent relation",
					myOut.toString().contains("Can't compute equivalence class.. NOT an equivalence relation"));
		}

		@Test
		public void testEquivalentClassE() {
			runTest("e.txt", "2");
			assertTrue("The equivalence class of node 2 should be: [2]={2}",
					myOut.toString().contains("The equivalence class : [2]={2}"));
		}

		@Test
		public void testEquivalentClassF() {
			runTest("f.txt", "1");
			assertTrue("the relation should NOT be an equivalent relation",
					myOut.toString().contains("Can't compute equivalence class.. NOT an equivalence relation"));
		}

		@Test
		public void testEquivalentClassG() {
			runTest("g.txt", "1");
			assertTrue("the relation should NOT be an equivalent relation",
					myOut.toString().contains("Can't compute equivalence class.. NOT an equivalence relation"));
		}

		@Test
		public void testEquivalentClassH() {
			runTest("h.txt", "1");
			assertTrue("the relation should NOT be an equivalent relation",
					myOut.toString().contains("Can't compute equivalence class.. NOT an equivalence relation"));
		}

	}

}
