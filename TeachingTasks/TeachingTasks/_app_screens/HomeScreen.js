// ---
// COMPONENT DESCRIPTION:
// This is the screen that opens when the app is first installed.
// ---
import * as React from 'react';
import {View, Text, Button, StyleSheet} from 'react-native';
import {NavigationContainer} from '@react-navigation/native';
import {createStackNavigator} from '@react-navigation/stack';

function HomeScreen({navigation}) {
  return (
    <View style={styles.main_BG}>
      <Text style={styles.text}>Welcome to Teaching Tasks!</Text>
      <Button
        title="Go to Getting Started"
        color="teal"
        onPress={() => navigation.navigate('Getting Started')}
      />
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

export default HomeScreen;
