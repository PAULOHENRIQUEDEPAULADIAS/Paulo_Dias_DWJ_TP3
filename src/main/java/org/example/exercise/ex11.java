package org.example.exercise;

import org.example.client.SimpleHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

public class ex11 {
    public void Ex11() throws IOException, URISyntaxException {
        String url = "https://apichallenges.eviltester.com/sim/entities";

        String optionsRequest = SimpleHttpClient.options(url);

        System.out.println("Options Response: " + optionsRequest);
    }
}
