package lr8.task4;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

public class ReadExcelFileExample {
    public static void main(String[] args) {
        boolean success = false;
        do {
            try {
                String filePath = "java-core/src/lr8/task4/example.xls";
                File file = new File(filePath);
                if (!file.exists()) {
                    System.out.println("Файл не найден. Пожалуйста, укажите верный путь к файлу.");
                    return;
                }
                Workbook workbook = Workbook.getWorkbook(file);
                String sheetName = "Товары";
                Sheet sheet = workbook.getSheet(sheetName);
                if (sheet == null) {
                    System.out.println("Лист '" + sheetName + "' не найден в файле. Пожалуйста, убедитесь, что файл содержит лист с таким именем.");
                    return;
                }
                for (int row = 0; row < sheet.getRows(); row++) {
                    for (int col = 0; col < sheet.getColumns(); col++) {
                        Cell cell = sheet.getCell(col, row);
                        System.out.print(cell.getContents() + "\t");
                    }
                    System.out.println();
                }
                workbook.close();
                success = true;
            } catch (IOException e) {
                System.out.println("Ошибка ввода-вывода: " + e.getMessage());
                e.printStackTrace();
            } catch (BiffException e) {
                System.out.println("Ошибка чтения файла Excel: " + e.getMessage());
                e.printStackTrace();
            }
            if (!success) {
                System.out.println("Произошла ошибка при чтении файла. Хотите попробовать еще раз? (Да/Нет)");
                String response = System.console().readLine();
                if (!response.equalsIgnoreCase("Да")) {
                    break;
                }
            }
        } while (!success);
    }
}