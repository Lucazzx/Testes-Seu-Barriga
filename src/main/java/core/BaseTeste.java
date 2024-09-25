package core;

import static core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import static core.DriverFactory.getDriver;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import pages.LoginPage;

public class BaseTeste {
	private LoginPage page = new LoginPage();
	
	@Rule
	public TestName testName = new TestName();
	
	@Before
	public void buildUp () {
		page.logar("lucassousa@email.com", "123");
	}

    @After
    public void tearDown() throws IOException{
    	TakesScreenshot ss = (TakesScreenshot) getDriver();
    	File arquivo = ss.getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(arquivo, new File("target"+ File.separator +"screenshots"+ File.separator + testName.getMethodName()+ ".jpg"));
    	
		if(Propriedades.FECHAR_BROWSER) {
			killDriver();
		}
    	
    }
}
