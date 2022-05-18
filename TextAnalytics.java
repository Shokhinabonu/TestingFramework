/*This class is supposed to analyse the given book and create a database through hashmap of words that are being used in the book and how many times they appear in the book
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextAnalytics {
    static String givenWord;
    static Scanner scanner;
    static Scanner scanner2 = new Scanner(System.in);
    static boolean quit;

    /**
     * ProcessTheBook method proccesses the passed book and created the databes of
     * key value pares
     * 
     * @param map - the hashMap where the words will be stored
     * @param scn - the given scanner use to read through the book
     */
    public static void processTheBook(ObjectHashMap map, Scanner scn) {// O(1) since we insert the given word and run
                                                                       // the method again
        boolean startCopying = false;
        while (scn.hasNextLine()) {
            String newLine = scn.nextLine();
            if (newLine.contains("*** START OF")) {
                newLine = scn.nextLine();
                startCopying = true;
            } else if (newLine.contains("*** END OF")) {
                startCopying = false;
            }
            if (startCopying) {
                newLine = newLine.toLowerCase();
                String[] arr = newLine.split("\\s+");
                for (String a : arr) {
                    a = a.replaceAll("[^a-z]", "");
                    if (a.length() > 0) {
                        if (map.containsKey(a)) {
                            int i = ((Integer) map.find(a)) + 1;
                            map.put(a, i);
                        } else {
                            map.put(a, 1);
                        }
                    }

                }
            }
        }

    }

    /**
     * theOutput is supposed to just print the result of looking for a book in the
     * terminal
     * 
     * @param map - the hashMap throuhg which we iterate to find the given word
     * @return returns the correct that will be printed out on the screen
     */
    public static String theOutput(ObjectHashMap map, String givenWord) {// O(n) where n is the length of the
                                                                         // map.getEntries() array
        String output;
        for (Entry e : map.getEntries()) {
            if (e.key.equals(givenWord)) {
                output = "The word '" + givenWord + "' occurs " + e.value + " times";
                return output;
            }
        }
        output = "The word '" + givenWord + "' is not present";
        return output;
    }

    /**
     * InsertionSort sorts out the given array
     * 
     * @param arr the array of the map
     */
    private static void insertionSort(Entry[] arr) {// 0(n^2) where n is the length of the array in the worst case since
                                                    // we iterate through the array twice to sort it out
        int temp = 0;
        for (int i = 1; i < arr.length; i++) {
            Entry curEntry = arr[i];
            temp = i - 1;
            Entry prevEntry = arr[temp];

            int prevInt = (Integer) prevEntry.value;
            int curInt = (Integer) curEntry.value;

            while (((temp > -1) && (prevInt > curInt))) {
                arr[temp + 1] = arr[temp];
                temp--;
                if (temp >= 0) {
                    prevInt = (Integer) arr[temp].value;
                }
            }
            arr[temp + 1] = curEntry;
        }

    }
/**
 * prints our the five most frequently used words in the book
 * @param arr accpets an unsorted array of key value pairs
 * @return returns sorted entries
 */
    public static Entry[] printOutTopFive(Entry[] arr) {
        Entry[] sortedEntries = arr;
        insertionSort(sortedEntries);
        int sortedEntriesLength = sortedEntries.length;
        System.out.println("--Top 5 Most Frequent Words--");
        System.out.println(" 1.) '" + sortedEntries[sortedEntriesLength - 1].key + "' "
                + sortedEntries[sortedEntriesLength - 1].value + " uses.");
        System.out.println(" 2.) '" + sortedEntries[sortedEntriesLength - 2].key + "' "
                + sortedEntries[sortedEntriesLength - 2].value + " uses.");
        System.out.println(" 3.) '" + sortedEntries[sortedEntriesLength - 3].key + "' "
                + sortedEntries[sortedEntriesLength - 3].value + " uses.");
        System.out.println(" 4.) '" + sortedEntries[sortedEntriesLength - 4].key + "' "
                + sortedEntries[sortedEntriesLength - 4].value + " uses.");
        System.out.println(" 5.) '" + sortedEntries[sortedEntriesLength - 5].key + "' "
                + sortedEntries[sortedEntriesLength - 5].value + " uses.");
        return sortedEntries;
    }

    public static void main(String[] args) {

        try {
            quit = false;
            Scanner scanner = new Scanner(new FileInputStream(args[0]));
            ObjectHashMap map = new ObjectHashMap(0.75);
            processTheBook(map, scanner);
            Entry[] d = printOutTopFive(map.getEntries());

            while (!quit) {
                System.out.println();
                System.out.println("Type a word or type 'q' to quit:");
                givenWord = scanner2.nextLine();
                if (givenWord.charAt(0) == 'q') {
                    quit = true;
                } else {
                    System.out.println(theOutput(map, givenWord));
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not Found!");
        }

    }
}
