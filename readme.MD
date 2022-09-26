This is a simple program that opens up a page stored in the resources directory using 4 Firefox browser instances in parallel.  One test is run in each browser instance.  In each test, one of the four buttons is clicked twice using Selenium WebDriver and the counter is incremented if the button is successfully clicked.  The first test is a control scenario in which the JavaScript code fails to hide the button, so it can be successfully clicked twice.  The second test covers the button with another element, and the third and fourth tests hide the button using different CSS styles.  The second, third, and fourth tests should fail because WebDriver should not be able to click on the buttons a second time.

The tests can be run either from an IDE like IntelliJ IDEA, or from the command line using the following commands:

mvn clean package

java -jar target/se_tests-1.0-SNAPSHOT.jar

I recommended using an IDE that can display the results of each test because the code was quickly written to run from an IDE.  Therefore, the output on the CLI isn't cleaned up to be easily read.