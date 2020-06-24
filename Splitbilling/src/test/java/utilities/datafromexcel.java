package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class datafromexcel {
XSSFWorkbook wb;
	public datafromexcel()
	{
		File src=new File("./testdata/dataentry.xlsx");
		try {
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
		} catch (IOException e) {
			System.out.println("file error no read"+e.getMessage());
		}
	}
	public String stringdata(int index,int row,int col)
	{
		return wb.getSheetAt(index).getRow(row).getCell(col).getStringCellValue();
	}
	public String stringdata(String sheetname,int row,int col)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
	}
	public double numericdata(String sheetname,int row, int col)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue();
	}
	
	
}
