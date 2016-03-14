package com.olayan.kevin.fitrewards;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by kevin on 3/8/2016.
 */
//TODO can this be replaced with GSON code?
public class FitRewardsJSONSerializer {

    private String TAG = "FitRewardsJSONSerializer";
    private Context mContext;
    private String mFilename;

    public FitRewardsJSONSerializer(Context c, String f) {
        mContext = c;
        mFilename = f;
    }

   public ArrayList<Reward> loadRewards() throws IOException, JSONException {
       ArrayList<Reward> rewards = new ArrayList<>();
       BufferedReader reader = null;
       try {
           //open and read the file into a string builder
//           InputStream in = mContext.openFileInput(mFilename);
           InputStream in = mContext.getAssets().open(mFilename);
           reader = new BufferedReader(new InputStreamReader(in));
           StringBuilder jsonString = new StringBuilder();
           String line = null;
           while ((line = reader.readLine()) != null) {
               //line breaks are omitted and irrelevant
               jsonString.append(line);
           }
           // parse the JSON using JSONTokener
           JSONArray array = (JSONArray) new JSONTokener(jsonString.toString()).nextValue();
           //build the array of rewards from JSONObjects
           for (int i = 0; i < array.length(); i++) {
               rewards.add(new Reward(array.getJSONObject(i)));
           }
       } catch (FileNotFoundException e) {
           Log.e(TAG, e.toString());
       } finally {
           if (reader != null) {
               reader.close();
           }
       }
       return rewards;
   }


}
