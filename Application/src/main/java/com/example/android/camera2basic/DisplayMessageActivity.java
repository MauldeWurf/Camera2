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
        TextView tview = (TextView)findViewById(R.id.SeriesNoPics);
        tview.setText(String.valueOf(nPics));

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
        TextView tview = (TextView)findViewById(R.id.SeriesNoPics);
        int nPics = Integer.parseInt(tview.getText().toString());
        settingsData.putExtra("NPICS", nPics);
        setResult(Activity.RESULT_OK, settingsData);
        finish();
    }
}
