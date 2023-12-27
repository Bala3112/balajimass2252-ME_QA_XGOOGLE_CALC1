package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");

        //verify the url
        String exceptedurl = "https://www.google.com";
        String currenturl = driver.getCurrentUrl();
        if(currenturl.contains(exceptedurl)){
            System.out.println("URl contains as excepted: " + currenturl);
        }else {
            System.out.println("URl contains not as excepted: " + currenturl);
        }

        //type calculator in the search bar
        WebElement searchtext = driver.findElement(By.xpath("//textarea[@name='q']"));
        searchtext.sendKeys("calculator");
        Thread.sleep(2000);
        WebElement searchbtn = driver.findElement(By.xpath("//input[@aria-label='Google Search']"));
        searchbtn.click();


        //verify the calculator
        WebElement verify = driver.findElement(By.xpath("//div[@jscontroller='qxNryb']"));
        if(verify.isDisplayed()){
            System.out.println("Google calculator is loaded");
        }else{
            System.out.println("Google calculator is not loaded");
        }

        //confirm initial display is 0
        WebElement inidisplay = driver.findElement(By.xpath("//span[@id='cwos']"));
        String display = inidisplay.getText();
        if(display.contains("0")){
            System.out.println("Initial display shows 0");
        }else {
            System.out.println("Initial display not shows 0");
        }


        System.out.println("Ens test case: testcase01");
    }


    public void testCase02() throws InterruptedException{
        System.out.println("Start Test case: testCase02");
        driver.get("https://www.google.com");

        //type calculator in the search bar
        WebElement searchtext = driver.findElement(By.xpath("//textarea[@name='q']"));
        searchtext.sendKeys("calculator");
        Thread.sleep(2000);
        WebElement searchbtn = driver.findElement(By.xpath("//input[@aria-label='Google Search']"));
        searchbtn.click();

        //verify the calculator
        WebElement verify = driver.findElement(By.xpath("//div[@jscontroller='qxNryb']"));
        if(verify.isDisplayed()){
            System.out.println("Google calculator is loaded");
        }else{
            System.out.println("Google calculator is not loaded");
        }

        //perform addition operation(5+7)
        WebElement nofive = driver.findElement(By.xpath("//div[@jsname='Ax5wH']"));
        nofive.click();
        Thread.sleep(1000);
        WebElement addbtn = driver.findElement(By.xpath("//div[@aria-label='plus']"));
        addbtn.click();
        Thread.sleep(1000);
        WebElement noseven = driver.findElement(By.xpath("//div[@jsname='rk7bOd']"));
        noseven.click();
        Thread.sleep(1000);
        WebElement ans = driver.findElement(By.xpath("//div[@aria-label='equals']"));
        ans.click();
        Thread.sleep(1000);
        WebElement ANS = driver.findElement(By.xpath("//span[@id='cwos']"));
        String answer = ANS.getText();
        if(answer.contains("12")){
        System.out.println("The answer is correct: " + answer);
        }else{
        System.out.println("The answer is not correct: " + answer);
        }

        //perform subtraction operation(15-8)
        WebElement one = driver.findElement(By.xpath("//div[@jsname='N10B9']"));
        one.click();
        Thread.sleep(1000);
        WebElement five = driver.findElement(By.xpath("//div[@jsname='Ax5wH']"));
        five.click();
        Thread.sleep(1000);
        WebElement minus = driver.findElement(By.xpath("//div[@jsname='pPHzQc']"));
        minus.click();
        Thread.sleep(1000);
        WebElement eight = driver.findElement(By.xpath("//div[@jsname='T7PMFe']"));
        eight.click();
        Thread.sleep(1000);
        WebElement soln = driver.findElement(By.xpath("//div[@aria-label='equals']"));
        soln.click();
        Thread.sleep(1000);
        WebElement solution = driver.findElement(By.xpath("//span[@id='cwos']"));
        String answ = solution.getText();
        if(answ.contains("7")){
            System.out.println("The answer is correct: " + answ);
        }else {
            System.out.println("The answer is not correct: " + answ);
        }
        System.out.println("Ens test case: testcase02");

    }

    public void testCase03() throws InterruptedException{
        System.out.println("Start Test case: testCase03");
        driver.get("https://www.google.com");

        //type calculator in the search bar
        WebElement searchtext = driver.findElement(By.xpath("//textarea[@name='q']"));
        searchtext.sendKeys("calculator");
        Thread.sleep(2000);
        WebElement searchbtn = driver.findElement(By.xpath("//input[@aria-label='Google Search']"));
        searchbtn.click();

        //verify the calculator
        WebElement verify = driver.findElement(By.xpath("//div[@jscontroller='qxNryb']"));
        if(verify.isDisplayed()){
            System.out.println("Google calculator is loaded");
        }else{
            System.out.println("Google calculator is not loaded");
        }

        //perform multiplication(10*3)
        WebElement one = driver.findElement(By.xpath("//div[@jsname='N10B9']"));
        one.click();
        Thread.sleep(1000);
        WebElement zero = driver.findElement(By.xpath("//div[@jsname='bkEvMb']"));
        zero.click();
        Thread.sleep(1000);
        WebElement multi = driver.findElement(By.xpath("//div[@jsname='YovRWb']"));
        multi.click();
        Thread.sleep(1000);
        WebElement three = driver.findElement(By.xpath("//div[@jsname='KN1kY']"));
        three.click();
        Thread.sleep(1000);
        WebElement equal = driver.findElement(By.xpath("//div[@aria-label='equals']"));
       equal.click();
       Thread.sleep(1000);
        WebElement solution = driver.findElement(By.xpath("//span[@id='cwos']"));
        String answ = solution.getText();
        if(answ.contains("30")){
            System.out.println("The answer is correct: " + answ);
        }else {
            System.out.println("The answer is not correct: " + answ);
        }

        //click on AC
        WebElement ACbtn = driver.findElement(By.xpath("//div[@jsname='SLn8gc']"));
        ACbtn.click();
        Thread.sleep(1000);
        WebElement inidisplay = driver.findElement(By.xpath("//span[@id='cwos']"));
        String display = inidisplay.getText();
        if(display.contains("0")){
            System.out.println("Initial display shows 0");
        }else {
            System.out.println("Initial display not shows 0");
        }


        System.out.println("Ens test case: testcase03");


    }

    public void testCase04() throws InterruptedException{

        System.out.println("Start Test case: testCase04");
        driver.get("https://www.google.com");

        //type calculator in the search bar
        WebElement searchtext = driver.findElement(By.xpath("//textarea[@name='q']"));
        searchtext.sendKeys("calculator");
        Thread.sleep(2000);
        WebElement searchbtn = driver.findElement(By.xpath("//input[@aria-label='Google Search']"));
        searchbtn.click();

        //verify the calculator
        WebElement verify = driver.findElement(By.xpath("//div[@jscontroller='qxNryb']"));
        if(verify.isDisplayed()){
            System.out.println("Google calculator is loaded");
        }else{
            System.out.println("Google calculator is not loaded");
        }

        //perform division(20/4)
        WebElement two = driver.findElement(By.xpath("//div[@jsname='lVjWed']"));
        two.click();
        Thread.sleep(1000);
        WebElement zero = driver.findElement(By.xpath("//div[@jsname='bkEvMb']"));
        zero.click();
        Thread.sleep(1000);
        WebElement division = driver.findElement(By.xpath("//div[@jsname='WxTTNd']"));
        division.click();
        Thread.sleep(1000);
        WebElement four = driver.findElement(By.xpath("//div[@jsname='xAP7E']"));
        four.click();
        Thread.sleep(1000);
        WebElement equal = driver.findElement(By.xpath("//div[@aria-label='equals']"));
        equal.click();
        Thread.sleep(1000);
        WebElement solution = driver.findElement(By.xpath("//span[@id='cwos']"));
        String answ = solution.getText();
        if(answ.contains("5")){
            System.out.println("The answer is correct: " + answ);
        }else {
            System.out.println("The answer is not correct: " + answ);
        }

        System.out.println("Ens test case: testcase04");
    }
}
