package probStatement1_Flipkart;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class ProblemStatement1 {
    WebDriver driver;

    List<WebElement> listOfMobilePhones ;
    List<WebElement> listedPrice;

    int PricesInPage1;

    @Test (priority=1)
    public void launch() {
        driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    // Search for ‘Mobile Phone’ on the ‘flipkart.com’ homepage
    @Test (priority=2)
    public void searchMobilePhone() {
        WebElement searchText = driver.findElement(By.xpath("//header/div[1]/div[2]/form[1]/div[1]/div[1]/input[1]"));
        WebElement searchIcon = driver.findElement(By.xpath("//header/div[1]/div[2]/form[1]/div[1]/button[1]/*[1]"));

        searchText.sendKeys("mobile phone");
        searchIcon.click();
    }
    //Fetch all the mobile phones listed in the product listing page along with their prices and output them
    //to an excel file and store them inside folder ‘testresult’ in ‘src/test/resources’
    @Test (priority=3)
    public void searchResult(){
        //to get all the phone names from the search result page1
        listOfMobilePhones = driver.findElements(By.xpath("//div[@class = '_4rR01T']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        int noOfMobilePhonesPage1 = listOfMobilePhones.size();
        System.out.println("Number of mobiles phones displayed in page1 : " +noOfMobilePhonesPage1);

        for(int i=0; i<= noOfMobilePhonesPage1-1; i++)
        {
            listOfMobilePhones.get(i).getText();
            System.out.println(listOfMobilePhones.get(i).getText());
        }

        //to get the price of the phone from the search result
        listedPrice= driver.findElements(By.xpath("//div[@class = '_30jeq3 _1_WHN1']"));

        PricesInPage1 = listedPrice.size();
        System.out.println("Number of listed price of all mobiles phones displayed in page1 : " +PricesInPage1);

        for(int i=0; i<=PricesInPage1-1 ; i++)
        {
            listedPrice.get(i).getText();
            System.out.println(listedPrice.get(i).getText());
        }
        Assert.assertEquals(noOfMobilePhonesPage1,24);
        Assert.assertEquals(PricesInPage1, 24);
    }
    //to write the phone names and its price in the Excel file
    @Test(priority =4)
    public void writeInExcel() throws IOException {
        File f = new File("src/test/resources/SearchResultsOfMobilePhone.xlsx");

        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet s = wb.createSheet("PriceOfMobilesInPage1");
        XSSFRow r = s.createRow(0);

        r.createCell(0).setCellValue("items");
        r.createCell(1).setCellValue("price");
        for(int i=0;i<=PricesInPage1-1 ;i++)
        {
            XSSFRow r1 = s.createRow(i+1);
            r1.createCell(0).setCellValue(listOfMobilePhones.get(i).getText());
            r1.createCell(1).setCellValue(listedPrice.get(i).getText());
        }

        FileOutputStream fos = new FileOutputStream(f);
        try
        {
             wb.write(fos);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        wb.close();

        driver.close();
    }
}
