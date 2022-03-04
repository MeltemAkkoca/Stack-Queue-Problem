
//-----------------------------------------------------
// Title: CMPE223 HW1
// Author: Meltem AKKOCA
// ID: 
// Section: 1
// Assignment: 1
// Description: This class tests if given string is good string and its good value.
//-----------------------------------------------------
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class QueueList {
	public static void main(String[] args) throws Exception {
		File file = new File("C:\\Users\\user\\Desktop\\sampleinput2.txt");

		BufferedReader br = new BufferedReader(new FileReader(file));

		int numberOfEx = 0;

		for (int a = 0; a < 1; a++) {
			//---------------------------------------
			//The first line of the string in the txt file was giving us
			//how many expressions there were, it was created to get the first line.
			//---------------------------------------
			String string = br.readLine();
			numberOfEx = Integer.parseInt(string);
		}

		String[] line = new String[numberOfEx];//A string array with as many elements as the number entered in the first line is created.

		String st;
		int index = 0;

		while ((st = br.readLine()) != null) {

			line[index] = st;
			index++;

		}

		for (int t = 0; t < numberOfEx; t++) {
			String s = line[t];
			int[] alphabet;
			boolean isWell;
			int goodValue = 0;
			Queue<Character> queue = new Queue<>();

			for (int i = 0; i < s.length(); i++) {
				// --------------------------------------------------------------------
				// to read the entered inputs one by one along the length of the string
				// --------------------------------------------------------------------
				for (int j = i + 1; j < s.length(); j++) {
					// --------------------------------------------------------------------
					// To find the substring between i and j
					// --------------------------------------------------------------------
					alphabet = new int[26];
					isWell = true;

					for (int k = i; k < j + 1; k++) {
						// ----------------------------------------------------
						// To put all the characters in the substring into queue
						// ----------------------------------------------------
						char c = s.charAt(k);
						queue.enqueue(c);
					}

					int length = queue.size();
					// --------------------------------------------------------------------
					// the size of queue which is kept substring between i and j
					// --------------------------------------------------------------------

					if (length >= 26) {
						// --------------------------------------------------------------------
						// if we have less than 26 char, we do not need to look at the substring,
						// because it cannot be good string
						// --------------------------------------------------------------------
						for (int m = 0; m < length; m++) {
							// --------------------------------------------------------------------
							// we have more than or equal to 26 char and we need to go around in the
							// substring. When we remove characters
							// from the queue, each characters' symbol of ascii will increased its index in
							// the alphabet array which is type int.
							// --------------------------------------------------------------------
							char c = queue.dequeue();
							alphabet[c - 97]++;
						}

						for (int k : alphabet) {
							// --------------------------------------------------------------------
							// we will go around along the alphabet array and If any index is equal to zero,
							// this substring is not a good string.
							// --------------------------------------------------------------------
							if (k == 0) {
								isWell = false;
								break;
							}
						}
						if (isWell)
							goodValue++;

					}

				}
			}
			System.out.println("Parsing string #" + (t + 1) + ":");
			System.out.println(goodValue);
		}
	}
}
