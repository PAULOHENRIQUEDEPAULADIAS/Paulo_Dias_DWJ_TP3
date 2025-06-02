package org.example.exercise;

import org.example.client.SimpleHttpClient;
import org.example.dtos.PostRequest;

import java.io.IOException;
import java.net.URISyntaxException;

public class ex07 {
    public void Ex07() throws IOException, URISyntaxException {
        String url = "https://apichallenges.eviltester.com/sim/entities/10";

        PostRequest postRequest = new PostRequest("atualizado", "" );
        String update10thParameter = SimpleHttpClient.post(url, postRequest);

        System.out.println("Post Response: " + update10thParameter);
    }
}
