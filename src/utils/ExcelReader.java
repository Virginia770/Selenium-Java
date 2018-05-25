package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mapping.Client;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * reads an Excel file.
 */
public class ExcelReader {

	private Object getCellValue(Cell cell) {
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();

		case Cell.CELL_TYPE_BOOLEAN:
			return cell.getBooleanCellValue();

		case Cell.CELL_TYPE_NUMERIC:
			return cell.getNumericCellValue();
		}

		return null;
	}

	public List<Client> readClientsFromExcelFile(String excelFilePath, int sheet) {
		List<Client> listClients = new ArrayList<>();
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File(excelFilePath));
		} catch (FileNotFoundException e) {
			System.out.println("The File was not found");
			e.printStackTrace();
		}

		Workbook workbook = null;
		try {
			workbook = new XSSFWorkbook(inputStream);
		} catch (IOException e) {
			System.out.println("The workbook failed");
			e.printStackTrace();
		}
		Sheet firstSheet = workbook.getSheetAt(sheet);
		Iterator<Row> iterator = firstSheet.iterator();

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			Client client = new Client();

			while (cellIterator.hasNext()) {
				Cell nextCell = cellIterator.next();
				int columnIndex = nextCell.getColumnIndex();

				switch (columnIndex) {
				case 0:
					client.setStatus((String) getCellValue(nextCell));

					break;

				case 1:
					client.setEmail((String) getCellValue(nextCell));

					break;
				case 2:
					client.setPassword((String) getCellValue(nextCell));

					break;

				case 3:
					client.setExpectedResult((String) getCellValue(nextCell));

					break;
				}

			}
			listClients.add(client);
		}

		try {
			workbook.close();
		} catch (IOException e) {
			System.out.println("The workbook was no closed");
			e.printStackTrace();
		}
		try {
			inputStream.close();
		} catch (IOException e) {
			System.out.println("It was no able to read file");
			e.printStackTrace();
		}

		return listClients;
	}

	public Client getSpecificClient(String clientType) {
		Client client = null;
		try {
			FileInputStream inputStream = new FileInputStream(new File(
					System.getProperty("user.dir") + Constants.excelFile));
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			Sheet firstSheet = workbook.getSheet("Users");
			Iterator<Row> iterator = firstSheet.iterator();
			while (iterator.hasNext()) {
				Row nextRow = iterator.next();
				if (nextRow.getCell(0).getStringCellValue()
						.equalsIgnoreCase(clientType)) {
					client = new Client();
					Iterator<Cell> cellIterator = nextRow.cellIterator();
					while (cellIterator.hasNext()) {
						Cell nextCell = cellIterator.next();
						/*
						 * if (nextCell.getStringCellValue().equalsIgnoreCase(
						 * clientType)) {
						 */
						int columnIndex = nextCell.getColumnIndex();
						switch (columnIndex) {
						case 0:
							client.setStatus((String) getCellValue(nextCell));
							break;
						case 1:
							client.setEmail((String) getCellValue(nextCell));
							break;
						case 2:
							client.setPassword((String) getCellValue(nextCell));
							break;
						case 3:
							client.setExpectedResult((String) getCellValue(nextCell));
							break;
						}
					}
				}
			}
			inputStream.close();
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Agregar posible logica si no se encuentra algo
		return client;
	}

	public String readExcelFile(String workbookName, int sheetName, int row,
			int column) {
		String val = null;
		try {
			InputStream ExcelFileToRead = new FileInputStream(workbookName);
			XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
			XSSFSheet sheet = wb.getSheetAt(sheetName);
			Row r = sheet.getRow(row);
			Cell value = r.getCell(column, Row.RETURN_BLANK_AS_NULL);
			val = value.toString();
			wb.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return val;

	}

}
