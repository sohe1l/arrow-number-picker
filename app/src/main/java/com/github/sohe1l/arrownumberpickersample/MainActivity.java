package com.github.sohe1l.arrownumberpickersample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.sohe1l.arrownumberpicker.ArrowNumberPicker;

public class MainActivity extends AppCompatActivity implements ArrowNumberPicker.PickerChangeListener {

    private ArrowNumberPicker numPicker;
    private TextView tvVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numPicker = findViewById(R.id.number_picker_custom);
        int count = numPicker.getValue();

        numPicker.setValue(24);
        numPicker.setPickerChangedListener(this);

        tvVal = findViewById(R.id.tvCurrentVal);

    }

    public void updateNumber(View view){
        tvVal.setText(String.valueOf( numPicker.getValue() ));
    }

    @Override
    public void onPickerChanged(int newValue) {
        tvVal.setText(String.valueOf( numPicker.getValue() ));
    }
}
