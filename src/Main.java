import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        System.out.println("Hello world!");
        System.out.println("This is an example");

        //Skapa JSON objekt
        JSONObject jsonOb = new JSONObject();

        //Skapa värden. Först nyckelord sedan värde
        jsonOb.put("namn", "Anton");
        jsonOb.put("age", 29);

        //Skriva ut värden
        System.out.println("Mitt namn är " + jsonOb.get("namn"));
        System.out.println("Jag är " + jsonOb.get("age") + " år gammal");

        Object o = new JSONParser().parse(new FileReader("src/data.json"));
        JSONObject jsonData =(JSONObject) o;

        JSONObject person = (JSONObject) jsonData.get("p1");
        String name = (String) person.get("name");
        System.out.println("P1 Name :" + name);
    }
}