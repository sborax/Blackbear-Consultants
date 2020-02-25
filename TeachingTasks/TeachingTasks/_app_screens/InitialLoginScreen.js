// ---
// COMPONENT DESCRIPTION:
// This is the screen that allows for user creation.
// ---
import * as React from 'react';
import {View, Text, Button, StyleSheet} from 'react-native';
import {NavigationContainer} from '@react-navigation/native';
import {createStackNavigator} from '@react-navigation/stack';

function InitialLoginScreen() {
  return (
    <View style={styles.main_BG}>
      <View style={{padding: 10}}>
        <Text style={styles.text}>Welcome to Teaching Tasks!</Text>
        <Text style={styles.text}>
          To begin, please create a user by clicking the edit button.
        </Text>
      </View>
      <View style={{paddingHorizontal: 100, paddingVertical: 10}}>
        <Button title="Edit user" color="teal"></Button>
      </View>
    </View>
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

export default InitialLoginScreen;
