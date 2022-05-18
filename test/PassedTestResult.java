/**
 * Implementation of TestResult class for Passed Tests
 */

package test;

public class PassedTestResult extends TestResult {

    protected PassedTestResult() {
        super("PASSED");
    }

    protected PassedTestResult(String m) {
        super("PASSED", m);
    }


    public String toHtml() {
        String html = "<tr><td style=\"background-color: green;\">PASSED: " + this.getTest().getTestId()
                + "</td><td>" + this.getErrorMessage() + "</td></tr>";
        return html;
    }

}
