# Kotlin Android notes for reference

All the important links, Important Pointers & Slides can be found in this notes.

Access the notes that is covered till date (07-feb-2024) [here](https://docs.google.com/document/d/12FOSc0OGAiPLIh-OhwdEYtzfMCsDSRYPynXrnYQq7Rk/edit)

### onSaveInstanceState

When an activity is rotated (configuration change happens) from potrait to landscape and vice-versa, the activity restarts. That is the reason, we see that the UI gets reset. Hence, in the score keeper app, the score is getting reset. 

How do we handle this ?. 
(A) With the help of onSaveInstanceState() concept. 

This onSaveInstanceState() method is going to save the values during the configuration change or when the activity is about to be destroyed. 

Explore more about onSaveInstanceState [here](https://developer.android.com/topic/libraries/architecture/saving-states)

### The UI Components in Android

- Button
- EditText / TextInputLayout & TextInputEditText - used to take input from the user (TextBox)
- RadioButtons (Used to let the user select an option from mutually exlusive option)
- CheckBoxes (these are again options where you can select multiple)
- Spinner (DropDown menu)
- Switch (Toggles between on and off states)
- Textview

[try this link](https://developer.android.com/develop/ui/views/layout/declaring-layout) to experiment on UI of android. 

Refer to the Material Design Components and How to use them in this [link](https://github.com/material-components/material-components-android/blob/master/docs/components/TextField.md)

Two Ways to display the items on the spinner
- By XML Code
- Kotlin Code

### Assignment
With the code below you are able to create a stunning design of a registration page. However, when the screen is rotated (configuration changed), you are scrolling the views from top to bottom. Please create a separate design that accommodates all these views properly on landscape orientation by creating a separate desgin for landscape screens. 

```xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
<androidx.appcompat.widget.LinearLayoutCompat
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <TextView
        android:rotation="-20"
        android:gravity="center"
        android:textSize="28sp"
        android:textColor="#00004A"
        android:text="Register"
        android:fontFamily="cursive"
        android:textStyle="bold"
        android:layout_width="match_parent"
        android:layout_height="60dp"/>
    <!--If you want to read the text from the user, you must be using EditText-->
    <com.google.android.material.textfield.TextInputLayout
        android:id="@+id/person_name"
        android:layout_margin="5dp"
        android:layout_width="match_parent"
        android:hint="Enter Your name"
        android:layout_height="75dp">

        <com.google.android.material.textfield.TextInputEditText
            android:layout_width="match_parent"
            android:layout_height="match_parent"/>

    </com.google.android.material.textfield.TextInputLayout>

    <com.google.android.material.textfield.TextInputLayout
        android:layout_margin="5dp"
        android:layout_width="match_parent"
        android:hint="Enter Your age"
        android:layout_height="75dp">

        <com.google.android.material.textfield.TextInputEditText
            android:layout_width="match_parent"
            android:inputType="number"
            android:layout_height="match_parent"/>

    </com.google.android.material.textfield.TextInputLayout>

    <RadioGroup
        android:orientation="horizontal"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <TextView
            android:textStyle="bold"
            android:layout_weight="1"
            android:gravity="center"
            android:layout_width="wrap_content"
            android:text="Gender"
            android:layout_height="match_parent"/>

        <RadioButton
            android:layout_weight="1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Male"
            />

        <RadioButton
            android:layout_weight="1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Female"
            />

    </RadioGroup>

    <LinearLayout
        android:orientation="horizontal"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <TextView
            android:layout_weight="1"
            android:textSize="16sp"
            android:textStyle="bold"
            android:gravity="center"
            android:text="Languages"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"/>

        <CheckBox
            android:text="English"
            android:layout_weight="1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"/>

        <CheckBox
            android:layout_weight="1"
            android:text="Hindi"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"/>

        <CheckBox
            android:layout_weight="1"
            android:text="Tamil"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"/>

    </LinearLayout>

    <androidx.appcompat.widget.AppCompatSpinner
        android:entries="@array/countires"
        android:layout_margin="5dp"
        android:layout_width="match_parent"
        android:layout_height="70dp"/>

    <androidx.appcompat.widget.SwitchCompat
        android:layout_margin="5dp"
        android:text="Open for Rotational Shift"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

    <Button
        android:layout_gravity="center"
        android:background="@drawable/button_shape"
        android:text="Submit"
        android:layout_margin="5dp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

    <TextView
        android:gravity="center"
        android:textSize="16sp"
        android:textColor="#0000ff"
        android:text="Contents here"
        android:textStyle="italic"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

</androidx.appcompat.widget.LinearLayoutCompat>
</ScrollView>
```
Note: Please do not use Scroll view in the design that you are going to do for landscape orientation.





