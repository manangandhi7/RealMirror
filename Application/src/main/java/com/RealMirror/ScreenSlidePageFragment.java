package com.RealMirror;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by manan on 11/4/2015.
 */



public class ScreenSlidePageFragment extends Fragment {

    int position = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);
        ImageView imageView = (ImageView)(rootView.findViewById(R.id.image));
        Uri uri = android.net.Uri.parse(ScreenSlidePagerActivity.files[ScreenSlidePagerActivity.files.length - position - 1].getAbsolutePath());
        imageView.setImageURI(uri);

        return rootView;
    }

    public void setPosition(int p){
        position = p;
    }
}