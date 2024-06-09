package lr8.task3;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CustomNewsParser {
    public static void main(String[] args) {
        String fileName = "java-core/src/lr8/task3/example.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            Connection.Response response = Jsoup.connect("http://fat.urfu.ru/index.html")
                    .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
                    .timeout(10000)
                    .ignoreHttpErrors(true)
                    .execute();
            int statusCode = response.statusCode();
            if (statusCode == 200) {
                Document doc = response.parse();
                Elements newsParent = doc.select("body > table > tbody > tr > td > div > table > tbody > tr:nth-child(5) > td:nth-child(3) > table > tbody > tr > td:nth-child(1)");
                for (int i = 3; i < 20; i++) {
                    if (!(i % 2 == 0)) {
                        List<Element> nodes = newsParent.get(0).children();
                        Element node = nodes.get(i);
                        Element titleElement = node.getElementsByClass("blocktitle").first();
                        Element dateElement = node.getElementsByClass("blockdate").first();
                        if (titleElement != null && dateElement != null) {
                            String title = titleElement.text();
                            String date = dateElement.text();
                            System.out.println("Тема: " + title);
                            System.out.println("Дата: " + date + "\n");
                            writer.write("Тема: " + title + "\n");
                            writer.write("Дата: " + date + "\n\n");
                        }
                    }
                }
            } else {
                System.out.println("Ошибка при обращении к серверу: " + statusCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
