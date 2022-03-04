
//-----------------------------------------------------
// Title:  CMPE223  HW1
// Author: Meltem Akkoca
// ID: 
// Section: 1
// Assignment: 1
// Description: This class tests the whether these entered expressions are in well form
//-----------------------------------------------------
import java.io.*;


public class StackList {

	public static void main(String[] args) throws Exception {
		File file = new File("C:\\Users\\user\\Desktop\\sampleinput1.txt");

		BufferedReader br = new BufferedReader(new FileReader(file));

		int numberOfEx = 0;

		for (int a = 0; a < 1; a++) {
			//---------------------------------------
			//The first line of the string in the txt file was giving us how
			//many expressions there were, it was created to get the first line.
			//---------------------------------------
			String string = br.readLine();
			numberOfEx = Integer.parseInt(string);
		}

		String[] line = new String[numberOfEx]; //A string array with as many elements as the number entered in the first line is created.

		String st;
		int index = 0;

		while ((st = br.readLine()) != null) {

			line[index] = st;
			index++;

		}

		for (int i = 0; i < numberOfEx; i++) { // this for loop is related to evaluate each
												// expression separately inside the loop.
			System.out.println("Parsing expression #" + (i + 1) + ":");
			String exp = line[i];

			Stack<Character> operations = new Stack(); // we need to collect characters inside the entered
														// expression into a stack.
			Stack<Integer> indexNumbers = new Stack();// we need to collect characters' index inside the entered
														// expression into another stack.

			boolean isWell = true; // to keep a boolean data to use other parts in the code to control
									// whether the given expression is well formed or not.
			int valid = 1;

			for (int k = 0; k < exp.length(); k++) { // in this nested for loop we need to control each expression's
				// character and decide that if it is valid for the characters which we want or
				// not.
				char temp = exp.charAt(k); // to keep each character of the expression in a temp because we need to find
											// the shortest
											// way not to write again and again charAt method.
				if (temp != '(' && temp != '[' && temp != '{' && temp != ')' && temp != ']' && temp != '}'
						&& temp != '+' && temp != '-' && temp != '*' && temp != '/' && temp != ' '
						&& !(temp >= 48 && temp <= 57)) {
					// in this if we need to check whether a expression include invalid character or
					// not. If the expression include invalid
					// character, it is not allowed to go to next for loop.
					System.out.println("invalid parse");
					valid = 0;

					break;

				}

			}
			if (valid == 0) // if its valid zero, than it is not need to enter other statements.
							//

				continue;

			for (int j = 0; j < exp.length(); j++) { // the expression which did not include invalid character is controlled
														// and collected in stack with some methods.
				char key = exp.charAt(j);
				if ((key == '(') || key == '[' || key == '{') {
					indexNumbers.push(j); // index of the characters(which is j) pushed into the stack of
											// indexNumbers.
					operations.push(key); // key (which is the character's data) pushed into the stack of
											// indexNumbers.
				} else if (key == ')' || key == ']' || key == '}') {
					if (operations.isEmpty()) { // if our operations stack is null, the new operation that is
												// entered in stack will ruin
												// well formed situation.
						isWell = false;
						break;
					}
					
					
					// -------------------------------------------------------------------------------
					// to keep operations and its index values in data with pop method (we remove it
					// from the list)
					char operation = operations.pop();
					int startPoint = indexNumbers.pop();
					// --------------------------------------------------------------------------------

					
					// -------------------------------------------------------------------------------
					// If the open and closed brackets match each other, we print the start and end
					// indexes of the expression
					// and express the expression between them with the substring method.
					if (operation == '(' && key == ')') {
						System.out.print(startPoint + ", " + j + ", ");
						System.out.println(exp.substring(startPoint, j + 1));

					} else if (operation == '[' && key == ']') {
						System.out.print(startPoint + ", " + j + ", ");
						System.out.println(exp.substring(startPoint, j + 1));

					} else if (operation == '{' && key == '}') {
						System.out.print(startPoint + "," + j + ",");
						System.out.println(exp.substring(startPoint, j + 1));

					} else {
						isWell = false;
						break;
					}
					// ---------------------------------------------------------------------
				}

			}
			//------------------------------------------------------------
			//According to the isWell value, the result has been printed
			if (isWell == true)
				System.out.println("Given expression is well formed. ");
			else
				System.out.println("Given expression is not well formed.");
			//-----------------------------------------------------------
			
		}

	}

}
