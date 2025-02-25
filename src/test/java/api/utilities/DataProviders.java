package api.utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "Data")
	public String[][] getAllData() throws IOException {
		String path = System.getProperty("user.dir") + "//testdata//Userdata.xlsx";

		ExcelUtility excel = new ExcelUtility(path);

		int rownum = excel.getRowCount("Sheet1");
		int colCount = excel.getCellCount("Sheet1", 1);
		String apidata[][] = new String[rownum][colCount];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colCount; j++) {
				apidata[i - 1][j] = excel.getCellData("Sheet1", i, j);
			}
		}
		return apidata;

	}

	@DataProvider(name = "UserNames")
	public String[] getUserNames() throws IOException {
		String path = System.getProperty("user.dir") + "//testdata//Userdata.xlsx";
		ExcelUtility excel = new ExcelUtility(path);
		int rownum = excel.getRowCount("Sheet1");
		String apidata[] = new String[rownum];
		
		for (int i = 1; i <= rownum; i++) {
			apidata[i - 1] = excel.getCellData("Sheet1", i, 1);

		}
		return apidata;

	}

}
