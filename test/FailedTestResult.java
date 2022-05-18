/**
 * Implementation of TestResult class for Failed Tests
 */

package test;

public class FailedTestResult extends TestResult {

    protected FailedTestResult() {
        super("FAILED");
    }

    protected FailedTestResult(String m) {
        super("FAILED", m);
    }


    public String toHtml() {
        String html = "<tr><td style=\"background-color: red;\">FAILED " + this.getTest().getTestId()
                + "</td><td>" + this.getErrorMessage() + "</td></tr>";
        return html;
    }

}
