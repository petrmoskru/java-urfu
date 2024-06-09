package lr8.task2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;

public class JsonCreatorLesson {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        JSONArray lessons = new JSONArray();

        JSONObject lesson1 = new JSONObject();
        lesson1.put("name", "Математика");
        lesson1.put("professor", "Иван Иванович");
        lesson1.put("credits", 5);

        JSONObject lesson2 = new JSONObject();
        lesson2.put("name", "Программирование");
        lesson2.put("professor", "Мария Сергеевна");
        lesson2.put("credits", 4);

        lessons.add(lesson1);
        lessons.add(lesson2);

        jsonObject.put("lessons", lessons);

        try (FileWriter file = new FileWriter("java-core/src/lr8/task2/my-lessons.json")) {
            file.write(jsonObject.toJSONString());
            System.out.println("JSON-файл успешно создан!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
