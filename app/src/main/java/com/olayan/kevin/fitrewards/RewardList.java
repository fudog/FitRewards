package com.olayan.kevin.fitrewards;

import android.content.Context;

import com.olayan.kevin.logger.Log;

import java.util.ArrayList;

/**
 * Created by kevin on 3/8/2016.
 * set up as a singleton
 */
public class RewardList {
    private static final String TAG = "RewardList";
    private static final String FILENAME = "rewards.json";

    private ArrayList<Reward> mRewards;
    private FitRewardsJSONSerializer mSerializer;

    private static RewardList uniqueInstance;
    private Context mAppContext;

    private RewardList(Context appContext) {
        mAppContext = appContext;
        mSerializer = new FitRewardsJSONSerializer(mAppContext, FILENAME);

        try {
            mRewards = mSerializer.loadRewards();
        } catch (Exception e) {
            Log.e(TAG, "Error loading rewards: ", e);
            //load fake data
            for (int i = 0; 1 < 10; i++) {
                Reward r = new Reward(i, "Reward #" + i, i*100);
                mRewards.add(r);
            }
        }
    }

    //access RewardList through this method
    public static RewardList getInstance(Context c) {
        //passing in context because need it for the serializer for loading the json
        if (uniqueInstance == null) {
            uniqueInstance = new RewardList(c.getApplicationContext());
        }
        return uniqueInstance;
    }

    public ArrayList<Reward> getRewards() {
        return mRewards;
    }

    public Reward getReward(int id) {
        for (Reward r : mRewards) {
            if (r.getRewardId() == id)
                return r;
        }
        return null;
    }
}
