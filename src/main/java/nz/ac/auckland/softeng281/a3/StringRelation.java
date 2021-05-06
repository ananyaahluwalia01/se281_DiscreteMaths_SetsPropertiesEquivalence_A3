package nz.ac.auckland.softeng281.a3;

//*******************************
//YOU SHOULD MODIFY THIS CLASS FOR TASK2, TASK3, TASK4, TASK5, and TASK6.
//- you can add all the methods that you need.
//- you cannot modify the method signature (return type, method name and parameters) of the existing methods
//- you can change the code of the existing methods but at your own risk! the program might not work properly
//*******************************

/**
 * A class for binary relations over a set of strings.
 *
 * @author Partha Roop
 */
public class StringRelation extends SetOfStrings {
	// This is a set used to store the members of the binary relation
	private SetOfStrings setMembers;

	/**
	 * create an empty StringRelation when no arguments are given -- constructor In
	 * this event the setMembers is a new SetOfStrings with no members yet
	 */
	public StringRelation() {
		this(new SetOfStrings());
	}

	/**
	 * create a StringRelation object
	 */
	public StringRelation(SetOfStrings setMembers) {
		super();
		this.setMembers = setMembers;
	}

	public void setSetMemberElements(SetOfStrings set) {
		setMembers = set;
	}

	public boolean isValid() {
		SetOfStrings product = setMembers.product(setMembers);
		return product.isSupersetOf(this);
	}

	public boolean isReflexive() {

		// if relation is not a subset of the Cartesian product of the set, return false (invalid)
		if (!isValid()) {
			return false;
		} else {
			// if relation valid, loop through the members in setMembers
			for (String memberInThis: this.setMembers.getElements()) {

				// if there is not a relation of every member with an edge to itself, return false.
				String relation = memberInThis + "," + memberInThis;
				if (!this.isMember(relation)) {
					return false;
				}
			}
			return true;
		}
	}

	// members = vertex, elements = relation
	public boolean isSymmetric() {
		if (!isValid()) {
			return false;
		}
		throw new java.lang.UnsupportedOperationException("Not implemented yet.");

	}

	public boolean isTransitive() {
		if (!isValid()) {
			return false;
		}
		throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}

	public boolean isEquivalence() {
		throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}

	/**
	 * do not change this method
	 * 
	 * @param node
	 * @return
	 */
	public SetOfStrings eqClass(String node) {
		if (!isEquivalence()) {
			System.out.println("Can't compute equivalence class.. NOT an equivalence relation");
			return new SetOfStrings();
		}
		return computeEqClass(node);
	}

	public SetOfStrings computeEqClass(String node) {
		throw new java.lang.UnsupportedOperationException("Not implemented yet.");
	}
}