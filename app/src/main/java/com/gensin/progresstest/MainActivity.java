package com.gensin.progresstest;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xiaochen.progressroundbutton.AnimDownloadProgressButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout progress = findViewById(R.id.progress);
        FrameLayout progressBackground = findViewById(R.id.progress_background);
        TextView progressValueText = findViewById(R.id.progress_value);
        TextView progressBackgroundValue = findViewById(R.id.progress_background_value);
        AnimDownloadProgressButton button = findViewById(R.id.anim_btn);

        final int progressValue = 50;
        final int percent = 1 - progressValue;

        button.setMaxProgress(100);
        button.setProgress(progressValue);
        button.setCurrentText(String.valueOf(progressValue));
        button.setState(AnimDownloadProgressButton.DOWNLOADING);

        progressValueText.setX(progressBackgroundValue.getX());
        progressValueText.setY(progressBackgroundValue.getY());
        progressValueText.setText(String.valueOf(progressValue));

        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) progress.getLayoutParams();
        params.height = progressBackground.getHeight();
        params.width = progressBackground.getWidth() * percent;
        progress.setLayoutParams(params);

    }
}
