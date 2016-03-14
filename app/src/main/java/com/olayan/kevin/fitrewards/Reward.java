package com.olayan.kevin.fitrewards;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kevin on 3/8/2016.
 */
public class Reward {

    private static final String JSON_ID = "RewardId";
    private static final String JSON_NAME = "RewardName";
    private static final String JSON_CALORIE = "RewardCalorie";

    private int mRewardId;
    private String mRewardName;
    private int mRewardCalorie;

    public int getRewardCalorie() {
        return mRewardCalorie;
    }

    public void setRewardCalorie(int rewardCalorie) {
        mRewardCalorie = rewardCalorie;
    }

    public int getRewardId() {
        return mRewardId;
    }

    public void setRewardId(int rewardId) {
        mRewardId = rewardId;
    }

    public String getRewardName() {
        return mRewardName;
    }

    public void setRewardName(String rewardName) {
        mRewardName = rewardName;
    }

    public Reward(int id, String name, int calorie) {
        mRewardId =id;
        mRewardName = name;
        mRewardCalorie = calorie;
    }

    public Reward(JSONObject json) throws JSONException {
        mRewardId = json.getInt(JSON_ID);
        mRewardName = json.getString(JSON_NAME);
        mRewardCalorie = json.getInt(JSON_CALORIE);
    }
}
