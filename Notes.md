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

### Navigation Components Android
This helps us build complex Navigations in a simple way
Navigation component is a part of Android Jetpack and it has basic building blocks
- Navigation Graph - you will have a graph that has two other components
    - Destinations (typically the fragment files that you want to display to the users)
    - Actions (they specify for what of kind of interactions from the user, what kinds of destinations to show)
- Navigation Controller
    - This controls the whole navigation process
- Navigation Host
    - Is typically an activity that hosts all these processes. 

[Offical Documentation link](https://developer.android.com/guide/navigation)

[Youtube video tutorial](https://www.youtube.com/watch?v=NqpyCKlYLVU&t=42s)

[Make sure you complete this codelab](https://developer.android.com/codelabs/android-navigation#0)

### Broadcast Receivers in Android
[refer](https://developer.android.com/develop/background-work/background-tasks/broadcasts)

[concepts notes](https://google-developer-training.github.io/android-developer-phone-sms-course/Lesson%202/2_p_2_sending_sms_messages.html)

[Implicit Broadcast Exceptions](https://developer.android.com/develop/background-work/background-tasks/broadcasts/broadcast-exceptions#:~:text=As%20part%20of%20the%20Android,are%20exempted%20from%20these%20limitations.)

### Custom broadcasts
- General/ Regular Broadcasts
    - sendBroadcast(...)
- Local Broadcasts
    - LocalBroadcastManager.sendBroadcast(...)
- Priority Broadcasts
    - sendOrderedBroadcasts(...)

### SQL - Structured Query Language
- SQLite -> is a light weight database designed for light weight applications.
- Typically, SQLite is a file based database.
- You can perform basic SQL operations for the relational data you have on SQLite

**Basic SQL CRUD Operations**
C - Create
R - Read
U - Update
D - Delete

You can try these Queries and get output immediately on [this website](https://sqliteonline.com/)

**Create Query**
- Used to create a table (scheme) to store relational data.
```SQL
create TABLE person(person_id integer PRIMARY KEY AUTOINCREMENT, person_name text, person_age integer);
```

**Insert Query**
```SQL
insert into person(person_name, person_age) VALUES ("Pavan", 18), ("Swetha", 17), ("Kumar", 19);
```

**Read values**
```SQL
select * from person;
```

- Where clause can be used
```SQL
select * from person where person_age>17;
```

- ORDER BY
```SQL
select * from person where person_age>17 ORDER BY person_name ASC;
```

**Delete**

```SQL
DELETE from person where person_age > 18;
```

**Update**
```SQL
update person set person_name = "Pavan Kumar" where person_id = 1;
```

### Assignment
- Write Code to update the database table row 
- Write code to delete a certain row
- use where clause on selection query to display sorted results.

### Content Provider
[Official Doc Link](https://developer.android.com/guide/topics/providers/content-provider-basics#:~:text=A%20content%20provider%20manages%20access,using%20a%20provider%20client%20object.)

![See the image here](/hello.png)

### Exercise
Try this app at your end along with inserting of data into database.

### Assignment
Try to read contacts app database
[refer to link](https://developer.android.com/training/contacts-provider/retrieve-names)

### Notifications in Android
[refer to the official documentation](https://developer.android.com/develop/ui/views/notifications)

[Pending Intent](https://developer.android.com/privacy-and-security/risks/pending-intent)
PendingIntent can be created using three ways

PendingIntent.getActivity(...) - if you want to open an activity when the pending intent object is in force.
PendingIntent.getBroadcast(...) - if you want to send a broadcast when the pending intent object is in force.
PendingIntent.getService(...) - if you want to start a serive when the pending intent object is in force.
 
### Job Scheduler in android
- Intelligent scheduling algorithm.
- It works based on conditions rather than on time. 
- Introduced from API 21+ (Lollipop)
- There is no backwards compatability for this library - Meaning we cannot run the apps that uses jobscheduler on devices below android 21
[Official Docs](https://developer.android.com/reference/android/app/job/JobScheduler)

- JobService
    - Is a service class where we perform the task using "onStartJob(...)"
    - stop a running task using "onStopJob(...)"
    - These two methods run on Main Thread
    - if there is any task that may consume more time for execution, you need off load the work to a worker thread from onStartJob(...)
- JobInfo - Builder pattern to set the conditions for the task.
- JobScheduler - Schedule and cancel tasks, launch service.

[PPT Link](https://docs.google.com/presentation/d/1UILCEnzR1vurX0XaFV71Ke_yyIhEJ9--iRzwVpYKLwc/edit?resourcekey=0-RTKA4Q5ubz5BcdHZ6gRt-Q#slide=id.g18e75634d0_0_255)

**Small Assignment**
- Do network operations on a separate thread and use jobscheduler with two conditions. 
- NETWORK 
- Charging.

### Work Manager
[Official Docs](https://developer.android.com/topic/libraries/architecture/workmanager)
- Is more intelligent than JobScheduler becasue it works for three kinds of tasks
    - Immediate
    - Scheduled
    - Deferable


### MVVM
- MVVM - Stands for Model, View, ViewModel
- This is an architectural Pattern like your MVC (Model View Controller)
- We have been using MVC

**MVC (Model View Controller)**
In MVC the App is divided into three interconnected components
- Model : Represents the Data and also the business logic of the application
- View : Presents the UI and interacts with the user
- Controller : Acts as an intermediary between Model and View. Handling the User Inputs and updates the model or view accordingly. 

**Example in Android**
A Simple Android app for displaying a list of Tasks.
- Model : Data to show the list of tasks (Data & Business Logic)
- View : RecyclerView
- Controller : Adapter (you actullay populate data that is given by Model on the View, You respond to the clicks happening on view with the help of Model)

**MVVM**
MVVM seperates the UI components and Business Logic. Introduces ViewModel, which acts as a mediator between the view and the model. 
Model Interacts with ViewModel & Your ViewModel interacts with the view. 

**Example in Android**
A Simple Android app for displaying a list of Tasks.
- Model : Data to show 
- View : RecyclerView
- ViewModel : 
    - Prepares data to show, Holds UI related logic.
    - It Observes changes in the model and updates the view Accordingly

Differences
- DataBinding
- Responsibiltiy Division
- Testability 

### ViewBinding Library 
View binding is a feature that makes it easier to write code that interacts with views. Once view binding is enabled in a module, it generates a binding class for each XML layout file present in that module. An instance of a binding class contains direct references to all views that have an ID in the corresponding layout.

In most cases, view binding replaces findViewById

[Official Document Link](https://developer.android.com/topic/libraries/view-binding)

- We can avoid a lot of boilerplate code (repetitive code). However it is not easy to eliminate all the boilerplate code that you have. 

### View Model in Android
The ViewModel class is a business logic or screen level state holder. It exposes state to the UI and encapsulates related business logic. Its principal advantage is that it caches state and persists it through configuration changes. This means that your UI doesn’t have to fetch data again when navigating between activities, or following configuration changes, such as when rotating the screen.

[Official Documentation Link](https://developer.android.com/topic/libraries/architecture/viewmodel/viewmodel-apis)

### LiveData in Android
LiveData is an observable data holder class. Unlike a regular observable, LiveData is lifecycle-aware, meaning it respects the lifecycle of other app components, such as activities, fragments, or services. This awareness ensures LiveData only updates app component observers that are in an active lifecycle state.

LiveData considers an observer, which is represented by the Observer class, to be in an active state if its lifecycle is in the STARTED or RESUMED state. LiveData only notifies active observers about updates. Inactive observers registered to watch LiveData objects aren't notified about changes.

[Official Documentation Link](https://developer.android.com/topic/libraries/architecture/livedata#:~:text=LiveData%20notifies%20Observer%20objects%20when,No%20memory%20leaks)

### Room Database
- Room is a part of Android JetPack components.
- It is built based on ORM (Object Relational Mapping)
- This feature (ORM) reduces the effort to write lengthy SQL queries to perfrom CRUD operations on SQL.
- [Official Doc](https://developer.android.com/training/data-storage/room#kts)

**Basic components of Room Database are as listed below**
- Entity
    - An Entity is a dataclass that represents a table
        - The class name - becomes the table name
        - the members of the class (variables) - become the coloumn names
    - You can create as many entities based on the number of tables you want to create.
- DAO (Database access Object)
    - Its an interface, that converts the abstract methods to queries based on the annotations you give.
    - Based on the operations you want to perform, you will be creating the number of abstract methods inside a DAO.
- RoomDatabase
    - This class, initializes the database and gives us the power to execute database operations.

**Step 1:** Add the dependencies
build.gradle (app/module), add the dependencies.

```Kotlin
    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)
```

**Step 2:** Develop the activity_main.xml code.
```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <EditText
        android:id="@+id/person_name"
        android:layout_width="0dp"
        android:layout_height="70dp"
        android:layout_marginStart="8dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="8dp"
        android:ems="10"
        android:hint="Enter Your Name"
        android:inputType="text"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <EditText
        android:id="@+id/person_age"
        android:layout_width="0dp"
        android:layout_height="70dp"
        android:layout_marginStart="8dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="8dp"
        android:ems="10"
        android:hint="Enter your Age"
        android:inputType="number"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/person_name" />

    <Button
        android:id="@+id/save_btn"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="Save"
        app:layout_constraintEnd_toStartOf="@+id/load_btn"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/person_age" />

    <Button
        android:id="@+id/load_btn"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="Load"
        app:layout_constraintBaseline_toBaselineOf="@+id/save_btn"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toEndOf="@+id/save_btn" />

    <TextView
        android:id="@+id/result"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="20sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/save_btn" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

**Step 3:** Enable ViewBinding Library

**Step 4:** Create a Entity for Person Table
```kotlin
    package com.nareshittechnologies.roomdatabase

    import androidx.room.ColumnInfo
    import androidx.room.Entity
    import androidx.room.PrimaryKey

    @Entity(tableName = "person")
    class PersonTable(person_name: String?, person_age: Int) {
        @PrimaryKey(autoGenerate = true)
        val person_id: Int = 0
        @ColumnInfo(name = "personname")
        var person_name: String?=person_name
        var person_age: Int = person_age

    }
```

**Step 5:** Implement Database Access Object Interface
```kotlin
    package com.nareshittechnologies.roomdatabase

    import androidx.room.Dao
    import androidx.room.Insert
    import androidx.room.Query
    import androidx.room.Update

    @Dao
    interface PersonDAO {

        @Insert
        fun insertData(p:PersonTable):Unit

        @Query("select * from person")
        fun getAll():List<PersonTable>

        @Update
        fun updateData(p:PersonTable):Unit
    }
```
**Step 6:** Create RoomDatabase abstract class.
```kotlin
    package com.nareshittechnologies.roomdatabase
    import androidx.room.Database
    import androidx.room.RoomDatabase

    @Database(entities = [PersonTable::class], version = 1)
    abstract class PersonDatabase: RoomDatabase() {
        abstract fun personDao():PersonDAO
    }
```

**Step 7:** Implement the save and load actions on the Database
```Kotlin
    package com.nareshittechnologies.roomdatabase

    import android.os.Bundle
    import androidx.activity.enableEdgeToEdge
    import androidx.appcompat.app.AppCompatActivity
    import androidx.core.view.ViewCompat
    import androidx.core.view.WindowInsetsCompat
    import androidx.room.Room
    import com.google.android.material.snackbar.Snackbar
    import com.nareshittechnologies.roomdatabase.databinding.ActivityMainBinding

    class MainActivity : AppCompatActivity() {
    lateinit var activityMainBinding:ActivityMainBinding
    lateinit var room:PersonDatabase

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
            val v = activityMainBinding.root
            setContentView(v)

            // Initializing the Room database object
            room = Room.databaseBuilder(applicationContext,PersonDatabase::class.java,"pavan.db")
                .allowMainThreadQueries()
                .build()

            activityMainBinding.saveBtn.setOnClickListener {
                // Save the data to the database
                val name:String = activityMainBinding.personName.text.toString()
                val age:Int = activityMainBinding.personAge.text.toString().toInt()
                // Prepare the dataclass object
                val p:PersonTable = PersonTable(name,age)

                room.personDao().insertData(p)

                Snackbar.make(it,"Success",Snackbar.LENGTH_LONG).show()
            }

            activityMainBinding.loadBtn.setOnClickListener {
                // load the data from the database
                val persons = room.personDao().getAll()
                activityMainBinding.result.text = ""
                for(i in persons){
                    activityMainBinding.result.append("${i.person_id} ${i.person_name} ${i.person_age}\n")
                }
            }
        }
    }
```

### Firebase
Firebase is a google cloud service offering a wide range of features such as build, Monitor and scale up your app. Some popular features include

- Firebase real time databases
- Firebase Storage
- Firebase Authentication
    - Google Signin
    - Linkedin Sign in
    - Github sign in
    - Phone number authentication
- ML tool kit
- Crashlytics
- Remote Configuration
- Hosting...
[Link](https://firebase.google.com/) to find out the documentation.

Set up an app in firebase following [this](https://firebase.google.com/docs/android/setup) documentation. 
find all the firebase dependencies [here](https://firebase.google.com/docs/android/android-play-services).

Click [here](https://firebase.google.com/docs/database/android/start) for Firebase Real Time Database

**Assignment:** Read about NoSQL databases

**Assignment** 
Display the data from firebase in recyclerview (you need not to show the id). Display two buttons on each item of the Recyclerview (update and delete). When Update button is pressed, present a new form to the users where they can update name and age. 

### CameraX Library
If you want to work with camera, you have mainly three options
- Camerax (Google Recommends to  use this)
- Camera2
- Camera (Deprecated)

- Camerax reduces the efforts to write device specific codes to use camera
- Camerax is a part of android's Jetpack components - Built to help make camera based app development easier. 
- Camerax is backwards compatible till android 5.0 (Api level 21)

[Official documentation](https://developer.android.com/media/camera/camerax)

- Camerax is lifecycle aware.

### Coroutines

co - Cooperative
routine - Function

What are coroutines ?
- If we have multiple long running tasks, you create multiple threads for each one of them. When there are multiple background threads, the system may run **Out Of Memory**. We can create a single background thread and create multiple coroutines to perform the multiple background operations. By Using memory that is required for running one single thread, we can handle multiple background tasks.
1. Light-Weight threads
2. Like Threads, coroutines can run in parllel, wait for each other and communicate with each other.
3. coroutines!=Thread
4. Coroutines are very cheap (in terms of memory). 
5. You can create thousands of coroutines without any memory issues. 

### What are threads ?

- Threads are used to execute concurrent tasks, allowing different parts of the program to run independently.
- Class that can be used for threads is `Thread`
- Threads allow for parallelism
- Threads also help to do asynchronous programming. 

#### Simple Program

```Kotlin
package com.nareshittechnologies.co_routines

import kotlin.concurrent.thread

fun main(){
    println("Main Program starts: ${Thread.currentThread().name}")

    thread {
        println("This line is running on:${Thread.currentThread().name}")
        // Lets fake that this thread is doing some work
        Thread.sleep(1000)
        println("This line is running on:${Thread.currentThread().name}")
    }

    println("Main Program Ends: ${Thread.currentThread().name}")
}
```

Note: Threads run in parallel. The program is not finished until your thread finishes its job.

#### Coroutine example

```kotlin
package com.nareshittechnologies.co_routines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

fun main(){
    println("Main Program starts: ${Thread.currentThread().name}")

    GlobalScope.launch {
        println("This line is running on: ${Thread.currentThread().name}")
        Thread.sleep(1000)
        println("This line is running on: ${Thread.currentThread().name}")
    }

    GlobalScope.launch {
        println("This line2 is running on: ${Thread.currentThread().name}")
        Thread.sleep(1000)
        println("This line2 is running on: ${Thread.currentThread().name}")
    }

    Thread.sleep(3000)

    println("Main Program Ends: ${Thread.currentThread().name}")
}
```

**delay() vs Thread.sleep()**

Thread.sleep(1000) -> blocks the thread for 1 second. Now, the thread gets lazy. 

delay(1000) -> Only suspends the coroutine for 1 second. This is not going to block the thread at all.Hence, Other coroutines can still run while the current coroutine is suspended. 

```kotlin
package com.nareshittechnologies.co_routines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

fun main(){
    println("Main Program starts: ${Thread.currentThread().name}")

    GlobalScope.launch {
        println("This line is running on: ${Thread.currentThread().name}")
        delay(1000)
        println("This line is running on: ${Thread.currentThread().name}")
    }

    GlobalScope.launch {
        println("This line2 is running on: ${Thread.currentThread().name}")
        delay(1000)
        println("This line2 is running on: ${Thread.currentThread().name}")
    }

    Thread.sleep(3000)

    println("Main Program Ends: ${Thread.currentThread().name}")
}
```

**Suspend** Modifier
- A Function with `suspend` modifier is known as suspending function. 
- A Suspending function can only be called from a coroutine context or from another suspending function.
- They cannot be called from outside a coroutine context. 
- `delay()` is a suspending function

**Now, you want to block the main thread using a coroutine**
```kotlin
runBlocking {// this creates a coroutine that blocks the thread on which it is running
        delay(3000)
    }
```

GlobalScope.launch -> This is a non blocking in nature
runBlocking -> Blocks the thread in which it operates. 

**Lets create a suspending function**
```kotlin
package com.nareshittechnologies.co_routines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main() = runBlocking {
    println("Main Starts: ${Thread.currentThread().name}")
    GlobalScope.launch {
        println("Thread runs on: ${Thread.currentThread().name}")
        delay(1000)
        println("Thread completed on: ${Thread.currentThread().name}")
        // This statement may run on another thread also.
    }
    
    GlobalScope.launch {
        println("Thread runs on: ${Thread.currentThread().name}")
        delay(1000)
        println("Thread completed on: ${Thread.currentThread().name}")
        // This statement may run on another thread also.
    }

    delayForSomeTime(2000)

    println("Main Completes: ${Thread.currentThread().name}")
}

suspend fun delayForSomeTime(i: Long) {
    delay(i)
}
```

#### Coroutine Builders
Functions that are used to create coroutines are called coroutine builders.

**Most Important functions to create a coroutine**

1. launch
    - GlobalScope.launch{} - Creates a coroutine at global (app) level which can survive the entire life cycle of an app.
    - launch{} - Creates a coroutine in local scope. Meaning, the coroutine created through this scope gets destroyed with the activity. 
    - This coroutine never blocks the thread in which it is running. 
2. async
    - GlobalScope.async{} - Creates a coroutine at a global scope (app level). This survives the entire life cycle of an app. 
    - async{} - creates a coroutine at a local scope.
    - This coroutine never blocks the thread in which it is running. 
3. runBlocking
    - Blocks the thread in which it is running. 

```Kotlin
GlobalScope.launch{
    // file download
    // Play Music
}
```

```Kotlin
launch{ //recommended
    // Some data consumption
    // Login etc.
}
```

```kotlin
package com.nareshittechnologies.co_routines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main() {
    Thread{

    }
    runBlocking {
        println("Main Starts: ${Thread.currentThread().name}")
        /*GlobalScope.launch {
            println("Thread runs on: ${Thread.currentThread().name}")
            delay(1000)
            println("Thread completed on: ${Thread.currentThread().name}")
            // This statement may run on another thread also.
        }*/

        launch {
            println("Thread runs on: ${Thread.currentThread().name}")
            delay(1000)
            println("Thread completed on: ${Thread.currentThread().name}")
            // This statement may run on another thread also.
        }

        delayForSomeTime(2000)

        println("Main Completes: ${Thread.currentThread().name}")
    }
}

suspend fun delayForSomeTime(i: Long) {
    delay(i)
}
```
**Note: launch corotuine builder launches the coroutine in the scope of the parent coroutine**

**launch** coroutine Builder (Fire and forget)
- Launches a new coroutine without blocking the current thread
    - Inherits the thread & coroutine scope of the immediate parent coroutine.
- Returns a reference to the `Job` Object
- Using this job object, we can cancel the coroutine or wait for the coroutine to finish
- It works on "Fire and forget" approach meaning that upon the launch, a new coroutine will be created, and it will not return anything to its caler. the started corotuine will keep working in the background. 

#### Async Coroutine builder

```kotlin
package com.nareshittechnologies.co_routines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main() {
    runBlocking {
        println("Main Starts: ${Thread.currentThread().name}")
        /*GlobalScope.launch {
            println("Thread runs on: ${Thread.currentThread().name}")
            delay(1000)
            println("Thread completed on: ${Thread.currentThread().name}")
            // This statement may run on another thread also.
        }*/

        val job = async {
            println("Thread runs on: ${Thread.currentThread().name}")
            delay(1000)
            println("Thread completed on: ${Thread.currentThread().name}")
            // This statement may run on another thread also.
            "I\'m done"
        }

        /*job.cancel() - can be used to cancel the job*/
        println(job.isActive)
        delayForSomeTime(2000)
        println(job.isActive)
        println("Main Completes: ${Thread.currentThread().name}")
    }
}

suspend fun delayForSomeTime(i: Long) {
    delay(i)
}

```

We just changed the launch to async lambda expression. This does not change anything. However, the async function does not return a job object. It returns a `JobDeferred` Object which is the subclass of `Job`.

[Coroutines Codelab](https://developer.android.com/codelabs/kotlin-coroutines#0)

The issue you're encountering is due to the fact that `data` is a `Deferred` object that can only be awaited once. When you click the button the second time, `data.await()` is called again, but since `data` has already been awaited once, it won't provide the expected result the second time.

To fix this issue, you should create a new `Deferred` object each time you want to fetch data. One way to do this is to move the creation of `data` inside the `fetchData()` function so that a new `Deferred` object is created every time the button is clicked.

Here's how you can modify your code:

```kotlin
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nareshittechnologies.co_routines.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import java.net.URL
import java.util.Scanner
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {
    val fetchJokes = "https://api.chucknorris.io/jokes/random"
    lateinit var activityMainBinding: ActivityMainBinding
    lateinit var scope: CoroutineScope

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        // Enable edge-to-edge display
        enableEdgeToEdge()

        // Set up CoroutineScope
        scope = CoroutineScope(Dispatchers.Main)

        activityMainBinding.progressBar.visibility = ProgressBar.INVISIBLE
        activityMainBinding.button.setOnClickListener {
            fetchData()
        }
    }

    private fun fetchData() {
        activityMainBinding.progressBar.visibility = ProgressBar.VISIBLE
        scope.launch {
            val data = fetchDataAsync() // Create a new Deferred object each time fetchData is called
            try {
                val d = data.await()
                activityMainBinding.result.text = d
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, "Error fetching data", Toast.LENGTH_SHORT).show()
            } finally {
                activityMainBinding.progressBar.visibility = ProgressBar.INVISIBLE
            }
        }
    }

    private suspend fun fetchDataAsync(): Deferred<String> = scope.async(Dispatchers.IO) {
        val url = URL(fetchJokes)
        val connection = url.openConnection() as HttpsURLConnection
        val inputStream = connection.inputStream
        val scanner = Scanner(inputStream)
        val stringBuilder = StringBuilder()
        while (scanner.hasNext()) {
            stringBuilder.append(scanner.nextLine())
        }
        stringBuilder.toString()
    }

    // Extension function to enable edge-to-edge display
    private fun AppCompatActivity.enableEdgeToEdge() {
        ViewCompat.setOnApplyWindowInsetsListener(window.decorView) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.updatePadding(top = systemBars.top, bottom = systemBars.bottom)
            insets
        }
        ViewCompat.requestApplyInsets(window.decorView)
    }
}
```

In this modified version, `fetchDataAsync()` function is introduced to create a new `Deferred` object each time `fetchData()` is called. This ensures that the data fetching operation can be performed multiple times without any issues.

### Services in Android
- Service runs in the background (not necessarily on a seperate thread) that performs a long running operation.
- Service does not offer any UI to the user.
- It is one of the application entry points (Basic building blocks of android).

Types of Services:
- Foreground Service 
    - If you want to run a service and let the user know that you are running it.
        - Typically sends a notification to the user
        - Music Player, Location Tracking apps, etc.,
- Background Service
    - Run in the background and the user is not notified about it
- Bound Service
    - Runs a service that is boundable. meaning, we can perform IPC between any component that is bound and the service.

[Official Doc](https://developer.android.com/develop/background-work/services)

### Media Player
[Official Doc](https://developer.android.com/reference/android/media/MediaPlayer)


### Jetpack Compose

- Jetpack Compose is a part of Android Jetpack that accelerates the development of Native UI without need of using Xml Views. Everything you write will be in kotlin. 
- Reusable code
- Clean code

[Official Documentation](https://developer.android.com/develop/ui/compose)

[Learn Jetpack UI Compose here](https://developer.android.com/courses/jetpack-compose/course)

**Jetpack Compose**

Modren components for building UI for Android apps.

**Two Approaches in Creating a UI**
- Imperative Programming approach
- Declarative Programming approach

**Imperative Style**
- UI Widget tree that is created by inflating an XML layout file.
- Each widget here, maintains its internal state and exposes a getter and setter methods to get and set data
**Declarative Style**
- Here, the widgets are not objects at all. 
- Widgets are stateless and does not expose getters and setters.
- Widgets are created using `Composables` and are updated by calling the same composables with different input arguments. 

**Dynamic Content**
- `Composables` are all written in kotlin.
- They can use all the dynamic hooks and branches that kotlin supports.
- you can use if statements to choose to show a widget or not. You can use for loops to show multiple widgets. 
- Widgets has full access to the flexibility of kotlin

**Re-composition**
- Process of re-invoking `Composable` functions when input changes
- This happens to update the data to the UI as the data got changed.
- Expensive operation. 
- That is the reason, koltin does not re-compose everything on UI. Instead, what ever is changed, that is re-composed. 

**Composables**
- Can execute in any order
- Can execute in parallel
- Re-composition skips as many composables as possible to avoid weight to put on the memory. 
- Re-composition is optimistic and may be cancelled. 
- This re-composition can also run very frequently (frame by frame)
- Compose has the option of identifying some composables that are higher priority than others. 
- You are not supposed to add composables in the order (because they can run in parallel)

***All Annotations and Composable function names usually starts with a capital letter: eX: Composable, Preview***
```kotlin
setContent{
     Text("Naresh Technologies",
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Blue)
}
```
