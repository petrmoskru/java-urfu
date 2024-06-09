package lr8.task4;

import java.io.File;
import java.io.IOException;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class WriteExcelFileExample {
    public static void main(String[] args) {
        try {
            WritableWorkbook workbook = Workbook.createWorkbook(new File("java-core/src/lr8/task4/example.xls"));
            WritableSheet sheet = workbook.createSheet("Товары", 0);
            sheet.addCell(new Label(0, 0, "Товар"));
            sheet.addCell(new Label(1, 0, "Характеристики"));
            sheet.addCell(new Label(2, 0, "Стоимость"));
            sheet.addCell(new Label(0, 1, "Книга"));
            sheet.addCell(new Label(1, 1, "Жанр: Фантастика, Автор: Иванов И.И."));
            sheet.addCell(new jxl.write.Number(2, 1, 500.0));
            sheet.addCell(new Label(0, 2, "Компьютер"));
            sheet.addCell(new Label(1, 2, "Процессор: Intel Core i5, Оперативная память: 8 Гб"));
            sheet.addCell(new jxl.write.Number(2, 2, 25000.0));
            workbook.write();
            workbook.close();
            System.out.println("Данные записаны в файл: example.xls");
        } catch (IOException | WriteException e) {
            e.printStackTrace();
        }
    }
}