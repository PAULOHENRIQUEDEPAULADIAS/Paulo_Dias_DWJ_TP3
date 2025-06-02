package org.example.exercise;

import com.google.gson.Gson;
import org.example.client.SimpleHttpClient;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URISyntaxException;

public class ex01 {
    public void Ex01() throws IOException, URISyntaxException {
        String getAllEntities = SimpleHttpClient.get("https://apichallenges.eviltester.com/sim/entities");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement jsonElement = JsonParser.parseString(getAllEntities);
        String prettyJson = gson.toJson(jsonElement);

        System.out.println(prettyJson);
    }
}
