package org.example.exercise;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.example.client.SimpleHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

public class ex03 {

    public void Ex03() throws IOException, URISyntaxException {
        try {
            String getInexistentEntity = SimpleHttpClient.get("https://apichallenges.eviltester.com/sim/entities/13");

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonElement jsonElement = JsonParser.parseString(getInexistentEntity);
            String prettyJson = gson.toJson(jsonElement);

            System.out.println(prettyJson);
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
}
