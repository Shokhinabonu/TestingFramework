package test;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class TestReporterHTML implements TestReporter {
    private PrintStream output;
    private String htmlCode;

    TestReporterHTML(String outputFileName) throws FileNotFoundException {
        output = new PrintStream(new File(outputFileName));
    }

    @Override
    public void generateReport(List<TestResult> passed, List<TestResult> failed, List<TestResult> exception) {
        htmlCode ="<!DOCTYPE html>"+
        "<html>"+
        "<style>"+
        "table, th, td {"+
         "   border-radius: 15px;"+
         " border:3px solid black;"+
        "}"+
        "</style>"+
        "<body>"+

        "<h2>Passed Tests</h2>"+
        "<table style=\"width:100%\">"+
         " <tr>"+
            "<th>Results</th>"+
            "<th>Messages</th> "+
          "</tr>";

          for(TestResult tr:passed){
            htmlCode=htmlCode+tr.toHtml();
          }


          htmlCode=htmlCode+ "</table>"+

        "<h2>Failed Tests</h2>"+
        "<table style=\"width:100%\">"+
          "<tr>"+
            "<th>Results</th>"+
            "<th>Messages</th> "+
          "</tr>";
          for(TestResult tr:failed){
            htmlCode=htmlCode+tr.toHtml();
          }
htmlCode=htmlCode+"</table>"+
        "</table>"+
        "<h2>Exceptions</h2>"+
        "<table style=\"width:100%\">"+
          "<tr>"+
            "<th>Results</th>"+
            "<th>Messages</th> "+
          "</tr>";

          for(TestResult tr:exception){
            htmlCode=htmlCode+tr.toHtml();
          }

       htmlCode=htmlCode+ "</table>"+
        "</body>"+
        "</html>";
        
        output.print(htmlCode);
        output.close();

    }

}
