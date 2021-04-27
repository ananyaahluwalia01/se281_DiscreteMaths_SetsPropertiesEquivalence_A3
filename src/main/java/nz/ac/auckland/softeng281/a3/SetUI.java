package nz.ac.auckland.softeng281.a3;

//*******************************
//YOU SHOULD NOT MODIFY THIS CLASS
//*******************************

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;

/**
 * This is the view class in this program using MVC The SetUI class reads a file
 * in dot format It also has a method to read user commands over this file
 *
 * @author PARTHA ROOP
 */
public class SetUI {
	// This stores the file name
	private String fileName;
	// This is set to true if a valid file has been opened
	private boolean fileStatus;
	// These store the lines, the elements of the set and the elements of the
	// relation
	// when the file is successfully opened
	private final List<String> fileLines;
	private final List<String> setElements;
	private final List<String> relationElements;

	public static Scanner scanner = new Scanner(System.in);

	public SetUI() {
		topicScreen();
		fileName = "NULL";
		fileLines = new ArrayList<>();
		fileStatus = false;
		setElements = new ArrayList<>();
		relationElements = new ArrayList<>();
	}

	public String getCommand() {
		System.out.print(">>");
		return scanner.nextLine();
	}

	public void open(String file) {
		setFileName(file);
		try {
			if (!processFile()) {
				System.out.println("File doesn't exist");
				System.out.println("Enter a valid file name");
			} else {
				// refresh the vectors every time a new file is opened
				setElements.clear();
				relationElements.clear();
				createSetElements();
				makeTokensGraph();
			}
		} catch (FileNotFoundException f) {
			System.err.println("File not found " + f);
		}
	}

	public void list() {
		listSetMembers();
		listRelationMembers();
	}

	private String concatenateElements(Enumeration<String> elements) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		while (elements.hasMoreElements()) {
			String nextEl = (String) elements.nextElement();
			sb.append(nextEl);
			if (elements.hasMoreElements()) {
				sb.append(",");
			}
		}
		sb.append("}");
		return sb.toString();
	}

	public void listEqClass(String node, SetOfStrings eq) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append(node);
		sb.append("]");
		sb.append("=");
		// create the list and sort to be sure we print consistent content
		List<String> list = new ArrayList<>(eq.getElements());
		Collections.sort(list);
		sb.append(concatenateElements(Collections.enumeration(list)));
		System.out.println("The equivalence class : " + sb.toString());
	}

	// Other getters and setters
	public void setFileName(String file) {
		fileName = createFileName(file);
	}

	public String getFileName() {
		return fileName;
	}

	public boolean getFileStatus() {
		return fileStatus;
	}

	public void setFileStatusTrue() {
		fileStatus = true;
	}

	public void setFileStatusFalse() {
		fileStatus = false;
	}

	public List<String> getSetElements() {
		return setElements;
	}

	public List<String> getRelationElements() {
		return relationElements;
	}

	// Private methods -- helper methods

	private void listSetMembers() {
		System.out.println("The set elements are: " + concatenateElements(Collections.enumeration(setElements)));
	}

	private void listRelationMembers() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (String rel : relationElements) {
			sb.append("(");
			sb.append(rel);
			sb.append(")");
		}
		sb.append("}");
		System.out.println("The relational elements are: " + sb.toString());

	}

	private String createFileName(String file) {
		String line = System.getProperty("user.dir");
		System.out.println("The current directory is " + line);
		line = line + File.separator + "testcases" + File.separator + file;
		System.out.println("The full path name is: " + line);
		return line;
	}

	private void topicScreen() {
		System.out.println("----------------------------------------------------------------------");
		System.out.println("Set Calculator. To know available commands, please type 'help");
		System.out.println("----------------------------------------------------------------------");
	}

	/**
	 * This method opens the file and If successful sets the file status to true
	 * File status is false otherwise
	 */
	private boolean processFile() throws FileNotFoundException {
		fileLines.clear();
		try {
			File f = new File(fileName);
			if (!f.exists()) {
				setFileStatusFalse();
				return false;
			} else {
				setFileStatusTrue();
			}
			Scanner s = new Scanner(f);
			while (s.hasNextLine()) {
				fileLines.add(s.nextLine());
			}
			s.close();
		} catch (FileNotFoundException e) {
			System.out.println("File reading error");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private void createSetElements() throws FileNotFoundException {
		String parts[] = fileLines.get(0).split("//");
		String tokens[] = parts[1].split(",");
		int i = 0;
		while (i < tokens.length) {
			tokens[i] = tokens[i].trim();
			setElements.add(tokens[i]);
			++i;
		}
	}

	private String[] makeTokensGraphEdge(String line) {
		String out[] = line.split("->");
		out[0] = out[0].trim();
		out[1] = out[1].trim();
		int i;
		if (out[1].contains(";") && !(out[1].contains("["))) {
			i = out[1].indexOf(";");
			out[1] = out[1].substring(0, i);
		} else if (out[1].contains("[")) {
			i = out[1].indexOf("[");
			out[1] = out[1].substring(0, i);
		}
		out[0] = out[0].trim();
		out[1] = out[1].trim();
		return out;
	}

	private void makeTokensGraph() {

		for (String line : fileLines) {
			line = line.trim();
			if (!line.equals("digraph testgraph{") && !line.equals("}") && line.charAt(0) != '/') {
				String adjNodes[] = makeTokensGraphEdge(line);
				String pair = adjNodes[0].trim() + "," + adjNodes[1].trim();
				// This will remove all white spaces between a , b tutple
				pair = pair.replaceAll("\\s+", "");
				relationElements.add(pair);
			}
		}

	}
}