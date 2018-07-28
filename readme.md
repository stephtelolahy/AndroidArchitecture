# Android Architecture

## Introduction
This tutorial is about how to architect your android application to make sure that it will be

- Easy to maintain (separation of concerns)
- Easy to test (dependency injection)
- Very concise
- Decoupled


## ModelView View Model
There are several Design pattern that could be used for android apps. See [Common design patters for Android with Kotlin](https://www.raywenderlich.com/168038/common-design-patterns-android-kotlin)

Anyway Google recommends the MVVM pattern in his [Guide to App Architecture](https://developer.android.com/jetpack/docs/guide)

The major benefits of this pattern are:

- separation of concerns
- Google recently introduced this pattern as part of its [Architecture Components library](https://developer.android.com/topic/libraries/architecture/viewmodel)
- completely decoupled compared to MVP
- take advantage of data binding, more event-drivent than MVP. 


## How it looks like

![alt text](images/clean_architecture_layers_details.png "Logo Title Text 1")


###View
User interface

###ViewModel
Presentation logic

###Model
Data class and Business logic



## Reactive approach
Make more concise code RX extensions.
Avoid interface boilderplates.

![alt text](images/0tcslPN3C5PJDW9rk.jpg "Logo Title Text 1")


## Testing
Test structure (assert, execute, verify)

What to test: busines logic

## Demo

- Create simple Android app : discover components
- Implement ViewModel
- Make business layer reactive
- Implement test

