package org.example.exercise;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.example.client.SimpleHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

public class ex04 {

    public void Ex04() throws IOException, URISyntaxException {
        String url = "https://apichallenges.eviltester.com/sim/entities?categoria=teste&limite=5";
        String getWithInexistingParameter = SimpleHttpClient.get(url);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement jsonElement = JsonParser.parseString(getWithInexistingParameter);
        String prettyJson = gson.toJson(jsonElement);

        System.out.println(url);
        System.out.println(prettyJson);
    }
}
