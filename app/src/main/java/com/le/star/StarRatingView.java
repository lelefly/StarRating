package com.le.star;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2016/11/9.
 */
public class StarRatingView extends LinearLayout{
    private Drawable on,off,half;
    private boolean ratable;
    private float padding;

    public StarRatingView(Context context) {
        super(context);
    }

    public StarRatingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.StarRatingView);
        on = array.getDrawable(R.styleable.StarRatingView_stat_on);
        off = array.getDrawable(R.styleable.StarRatingView_stat_off);
        half = array.getDrawable(R.styleable.StarRatingView_stat_half);
        ratable = array.getBoolean(R.styleable.StarRatingView_ratable, false);
        padding = array.getDimension(R.styleable.StarRatingView_star_padding, on.getIntrinsicWidth() / 3);

        ImageView imageView1 = new ImageView(context);
        imageView1.setImageDrawable(on);
        ImageView imageView2 = new ImageView(context);
        imageView2.setImageDrawable(off);
        ImageView imageView3 = new ImageView(context);
        imageView3.setImageDrawable(half);
        setOrientation(LinearLayout.VERTICAL);
        addView(imageView1);
        addView(imageView2);
        addView(imageView3);

        Log.i("testlog",ratable+"---"+padding);
    }
}
