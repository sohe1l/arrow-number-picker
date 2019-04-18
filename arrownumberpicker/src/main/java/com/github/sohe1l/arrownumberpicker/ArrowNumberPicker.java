package com.github.sohe1l.arrownumberpicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Dimension;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ArrowNumberPicker extends FrameLayout {



    private void init(Context context, @Nullable AttributeSet attrs){
        LayoutInflater layoutInflater =  LayoutInflater.from(getContext());
        View view = layoutInflater.inflate(R.layout.arrow_number_picker, this);



        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ArrowNumberPicker, 0, 0);
        float textSize = a.getDimension(R.styleable.ArrowNumberPicker_textSize, context.getResources().getDimension(R.dimen.default_font_size));
        a.recycle();


        TextView tvPicker = findViewById(R.id.picker_text_view);
        tvPicker.setTextSize(textSize);

    }


    public ArrowNumberPicker(Context context) {
        super(context);
        init(context, null);
    }


    public ArrowNumberPicker(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }


    public ArrowNumberPicker(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);





    }

//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        canvas.drawColor(Color.RED);
//    }
}
