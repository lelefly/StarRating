package com.le.star;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final StarRatingView srv = (StarRatingView) findViewById(R.id.srv);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                srv.setRate(count);
            }
        });
        final TextView tv = (TextView) findViewById(R.id.tv);
        StarRatingView srv_ratable = (StarRatingView) findViewById(R.id.srv_ratable);
        srv_ratable.setOnRateChangeListener(new StarRatingView.OnRateChangeListener() {
            @Override
            public void onRateChange(int rate) {
                tv.setText(rate+"分");
            }
        });
    }

}
