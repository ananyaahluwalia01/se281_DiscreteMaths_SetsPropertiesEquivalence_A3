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
				if (!this.isMember(memberInThis + "," + memberInThis)) {
					return false;
				}
			}
			return true;
		}
	}

	// method to split an edge by the comma, giving the two nodes it connects
	private String[] splitRelation(String relation) {
		return relation.split(",");
	}

	// members = vertex, elements = relation
	public boolean isSymmetric() {
		// if relation is not a subset of the Cartesian product of the set, return false (invalid)
		if (!isValid()) {
			return false;
		} else {

			// if relation valid, loop through the relations in this
			for (String relationInThis: this.getElements()) {

				// split the current edge by the comma, giving the two nodes it connects
				String[] relationNodes = splitRelation(relationInThis);

				// if the alternate order of the nodes: nodeB,nodeA is not an edge, return false
				if (!this.isMember(relationNodes[1] + "," + relationNodes[0])) {
					return false;
				}
			}
			return true;
		}
	}

	public boolean isTransitive() {
		// if relation is not a subset of the Cartesian product of the set, return false (invalid)
		if (!isValid()) {
			return false;
		} else {

			// if relation valid loop through edges and split into the nodes, check every edge against the other edges on the list (nested for loop)
			for (String relationI: this.getElements()) {
				String[] relationINodes = splitRelation(relationI);;

				for (String relationJ: this.getElements()) {
					String[] relationJNodes = splitRelation(relationJ);;

					// if the relations (a,b),(c,d) exist such that a=d, make sure (c,b) is in the relation
					if (relationINodes[0].equals(relationJNodes[1])) {
						if (!this.isMember(relationJNodes[0] + "," + relationINodes[1])) {
							return false;
						}
					}

					// if the relations (a,b),(c,d) exist such that b=c, make sure (a,d) is in the relation
					if (relationINodes[1].equals(relationJNodes[0])) {
						if (!this.isMember(relationINodes[0] + "," + relationJNodes[1])) {
							return false;
						}
					}
				}
			}
			return true;
		}
	}

	public boolean isEquivalence() {
		// checks if all functions return true, before returning true
		if (this.isReflexive() && this.isSymmetric() && this.isTransitive()) {
			return true;
		} else {
			return false;
		}
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
		SetOfStrings returnEqClass = new SetOfStrings();

		// Check if any relations have The Node as a node. If yes, add what they connect to, to returned set.
		for (String relationInThis: this.getElements()) {
			String[] relationNodes = splitRelation(relationInThis);;

			if (node.equals(relationNodes[0])) {
				returnEqClass.insertElement(relationNodes[1]);
			} else if (node.equals(relationNodes[1])) {
				returnEqClass.insertElement(relationNodes[0]);
			}
		}
		return returnEqClass;
	}
}