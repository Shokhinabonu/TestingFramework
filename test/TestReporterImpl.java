package test;

import java.util.List;

public class TestReporterImpl implements TestReporter {
    TestReporterImpl() {
    }

    @Override
    public void generateReport(List<TestResult> passed, List<TestResult> failed, List<TestResult> exception) {
        System.out.println("------------------Passed Tests------------------");
        for (TestResult tr : passed) {
            System.out.println(tr.toString());
        }
        System.out.println("------------------Failed Tests------------------");
        for (TestResult tr : failed) {
            System.out.println(tr.toString());
        }
        System.out.println("------------------Exceptions------------------");
        for (TestResult tr : exception) {
            System.out.println(tr.toString());
        }

    }

}
