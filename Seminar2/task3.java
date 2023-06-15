import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main03_DZ {
    public static void JsonWriter(String fileName){
        JSONArray data = new JSONArray();

        JSONObject student1 = new JSONObject();
        student1.put("фамилия", "Иванов");
        student1.put("оценка", "5");
        student1.put("предмет", "Математика");

        JSONObject student2 = new JSONObject();
        student2.put("фамилия", "Петрова");
        student2.put("оценка", "4");
        student2.put("предмет", "Информатика");

        JSONObject student3 = new JSONObject();
        student3.put("фамилия", "Краснов");
        student3.put("оценка", "5");
        student3.put("предмет", "Физика");

        data.put(student1);
        data.put(student2);
        data.put(student3);

        try(FileWriter fileWriter = new FileWriter(fileName)){

            fileWriter.write(data.toString());
            System.out.println("Текст успешно записан в файл : " + "data.json");
            System.out.println(data);

        } catch (IOException e) {
            System.out.println("Ошибка записи :(");
        }
    }
    public static String JsonReader(String fileName){
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

    public static void JsonParser(String jsonString){

        JSONArray jsonArray = new JSONArray(jsonString);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject student = jsonArray.getJSONObject(i);
            String surname = student.getString("фамилия");
            String mark = student.getString("оценка");
            String item = student.getString("предмет");
            stringBuilder.append("Студент ").append(surname).append(" получил ").append(mark).append(" по предмету ").append(item).append(".\n");
        }

        // Вывод результатов
        System.out.println(stringBuilder.toString());
    }

    public static void main(String[] args) {
        String fileName = "data.json";
        JsonWriter(fileName);
        String res = JsonReader(fileName);

        System.out.println("\n");
        String jsonString = res;
        JsonParser(jsonString);

    }
}