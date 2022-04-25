# Mobiquity-Assignment
## Implementation Details
The project is implemented in Kotlin and the software architectural pattern is MVVM. The project implemented in clean architecture which separates the application code into layers and these layers define the Separation of Concerns (SOC) inside the codebase  

Thanks to clean architecture and jetpack components which enabled me to implement a modular and robust Android app

Following are the features implemented;
1. The user can view a categorized list of products and view details of all the products.
2. The product data is persisted in *Room Database* in the cache layer.
3. The data for porducts is fetched using *Retrofit2*
4. Kotlin Coroutines are used thrught out the project to implement asynchronous code.
5. All the project dependencies are injected using *Hilt*
7. Extensive *Unit tests* are also implemented using *JUnit4, Androidx tests, Mockk and RoboElectric*.  

## Tech stack
* [Kotlin](https://kotlinlang.org/)
* [MVVM Architecture](https://developer.android.com/jetpack/guide) - Modern, maintainable, and Google suggested app architecture
* [Gradle Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html) - Type safe dependency management
* [Navigation Component](https://developer.android.com/guide/navigation) - Single-activity architecture, using the Navigation Components to manage UI navigation.
* [Dagger Hilt](https://dagger.dev/hilt/) - Easy implementation and less boilerplate code than Dagger2
* [Coroutine](https://developer.android.com/kotlin/coroutines) & [Flow](https://developer.android.com/kotlin/flow)
* [Retrofit](https://square.github.io/retrofit/)
* [OkHttp](https://square.github.io/okhttp/)
* [Moshi](https://github.com/square/moshi)
* [Jetpack Components](https://developer.android.com/jetpack) - ViewModel, LiveData, DataBinding and more
* [Lottie](https://github.com/airbnb/lottie-android)
* [Truth](https://truth.dev/) & [Mockk](https://mockk.io/) - For unit tests
* [Lottie](https://github.com/airbnb/lottie-android)
* [Room](https://developer.android.com/training/data-storage/room) - For storing favorited data

## Useful points
* Modern architecture
* Readable and scalable codebase
* Responsive layout design, vertical and horizontal usage
* Good state handling
* Unit tests

## Project Setup

1. Clone the project and run it in Android studio.
3. Build and Run the application.
