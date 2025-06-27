# mcommerce-ios-practical5
 
A modern Android eCommerce application built with Jetpack Compose, following MVVM architecture and using modern Android development practices.

## Features

- Product listing from Fake Store API
- Product detail view with full information
- Shopping cart functionality
- Quantity management
- Local persistence using SharedPreferences
- Modern UI with Material Design 3
- Proper error handling and loading states

## Tech Stack

- **Kotlin** - Programming language
- **Jetpack Compose** - Modern UI toolkit
- **ViewModel & LiveData** - Architecture components
- **Retrofit** - Network calls
- **Coil** - Image loading
- **Navigation Compose** - Navigation
- **Material Design 3** - UI design system
- **Coroutines** - Asynchronous programming
- **SharedPreferences** - Local storage

## Architecture

The app follows MVVM (Model-View-ViewModel) architecture pattern:

- **Model**: Data classes and repository pattern for data management
- **View**: Composable functions for UI
- **ViewModel**: Business logic and state management

### Project Structure

- `data/`: Data layer with models, API services, and repositories
- `ui/`: UI layer with screens, components, and ViewModels
- `navigation/`: Navigation setup
- `utils/`: Utility classes like SharedPreferencesManager

## Setup Instructions

1. Clone the repository
2. Open the project in Android Studio
3. Sync the project with Gradle files
4. Run the app on an emulator or physical device

## Dependencies

All dependencies are managed through Gradle and include:
- Jetpack Compose BOM
- Retrofit for networking
- Coil for image loading
- Navigation Compose
- Material Design 3

## Testing

The project includes unit tests for:
- ViewModels
- Repository classes
- Business logic

Run tests using: `./gradlew test`

## Known Issues

- Checkout functionality is not implemented (button placeholder)
- No user authentication
- Limited error handling for network edge cases

## Time Taken

Approximately 6-8 hours for complete implementation including:
- Architecture setup
- UI implementation
- Business logic
- Testing
- Documentation

## Optional Features Implemented

- Local persistence using SharedPreferences
- Unit testing with Mockito
- Dependency injection pattern
- Modern UI with animations and proper state management