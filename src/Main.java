import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

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

        fetchJsonFromFile();
        fetchJsonFromAPI();
    }

    static void fetchJsonFromFile() throws IOException, ParseException {

        //Hämta data från JSON fil
        JSONObject fetchData = (JSONObject) new JSONParser().parse(new FileReader("src/data.json"));

        //Konvertera data till ett JSONObject
        JSONObject person1 = (JSONObject) fetchData.get("p1");
        JSONObject person2 = (JSONObject) fetchData.get("p2");

        //Hämta och skriv ut data
        String nameP1 = person1.get("name").toString();
        String nameP2 = person2.get("name").toString();
        int ageP1 = Integer.parseInt(person1.get("age").toString());
        int ageP2 = Integer.parseInt(person2.get("age").toString());

        System.out.println("P1 Name : " + nameP1);
        System.out.println("P1 Age : " + ageP1);

        JSONArray dataArray = (JSONArray) person1.get("data");
        System.out.println(dataArray);
        System.out.println(dataArray.get(2));
    }

    static void fetchJsonFromAPI() throws IOException, ParseException {
        //Spara URL till API
        URL url = new URL("https://api.wheretheiss.at/v1/satellites/25544");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        if (conn.getResponseCode() == 200) {
            System.out.println("Koppling lyckades");
        } else {
            System.out.println("Koppling misslyckades");
        }

        StringBuilder strData = new StringBuilder();
        Scanner scanner = new Scanner(url.openStream());
        while (scanner.hasNext()) {
            strData.append(scanner.nextLine());
        }
        scanner.close();

        JSONObject dataObject = (JSONObject) new JSONParser().parse(String.valueOf(strData));

        System.out.println(dataObject);
    }
}
