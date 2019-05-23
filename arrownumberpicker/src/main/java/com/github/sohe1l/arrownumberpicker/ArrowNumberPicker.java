package com.github.sohe1l.arrownumberpicker;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.os.Debug;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ArrowNumberPicker extends FrameLayout {


    private TextView tvPicker;
    private TextView tvPlus;
    private TextView tvMinus;

    private int selectedValue = 0;

    private Context context;

    private void init(Context context, @Nullable AttributeSet attrs){
        this.context = context;
        LayoutInflater layoutInflater =  LayoutInflater.from(getContext());
        View view = layoutInflater.inflate(R.layout.arrow_number_picker, this);

        tvPicker = findViewById(R.id.tv_picker);
        tvPlus = findViewById(R.id.tv_plus);
        tvMinus = findViewById(R.id.tv_minus);

        setAttrs(attrs);
        setClickListeners();
    }

    private void setAttrs(@Nullable AttributeSet attrs){

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ArrowNumberPicker, 0, 0);
        setPickerAttr(a, tvPicker);
        setButtunAttr(a, tvPlus);
        setButtunAttr(a, tvMinus);
        a.recycle();
    }

    private void setPickerAttr(TypedArray a, TextView tv){
        Resources res = context.getResources();

        // Picker Colors
        int pickerTextColor = a.getColor(R.styleable.ArrowNumberPicker_picker_text_color, res.getColor(R.color.picker_text));
        int pickerBackgroundColor = a.getColor(R.styleable.ArrowNumberPicker_picker_background_color, res.getColor(R.color.picker_background));
        tv.setTextColor(pickerTextColor);
        tv.setBackgroundColor(pickerBackgroundColor);

        // Picker Dimens
        float pickerTextSize = a.getDimension(R.styleable.ArrowNumberPicker_picker_text_size, res.getDimension(R.dimen.picker_text_size));
        tv.setTextSize(pickerTextSize);
    }

    private void setButtunAttr(TypedArray a, TextView tv){
        Resources res = context.getResources();

        int buttonTextColor = a.getColor(R.styleable.ArrowNumberPicker_button_text_color, res.getColor(R.color.button_text));
        tv.setTextColor(buttonTextColor);

        int buttonPadding = a.getDimensionPixelSize(R.styleable.ArrowNumberPicker_button_padding, res.getDimensionPixelSize(R.dimen.btn_padding));
        int buttonWidth = a.getDimensionPixelSize(R.styleable.ArrowNumberPicker_button_width, res.getDimensionPixelSize(R.dimen.btn_width));
        float buttonTextSize = a.getDimension(R.styleable.ArrowNumberPicker_button_text_size, res.getDimension(R.dimen.btn_text_size));

        tv.setTextSize(buttonTextSize);
        tv.setPadding(buttonPadding, buttonPadding, buttonPadding, buttonPadding);

        ViewGroup.LayoutParams params = tv.getLayoutParams();
        params.width = buttonWidth;
        tv.setLayoutParams(params);

        // set button drawable attributes
        int buttonBorderColor = a.getColor(R.styleable.ArrowNumberPicker_button_border_color, res.getColor(R.color.button_border));
        int buttonBackgroundColor = a.getColor(R.styleable.ArrowNumberPicker_button_background_color, res.getColor(R.color.button_background));
        int buttonBorderWidth = a.getDimensionPixelSize(R.styleable.ArrowNumberPicker_button_border_width, res.getDimensionPixelSize(R.dimen.btn_border_width));

        GradientDrawable bg = (GradientDrawable)tv.getBackground();
        bg.setStroke(buttonBorderWidth, buttonBorderColor);
        bg.setColor(buttonBackgroundColor);
    }


    private void setClickListeners(){
        tvPlus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedValue++;
                updateCounter();
            }
        });

        tvMinus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedValue >0){
                    selectedValue--;
                    updateCounter();
                }
            }
        });
    }

    private void updateCounter(){
        tvPicker.setText(String.valueOf(selectedValue));
        if(listener != null){
            listener.onPickerChanged(selectedValue);
        }
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

    public int getValue(){
        return selectedValue;
    }

    public void setValue(int newValue){
        selectedValue = newValue;
        updateCounter();
    }



    // listener -->

    public interface PickerChangeListener {
        void onPickerChanged(int newValue);
    }

    private PickerChangeListener listener;

    public void setPickerChangedListener(PickerChangeListener l){
        listener = l;
    }
    // listener <--


}