package com.RealMirror;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import java.io.File;

/**
 * Created by manan on 11/4/2015.
 */

public class ScreenSlidePagerActivity extends FragmentActivity /*implements LoaderManager.LoaderCallbacks<Cursor>*/{
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static int NUM_PAGES = 5;
    static int IMAGE_NUM = 0;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;
    public static File[] files;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        //set numpages = num of images
        SharedPreferences sharedPreferences = getSharedPreferences("pref", Context.MODE_PRIVATE);
        File file = new File(sharedPreferences.getString(MirrorKlass.DIRECTORY_NAME_PREF, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath()));

        if (file.isDirectory()) {
            if (file.listFiles() != null) {
                //files = new File[file.listFiles().length];
                NUM_PAGES = file.listFiles().length;
                files = file.listFiles();
            }
        }

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
    }

    @Override
    public void onBackPressed() {
        //if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        //} else {
            // Otherwise, select the previous step.
          //  mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        //}
    }

    /**
     * A simple pager adapter that represents ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            IMAGE_NUM = position;
            Fragment fr = new ScreenSlidePageFragment();
            ((ScreenSlidePageFragment)fr).setPosition(position);

            //ImageView imageView = (ImageView)findViewById(R.id.image);

            //URI to Uri and done
            //Uri uri = android.net.Uri.parse(files[position].getAbsolutePath());
            //imageView.setImageURI(uri);
            return fr;

        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}