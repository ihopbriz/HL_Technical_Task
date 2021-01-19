package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;



public class baseTest {

    private WebDriver driver;

    // Sets up for Chrome, opens browser and navigates to starting point.
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
    }

    /* Automated Test to test the screen and functionality of the webpage https://the-internet.herokuapp.com/tables
    *
    * Before attempting to write any Java, state what it is intended to test.
    * I've seen Gherkins before and used them to describe manual tests.
    * I've never had any formal training in their use or researched their syntax before now!!!
    *
    *
    * Feature: Tables page of herokuapp.com website
    *
    *   The heading paragraph has been run through Grammerly. It indicated "which is" an incorrect pronoun usage.
    *   This should be checked with the author to see whether this should state "that is". In the meantime, assume
    *   this paragraph is correct and use this as the baseline check to test for any changes
    *
    * Scenario: Check heading and static text in Data Tables section
    *
    * Given Web browser is open at https://the-internet.herokuapp.com/tables
    * When the screen text is compared to expected results
    * Then the screen text and the expected result text are identical.
    */

    public void dataTablesSection() {
        System.out.println("Checking Main Section...");
        // Set up expected results
        String headerExpected = ("Data Tables");
        String paragraphExpected = ("Often times when you see a table it contains data which is sortable -- sometimes with actions that can be taken within each row (e.g. edit, delete). And it can be challenging to automate interaction with sets of data in a table depending on how it is constructed.");
        // Collect actual data
        String headerActual = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText();
        String paragraphActual = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p[1]")).getText();
        // Compare actual data with expected result and output result
        if (headerExpected.equals(headerActual)) {
            System.out.println("First check passed - Main Header correct");
        } else {
            System.out.println("First check failed - Main Header not as expected");
            System.out.println("Expected: " + headerExpected);
            System.out.println("Actual: " + headerActual);
        }
        if (paragraphExpected.equals(paragraphActual)) {
            System.out.println("Second check passed - First paragraph correct");
        } else {
            System.out.println("Second check failed - First paragraph not as expected");
            System.out.println("Expected: " + paragraphExpected);
            System.out.println("Actual: " + paragraphActual);
        }
        System.out.println();


    }


    /*
    * Check Examples (Perform the following checks and repeat for all examples
    *  - not sure how to specify the repeat using Gherkin)
    *
    * Scenario: Check heading and static text in Examples section
    *
    * Given Web browser is open at https://the-internet.herokuapp.com/tables
    * And an example is displayed on screen
    * When the example title and descriptive text is compared to expected results
    * Then the screen text and the expected result text are identical.
    *
    */

    public void exampleSection(int exampleNo) {
        // Collect data to check and compare to expected result
        String exampleheaderExpected = ("Example " + exampleNo);
        System.out.println();
        System.out.println("Checking Example section..." + exampleheaderExpected);
        //Different expected result depending on paragraph - THIS IS INCOMPLETE...
        // ...will work with first example but need to find way to set expected result for second example
        String exampleparagraphExpected = ("No Class or ID attributes to signify groupings of rows and columns");
        String exampleheaderActual = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h4[" + exampleNo +"]")).getText();
        // Xpath that identifies paragraph text is one greater than the iteration - using examplenoplusone as variable for this
        int examplenoplusone = exampleNo + 1;
        String exampleparagraphActual = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p[" + examplenoplusone +"]")).getText();
        //Check Example header
        if (exampleheaderExpected.equals(exampleheaderActual)) {
            System.out.println("First check passed - Header correct");
        } else {
            System.out.println("First check failed - Header not as expected");
            System.out.println("Expected: " + exampleheaderExpected);
            System.out.println("Actual: " + exampleheaderActual);
        }
        //Check Example paragraph
        if (exampleparagraphExpected.equals(exampleparagraphActual)) {
            System.out.println("Second check passed - First paragraph correct");
        } else {
            System.out.println("Second check failed - First paragraph not as expected");
            System.out.println("Expected: " + exampleparagraphExpected);
            System.out.println("Actual: " + exampleparagraphActual);
        }
        System.out.println();

        /*
         *
         * Scenario: Check table header in Examples section
         *
         * Given Web browser is open at https://the-internet.herokuapp.com/tables and an example is displayed on screen
         * When the header row is compared to expected results
         * Then the screen text and the expected result text are identical.
         *
         */
        // Define expected result
        String[] columnNamesExpected = {"Last Name", "First Name", "Email", "Due", "Website", "Action"};
        // Capture actual result
        String[] columnNamesActual = {
                driver.findElement(By.xpath("//*[@id=\"table"+exampleNo+"\"]/thead/tr/th[1]/span")).getText(),
                driver.findElement(By.xpath("//*[@id=\"table"+exampleNo+"\"]/thead/tr/th[2]/span")).getText(),
                driver.findElement(By.xpath("//*[@id=\"table"+exampleNo+"\"]/thead/tr/th[3]/span")).getText(),
                driver.findElement(By.xpath("//*[@id=\"table"+exampleNo+"\"]/thead/tr/th[4]/span")).getText(),
                driver.findElement(By.xpath("//*[@id=\"table"+exampleNo+"\"]/thead/tr/th[5]/span")).getText(),
                driver.findElement(By.xpath("//*[@id=\"table"+exampleNo+"\"]/thead/tr/th[6]/span")).getText()};

        //Output result
        int noOfColumns = columnNamesExpected.length;
        System.out.println("no. of columns expected: " + noOfColumns);
        for (int column = 0; column < noOfColumns; column++) {
            if (columnNamesExpected[column].equals(columnNamesActual[column])) {
                System.out.println(columnNamesExpected[column] + " column heading correct");
            } else {
                System.out.println(columnNamesExpected[column] + " not as expected. Actual value is: "
                        + columnNamesActual[column]);
            }
        }
        //Sort tables by clicking column heading - use different column per iteration using exampleNo variable
        driver.findElement(By.xpath("//*[@id=\"table" + exampleNo + "\"]/thead/tr/th[" + exampleNo + "]/span")).click();


        /*

         * - For each row of data (not sure how to specify this using Gherkin)
         *

         * Scenario: Capture each item of data (in future it may be possible to compare this to some expected results)
         *
         * Given Web browser is open at https://the-internet.herokuapp.com/tables
         * And an example is displayed on screen
         * And there is data in the table
         * Then it is possible to capture and store the data

         */
        // Capture data from second row of table into an array
        // Given more time I would have worked out how to create a multi dimensional array and captured all rows
        // Second row was chosen as my simple sort for each table was producing the same first row
        // despite being sorted on different columns!!
        String[] datavalues = {
                driver.findElement(By.xpath("//*[@id=\"table" + exampleNo + "\"]/tbody/tr[2]/td[1]")).getText(),
                driver.findElement(By.xpath("//*[@id=\"table" + exampleNo + "\"]/tbody/tr[2]/td[2]")).getText(),
                driver.findElement(By.xpath("//*[@id=\"table" + exampleNo + "\"]/tbody/tr[2]/td[3]")).getText(),
                driver.findElement(By.xpath("//*[@id=\"table" + exampleNo + "\"]/tbody/tr[2]/td[4]")).getText(),
                driver.findElement(By.xpath("//*[@id=\"table" + exampleNo + "\"]/tbody/tr[2]/td[5]")).getText(),};
                System.out.println("Actual: " + datavalues[0] + ", " + datavalues[1] + ", " + datavalues[2] + ", " + datavalues[3] + ", " + datavalues[4]);



    /*
    *
    * Scenario: Check the edit button gives user ability to edit data
    *
    * Given Web browser is open at https://the-internet.herokuapp.com/tables
    * And an example is displayed on screen
    * And there is data in the table
    * When the 'edit' hyperlink is selected
    * Then it is possible to edit data from the corresponding row
    *
    * Didn't attempt this as functionality doesn't appear to exist
    *
    *
    *
    * Scenario: Check the delete button gives user ability to delete a row
    *
    * Given Web browser is open at https://the-internet.herokuapp.com/tables
    * And an example is displayed on screen
    * And there is data in the table
    * When the 'delete' hyperlink is selected
    * Then it is possible to delete the corresponding row from the table

    * Didn't attempt this as functionality doesn't appear to exist


    */

    }

     /*

    *
    * Scenario: Check footer text
    *
    * Given Web browser is open at https://the-internet.herokuapp.com/tables
    * When the footer text is compared to expected results
    * Then the screen text and the expected result text are identical.
    */

     public void footerSection() {
         System.out.println();
         System.out.println("Checking Footer...");
         // Set up expected results
         String footerExpected = ("Powered by Elemental Selenium");
         // Collect actual data
         String footertextActual = driver.findElement(By.xpath("//*[@id=\"page-footer\"]/div/div")).getText();
         if (footerExpected.equals(footertextActual)){
             System.out.println("Footer is correct: " + footertextActual);
         } else {
             System.out.println("Footer is incorrect: " + footertextActual);
         }

     /*        * Scenario: Check footer text hyperlink
    *
    * Given Web browser is open at https://the-internet.herokuapp.com/tables
    * When the footer text hyperlink is selected
    * Then the hyperlink is opened.
    *  */

         driver.findElement(By.xpath("//*[@id=\"page-footer\"]/div/div/a")).click();
     // Need to add a check that the correct page has been opened
     }



    public void closeBrowser() {
        // Close browser - this worked before I added the click on the hyperlink!
        driver.close();
    }



        // This bit runs the individual parts of the test.
        public static void main(String args[]){
            base.baseTest test = new baseTest();
            test.setUp();
            test.dataTablesSection();
            //Loop for each example
            for (int exampleloop = 1; exampleloop <=2; exampleloop ++) {
                test.exampleSection(exampleloop);
            }
            test.footerSection();
            test.closeBrowser();
        }
    }
