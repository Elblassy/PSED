package com.example.m_elblasy.psedv2.loading_data;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;

import com.example.m_elblasy.psedv2.list.ItemsForCells;
import com.example.m_elblasy.psedv2.list.ProjectsList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.example.m_elblasy.psedv2.QueryUtils.createUrl;
import static com.example.m_elblasy.psedv2.QueryUtils.makeHttpRequest;

public class ProjectsData {

    private static final String LOG_TAG = ProjectsData.class.getName();

   public static List<ItemsForCells> fetchProjectsData(String requestUrl) {

        //create Url
        URL url = createUrl(requestUrl);

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }
        // Extract relevant fields from the JSON response and create a list of {@link ProjectsData}s
        List<ItemsForCells> projectsData = extractFeatureFromJson(jsonResponse);

        // Return the list of {@link ProjectsData}s
        return projectsData;
    }

    public static List<ItemsForCells> extractFeatureFromJson(String projectsJson) {

        if (TextUtils.isEmpty(projectsJson)) {
            return null;
        }
        ArrayList<ItemsForCells> items = new ArrayList<>();
        ArrayList<ArrayList<ProjectsList>> lists = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(projectsJson);
            Bitmap imageUrl2 = null;
            Bitmap imageUrl = null;

            //get JSON Array
            JSONArray projects = jsonObject.getJSONArray("Projects");
            for (int i = 0; i < projects.length(); i++) {
                ArrayList<ProjectsList> projectsLists = new ArrayList<>();

                JSONObject object1 = projects.getJSONObject(i);
                Log.i(LOG_TAG, "JSON : " + i);
                //String image = object1.getString("image");
                JSONArray listOfProjects = object1.getJSONArray("listOfProjects");
                for (int j = 0; j < listOfProjects.length(); j++) {
                    Log.i(LOG_TAG, "JSON2 : " + j);

                    JSONObject object2 = listOfProjects.getJSONObject(j);
                    String image2 = object2.getString("imageOfProject");
                    String dis = object2.getString("discription");
                   imageUrl2 = getProjectsImage(image2);

                    ProjectsList projectsData = new ProjectsList(imageUrl2, dis);
                    projectsLists.add(projectsData);
                }
                ItemsForCells itemsForCells = new ItemsForCells();
                //imageUrl = getProjectsImage(image);
               // itemsForCells.setImage(imageUrl);
                lists.add(i, projectsLists);
                itemsForCells.setListOFProjects(lists);
                items.add(itemsForCells);
                Log.i(LOG_TAG, "lists : " + lists.get(i).size());
                Log.i(LOG_TAG, "lists1 : " + itemsForCells.getListOFProjects().size());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return items;
    }

    private static Bitmap getProjectsImage(String imageUrl) {
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
