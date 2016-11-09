package com.le.star;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/9.
 */
public class StarRatingView extends LinearLayout{
    private Drawable on,off,half;
    private boolean ratable;
    private float padding;
    private List<ImageView> list;

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
        list = new ArrayList<>();
        ImageView imageView;
        for(int i=0;i<5;i++){
            imageView = new ImageView(context);
            LinearLayout.LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
            if(i!=0&&i!=4) {
                layoutParams.setMargins((int) padding / 2, 0, (int) padding / 2, 0);
            }
            if(i==0){
                layoutParams.setMargins(0, 0, (int) padding / 2, 0);
            }
            if(i==4){
                layoutParams.setMargins((int) padding / 2, 0, 0, 0);
            }
            imageView.setLayoutParams(layoutParams);
            imageView.setImageDrawable(off);
            list.add(imageView);
            addView(list.get(i));
        }
        setOrientation(LinearLayout.HORIZONTAL);
    }

    public void setRate(int rate){
        removeAllViews();
        int count = rate/2;
        boolean isOdd;
        if(rate%2==0){
            isOdd = false;
        }else{
            isOdd = true;
        }
        for(int i=0;i<list.size();i++){
            if(i<count){
                list.get(i).setImageDrawable(on);
            }else{
                list.get(i).setImageDrawable(off);
            }
            if(isOdd&&i==count){
                list.get(i).setImageDrawable(half);
            }
            addView(list.get(i));
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
