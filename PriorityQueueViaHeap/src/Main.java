import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Comparator;

/**

 The Main class is responsible for running the program by reading CSV files containing candidate information,
 adding candidates to a priority queue based on their score, and printing the candidates in sorted order.
 Additionally, the Main class sorts an array of integers using an ArrayHeap data structure.
 */
public class Main {
            /**
             * The main method runs the program by reading CSV files containing candidate information,
             * adding candidates to a priority queue based on their score, and printing the candidates in sorted order.
             * Additionally, the main method sorts an array of integers using an ArrayHeap data structure.
             * @param args An array of command-line arguments containing the names of the CSV files to be read.
             * @throws FileNotFoundException if the specified file cannot be found.
             */

            public static void main(String[] args) throws FileNotFoundException {
                ArrayList<String[]> candidates = new ArrayList<String[]>(); //empty arraylist

                for (String fileName : args) { //iterate through files in args
                    // Create a new CSVReader object to read the CSV file specified by the fileName parameter.
                            CSVReader reader = new CSVReader();
                    // Create a new FileReader object to read the contents of the file.
                    FileReader input = new FileReader(fileName);
                    // Call the read() method of the CSVReader object to read the data from the FileReader and store it in an ArrayList of String arrays.
                    ArrayList<String[]> csvData = reader.read(input);

                    for (String[] sLine : csvData) { //iterate through each line
                        candidates.add(sLine); // adds to the arraylist
                    }
                }

                ArrayHeap<Candidate> candidatesData = new ArrayHeap<Candidate>();

                for (String[] candidateDataArray : candidates) { //goes through arrays of candidate data
                    Candidate newCandidate = new Candidate(candidateDataArray[0], candidateDataArray[1], Double.parseDouble(candidateDataArray[2])); //creates new candidate
                    candidatesData.insert(newCandidate); //inserts into priority queue
                }
                System.out.println("Candidates sorted by score:");
                while (!candidatesData.isEmpty()) { //print candidates in sorted order
                    System.out.println(candidatesData.removeMax());
                }


                System.out.println("\nThe sorted array is ");

                //create an ArrayList using static method "asList"
                Integer[] arr = {-2, 3, 9, -7, 1, 2, 6, -3};
                ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(arr));

                //make a new heap out of the array
                ArrayHeap<Integer> heap = new ArrayHeap<Integer>();
                ArrayList<Integer> sortedArray = heap.sort(array);
                System.out.println(sortedArray + "\n");


                ArrayHeap<Character> letterHeap = new ArrayHeap<Character>();
                letterHeap.insert('A');
                letterHeap.insert('C');
                letterHeap.insert('G');
                letterHeap.insert('B');
                letterHeap.insert('D');
                letterHeap.insert('G'); // inserting again, will still both copies
                letterHeap.insert('F');
                letterHeap.insert('E');
                letterHeap.insert('H');
                letterHeap.insert('I');
                System.out.println("size:" + letterHeap.size());
                System.out.println(letterHeap);



                Integer[] numbers = {-2, 3, 9, -7, 1, 2, 6, -3};
                ArrayHeap<Integer> numberHeap = new ArrayHeap<>(); // Create a new heap of Integers
                for (Integer num : numbers) {
                    numberHeap.insert(num); // Insert each element from the arr array into the heap
                }
                System.out.println(numberHeap); // Print the heap

            }

        }

