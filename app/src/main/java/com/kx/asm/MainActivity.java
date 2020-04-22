package com.kx.asm;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show();
    }
    private void show(){
        System.out.println("show");
    }

    public void onResume() {
        SystemClock.sleep(3000);
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
