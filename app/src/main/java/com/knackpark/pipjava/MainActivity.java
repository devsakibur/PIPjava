package com.knackpark.pipjava;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PictureInPictureParams;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Rational;
import android.view.Display;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Display d = getWindowManager().getDefaultDisplay();
                Point p = new Point();

                d.getSize(p);

                int width = p.x;
                int height = p.y;


                Rational ratio = new Rational(width , height);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    PictureInPictureParams.Builder pipBuilder = new PictureInPictureParams.Builder();
                    pipBuilder.setAspectRatio(ratio).build();
                    enterPictureInPictureMode(pipBuilder.build());
                }



            }
        });

    }
}