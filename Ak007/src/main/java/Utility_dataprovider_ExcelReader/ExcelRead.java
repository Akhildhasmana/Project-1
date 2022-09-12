/*Maintain an excel file that will have� all the values eg. name, Bill address, Billcity,� 
State zip code, phone, email,�read these values�from excel and store it to a variable, 
and these variables�should�be passed to the field�*/
//Excel file to read and store in list.

package Utility_dataprovider_ExcelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.record.RowRecord;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	private static List<String> details;
	private static HashMap<Integer, List<String>> rowDetails;

	private static boolean skipped = false;

	public static List<String> readRow(String filePath) throws IOException {

		FileInputStream file = new FileInputStream(new File(filePath));

		Workbook excelFile = new XSSFWorkbook(file);
		Sheet sheet = excelFile.getSheetAt(0);

		Iterator<Row> iteratorRow = sheet.iterator();

		details = new ArrayList<String>();

		DataFormatter dataFormatter = new DataFormatter();

		while (iteratorRow.hasNext()) {
			if (!skipped) {
				iteratorRow.next();
				skipped = true;
				continue;
			}

			Row row = iteratorRow.next();

			Iterator<Cell> cellIterator = row.iterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				String data = dataFormatter.formatCellValue(cell);
				if (data != "") {
					details.add(data);
				}
			}
		}

		return details;
	}// 4 records>>test case will run 4 times for each set of data

	public static HashMap<Integer, List<String>> readRows(String filePath) throws IOException {
		FileInputStream file = new FileInputStream(new File(filePath));

		Workbook excelFile = new XSSFWorkbook(file);
		Sheet sheet = excelFile.getSheetAt(0);

		Iterator<Row> iteratorRow = sheet.iterator();

		rowDetails = new HashMap<Integer, List<String>>();
		details = new ArrayList<String>();

		DataFormatter dataFormatter = new DataFormatter();

		Integer i = 0;
		while (iteratorRow.hasNext()) {
			if (!skipped) {
				iteratorRow.next();
				skipped = true;
				continue;
			}

			Row row = iteratorRow.next();

			if (row == null)
				System.out.println("null");

			Iterator<Cell> cellIterator = row.iterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();

				String data = dataFormatter.formatCellValue(cell);
				if (data != "") {
					details.add(data);
				}
			}
			rowDetails.put(i, new ArrayList<String>(details));
			details.clear();
			i++;
		}
		System.out.println(rowDetails.size());
		return rowDetails;
	}

	public static List<String> readAnyRow(String filePath, int rowNo) throws IOException {

		FileInputStream file = new FileInputStream(new File(filePath));

		Workbook excelFile = new XSSFWorkbook(file);
		Sheet sheet = excelFile.getSheetAt(0);

		Iterator<Row> iteratorRow = sheet.iterator();

		details = new ArrayList<String>();

		DataFormatter dataFormatter = new DataFormatter();

		Row row = sheet.getRow(rowNo);
		if (row == null) {
			System.out.println("null");
			return null;
		}
		Iterator<Cell> cellIterator = row.iterator();

		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			String data = dataFormatter.formatCellValue(cell);
			if (data != "") {
				details.add(data);
			}
		}

		return details;
	}

	public static HashMap<Integer, List<String>> readRowsTest(String filePath) throws IOException {
		FileInputStream file = new FileInputStream(new File(filePath));

		Workbook excelFile = new XSSFWorkbook(file);
		Sheet sheet = excelFile.getSheetAt(0);

		Iterator<Row> iteratorRow = sheet.iterator();

		rowDetails = new HashMap<Integer, List<String>>();
		details = new ArrayList<String>();

		DataFormatter dataFormatter = new DataFormatter();

		Integer i = 0;

		for (Row row : sheet) {
			if (row.getCell(0).getStringCellValue() == "")
				System.out.println("Null");
		}
		while (iteratorRow.hasNext()) {
			if (!skipped) {
				iteratorRow.next();
				skipped = true;
				continue;
			}

			Row row = iteratorRow.next();

			if (row == null)
				System.out.println("null");

			Iterator<Cell> cellIterator = row.iterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();

				String data = dataFormatter.formatCellValue(cell);

				if (cell.getColumnIndex() == 0 && data == "")
					return rowDetails;
				if (data != "") {
					details.add(data);
				}
			}
			rowDetails.put(i, new ArrayList<String>(details));
			details.clear();
			i++;
		}
		return rowDetails;
	}
}
