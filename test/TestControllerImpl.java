/**
 * Implementation of TestController interface in order to store the test suites and run them
 */

package test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class TestControllerImpl implements TestController {
    private ArrayList<TestEntry> testsList = new ArrayList<TestEntry>();// faster
    private ArrayList<TestResult> resultsList = new ArrayList<TestResult>();// faster
    private String[] str;
    private List<TestResult> passed = new ArrayList<TestResult>();
    private List<TestResult> failed = new ArrayList<TestResult>();
    private List<TestResult> exception = new ArrayList<TestResult>();
    private boolean generateHtml, areTestsPassed = false;
    private String outputFileName;
    private TestReporter reportGenerator;

    public TestControllerImpl(String[] args) throws FileNotFoundException {
        str = args;
        if (str.length > 0) {
            if (str[0].equals("-h") && str[1].contains(".html")) {
                generateHtml = true;
                outputFileName = str[1];
                reportGenerator = new TestReporterHTML(outputFileName);
                if (str.length > 2) {
                    areTestsPassed = true;
                }
            } else {
                areTestsPassed = true;
                reportGenerator = new TestReporterImpl();
            }
        } else {
            reportGenerator = new TestReporterImpl();
        }

    }

    @Override
    public void addTest(Test test, double rank) {
        TestEntry newEntry = new TestEntry(rank, test);
        testsList.add(newEntry);
    }

    @Override
    public void runTests() {
        TestResult testR;
        if (areTestsPassed) {
            updateTestEntry();
        } else {
            this.insertionSort();
        }

        for (TestEntry testE : testsList) {
            try {
                testR = testE.key.runTest();
                testR.setTest(testE.key);
                resultsList.add(testR);
            } catch (Exception e) {
                TestResult exceptionTR = TestResult.createExceptionResult("Exception was caught");
                exceptionTR.setTest(testE.key);
                resultsList.add(exceptionTR);
            }

        }
        createReport();
    }

    @Override
    public void createReport() {

        for (TestResult tr : resultsList) {
            if (tr.isPassed()) {
                if (tr != null) {
                    passed.add(tr);
                }
            } else if (tr.isFailed()) {
                if (tr != null) {
                    failed.add(tr);
                }
            } else if (tr.isException()) {
                if (tr != null) {
                    exception.add(tr);
                }
            }
        }
        reportGenerator.generateReport(passed, failed, exception);

    }

    /**
     * method that fills up the TestsList with Tests that were passed through the
     * terminal
     */
    private void updateTestEntry() {
        ArrayList<TestEntry> newTestsList = new ArrayList<TestEntry>();
        for (int i = 0; i < str.length; i++) {
            for (TestEntry te : testsList) {
                if (te.key.getTestId().equals(str[i])) {
                    newTestsList.add(te);
                }
            }
        }

        testsList = newTestsList;
    }

    /**
     * sorts the testsList from the smallest to largest rank
     */
    private void insertionSort() {
        int temp = 0;
        for (int i = 1; i < testsList.size(); i++) {
            TestEntry curEntry = testsList.get(i);
            temp = i - 1;
            TestEntry prevEntry = testsList.get(temp);

            double prevRank = prevEntry.value;
            double curRank = curEntry.value;

            while (((temp > -1) && (prevRank > curRank))) {
                testsList.set(temp + 1, testsList.get(temp));
                temp--;
                if (temp >= 0) {
                    prevRank = testsList.get(temp).value;
                }
            }
            testsList.set(temp + 1, curEntry);
        }
    }

}
