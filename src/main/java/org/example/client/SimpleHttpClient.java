package org.example.client;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class SimpleHttpClient {

    private static final Gson gson = new Gson();

    public static String get(String urlStr) throws IOException, URISyntaxException {
        HttpURLConnection conn = getConnection(urlStr, "GET");

        int status = conn.getResponseCode();
        System.out.println("Response Status: "+status);
        return lerResposta(conn);
    }
    public static String delete(String urlStr) throws IOException, URISyntaxException {
        HttpURLConnection conn = getConnection(urlStr, "DELETE");

        int status = conn.getResponseCode();
        System.out.println("Response Status: "+status);
        return lerResposta(conn);
    }
    public static String options(String urlStr) throws IOException, URISyntaxException {
        HttpURLConnection conn = getConnection(urlStr, "OPTIONS");

        int status = conn.getResponseCode();
        System.out.println("Response Status: "+status);

        String allowedMethods = conn.getHeaderField("Allow");
        return allowedMethods != null ? allowedMethods : "Nenhum método encontrado.";
    }

    public static String post(String urlStr, Object body) throws IOException, URISyntaxException {
        HttpURLConnection conn = getConnection(urlStr, "POST");

        String jsonInputString = gson.toJson(body);
        try (OutputStream os = conn.getOutputStream()){
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input);
        }

        int status = conn.getResponseCode();
        if (status != 200 && status != 201){
            throw new IOException("Erro na requisição Post. Código de resposta " + status);
        }
        System.out.println("Response Status: "+status);
        return lerResposta(conn);
    }

    public static String put(String urlStr, Object body) throws IOException, URISyntaxException {
        HttpURLConnection conn = getConnection(urlStr, "PUT");

        String jsonInputString = gson.toJson(body);
        try (OutputStream os = conn.getOutputStream()){
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input);
        }

        int status = conn.getResponseCode();
        if (status != 200 && status != 201 && status != 204){
            throw new IOException("Erro na requisição Post. Código de resposta " + status);
        }
        System.out.println("Response Status: "+status);
        return lerResposta(conn);
    }

    public static HttpURLConnection getConnection(String urlStr, String requestMethod) throws URISyntaxException, IOException {
        URL url = new URI(urlStr).toURL();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(requestMethod);
        conn.setRequestProperty("Accept", "application/json");

        if(requestMethod.equals("POST") || requestMethod.equals("PUT")){
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);
        }

        return conn;
    }

    private static String lerResposta(HttpURLConnection conn) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        String inputLine;
        StringBuilder content = new StringBuilder();
        while((inputLine = in.readLine()) != null){
            content.append(inputLine).append('\n');
        }

        in.close();
        conn.disconnect();
        return content.toString();
    }
}
