package pages;

import okhttp3.*;

import java.io.IOException;
import java.util.List;

import org.json.JSONObject;
import utilities.ConfigurationReader;

public class OpenAI_Validator {


    private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    private static final String API_KEY = ConfigurationReader.getProperty("API_KEY"); //// Fetch from config

    public static String validateWithOpenAI(String contentType, List<String> items, String expectedItems) throws IOException {
        OkHttpClient client = new OkHttpClient();
        String itemContent = String.join(", ", items);

           String requestBody = "{"
                + "\"model\": \"gpt-3.5-turbo\","
                + "\"messages\": [{"
                + "\"role\": \"user\","
                + "\"content\": \"Here are the " + contentType + " I found: " + itemContent
                + ". Do these match the expected " + contentType + ": " + expectedItems + "?\""
                + "}]"
                + "}";

        RequestBody body = RequestBody.create(requestBody, MediaType.get("application/json"));
        Request request = new Request.Builder()
                .url(API_URL)
                .post(body)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new IOException("Request failed: " + response.body().string());
            }
        }
    }

    public static boolean isValidationSuccessful(String openAIResponse) {
        JSONObject jsonResponse = new JSONObject(openAIResponse);
        String content = jsonResponse.getJSONArray("choices")
                .getJSONObject(0)
                .getJSONObject("message")
                .getString("content");

        // Check for "match" confirmation
        if (content.contains("Yes") && content.contains("match")) {
            return true;
        }

        // Check for mismatch indicators
        if (content.contains("do not match") || content.contains("mismatch") || content.contains("do not include")) {
            return false;
        }

        // Unexpected format; treat it as a failure
        System.err.println("Unexpected response format: " + content);
            return false;

    }

}




