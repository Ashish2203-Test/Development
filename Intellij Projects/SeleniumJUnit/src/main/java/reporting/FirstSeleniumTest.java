package reporting;

import java.util.*;
import org.junit.*;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.CricketPage;
import report.ExcelReportData;
import utils.ExcelUtils;

@RunWith(Parameterized.class)
public class FirstSeleniumTest {

	private static WebDriver driver;
	private static CricketPage page;
	private static final String PROJECT_DIRECTORY=System.getProperty("user.dir");
	private static final String EXCEL_DATA_FILE=PROJECT_DIRECTORY+"/src/main/resources/data.xlsx";
	private static final String CRICKET_WEB_SITE="http://refer.cricketwireless.com/";
	private static final String CHROME_DRIVER_PATH=PROJECT_DIRECTORY+"/src/main/resources/chromedriver";
	public static List<ExcelReportData> report=new ArrayList<>();
	public String username;
	public String password;

	public FirstSeleniumTest(String username, String password){
		this.username=username;
		this.password=password;
	}

	@Rule
	public TestResultActions resultActions=new TestResultActions(report);
	
	@BeforeClass
	public static void setUp(){
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
		driver = new ChromeDriver();
		page=new CricketPage(driver);
	}
	
	@Before
	public void goToCorrectUrl(){
		driver.get(CRICKET_WEB_SITE);
	}
	
	@Test
	public void testLoginFunctionality(){
		page.login(username, password);
	}
	
	@After
	public void afterMethodLogs(){
	}
	
	
	@AfterClass
	public static void tearDown(){
		ExcelUtils.generateExcelReport(report, EXCEL_DATA_FILE);
		driver.close();
		driver.quit();
	}
	
	@Parameters
	public static Collection<Object[]> getLoginData(){
		return ExcelUtils.getLoginData(EXCEL_DATA_FILE);
	}
}
