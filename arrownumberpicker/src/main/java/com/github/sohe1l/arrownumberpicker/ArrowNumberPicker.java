package com.github.sohe1l.arrownumberpicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ArrowNumberPicker extends FrameLayout {



    private void init(@Nullable AttributeSet attrs){
        LayoutInflater layoutInflater =  LayoutInflater.from(getContext());
        layoutInflater.inflate(R.layout.arrow_number_picker, this);
    }


    public ArrowNumberPicker(Context context) {
        super(context);
        init(null);
    }


    public ArrowNumberPicker(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }


    public ArrowNumberPicker(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        canvas.drawColor(Color.RED);
//    }
}
