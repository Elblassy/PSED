package com.elblasy.m_elblasy.psedv2.loading_data;

import android.text.TextUtils;
import android.util.Log;

import com.elblasy.m_elblasy.psedv2.list.AjendaList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.elblasy.m_elblasy.psedv2.QueryUtils;

import static com.elblasy.m_elblasy.psedv2.QueryUtils.createUrl;
import static com.elblasy.m_elblasy.psedv2.QueryUtils.makeHttpRequest;

public class AjendaData {


    private static final String LOG_TAG = AjendaData.class.getName();


    public static List<AjendaList> fetchAjendaData(String requestUrl) {


        // Create URL object
        URL url = QueryUtils.createUrl(requestUrl);

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = QueryUtils.makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }

        // Extract relevant fields from the JSON response and create a list of {@link ajenda}s
        List<AjendaList> ajenda = extractFeatureFromJson(jsonResponse);

        // Return the list of {@link ajenda}s
        return ajenda;
    }

    private static List<AjendaList> extractFeatureFromJson(String ajendaJSON) {
        if (TextUtils.isEmpty(ajendaJSON)) {
            return null;
        }

        List<AjendaList> list = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(ajendaJSON);
            JSONArray array = jsonObject.getJSONArray("ajenda");

            for (int i = 0; i < array.length(); i++) {
                JSONObject ajenda = array.getJSONObject(i);
                String name = " ";
                if (ajenda.has("name")) {
                    name = ajenda.getString("name");
                }
                String date = ajenda.getString("date");
                String time = ajenda.getString("time");
                String event = ajenda.getString("event");

                AjendaList ajendaList = new AjendaList(name, time, date, event);

                list.add(ajendaList);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;
    }


}
