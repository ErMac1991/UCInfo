import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "C:/Selenium/Drivers/msedgedriver.exe");

        WebDriver driver = new EdgeDriver();
        driver.get("https://ultimatecup.ru");

        System.out.println("Произошел переход на сайт.");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ожидание пройдено.");


        WebElement elementMenu = driver.findElement(By.xpath("//a[@class = 'launch icon item']"));
        elementMenu.click();


        System.out.println("Открыто меню.");



        WebElement element = driver.findElement(By.xpath("//a[text() = 'Ultimate Mortal Kombat 3 SEGA']"));
        element.click();
        System.out.println("Произошел переход на GENS раздел сайта.");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ожидание пройдено.");

        WebElement account = driver.findElement(By.xpath("//a[text() = 'the ErMac']"));
        System.out.println("Аккаунт найден.");

        account.click();
        System.out.println("Совершен переход в аккаунт.");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ожидание пройдено.");

        WebElement rateBox = driver.findElement(By.xpath("//div[@class = 'ui one medium statistics']"));
        System.out.println("Рейтбокс найден.");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        WebElement statBox = rateBox.findElement(By.xpath("//div[@class = 'statistic']"));
        System.out.println("Статистика найдена.");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        WebElement rate = statBox.findElement(By.xpath("//input[@id = 'rating_round']"));
        System.out.println("Значение рейтинга получено.");

        String Rate = rate.getAttribute("value");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        WebElement position = statBox.findElement(By.xpath("//div[@class = 'label']"));
        System.out.println("Значение позиции получено.");

        String Position = position.getText();

        element = driver.findElement(By.xpath("//a[text() = 'Список матчей']"));
        element.click();

        System.out.println("Произошел переход на страницу 'Список матчей'.");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ожидание пройдено.");


        element = driver.findElement(By.xpath("//table[@class = 'ui single line unstackable schedule tablesorter table']"));


        System.out.println("Таблица матчей найдена.");


        ArrayList<WebElement> matcheslist = new ArrayList<WebElement>();
        matcheslist = (ArrayList<WebElement>) element.findElements(By.xpath("//td [@class = 'td-vs-status']"));
        long MatchCounter = matcheslist.stream().count();

        driver.quit();
        System.out.println("Выход из системы выполнен.\n");
        System.out.println("Количество очков GENS рейтинга: " + Rate +
                "\nПозиция в GENS рейтинге: " + Position +
                "\nКоличество незакрытых матчей GENS рейтинга: " + MatchCounter);
    }
}
