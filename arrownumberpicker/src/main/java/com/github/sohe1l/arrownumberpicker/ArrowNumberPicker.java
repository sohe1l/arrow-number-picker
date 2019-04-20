package com.github.sohe1l.arrownumberpicker;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

public class ArrowNumberPicker extends FrameLayout {


    private TextView tvPicker;
    private TextView tvPlus;
    private TextView tvMinus;

    private int count = 0;

    private Context context;

    private void init(Context context, @Nullable AttributeSet attrs){
        this.context = context;
        LayoutInflater layoutInflater =  LayoutInflater.from(getContext());
        View view = layoutInflater.inflate(R.layout.arrow_number_picker, this);

        tvPicker = findViewById(R.id.tv_picker);
        tvPlus = findViewById(R.id.tv_plus);
        tvMinus = findViewById(R.id.tv_minus);

        TypedArray attrTypedArray = context.obtainStyledAttributes(attrs, R.styleable.ArrowNumberPicker, 0, 0);
        setAttrs(attrTypedArray);

        setClickListeners();
    }

    private void setAttrs(TypedArray a){
        Resources res = context.getResources();

        // Button Colors
        int buttonTextColor = a.getColor(R.styleable.ArrowNumberPicker_button_text_color, res.getColor(R.color.button_text));
        tvPlus.setTextColor(buttonTextColor);
        tvMinus.setTextColor(buttonTextColor);

        // Picker Colors
        int pickerTextColor = a.getColor(R.styleable.ArrowNumberPicker_picker_text_color, res.getColor(R.color.picker_text));
        int pickerBackgroundColor = a.getColor(R.styleable.ArrowNumberPicker_picker_background_color, res.getColor(R.color.picker_background));
        tvPicker.setTextColor(pickerTextColor);
        tvPicker.setBackgroundColor(pickerBackgroundColor);

        // Button Dimens
        int buttonWidth = a.getDimensionPixelSize(R.styleable.ArrowNumberPicker_button_width, res.getDimensionPixelSize(R.dimen.btn_width));
        float buttonTextSize = a.getDimension(R.styleable.ArrowNumberPicker_button_text_size, res.getDimension(R.dimen.btn_text_size));
        tvPlus.setWidth(buttonWidth);
        tvPlus.setTextSize(buttonTextSize);
        tvMinus.setWidth(buttonWidth);
        tvMinus.setTextSize(buttonTextSize);

        // Picker Dimens
        float pickerTextSize = a.getDimension(R.styleable.ArrowNumberPicker_picker_text_size, res.getDimension(R.dimen.picker_text_size));
        tvPicker.setTextSize(pickerTextSize);

        a.recycle();

        // set button drawable attributes
        int buttonBorderColor = a.getColor(R.styleable.ArrowNumberPicker_button_border_color, res.getColor(R.color.button_border));
        int buttonBackgroundColor = a.getColor(R.styleable.ArrowNumberPicker_button_background_color, res.getColor(R.color.button_background));
        int buttonBorderWidth = a.getDimensionPixelSize(R.styleable.ArrowNumberPicker_button_border_width, res.getDimensionPixelSize(R.dimen.btn_border_width));

        GradientDrawable plusBg = (GradientDrawable)tvPlus.getBackground();
        plusBg.setStroke(buttonBorderWidth, buttonBorderColor);
        plusBg.setColor(buttonBackgroundColor);

        GradientDrawable minusBg = (GradientDrawable)tvMinus.getBackground();
        minusBg.setStroke(buttonBorderWidth, buttonBorderColor);
        minusBg.setColor(buttonBackgroundColor);
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
        tvPicker.setText(String.valueOf(count));
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

    public int getCount(){
        return count;
    }

//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        canvas.drawColor(Color.RED);
//    }
}
