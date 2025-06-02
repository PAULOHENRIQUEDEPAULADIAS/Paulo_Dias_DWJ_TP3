package org.example.exercise;

import com.google.gson.Gson;
import org.example.client.SimpleHttpClient;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URISyntaxException;
public class ex02 {
    public void Ex02() throws IOException, URISyntaxException {
        for (int id = 1; id <= 8; id++){
            String requisition = "https://apichallenges.eviltester.com/sim/entities/" + id;
            String getEntitiesById = SimpleHttpClient.get(requisition);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonElement jsonElement = JsonParser.parseString(getEntitiesById);
            String prettyJson = gson.toJson(jsonElement);

            System.out.println(prettyJson);
        }
    }
}
