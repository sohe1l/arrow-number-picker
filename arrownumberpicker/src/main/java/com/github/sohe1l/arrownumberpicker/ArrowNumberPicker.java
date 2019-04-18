package com.github.sohe1l.arrownumberpicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ArrowNumberPicker extends FrameLayout {


    private TextView tvNumber;
    private TextView tvPlus;
    private TextView tvMinus;

    private int count = 0;

    private Context context;

    private void init(Context context, @Nullable AttributeSet attrs){
        this.context = context;
        LayoutInflater layoutInflater =  LayoutInflater.from(getContext());
        View view = layoutInflater.inflate(R.layout.arrow_number_picker, this);

        tvNumber = findViewById(R.id.tv_number);
        tvPlus = findViewById(R.id.tv_plus);
        tvMinus = findViewById(R.id.tv_minus);

        TypedArray attrTypedArray = context.obtainStyledAttributes(attrs, R.styleable.ArrowNumberPicker, 0, 0);
        setAttrs(attrTypedArray);

        setClickListeners();
    }

    private void setAttrs(TypedArray a){
        float textSize = a.getDimension(R.styleable.ArrowNumberPicker_textSize, context.getResources().getDimension(R.dimen.default_font_size));
        a.recycle();
        tvNumber.setTextSize(textSize);

    }

    private void setClickListeners(){
        tvPlus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                count ++;
                updateCounter();
            }
        });

        tvMinus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count>0){
                    count --;
                    updateCounter();
                }
            }
        });
    }

    private void updateCounter(){
        tvNumber.setText(String.valueOf(count));
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
