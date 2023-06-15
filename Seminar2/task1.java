import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main01_DZ {
    public static void JsonWriter(String fileName) {
        JSONObject person = new JSONObject();
        person.put("name", "Ivanov");
        person.put("city", "Moscow");
        person.put("country", "Russia");
        person.put("age", "null");

        try (FileWriter fileWriter = new FileWriter(fileName)) {

            fileWriter.write(person.toString());
            System.out.println("Текст успешно записан в файл : " + "data.json");
            System.out.println(person);

        } catch (IOException e) {
            System.out.println("Ошибка записи :(");
        }
    }

    public static String JsonReader(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения.....");
        }

        String jsonString = stringBuilder.toString();
        System.out.println(jsonString);
        return jsonString;
    }


    public static void JsonParser(String jsonString) {
        try {
            JSONObject jsonObject = new JSONObject(jsonString);

            Map<String, String> hashMap = new HashMap<>();

            Iterator<String> keys = jsonObject.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                String value = jsonObject.getString(key);
                hashMap.put(key, value);
            }

            StringBuilder whereClause = new StringBuilder("select * from students where ");

            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                if (value != null && !value.equals("null")) {
                    whereClause.append(key).append(" = '").append(value).append("' AND ");
                }
            }

            int lastIndex = whereClause.lastIndexOf("AND");
            whereClause.delete(lastIndex, lastIndex + 3);
            System.out.println(whereClause.toString());

        } catch (JSONException e) {
            System.out.println("Ошибка");
        }
    }


    public static void main(String[] args) {
        String fileName = "data1.json";
        JsonWriter(fileName);
        String res = JsonReader(fileName);

        JsonParser(res);

    }
}