// ---
// COMPONENT DESCRIPTION:
// This is the screen that opens when the app is first installed.
// ---
import * as React from 'react';
import {View, Text, Button, StyleSheet} from 'react-native';
import {NavigationContainer} from '@react-navigation/native';
import {createStackNavigator} from '@react-navigation/stack';
import {TextInput} from 'react-native-gesture-handler';

function RegisterParent({navigation}) {
  return (
    <View style={styles.main_BG}>
      <Text style={styles.text}>Create Parent Account</Text>
      <View style={{padding: 10}}>
        <TextInput style={styles.text_input} placeholder="Username" />
        <TextInput style={styles.text_input} placeholder="Password" />
        <Button title="Create account" color="green"></Button>
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
  text_input: {
    backgroundColor: 'white',
    textAlign: 'center',
    color: 'black',
    padding: 10,
    borderColor: 'black',
    borderWidth: 2,
    borderRadius: 10,
  },
});

export default RegisterParent;
