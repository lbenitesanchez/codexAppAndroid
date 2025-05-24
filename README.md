# TodoListApp

This is a simple Android application written in Kotlin that lets users manage daily tasks.

## Features

- Add tasks using the input field at the top of the screen.
- Tasks appear in a list where they can be marked as completed or deleted.
- Completed tasks are displayed with a strike-through effect.

## Building and Running

1. Open **Android Studio** and select **Open** to import this project directory.
2. Allow Android Studio to download any missing dependencies if prompted.
3. Connect an Android device or start an emulator.
4. Click **Run** to build and install the app on your device.

## Improvements

To keep tasks after the app is closed, consider using persistent storage. For example:

- Use `Room` to store tasks in a local database.
- Save tasks in a simple `SharedPreferences` file for lightweight persistence.
