package com.gensin.progresstest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;

/**
 * Created on 02/07/2018.
 */
public class TextProgressbar extends android.support.v7.widget.AppCompatTextView {

    private int progress;
    @ColorInt int color1;
    @ColorInt int color2;

    public TextProgressbar(Context context) {
        super(context);
    }

    public TextProgressbar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TextProgressbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.save();
        setTextColor(color1);
        setBackgroundColor(color2);
        canvas.clipRect(new Rect(0, 0, (int)(getWidth() * calculatePercent(progress)), getHeight()));
        super.draw(canvas);
        canvas.restore();

        canvas.save();
        setTextColor(color2);
        setBackgroundColor(color1);
        canvas.clipRect(new Rect((int)(getWidth() * calculatePercent(progress)), 0, getWidth(), getHeight()));
        super.draw(canvas);
        canvas.restore();
    }

    public synchronized void setProgress(int progress) {
        this.progress = progress;
        drawableStateChanged();
    }

    public synchronized void setProgressColor(@ColorInt int progressColor) {
        this.color1 = progressColor;
        drawableStateChanged();
    }

    public synchronized void setBackgroundColor(@ColorInt int backgroundColor) {
        this.color2 = backgroundColor;
        drawableStateChanged();
    }

    private float calculatePercent(int progress) {
        return progress/100f;
    }
}
