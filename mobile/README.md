# Baufest automation
Mobile testing framework

## Prerequisites

+ Java Development Kit 17.0.2
+ Maven 3.8.5
- Appium 1.22.3

## Dependencies

+ JUnit 4.13.1
+ Cucumber 6.0.0 
+ Allure 2.13.8
+ Appium Java client 7.5.1

## Features

✅ Page Object design pattern for enhancing test maintenance and reducing code duplication
✅ Behavior-driven development with Gherkin
✅ Allure Test report integrated with Cucumber


## Configure Android SDK

+ [Download and install Android Studio](https://developer.android.com/studio)
+ En la opción Tools > SDK Manager puede definir el Android SDK location
+ Definir la variable de sistema ANDROID_HOME a fin de que apunte al Android SDK location  
+ [Install the Android SDK platform and SDK tool](https://www.mathworks.com/help/supportpkg/android/ug/install-latest-version-of-android-studio-and-sdk-platform-packages-and-tools.html)
+ Agregar las siguientes rutas %ANDROID_HOME%/platform-tools, %ANDROID_HOME%/emulator y %ANDROID_HOME%/tools/bin a la variable de sistema PATH


## Configure development options on the Androd device 

[Enable developer options and USB debugging](https://developer.android.com/studio/debug/dev-options)

## Install APK list Android device connected to PC 

+ Connect the Android device to the PC by USB
+ Execute the scrip `list-devices.bat` to get the key of the device connected
+ Update the key of the device in the `script/install-apk.bat` script
+ Update the key of the device in the property udid of the file`src/test/java/com/baufest/config.properties` 
+ Put the application APK file in the `script/` directory 
+ Run the `script/install-apk.bat` script

## Appium install via Node.js

+ Install Node.js from the [site](https://nodejs.org/es/) 
+ Run the commend npm `install -g appium`
+ Verify the instalation with `appium --version`
+ To start appium on port 4723 run `appium` 

## Allure install

Open a PowerShell terminal version 5.1 or later and run to install Scoop

`Set-ExecutionPolicy RemoteSigned -Scope CurrentUser`

`iwr -useb get.scoop.sh | iex` 

For install Allure run

`scoop install allure`


## Usage

The scrip `run.bat` is provided to run on Windows systems.



