# Tools Needed

You will need:

- Android Studio 3.5.3
- NodeJS 13.9.0
- React

1. Install [NodeJS](https://nodejs.org/en/ )
2. Follow the installation instructions for [React-Native](https://facebook.github.io/react-native/docs/getting-started )

- These instructions will detail how to get Android Studio virtual devices to work with React-Native
- **CAREFULLY READ THE INSTRUCTIONS**. Failure to follow the steps may prevent you from running the app.

3. Follow the installation instructions for [React-Navigation](https://facebook.github.io/react-native/docs/navigation )

Contact Chad Berry (chad.berry@maine.edu) with any problems regarding the project.

# Using the App

## Running the application via terminal

- cd 'TeachingTasks\TeachingTasks'
- npx react-native run-android

## If application won't run

- Try running an android emulator via Android studio
- You can do this from the "Welcome to Android Studio" menu
  - Click 'Configure' in the bottom right of the window
  - Click 'AVD Manager'
  - Create a virtual device (if needed)
    - Make sure the API says '28' / 'Pie'
  - Click the green triangle
  - In the console, repeat the commands from the last heading.

# Dependencies

    ## React Libraries
    "react": "16.9.0",
    "react-native": "0.61.5",
    "react-native-gesture-handler": "^1.6.0",
    "react-native-reanimated": "^1.7.0",
    "react-native-safe-area-context": "^0.7.3",
    "react-native-screens": "^2.0.0-beta.8"

    ## React Native Libraries
    "@react-native-community/masked-view": "^0.1.6",
    "@react-navigation/native": "^5.0.6",
    "@react-navigation/stack": "^5.0.6",

# Development Dependencies

    "@babel/core": "^7.6.2",
    "@babel/runtime": "^7.6.2",
    "@react-native-community/eslint-config": "^0.0.5",
    "babel-jest": "^24.9.0",
    "eslint": "^6.5.1",
    "jest": "^24.9.0",
    "metro-react-native-babel-preset": "^0.56.0",
    "react-test-renderer": "16.9.0"
