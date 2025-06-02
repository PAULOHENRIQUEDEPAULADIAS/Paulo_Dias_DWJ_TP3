package org.example.exercise;

import com.google.gson.Gson;
import org.example.client.SimpleHttpClient;
import org.example.dtos.PostRequest;

import java.io.IOException;
import java.net.URISyntaxException;

public class ex05 {
    public void Ex05() throws IOException, URISyntaxException {
        Gson gson = new Gson();
        String url = "https://apichallenges.eviltester.com/sim/entities";
        PostRequest postRequest = new PostRequest("aluno", "" );
        String post = SimpleHttpClient.post(url, postRequest);

        System.out.println("Post Response: " + post);

        String jsonInputString = gson.toJson(postRequest);
        System.out.println("Corpo enviado: " + jsonInputString);
    }
}
