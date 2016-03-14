package com.olayan.kevin.fitrewards;

import android.support.v4.app.Fragment;

    /**
     * This app gets calories expended from the History API of the Google Fit platform.
     * User is authenticated with Google Play Services.
     * App shows how many rewards you get per day for exercising
     */
    public class RewardsActivity extends SingleFragmentActivity {
        public static final String TAG = "RewardsActivity";


        @Override
        protected Fragment createFragment() {
            return new RewardsFragment();
        }

    }
