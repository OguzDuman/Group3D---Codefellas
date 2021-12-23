package com.example.pandemikent.Service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

@Service
public class SeleniumService {

	public String getRiskInfo(String tc, String passw, String hes) {
		HtmlUnitDriver driver = new HtmlUnitDriver();
		try {
			driver.get("https://www.turkiye.gov.tr/saglik-bakanligi-hes-kodu-sorgulama");
	        driver.findElement(By.className("loginLink")).click();
	        driver.findElement(By.name("tridField")).sendKeys(tc);
	        driver.findElement(By.name("egpField")).sendKeys(passw);
	        driver.findElement(By.name("submitButton")).click();
	        driver.findElement(By.name("hes_kodu")).sendKeys(hes + Keys.ENTER);
	            
	        String s = "";
	        WebElement table = driver.findElement(By.className("compact"));
	        List<WebElement> allRows = table.findElements(By.xpath("./*"));
	        for(WebElement cell : allRows) {
	            s = s + cell.getText() + "\n";
	        }
	        return s;
	     } 
		 catch(Exception e) {
			 return "error";
		 }
		 finally {
	         driver.quit();
	     }
	}
	
	public String getRiskStatus(String tc, String passw, String hes) throws IOException {
		String s = getRiskInfo(tc, passw, hes);
		s = getRiskInfo(tc, passw, hes);
		List<String> lines = IOUtils.readLines(new StringReader(s));
		if(lines.get(9).equalsIgnoreCase("Riskli")) {
			System.out.println("Riskli");
			return "Riskli";
		}
		else if(lines.get(9).equalsIgnoreCase("Riskli Değil")) {
			System.out.println("Riskli değil aşı kontrolü");
			if(lines.get(11).equalsIgnoreCase("Evet")) {
				System.out.println("Riskli değil");
				return "Riskli değil";
			}
			else if(lines.get(11).equalsIgnoreCase("Hayır")) {
				System.out.println("Riskli değil aşılı değil PCR kontrolü");
				if(lines.get(15).equalsIgnoreCase("Evet")) {
					System.out.println("Riskli değil");
					return "Riskli değil";
				}
				else if(lines.get(15).equalsIgnoreCase("Hayır")) {
					System.out.println("Riskli");
					return "Riskli";
				}
				else {
					return "sıkıntı3";
				}
			}
			else {
				return "sıkıntı2";
			}
		}
		else {
			return "sıkıntı1";
		}
	}
}
