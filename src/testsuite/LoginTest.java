package testsuite;
/*
Create the package ‘testsuite’ and create the
following class inside the ‘testsuite’ package.
1. LoginTest
3. Write down the following test into ‘LoginTest’ class
1. userShouldNavigateToLoginPageSuccessfully *
click on the ‘Sign In’ link
* Verify the text ‘Welcome Back!’
2. verifyTheErrorMessage
* click on the ‘Sign In’ link
* Enter invalid username
* Enter invalid password
* Click on Login button
* Verify the error message ‘Invalid email
or password.’
 */
import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
    WebElement userSignIn =  driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li/a"));
    userSignIn.click();
    Assert.assertEquals("Welcome Back!", driver.findElement(By.cssSelector("h2")).getText());

    }
    @Test
    public void verifyTheErrorMessage() {
    WebElement userSignIn =  driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li/a"));
    userSignIn.click();
    WebElement invalidUserName = driver.findElement(By.id("user[email]"));
    invalidUserName.sendKeys("Prime12gmail.com");
    WebElement invalidPassword = driver.findElement(By.id("user[password]"));
    invalidPassword.sendKeys(" ");
    try {
        WebElement userSubmit = driver.findElement(By.className("form__button-group"));
        userSubmit.click();

    }catch (Exception e) {
        System.out.println("capcha");

         Assert.assertEquals("Invalid email or password.", driver.findElement(By.className("form-error__list")));
    }





    }
    @After
    public void tearDown() {

        driver.quit();
    }

}
