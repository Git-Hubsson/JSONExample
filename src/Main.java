import org.json.simple.JSONObject;

public class Main {
    public static void main(String[] args) {
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
    }
}