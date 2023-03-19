package Base;

import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	@SuppressWarnings("resource")
	public Object[][] getData(String filePath, String sheetName) throws IOException {

		Object data[][] = null;

		XSSFWorkbook wb = new XSSFWorkbook(filePath);
		XSSFSheet sheet = wb.getSheet(sheetName);

		int row = sheet.getPhysicalNumberOfRows();
		int column = sheet.getRow(0).getLastCellNum();

		data = new Object[row][column];

		for (int i = 1; i < row; i++) {				//skip 1st row
			for (int j = 0; j < column; j++) {

				if (sheet.getRow(i) != null) {
					data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				}
			}
		}

		System.out.println(Arrays.deepToString(data));
		return data;
	}
}
