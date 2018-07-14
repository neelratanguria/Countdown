package com.neelratan.countdown;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.util.logging.Logger.global;

public class MainActivity extends AppCompatActivity {
    int counter = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView) findViewById(R.id.textView);
        Button btnStart = (Button) findViewById(R.id.btnStart);
        textView.setText("10");
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Handler handler = new Handler();

                final Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(String.valueOf(counter));
                        if (counter>0) {
                            counter--;
                        }

                        handler.postDelayed(this, 1000);
                    }
                };
                    handler.post(runnable);
            }

        });

    }
}
