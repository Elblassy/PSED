package com.elblasy.m_elblasy.psedv2.loading_data;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;

import com.elblasy.m_elblasy.psedv2.QueryUtils;
import com.elblasy.m_elblasy.psedv2.activities.Speakers;
import com.elblasy.m_elblasy.psedv2.list.ModelOfData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.elblasy.m_elblasy.psedv2.QueryUtils.createUrl;
import static com.elblasy.m_elblasy.psedv2.QueryUtils.makeHttpRequest;

public class SpeakersData {


    private static final String LOG_TAG = SpeakersData.class.getName();


    public static List<ModelOfData> fetchSpeakersData(String requestUrl) {


        // Create URL object
        URL url = createUrl(requestUrl);

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }

        // Extract relevant fields from the JSON response and create a list of {@link speaker}s
        List<ModelOfData> speakers = extractFeatureFromJson(jsonResponse);

        // Return the list of {@link speakers}s
        return speakers;
    }

    private static List<ModelOfData> extractFeatureFromJson(String speakersJSON) {
        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(speakersJSON)) {
            return null;
        }

        List<ModelOfData> list = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(speakersJSON);
            Bitmap imageUrl = null;
            Bitmap imageUrl2 = null;

            //get JSon Array
            JSONArray array = jsonObject.getJSONArray("Speakers");
            for (int i = 0; i < array.length(); i++) {
                JSONObject speakers = array.getJSONObject(i);

                String name = speakers.getString("name");

                String image = speakers.getString("image");

                String image2 = "";
                if(speakers.has("image2")){
                    image2 = speakers.getString("image2");
                    imageUrl2 = getSpeakerImage(image2);
                }
                String dis = speakers.getString("description");
                imageUrl = getSpeakerImage(image);

                ModelOfData modelOfData = new ModelOfData(name, imageUrl,imageUrl2, dis);
                Speakers.categories.add(modelOfData.getName());
                list.add(modelOfData);
            }
        } catch (Exception e) {

            Log.d("Error", "Cannot process JSON results", e);
        }
        return list;
    }

    private static Bitmap getSpeakerImage(String imageUrl) {
        URL url = createUrl(imageUrl);
        Bitmap bitmap = null;
        InputStream ins = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.connect();
            int code = httpURLConnection.getResponseCode();
            if (code == 200) {
                ins = httpURLConnection.getInputStream();
                bitmap = BitmapFactory.decodeStream(ins);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
