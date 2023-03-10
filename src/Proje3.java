import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Proje3 extends BaseDriver {
        @Test
        public void Test1() {
                driver.get("https://shopdemo.e-junkie.com/");

                WebElement ebookaddtocart = driver.findElement(By.xpath("//*[text()='Demo eBook']//..//following-sibling::button"));
                ebookaddtocart.click();
                MyFunc.Bekle(1);
                driver.switchTo().frame(4);
                WebElement addpromo = driver.findElement(By.xpath("//button[@class='Apply-Button Show-Promo-Code-Button']"));
                addpromo.click();
                MyFunc.Bekle(1);
                WebElement promokod = driver.findElement(By.xpath("//input[@placeholder='Promo Code']"));
                promokod.sendKeys("grup12");
                MyFunc.Bekle(1);
                WebElement apply = driver.findElement(By.xpath("//button[@type='button' and @class='Promo-Apply']"));
                apply.click();
                MyFunc.Bekle(1);
                WebElement invalidPromoCode = driver.findElement(By.xpath("//span[text()='Invalid promo code']"));
                Assert.assertEquals("Invalid promo code", invalidPromoCode.getText());

                BekleKapat();


        }


        @Test
        public void Test2() {
                driver.get("https://shopdemo.e-junkie.com/");
                WebElement ebookaddtocart2=driver.findElement(By.xpath("//*[text()='Demo eBook']//..//following-sibling::button"));
                ebookaddtocart2.click();
                MyFunc.Bekle(1);
                driver.switchTo().frame(4);
                MyFunc.Bekle(1);
                WebElement payusing=driver.findElement(By.cssSelector("button[class='Payment-Button CC']"));
                payusing.click();
                MyFunc.Bekle(1);
                WebElement payclick=driver.findElement(By.xpath("//button[@class='Pay-Button']"));
                payclick.click();
                WebElement msg = driver.findElement(By.cssSelector("div[id='SnackBar']"));
                Assert.assertTrue("Bilgi yanlış", msg.getText().contains("Invalid"));

        }
        @Test
        public void Test3(){
                driver.get("https://shopdemo.e-junkie.com/");
                WebElement ebookaddtocart2=driver.findElement(By.xpath("//*[text()='Demo eBook']//..//following-sibling::button"));
                ebookaddtocart2.click();
                MyFunc.Bekle(1);
                driver.switchTo().frame(4);
                WebElement payusing=driver.findElement(By.cssSelector("button[class='Payment-Button CC']"));
                payusing.click();
                MyFunc.Bekle(1);
                driver.switchTo().frame(2);
                MyFunc.Bekle(1);
                WebElement cardnumber=driver.findElement(By.name("cardnumber"));
                cardnumber.click();
                cardnumber.sendKeys("1111111111111111");
                driver.switchTo().defaultContent();
                driver.switchTo().frame(4);
                WebDriverWait bekle=new WebDriverWait(driver, Duration.ofSeconds(30));
                bekle.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Kart numaranız geçersiz.']")));
                WebElement msg=driver.findElement(By.xpath("//span[text()='Kart numaranız geçersiz.']"));
                Assert.assertEquals("Kart numaranız geçersiz.",msg.getText());

                BekleKapat();


        }

        @Test
        public void Test4(){
                driver.get("https://shopdemo.e-junkie.com/");
                WebElement ebookaddtocart2=driver.findElement(By.xpath("//*[text()='Demo eBook']//..//following-sibling::button"));
                ebookaddtocart2.click();
                MyFunc.Bekle(1);
                driver.switchTo().frame(4);
                MyFunc.Bekle(1);
                WebElement payusing=driver.findElement(By.cssSelector("button[class='Payment-Button CC']"));
                payusing.click();
                MyFunc.Bekle(1);
                WebElement email=driver.findElement(By.xpath("//*[@placeholder='Email']"));
                email.sendKeys("grup12@gmail.com");
                WebElement confrimemail=driver.findElement(By.xpath("//*[@placeholder='Confirm Email']"));
                confrimemail.sendKeys("grup12@gmail.com");
                WebElement nameOnCard = driver.findElement(By.cssSelector("[placeholder='Name On Card']"));
                nameOnCard.sendKeys("grup12");
                MyFunc.Bekle(1);
                driver.switchTo().frame(2);
                MyFunc.Bekle(1);
                WebElement cardnumber=driver.findElement(By.name("cardnumber"));
                cardnumber.click();
                cardnumber.sendKeys("4242424242424242");
                WebElement monthyear=driver.findElement(By.cssSelector("[name='exp-date']"));
                monthyear.sendKeys("1223");
                WebElement cvc=driver.findElement(By.cssSelector("[name='cvc']"));
                cvc.sendKeys("000");
                driver.switchTo().parentFrame();
                WebElement paybutton= driver.findElement(By.cssSelector("[class='Pay-Button']"));
                paybutton.click();

        }
        @Test
        public void Test5(){

                driver.get("https://shopdemo.e-junkie.com/");




                WebElement contactUs = driver.findElement(By.xpath("//a[@class='contact']"));
                contactUs.click();
                MyFunc.Bekle(1);
                WebElement name = driver.findElement(By.xpath("//input[@name='sender_name']"));
                name.sendKeys("Grup1212345");
                MyFunc.Bekle(1);
                WebElement Email = driver.findElement(By.xpath("//input[@name='sender_email']"));
                Email.sendKeys("abcd@gmail.com");
                MyFunc.Bekle(1);
                WebElement Subject = driver.findElement(By.xpath("//input[@name='sender_subject']"));
                Subject.sendKeys("technostudy");
                MyFunc.Bekle(1);
                WebElement message = driver.findElement(By.xpath("//textarea[@name='sender_message']"));
                message.sendKeys("test");
                MyFunc.Bekle(1);
                driver.switchTo().frame(0);
                WebElement robot123 = driver.findElement(By.cssSelector("[class='recaptcha-checkbox-border']"));
                robot123.click();
                driver.switchTo().defaultContent();
                MyFunc.Bekle(30);
                WebElement sendButton = driver.findElement(By.cssSelector("button[type='submit']"));
                sendButton.click();
                MyFunc.Bekle(4);

                Assert.assertEquals("Message sent successfully", driver.switchTo().alert().getText());
                MyFunc.Bekle(1);
                driver.switchTo().alert().accept();





                BekleKapat();

        }

}
