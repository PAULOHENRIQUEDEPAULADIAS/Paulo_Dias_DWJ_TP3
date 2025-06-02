package org.example.exercise;

import com.google.gson.Gson;
import org.example.client.SimpleHttpClient;

import java.io.IOException;
import java.net.URISyntaxException;

public class ex10 {
    public void Ex10() throws IOException, URISyntaxException {
        try
        {
        String url = "https://apichallenges.eviltester.com/sim/entities/2";

        String deleteRequest = SimpleHttpClient.delete(url);


        System.out.println("Delete Response: " + deleteRequest);

        }
        catch (Exception e)
        {
            System.out.println(e);;
        }
    }
}
