package com.mobile_apps.lifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView tv;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv = (TextView) ( findViewById(R.id.tv));

        i = getIntent();
        myReport(i.getStringExtra("log"));

        myReport("A2 - onCreate");
    }

    @Override
    protected void onStop() {
        super.onStop();
        myReport("A2 - onStop");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        myReport("A2 - onPostResume");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myReport("A2 - onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();

        String log = i.getStringExtra("log");
        if(log != null)
            myReport(log);

        i.removeExtra("log");

        myReport("A2 - onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        String log = i.getStringExtra("log");
        if(log != null)
            myReport(log);

        i.removeExtra("log");

        myReport("A2 - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        myReport("A2 - onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        String log = i.getStringExtra("log");
        if(log != null)
            myReport(log);

        i.removeExtra("log");

        myReport("A2 - onRestart");
    }

    public void onClear(View view) {
        tv.setText("");
        myReport("A2 - onClear");
    }

    public void onG2(View view) {
        //Intent i = new Intent(this, MainActivity.class);
        i.putExtra("log", tv.getText().toString());
        this.startActivity(i);
    }

    void myReport(String s){
        tv.setText(tv.getText().toString() + s + "\n");
    }
}
