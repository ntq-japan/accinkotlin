# Android Component Architect base application in Kotlin
(Included the supported for Java 9)

This project contain the basic source code using for start a new Android project with Android Component Architect in Kotlin.

### Table of contents
- [Build project and test](https://github.com/ntqsolution/accinkotlin/readme.md#build-project-and-test)
  - [For Windows OS](https://github.com/ntqsolution/accinkotlin/readme.md#for-windows-os)
  - [For Linux base OS (Ubuntu, MacOS)](https://github.com/ntqsolution/accinkotlin/readme.md#for-linux-base-os-ubuntu-macos)
- [Project structure](https://github.com/ntqsolution/accinkotlin/readme.md#project-structure)
- [Library list](https://github.com/ntqsolution/accinkotlin/readme.md#library-list)
- [How to use](https://github.com/ntqsolution/accinkotlin/readme.md#how-to-use)

## Build project and test
This tutorial wrote base on Gradle manual step. You should familiar with command prompt for that.

### For Windows OS
- Step 1: On project location, just enter this command bellow:

```
gradlew build
```

- Step 2: Confirm the output message display something like that.

> BUILD SUCCESSFUL in 1m 19s
>
> 74 actionable tasks: 60 executed, 14 up-to-date

### For Linux base OS (Ubuntu, MacOS)
- Step 1: On project location, grant execute permission for gradlew file.

```
$ sudo chmod 755 gradlew
```

- Step 2: Enter this command bellow:

```
$ gradlew build
```

- Step 3: Confirm the output message display something like that.

> BUILD SUCCESSFUL in 1m 19s
>
> 74 actionable tasks: 60 executed, 14 up-to-date

## Project structure
```
src/java/vn/com/ntq_solution
  ├app/ : Android application basic component. (Activity/Fragment, Content Provider...).
    ├activities/ : List acitvities used in this project.
    └fragments/ : List fragments used in this project.
  ├data/ : The data layer of this project.
    ├converter/ : The models of data, the entities of database, the reponses of web api... don't be the same all the times. So we need to convert it.
    ├database/ : Database base on Google Room database.
      ├dao/ : Data accept object.
      └entities/ : The Room entities class defined the database schema.
    ├network/ : Web Api connection.
    └repository/ : The communicating class between view and model.
  ├di/ : Dagger base class for dependency injection.
    ├component/ : List of application's component. Each component created a new DI graph
    ├submodule/ : The activity submodule. (basically be fragment)
    └support/ : The support class using for auto dependency injection.
  ├domain/ : Application business logic and utilities class.
    ├loggings/ : Application loggings method.
    └utils/ : The list utilities class.
  └presenter/ : Package using for create a new widget, the presenter and the viewmodel classes.
    └viewmodel/ : Each screen have one view model which hold a list of live data and communicate with repository classes.
```

## Library list
#### Gson
A Java serialization/deserialization library to convert Java Objects into JSON and back

#### Retrofit 2
The library for communicate with remote server had been recommended by Google. A type-safe HTTP client for Android and Java and turns your HTTP API into a Java interface.

#### Dagger 2
A fast dependency injector for Android and Java.

#### ButterKnife
Field and method binding for Android views.

#### Glide
An image loading and caching library for Android focused on smooth scrolling. Glide also supporting animated image.

#### ViewModel and LiveData
LiveData class is from lifecycle library, for observing the data changes. It’s an observable data holder class, and it is also lifecycle aware which means that this is going to update the component which is in the active lifecycle state.

ViewModel is also the part of lifecycle library; this will help you to provide data between repository and UI. This survives the data on configuration changes and gets the existing ViewModel to reconnect with the new instance of the owner. This is the lifecycle of ViewModel attached with an activity. Activity created and destroyed many times, but ViewModel survive the data. ViewModel is not the replacement of onSavedInstance because does not survive process shutdown although onSavedInstance can restore small data and ViewModel can restore a large amount of data like bitmaps.

#### Room (use 1.1.0-alpha2 for latest alpha)
The Room persistence library provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite.

## How to use
N/A - Under construction
