// ---
// COMPONENT DESCRIPTION:
// This is the entrypoint of the application.
// All subsequent screens are handled in this file.
// ---
import * as React from 'react';
import {View, Text, Button, StyleSheet} from 'react-native';
import {NavigationContainer} from '@react-navigation/native';
import {createStackNavigator} from '@react-navigation/stack';

// ---
// SCREEN COMPONENTS
//  * Remember to add the components to the stack navigator
// ---
import HomeScreen from './_app_screens/HomeScreen';
import InitialLoginScreen from './_app_screens/InitialLoginScreen';

const Stack = createStackNavigator();

function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName="Welcome Page">
        <Stack.Screen name="Welcome Page" component={HomeScreen} />
        <Stack.Screen name="Getting Started" component={InitialLoginScreen} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

// ---
// STYLE SHEET
// ---

const styles = StyleSheet.create({
  main_BG: {
    backgroundColor: '#000010',
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  text: {
    textAlign: 'center',
    color: 'white',
    fontWeight: 'bold',
    fontSize: 24,
  },
});

export default App;
