import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import test.Test;
import test.TestController;
import test.TestControllerImpl;
import test.TestResult;

public class HW7SampleCodeTest {
    public static void main(String[] args) throws FileNotFoundException {

        TestController tc = new TestControllerImpl(args);

        // Check put() in ObjectHashMap
        Test testPut = new Test("CheckPut") {
            @Override
            public TestResult runTest() {
                boolean passed = false;
                ObjectHashMap code = new ObjectHashMap();
                code.put(1, "h");
                code.put(2, "e");
                code.put(3, "u");
                code.put(4, "w");
                code.put(5, "r");
                code.put(6, "k");

                Entry[] testArray = {
                        new Entry(1, "h"),
                        new Entry(2, "e"),
                        new Entry(3, "u"),
                        new Entry(4, "w"),
                        new Entry(5, "r"),
                        new Entry(6, "k") };
                for (int i = 0; i < code.getEntries().length; i++) {
                    if (!code.getEntries()[i].equals(testArray[i])) {
                        passed = false;
                    }
                    passed = true;
                }
                if (passed) {
                    return TestResult.createPassedResult();
                } else {
                    return TestResult.createFailedResult("put() Expected to properly add the entries to the map");
                }
            }
        };
        tc.addTest(testPut, 1.0);

        // Check find() in ObjectHashMap
        Test testFind = new Test("CheckFind") {
            @Override
            public TestResult runTest() {
                ObjectHashMap code = new ObjectHashMap();
                code.put(1, "h");
                code.put(2, "e");
                code.put(3, "u");
                code.put(4, "w");
                code.put(5, "r");
                code.put(6, "k");

                if (code.find(1).equals("h") &&
                        code.find(2).equals("e") &&
                        code.find(3).equals("u") &&
                        code.find(4).equals("w") &&
                        code.find(5).equals("r") &&
                        code.find(6).equals("k")) {
                    return TestResult.createPassedResult();
                } else {
                    return TestResult.createFailedResult("find() was expected to find these values");
                }
            }
        };
        tc.addTest(testFind, 2);

        // Check find() in ObjectHashMap when the Entry doesn't exist
        Test testFindException = new Test("CheckFindException") {
            @Override
            public TestResult runTest() {
                ObjectHashMap code = new ObjectHashMap();
                code.put(1, "h");
                code.put(2, "e");
                code.put(3, "u");
                code.put(4, "w");
                code.put(5, "r");
                code.put(6, "k");

                try {
                    code.find(12);
                } catch (NullPointerException e) {
                    return TestResult.createPassedResult("Correctly caught exception");
                }
                return TestResult.createFailedResult("find() Failed to catch exception");
            }
        };
        tc.addTest(testFindException, 3);

        // Check find() in ObjectHashMap when the map is empty
        Test testFindEmpty = new Test("CheckFindEmpty") {
            public TestResult runTest() {
                ObjectHashMap code = new ObjectHashMap();
                try {
                    code.find(12);
                } catch (NullPointerException e) {
                    return TestResult.createPassedResult("Correctly caught exception");
                }
                return TestResult.createFailedResult("find() Failed to catch exception");
            }
        };
        tc.addTest(testFindEmpty, 4);

        // Check resize() in ObjectHashMap
        Test testResize = new Test("CheckResize") {
            @Override
            public TestResult runTest() {
                ObjectHashMap code = new ObjectHashMap();
                code.put(22, "ee");
                code.put(21, "ee");
                code.put(20, "ee");
                code.put(19, "ee");
                code.put(18, "ee");
                code.put(17, "ee");
                code.put(16, "ee");
                code.put(15, "ee");
                code.put(14, "ee");
                code.put(13, "ee");
                code.put(12, "ee");
                code.put(11, "ee");
                code.put(10, "ee");
                code.put(9, "ee");
                code.put(8, "ee");
                code.put(7, "ee");
                code.put(6, "ee");
                code.put(5, "ee");
                code.put(4, "ee");
                code.put(3, "ee");
                code.put(2, "ee");
                code.put(1, "ee");

                if (code.getEntries().length == 22) {
                    return TestResult.createPassedResult();
                } else {
                    return TestResult.createFailedResult("resize() failed to resize");
                }
            }
        };
        tc.addTest(testResize, 4);

        // Check () getEntries in ObjectHashMap
        Test testGetEntries = new Test("CheckGetEntries") {
            @Override
            public TestResult runTest() {
                boolean passed = false;
                ObjectHashMap code = new ObjectHashMap();
                code.put(1, "h");
                code.put(2, "e");
                code.put(3, "u");
                code.put(4, "w");
                code.put(5, "r");
                code.put(6, "k");

                Entry[] testArray = {
                        new Entry(1, "h"),
                        new Entry(2, "e"),
                        new Entry(3, "u"),
                        new Entry(4, "w"),
                        new Entry(5, "r"),
                        new Entry(6, "k") };
                for (int i = 0; i < code.getEntries().length; i++) {
                    if (!code.getEntries()[i].equals(testArray[i])) {
                        passed = false;
                    }
                    passed = true;
                }
                if (passed) {
                    return TestResult.createPassedResult();
                } else {
                    return TestResult
                            .createFailedResult("getEntries() Expected to properly get the entries from the map");
                }
            }
        };
        tc.addTest(testGetEntries, 1.0);

        // Check getEntriesEmpty() in ObjectHashMap
        Test testGetEntriesEmpty = new Test("CheckGetEntriesEmpty") {
            @Override
            public TestResult runTest() {
                ObjectHashMap code = new ObjectHashMap();

                if (code.getEntries().length == 0) {
                    return TestResult.createPassedResult();
                } else {
                    return TestResult.createFailedResult("getEntries() Expected to be empty");
                }
            }
        };
        tc.addTest(testGetEntriesEmpty, 5.0);

        // Check containsKey() in ObjectHashMap
        Test testContainsKey = new Test("CheckContainsKey") {
            // anonymous class
            @Override
            public TestResult runTest() {
                ObjectHashMap code = new ObjectHashMap();
                code.put(1, "h");
                code.put(2, "e");
                code.put(3, "u");
                code.put(4, "w");
                code.put(5, "r");
                code.put(6, "k");

                if (code.containsKey(1) &&
                        code.containsKey(2) &&
                        code.containsKey(3) &&
                        code.containsKey(4) &&
                        code.containsKey(5) &&
                        code.containsKey(6)) {
                    return TestResult.createPassedResult();
                } else {
                    return TestResult.createFailedResult("containsKey did not return true");
                }
            }
        };
        tc.addTest(testContainsKey, 10.0);

        // Check containsKeyFalse() in ObjectHashMap
        Test testContainsKeyFalse = new Test("CheckContainsKeyFalse") {
            // anonymous class
            @Override
            public TestResult runTest() {
                ObjectHashMap code = new ObjectHashMap();
                code.put(1, "h");
                code.put(2, "e");
                code.put(3, "u");
                code.put(4, "w");
                code.put(5, "r");
                code.put(6, "k");

                if (!code.containsKey(11)) {
                    return TestResult.createPassedResult();
                } else {
                    return TestResult.createFailedResult("containsKey did not return false");
                }
            }
        };
        tc.addTest(testContainsKeyFalse, 9.0);

        // Check containsKeyEmpty() in ObjectHashMap
        Test testContainsKeyEmpty = new Test("CheckContainsKeyEmpty") {
            // anonymous class
            @Override
            public TestResult runTest() {
                ObjectHashMap code = new ObjectHashMap();

                if (!code.containsKey(11)) {
                    return TestResult.createPassedResult();
                } else {
                    return TestResult.createFailedResult("containsKey did not return false");
                }
            }
        };
        tc.addTest(testContainsKeyEmpty, 9.0);

        // Check processTheBook() in TextAnalytics
        Test testProcessTheBook = new Test("CheckProcessTheBook") {
            // anonymous class
            @Override
            public TestResult runTest() {
                try {
                    boolean passed = false;
                    Scanner scanner = new Scanner(new FileInputStream("mySampleBook.txt"));
                    ObjectHashMap map = new ObjectHashMap(0.75);
                    TextAnalytics.processTheBook(map, scanner);

                    if (map.containsKey("the") && (map.find("the").equals(3)) &&
                            map.containsKey("a") && (map.find("a").equals(3)) &&
                            map.containsKey("their") && (map.find("their").equals(3)) &&
                            map.containsKey("to") && (map.find("to").equals(2)) &&
                            map.containsKey("children") && (map.find("children").equals(2)) &&
                            map.containsKey("dostoevsky") && (map.find("dostoevsky").equals(2)) &&
                            map.containsKey("generally") && (map.find("generally").equals(1))

                    ) {
                        passed = true;
                    }

                    if (passed) {
                        return TestResult.createPassedResult();
                    } else {
                        return TestResult.createFailedResult("processTheBook() did not process the book properly");
                    }

                } catch (FileNotFoundException e) {
                    return TestResult.createExceptionResult("mySampleBook.txt file doesn' exist");
                }
            }
        };
        tc.addTest(testProcessTheBook, 9.0);

        // Check output() in TextAnalytics
        Test testTheOutput = new Test("CheckTheOutput") {
            // anonymous class
            @Override
            public TestResult runTest() {
                try {
                    Scanner scanner = new Scanner(new FileInputStream("mySampleBook.txt"));
                    ObjectHashMap map = new ObjectHashMap(0.75);
                    TextAnalytics.processTheBook(map, scanner);
                    String output = TextAnalytics.theOutput(map, "their");
                    if ((output.equals("The word 'their' occurs 3 times") == true)) {
                        return TestResult.createPassedResult();
                    } else {
                        return TestResult.createFailedResult("theOutput() outputted the wrong String");
                    }

                } catch (FileNotFoundException e) {
                    return TestResult.createExceptionResult("mySampleBook.txt file doesn' exist");
                }
            }
        };
        tc.addTest(testTheOutput, 13.0);

        // Check printTopFive() in TextAnalytics
        Test testprintTopFive = new Test("CheckprintTopFive") {
            // anonymous class
            @Override
            public TestResult runTest() {
                try {
                    Scanner scanner = new Scanner(new FileInputStream("mySampleBook.txt"));
                    ObjectHashMap map = new ObjectHashMap(0.75);
                    TextAnalytics.processTheBook(map, scanner);
                    Entry[] sortedList = TextAnalytics.printOutTopFive(map.getEntries());
                    if (sortedList[sortedList.length - 1].toString().equals("(the, 3)") &&
                            sortedList[sortedList.length - 2].toString().equals("(a, 3)") &&
                            sortedList[sortedList.length - 3].toString().equals("(their, 3)") &&
                            sortedList[sortedList.length - 4].toString().equals("(children, 2)") &&
                            sortedList[sortedList.length - 5].toString().equals("(to, 2)")) {
                        return TestResult.createPassedResult();
                    } else {
                        return TestResult.createFailedResult(
                                "testprintTopFive() incorrectly sorted out the list and has the wrong top five entries");
                    }

                } catch (FileNotFoundException e) {
                    return TestResult.createExceptionResult("mySampleBook.txt file doesn' exist");
                }
            }
        };
        tc.addTest(testprintTopFive, 13.0);

        // run tests
        tc.runTests();

    }
}