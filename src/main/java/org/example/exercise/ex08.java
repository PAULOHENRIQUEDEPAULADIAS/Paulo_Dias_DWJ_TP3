package org.example.exercise;

import com.google.gson.Gson;
import org.example.client.SimpleHttpClient;
import org.example.dtos.PostRequest;
import java.io.IOException;
import java.net.URISyntaxException;

public class ex08 {
    public void Ex08() throws IOException, URISyntaxException {
        Gson gson = new Gson();
        String url = "https://apichallenges.eviltester.com/sim/entities/10";

        var postRequest = new PostRequest("atualizado", "" );
        String update10thParameter = SimpleHttpClient.put(url, postRequest);


        System.out.println("Put Response: " + update10thParameter);
        String jsonInputString = gson.toJson(postRequest);
        System.out.println("Corpo enviado: " + jsonInputString);

        String get10thParameter = SimpleHttpClient.get(url);
        System.out.println("Get Response: " + get10thParameter);



    }
}
