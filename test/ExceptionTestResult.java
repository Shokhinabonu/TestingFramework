/**
 * Implementation of TestResult class for Exceptions
 */

package test;

public class ExceptionTestResult extends TestResult {

    protected ExceptionTestResult() {
        super("EXCEPTION");
    }

    protected ExceptionTestResult(String m) {
        super("EXCEPTION", m);
    }

    @Override
    public String toHtml() {
        String html = "<tr><td style=\"background-color: yellowgreen;\">EXCEPTION: " + this.getTest().getTestId()
                + "</td><td>" + this.getErrorMessage() + "</td></tr>";
        return html;
    }

}
