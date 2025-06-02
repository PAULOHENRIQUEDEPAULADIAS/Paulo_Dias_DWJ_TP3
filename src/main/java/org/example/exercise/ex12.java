package org.example.exercise;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.example.client.SimpleHttpClient;
import org.example.dtos.Items;
import java.io.IOException;
import java.net.URISyntaxException;

public class ex12 {

    public void Ex12() throws IOException, URISyntaxException {
        String url1 = "https://apichallenges.eviltester.com/simpleapi/items";

        String getAll = SimpleHttpClient.get(url1);
        System.out.println("Get all Response: " + getAll);
        System.out.println("\n\n");

        String url2 = "https://apichallenges.eviltester.com/simpleapi/randomisbn";

        String getISBNRandon = SimpleHttpClient.get(url2);
        String ISBN = getISBNRandon.trim();
        System.out.println("Get randon ISBN Response: " + getISBNRandon);
        System.out.println("\n\n");

        String url3 = "https://apichallenges.eviltester.com/simpleapi/items";

        var item = new Items("cd", ISBN, 5.50, 50);

        String creatingItem = SimpleHttpClient.post(url3, item);
        System.out.println("Creating item Response: " + creatingItem);
        System.out.println("\n\n");

        JsonObject jsonObject = JsonParser.parseString(creatingItem).getAsJsonObject();
        String id = jsonObject.get("id").getAsString();
        String url4 = "https://apichallenges.eviltester.com/simpleapi/items/" + id;

        var itemAdded = new Items("cd", ISBN, 1.00, 100);

        String updatingItem = SimpleHttpClient.put(url4, itemAdded);
        System.out.println("Updating item Response: " + updatingItem);
        System.out.println("\n\n");

        String url5 = "https://apichallenges.eviltester.com/simpleapi/items/" + id;

        String deletingItem = SimpleHttpClient.delete(url5);
        System.out.println("Deleting item Response: " + deletingItem);
        System.out.println("\n\n");
    }
}
