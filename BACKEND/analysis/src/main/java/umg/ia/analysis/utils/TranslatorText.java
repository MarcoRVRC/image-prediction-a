package umg.ia.analysis.utils;

import java.io.IOException;

import com.google.gson.*;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class TranslatorText {

    private static String key = "00a4e74b80bf441c839cf50c4337013b";
    public String endpoint = "https://api.cognitive.microsofttranslator.com/";
    public String route = "/translate?api-version=3.0&from=en&to=es";
    public String url = endpoint.concat(route);

    // location, also known as region.
    // required if you're using a multi-service or regional (not global) resource. It can be found in the Azure portal on the Keys and Endpoint page.
    private static String location = "eastus";

    // Instantiates the OkHttpClient.
    OkHttpClient client = new OkHttpClient();

    // This function performs a POST request.
    public String Post(String texto) throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType,
                "[{\n\t\"Text\": \" "+ texto +"   \"\n}]");
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Ocp-Apim-Subscription-Key", key)
                // location required if you're using a multi-service or regional (not global) resource.
                .addHeader("Ocp-Apim-Subscription-Region", location)
                .addHeader("Content-type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    // This function prettifies the json response.
    public String prettify(String json_text) {
        JsonParser parser = new JsonParser();
        JsonElement json = parser.parse(json_text);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(json);
    }

    public String traducirTexto(String texto){
        String response="";
        try {
            TranslatorText translateRequest = new TranslatorText();
            String jsonResponse = translateRequest.Post(texto);
            response = extractTextFromJson(jsonResponse);
        } catch (Exception e) {
            System.out.println(e);
        }
        return response;
    }

    private String extractTextFromJson(String json) {
        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(json);
        JsonArray jsonArray = jsonElement.getAsJsonArray();
        String text = jsonArray.get(0).getAsJsonObject().getAsJsonArray("translations").get(0).getAsJsonObject().get("text").getAsString();
        return text;
    }


}
