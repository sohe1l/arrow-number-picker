# Arrow Number Picker

Customizable android component for picking an integer.

<img src="screenshot.png">


## Installation

Make sure jcenter is in your project build settings and then simply add the following to the dependencies section of your app:

```groovy
    implementation 'com.github.sohe1l.arrownumberpicker:arrownumberpicker:0.1.2'
```

This project requires API level 16.

## Usage

Baisc Usage in layout:

```xml
    <com.github.sohe1l.arrownumberpicker.ArrowNumberPicker
        android:id="@+id/number_picker"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
     />
```

To get the selected value:

```java
    ArrowNumberPicker arrowNumberPicker = findViewById(R.id.number_picker);
    int count = numPicker.getValue();
```


To set the picker value dyanmically:

```java
    ArrowNumberPicker arrowNumberPicker = findViewById(R.id.number_picker);
    numPicker.setValue(24);
```

To set a callback listener for change event:

```java
    // on your activity
    // implement ArrowNumberPicker.PickerChangeListener 

    @Override
    public void onPickerChanged(int newValue) {
        // use newValue or numPicker.getValue()
    }
```


Customizable options:
```xml
    <com.github.sohe1l.arrownumberpicker.ArrowNumberPicker 
        xmlns:custom="http://schemas.android.com/apk/res-auto"
        android:id="@+id/number_picker_custom"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        custom:button_background_color="#575757"
        custom:button_border_color="#575757"
        custom:button_border_width="1dp"
        custom:button_padding="8dp"
        custom:button_text_color="#FFFFFF"
        custom:button_text_size="14sp"
        custom:button_width="100dp"
        custom:picker_background_color="#000000"
        custom:picker_text_color="#FAFAFA"
        custom:picker_text_size="16sp" />
```


## Support

Please [open an issue](https://github.com/sohe1l/arrow-mumber-picker/issues/new) for support.

## Contributing

Please contribute using [Github Flow](https://guides.github.com/introduction/flow/). Create a branch, add commits, and [open a pull request](https://github.com/sohe1l/arrow-mumber-picker/compare/).