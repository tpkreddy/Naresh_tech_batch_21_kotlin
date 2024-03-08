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

# Intents in Android
Learn More about Intents [here](https://developer.android.com/guide/components/intents-filters)

Intents are messaging objects that we send to the system (android). Based on the operation you want to perform, your intent will be processed by the system (android)

Intents can primarily be used for three actions
- Start Activity
- Start Service
- Deliver a Broadcast

### Intents are two types
- Explicit Intent
- Implicit Intent

### Assignment
Create an App that takes in the Person name and age as inputs and when the button is pressed, you take the user to the next screen where he will be shown a random information about his personality based on the year he was born.

- 1980 to 1990
    - Hi Ramesh, You were born in 1982
    - Middle Aged, The person has more maturity, the person has great talents
- 1991 to 2000
    - Hi suresh, You were born in 1999
    - Young Person, The person is evolving in all aspects, the person is a great companion.
- 2000 to 2024
    - Hi Nitin, You were born in 2005
    - Too young to understand everything. Has a great opportunity to grow in every possible direction. Lot to explore is left. 

Push this project to github as a public repo. share the link to `pavankreddy.t@gmail.com`

Project deadline - 17th of Feb 2024


**To change the name of the project**

raw -> Values -> Strings.xml
Change the project name

### Common Intents (Implicit Intents)
Please refer this [link](https://developer.android.com/guide/components/intents-common)

Assignment: Work with other common intents other than camera.

### Constraint Layout
ConstraintLayout lets you create large, complex layouts with a flat view hierarchy—no nested view groups. It's similar to RelativeLayout in that all views are laid out according to relationships between sibling views and the parent layout, but it's more flexible than RelativeLayout and easier to use with Android Studio's Layout Editor.

[Read More](https://developer.android.com/develop/ui/views/layout/constraint-layout)about constraint layout here

**Activity Life cycle**
    As a user navigates through, out of, and back to your app, the Activity instances in your app transition through different states in their lifecycle. The Activity class provides a number of callbacks that let the activity know when a state changes or that the system is creating, stopping, or resuming an activity or destroying the process the activity resides in.

![lifecycle](/activity_lifecycle.png)

***onCreate()***
You must implement this callback, which fires when the system first creates the activity. On activity creation, the activity enters the Created state. In the onCreate() method, perform basic application startup logic that happens only once for the entire life of the activity.

***onStart()***
When the activity enters the Started state, the system invokes onStart(). This call makes the activity visible to the user as the app prepares for the activity to enter the foreground and become interactive. 

***onResume()***
When the activity enters the Resumed state, it comes to the foreground, and the system invokes the onResume() callback. This is the state in which the app interacts with the user. The app stays in this state until something happens to take focus away from the app, such as the device receiving a phone call, the user navigating to another activity, or the device screen turning off.

***onPause()***
The system calls this method as the first indication that the user is leaving your activity, though it does not always mean the activity is being destroyed. It indicates that the activity is no longer in the foreground, but it is still visible if the user is in multi-window mode.

***onStop()***
When your activity is no longer visible to the user, it enters the Stopped state, and the system invokes the onStop() callback. This can occur when a newly launched activity covers the entire screen. The system also calls onStop() when the activity finishes running and is about to be terminated.

***onDestroy()*** 
is called before the activity is destroyed. The system invokes this callback for one of two reasons:

The activity is finishing, due to the user completely dismissing the activity or due to finish() being called on the activity.
The system is temporarily destroying the activity due to a configuration change, such as device rotation or entering multi-window mode.

[Refer to this documentation](https://developer.android.com/guide/components/activities/activity-lifecycle)


**Activity Stack (TASK)**

**List View Android**
Displays a vertically-scrollable collection of views, where each view is positioned immediatelybelow the previous view in the list. For a more modern, flexible, and performant approach to displaying lists, use RecyclerView

[Refer here](https://developer.android.com/reference/android/widget/ListView)

**RecyclerView**
[PPT here](https://docs.google.com/presentation/d/1nFJqH0OSSZmjaycRzEGE6vvsm6jlxghQyoO15KKbkwc/edit#slide=id.gf0dd569a47_0_123)

[Official Documentation](https://developer.android.com/develop/ui/views/layout/recyclerview)

### Assignment - RecyclerView
- Create an app that displays the favorite movies (20 in number) in an alphabetical order. The items on recyclerview should show the movie poster & the movie name. 
- When the user taps on the recyclerview item, bring the user to details screen that should show the following items related to that movie
    - Movie Poster
    - Movie Name
    - Movie Actors (with images if possible in a horizontally scrollable view)
    - Synopsis of the movie (simple paragraph)
- Make sure, you are designing for dark mode theme as well. 
- Make the app available in multiple languages.

## Async Task in android for Networking

*AysncTask is deprecated in api level 30*
[Refer to AsyncTask here](https://docs.google.com/presentation/d/1HVNyrppFuOv-6MgUCIQ-SZyZxLcK4DVKtSyI82T5R6A/edit?resourcekey=0-xuLPU518hMsSLE9bJaJ65Q#slide=id.g116d7d9d49_3_13)

When you start your app, the app runs on a thread called "main thread" or "UI Thread".

***Two Important rules while you work with Threads***
*Do not block the UI thread*
- Complete all work in less than 16 ms for each screen
- Run slow non-UI work on a non-UI thread
*Do not access the Android UI toolkit from outside 
the UI thread* 
- Do UI work only on the UI thread


Refer to all the publicly available list of Libraries that we can use for our projects [here](https://github.com/public-apis/public-apis).

**JSON - Java script object notation**

JSON stands for JavaScript Object Notation. It's a lightweight, human-readable format used for exchanging data between different systems and programming languages. Here's a breakdown of its key aspects:

Usages:

Data Interchange: JSON is widely used for exchanging data between web servers and web applications. 
- It facilitates smooth communication by providing a structured way to send and receive information.
API Communication: Many APIs (Application Programming Interfaces) use JSON to define the format of data they accept or return. This allows developers to easily integrate these APIs into their applications.
Configuration Files: JSON can be used to store configuration settings for applications or websites. This makes it easier to manage and modify these settings without needing to change the code itself.
Data Storage: JSON is sometimes used for storing data in files or databases, although for large datasets, other formats might be more efficient.
Benefits:

Simplicity: JSON is easy to understand and write, even for people with no programming experience.
Lightweight: Compared to other data formats like XML, JSON is smaller in size, making it faster to transmit and process.
Language Independence: JSON is not tied to any specific programming language, allowing different programming environments to work with it seamlessly.

***Important Points to remember***
- {} -> JSONObject
- [] -> JSONArray
- "Key":"Value" -> You can get String value through the key
- "Key":120 -> you can get int value through the key

Get huge response through this URL
https://www.googleapis.com/books/v1/volumes?q=quilting

### Assignment

Design a google books app with the following guidelines
- Check if the internet connection is active
- If not active, show a Snackbar message to the user.
- If active && connected, Do networking using AsyncTask and fetch the json data for android books from the link
https://www.googleapis.com/books/v1/volumes?q=quilting
- Show the book details as follows
    - title
    - authors
    - description
    - horizontal divider 
- You can show the aforementioned details on text view
- do not forget to implement Progress bar just like the way we did it for Jokes app. 

**Advanced Stuff you can do in addition to the Assignment**
- Display the data on RecyclerView instead of TextView.
- Load the book thumbnail images on the recyclerview items using Glide or Picasso libraries. 

**Important Note:** With the same model of the assignment above, you can implement several applications
- Recipe book
- News App
- Weather app
- COVID app
- etc.,

***How to display images using Glide?***
[Glide Link](https://bumptech.github.io/glide/#:~:text=Glide%20is%20a%20fast%20and,%2C%20images%2C%20and%20animated%20GIFs.)

### Volley Networking library
[documentation](https://google.github.io/volley/)

### Gson Library
[documentation](https://github.com/google/gson)


## Networking with Retrofit
[Official doc](https://square.github.io/retrofit/)

[For Fake Rest API visit](https://jsonplaceholder.typicode.com)
For Get Request -> https://jsonplaceholder.typicode.com/posts/1
For Post Request -> https://jsonplaceholder.typicode.com/posts
So the base url could be -> https://jsonplaceholder.typicode.com/

REST API -> Representational state transfer Application Programming Interface.
- This is a web service
- When a client (Mobile Application/ Web application) interacts with it, it requests the resources from a server, and the server gives those resources (based on the authenticity of the request). 
- These services are in place to make the communication between apps of various domains possible. 
- In A REST, there are a few standard methods that we use
    - GET
    - POST
    - PUT
    - DELETe
    - UPDATE
- Important advantage of a REST service is that they consume a very less bandwidth due to the efficient use of JSON data exchange. 

***Assignment***
This json palce holder can be used to learn how to send various kinds of request, however, this also helps us to work with various other libraries (volley, asyncTask etc.). Try sending a request through volly and async Task.

### Fragments in android
A Fragment represents a reusable portion of your app's UI. A fragment defines and manages its own layout, has its own lifecycle, and can handle its own input events. Fragments can't live on their own. **They must be hosted by an activity or another fragment**. The fragment’s view hierarchy becomes part of, or attaches to, the host’s view hierarchy.

[How to create a fragment in android](https://developer.android.com/guide/fragments/create)

### Assignment
Create another fragment on "Fragments in Android" application. That displays data on Recyclerview.

### Tab Navigation in Android
Tab Navigation is also called as lateral navigation in android. Where there will be multiple fragments that gets loaded on a single view pager (that actually acts like a container). On top of the viewpager to transact between the fragments, the user needs to swipe through the screens. When we swipe the existing screen from right to left, we arrive at new screen. If we swipe from left to right, we arrive at the previous screen. 

[Link here](https://developer.android.com/guide/navigation/navigation-swipe-view)








