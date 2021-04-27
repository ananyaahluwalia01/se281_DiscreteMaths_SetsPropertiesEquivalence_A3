package nz.ac.auckland.softeng281.a3;

// *******************************
// YOU SHOULD NOT MODIFY THIS CLASS
// *******************************

/**
 * This program uses MVC and has the following classes The SetUI class reads a
 * file in dot format It also has a method to read user commands over this file
 * The entity classes are SetOfStrings and StringRelations The SetContrtol is
 * the main controller which has a execute() method that joins all the classes
 * by passing appropriate messages
 * <p>
 * The controller class parses the user commands by invoking the appropriate
 * method of the SetUI class and then processes the command The program runs
 * until user specifies the "exit" command and to support set operations on
 * these SetOfStrings
 *
 * @author PARTHA ROOP
 */
public class SetControl {

	private final SetOfStrings setMembers;
	private final StringRelation relations;
	private final SetUI sUI;

	/**
	 * The constructor that initializes all private members
	 */
	public SetControl() {
		setMembers = new SetOfStrings();
		relations = new StringRelation();
		relations.setSetMemberElements(setMembers);
		sUI = new SetUI();
	}

	/**
	 * The main method that reads the next user command and processes it until the
	 * "exit" command is entered
	 */
	public void execute() {
		boolean isAnotherCommand;
		do {
			String nextCmd = sUI.getCommand();
			isAnotherCommand = processCommand(nextCmd);
		} while (isAnotherCommand);
	}

	/**
	 * This method processes a given user command
	 *
	 * @param command
	 * @return true if another command is required false if we need to terminate the
	 *         program
	 */
	public boolean processCommand(String command) {

		System.out.println("The command is " + command);
		String[] parts = command.split(" ");

		switch (parts[0]) {
		case "open":
			if (parts.length == 1) {
				System.out.println("Invalid file name");
				return true;
			} else if (parts.length == 2) {
				sUI.open(parts[1]);
				createSetElements();
				createRelationElements();
			} else if (!sUI.getFileStatus()) {
				System.out.println("File can't be opened");
				System.out.println("Enter a valid file name");
				return true;
			}
			break;

		case "help":
			System.out.println("You can either *open* a file or *list* an opened file or *exit* the program");
			System.out.println("Once a valid file is open you can check its properties using the *check* command");
			break;
		case "list":
			if (sUI.getFileStatus()) {
				sUI.list();
			}
			break;
		case "check":
			if (!sUI.getFileStatus()) {
				System.out.println("First open a valid file ");
				break;
			} else if (parts.length == 1) {
				System.out.println("Invalid check command: specify -r / -s/ -t ");
				return true;
			} else if (parts.length == 2) {
				switch (parts[1]) {
				case "-r":
					if (relations.isReflexive()) {
						System.out.println("The relation is reflexive");
						break;
					} else {
						System.out.println("The relation is NOT reflexive");
						break;
					}
				case "-s":
					if (relations.isSymmetric()) {
						System.out.println("The relation is symmetric");
						break;
					} else {
						System.out.println("The relation is NOT symmetric");
						break;
					}
				case "-t":
					if (relations.isTransitive()) {
						System.out.println("The relation is transitive");
						break;
					} else {
						System.out.println("The relation is NOT transitive");
						break;
					}
				case "-e":
					if (relations.isEquivalence()) {
						System.out.println("The relation is an equivalence relation");
						break;
					} else {
						System.out.println("The relation is NOT an equivalence relation");
						break;
					}
				default:
					System.out.println("Invalid check command entered .. try again");
					break;
				}
			}
			break;
		case "eqclass":
			if (sUI.getFileStatus()) {
				SetOfStrings out = relations.eqClass(parts[1]);
				if (!out.isEmpty()) {
					sUI.listEqClass(parts[1], out);
				}
			}
			break;
		case "exit":
			System.out.println("We will exit now.. bye!!");
			return false;
		default:
			System.out.println("Enter a valid command:");
			return true;
		}
		return true;
	}

	private void createSetElements() {
		setMembers.clear();
		for (String el : sUI.getSetElements()) {
			setMembers.insertElement(el);
		}
	}

	private void createRelationElements() {
		relations.clear();
		for (String rel : sUI.getRelationElements()) {
			relations.insertElement(rel);
		}
	}

	public static void main(String[] args) {
		SetControl controller = new SetControl();
		controller.execute();
	}
}