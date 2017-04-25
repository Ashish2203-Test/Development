package reporting;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import report.ExcelReportData;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class TestResultActions extends TestWatcher{

	private List<ExcelReportData> report;

	public TestResultActions(List<ExcelReportData> report){
		this.report=report;
	}

	@Override
	public void failed(Throwable e, Description desc){
		System.out.println(desc.getTestClass().getName());
		System.out.println(report);
		//createReportData(desc, "FAIL");


	}
	
	@Override
	public void succeeded(Description desc){

		ExcelReportData data=new ExcelReportData();
		data.setResult("PASS");

		report.add(data);
		//createReportData(desc, "PASS");

	}

	private void createReportData(Description desc, String status){

		ExcelReportData data=new ExcelReportData();

		Class<?> clazz=desc.getTestClass();

		Field fldUsr=null;
		Field fldPass=null;

		try{
			fldUsr=clazz.getDeclaredField("username");
			fldUsr.setAccessible(true);
			System.out.println("This fields name is: "+fldUsr.get(clazz));
			Object obj=fldUsr.get(clazz);

			String str=(String)obj;

			data.setUsername(str);

			fldPass=clazz.getDeclaredField("password");
			fldPass.setAccessible(true);
			data.setPassword((String)(fldPass.get(clazz)));

			data.setResult(status);

			report.add(data);

		}catch(NoSuchFieldException|IllegalAccessException e){
			e.printStackTrace();
		}
	}
}