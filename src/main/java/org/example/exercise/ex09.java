package org.example.exercise;

import com.google.gson.Gson;
import org.example.client.SimpleHttpClient;
import java.io.IOException;
import java.net.URISyntaxException;

public class ex09 {
    public void Ex09() throws IOException, URISyntaxException {

        Gson gson = new Gson();
        String url = "https://apichallenges.eviltester.com/sim/entities/9";

        String deleteRequest = SimpleHttpClient.delete(url);


        System.out.println("Delete Response: " + deleteRequest);
        String jsonInputString = gson.toJson(deleteRequest);
        System.out.println("Corpo enviado: " + jsonInputString);
        try
        {
            String get9thParameter = SimpleHttpClient.get(url);
            System.out.println("Get Response: " + get9thParameter);
        }
        catch (Exception e)
        {
            System.out.println(e);;
        }
    }
}
