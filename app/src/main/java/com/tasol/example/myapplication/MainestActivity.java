package com.tasol.example.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainestActivity extends AppCompatActivity {

    ViewPager myVP;
    private ArrayList<String> percentArray = new ArrayList<>();
    private ArrayList<String> presentArray = new ArrayList<>();
    SpeakerInfoAdapter speakerInfoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainest);
        myVP = (ViewPager) findViewById(R.id.myVP);

        dateWalaMethod();

        percentArray.add("30");
        percentArray.add("45");
        percentArray.add("50");
        percentArray.add("65");
        percentArray.add("70");

        presentArray.add("40");
        presentArray.add("55");
        presentArray.add("10");
        presentArray.add("45");
        presentArray.add("50");

        speakerInfoAdapter = new SpeakerInfoAdapter(getSupportFragmentManager());
        myVP.setAdapter(speakerInfoAdapter);
        myVP.setCurrentItem(2, true);
        myVP.setPageTransformer(true, new ZoomOutPageTransformer(true));
//        myVP.setOffscreenPageLimit(3);
//        //A little space between pages
//        myVP.setPageMargin(20);
//        //If hardware acceleration is enabled, you should also remove
//        // clipping on the pager for its children.
//        myVP.setClipChildren(false);
    }

    //Honest Method Names
    private void dateWalaMethod() {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, - (Calendar.DAY_OF_MONTH - 1));
        Log.d("TAG0", format.format(cal.getTime()));

        Calendar cal0 = Calendar.getInstance();
        cal0.add(Calendar.MONTH, -1);
        cal0.add(Calendar.DAY_OF_MONTH, - (Calendar.DAY_OF_MONTH - 1));
        Log.d("TAG1", format.format(cal0.getTime()));

        Calendar cal1 = Calendar.getInstance();
        cal1.add(Calendar.MONTH, -2);
        cal1.add(Calendar.DAY_OF_MONTH, - (Calendar.DAY_OF_MONTH - 1));
        Log.d("TAG2", format.format(cal1.getTime()));

        Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.MONTH, -3);
        cal2.add(Calendar.DAY_OF_MONTH,  - (Calendar.DAY_OF_MONTH - 1));
        Log.d("TAG3", format.format(cal2.getTime()));
    }

    private class SpeakerInfoAdapter extends FragmentStatePagerAdapter {

        public SpeakerInfoAdapter(FragmentManager fm) {
            super(fm);
        }

        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        @Override
        public Fragment getItem(int pos) {
            System.gc();
            try {
                return new IndoLyticsSpeakerInfoAdapter(MainestActivity.this, percentArray.get(pos), presentArray.get(pos));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }




        @Override
        public int getCount() {

            return percentArray.size();

        }
    }
}
