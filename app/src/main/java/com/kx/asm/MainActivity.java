package com.kx.asm;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show();
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(" onClick ");
            }
        });
    }

    private void show() {
        System.out.println("show");
    }

    public void onResume() {
        SystemClock.sleep(500);
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
