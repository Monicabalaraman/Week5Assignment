package week5.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RunCreateLead extends BaseClass {
	@DataProvider(name="Leads")
	public String[][] sendData(){
		String[][] data=new String[3][4];
		data[0][0]="TestLeaf";
		data[0][1]="Moni";
		data[0][2]="Bala";
		data[0][3]="88";
		
		data[1][0]="TCS";
		data[1][1]="Monica";
		data[1][2]="B";
		data[1][3]="99";
		
		data[2][0]="Cognizant";
		data[2][1]="Monica";
		data[2][2]="Balaraman";
		data[2][3]="67";
		
		return data;
	}
	@Test(dataProvider="Leads")
	public  void Runcreate(String Cname, String Fname, String Lname, String PhNo) {
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(Cname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(Fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(Lname);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(PhNo);
		driver.findElement(By.name("submitButton")).click();
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (text.contains("Testleaf")) {
			System.out.println("Lead created successfully");
		}
		else {
			System.out.println("Lead is not created");
		}
		


	}

}
