package com.example.android.camera2basic;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayMessageActivity extends Activity {

    private int nPics;
    private long waitTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
    }


    @Override
    protected void onResume(){
        super.onResume();
        Intent intent = getIntent();
        nPics = intent.getIntExtra(getString(R.string.Settings_NPICS),0);
        waitTime = intent.getLongExtra(getString(R.string.Settings_WaitTime),0);
        TextView nPicView = (TextView)findViewById(R.id.SeriesNoPics);
        TextView waitView = (TextView)findViewById(R.id.WaitingTime);
        nPicView.setText(String.valueOf(nPics));
        waitView.setText(String.valueOf(waitTime));

    }

    @Override
    public void onBackPressed(){
        changeValue();
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
          super.onPause();
    }

    private void changeValue(){
        Intent intent = getIntent();
        Intent settingsData = new Intent();
        TextView nPicView = (TextView)findViewById(R.id.SeriesNoPics);
        TextView WaitTimeView = (TextView)findViewById(R.id.WaitingTime);
        nPics = Integer.parseInt(nPicView.getText().toString());
        waitTime = Integer.parseInt(WaitTimeView.getText().toString());
        settingsData.putExtra("NPICS", nPics);
        settingsData.putExtra("WAITT",waitTime);
        setResult(Activity.RESULT_OK, settingsData);
        finish();
    }
}
