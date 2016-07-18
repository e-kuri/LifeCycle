package com.mobile_apps.lifecycle;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Intent i;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        myReport("A1 - onPostCreate");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) ( findViewById(R.id.tv));

        //Context context = getActivity

        i = new Intent(this, Main2Activity.class);

        myReport("A1 - onCreate");
    }

    public void onG2(View view) {
        //Intent nextAct = new Intent(this, Main2Activity.class);
        //nextAct.putExtra("log", tv.getText().toString());
        i.putExtra("log", tv.getText().toString());
        this.startActivity(i);
    }

    void myReport(String s){
        tv.setText(tv.getText().toString() + s + "\n");
    }


    @Override
    protected void onStop() {
        super.onStop();
        myReport("A1 - onStop");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        myReport("A1 - onPostResume");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myReport("A1 - onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();

        //i = getIntent();
        String log = i.getStringExtra("log");
        if(log != null)
            myReport(log);

        i.removeExtra("log");

        myReport("A1 - onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

       // i = getIntent();
        String log = i.getStringExtra("log");
        if(log != null)
            myReport(log);

        i.removeExtra("log");

        myReport("A1 - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        myReport("A1 - onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        //i = getIntent();
        String log = i.getStringExtra("log");
        if(log != null)
            myReport(log);

        i.removeExtra("log");

        myReport("A1 - onRestart");
    }

    public void onClear(View view) {
        tv.setText("");
        myReport("A1 - onClear");
    }
}
