# Data Store Preferences with Koin in Compose Multiplatform (KMP)

## Overview

A Kotlin Multiplatform project that demonstrates managing user authentication with data persistence using DataStore Preferences and Koin dependency injection. This project includes a Login and Sign-Up flow with full data validation. User information is saved in DataStore Preferences and used to verify login credentials.

## IOS and Android
https://github.com/user-attachments/assets/57f7634e-648a-4e51-92d6-06ca427cec69

## Desktop
https://github.com/user-attachments/assets/67d57703-af7e-4be2-b2eb-e3e33786d921

## Features

- **User Authentication**: Signup and login functionalities.
- **Data Storage**: User data is stored using Data Store preferences.
- **Input Validation**: Ensures users provide valid information during signup and login.
- **User Interface**: Clean and responsive UI built with Jetpack Compose.
- **Logout Functionality**: Users can log out and clear their session.

## Create Data Store in Shared Module
```kotlin
expect fun createDataStore(): DataStore<Preferences>

internal const val dataStoreFileName = "create_datastore.preferences_pb"

private lateinit var dataStore: DataStore<Preferences>
@OptIn(InternalCoroutinesApi::class)
private val lock = SynchronizedObject()

@OptIn(InternalCoroutinesApi::class)
fun getDataStore(producePath: () -> String): DataStore<Preferences> =
    synchronized(lock) {
        if (::dataStore.isInitialized) {
            dataStore
        } else {
            PreferenceDataStoreFactory.createWithPath(produceFile = { producePath().toPath() })
                .also { dataStore = it }
        }
    }
```

## Create Data Store in Android Module
```kotlin

actual fun createDataStore(): DataStore<Preferences> {
    return runBlocking {
        getDataStore(producePath = {
            ContextUtils.dataStoreApplicationContext!!.filesDir.resolve(
                dataStoreFileName
            ).absolutePath
        })
    }
}
```

## Create Data Store in IOS Module
```kotlin
@OptIn(ExperimentalForeignApi::class)
actual fun createDataStore(): DataStore<Preferences> {
    return runBlocking {
        getDataStore(producePath = {
            val documentDirectory: NSURL? = NSFileManager.defaultManager.URLForDirectory(
                directory = NSDocumentDirectory,
                inDomain = NSUserDomainMask,
                appropriateForURL = null,
                create = false,
                error = null,
            )
            requireNotNull(documentDirectory).path + "/$dataStoreFileName"
        })
    }
}
```

## Create Data Store in Desktop Module
```kotlin
actual fun createDataStore(): DataStore<Preferences> {
    return PreferenceDataStoreFactory.createWithPath(
        corruptionHandler = null,
        migrations = emptyList(),
        produceFile = { dataStoreFileName.toPath() }
    )
}
```

## Contributing

Contributions are welcome! Please follow these steps:

- Fork the repository.
- Create a new branch (git checkout -b feature-branch).
- Commit your changes (git commit -m 'Add some feature').
- Push to the branch (git push origin feature-branch).
- Open a pull request.

## Contact

For any inquiries, please contact waqaswaseem679@gmail.com.
