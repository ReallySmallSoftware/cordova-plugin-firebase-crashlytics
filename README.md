# Cordova Firebase Crashlytics Plugin

A Google Firebase Crashlytics plugin to enable capture of crash reports.

# What is Crashlytics?

From the Google documentation (https://firebase.google.com/products/crashlytics/):

> Firebase Crashlytics helps you track, prioritize, and fix stability issues that erode app quality, in realtime. Spend less time triaging and troubleshooting crashes and more time building app features that delight users

# Supported platforms
This plugin supports the following platforms:

- Android
- iOS (untested)
- Browser (for testing only)

# Installation

`cordova plugin add cordova-plugin-firebase-crashlytics --variable ANDROID_FIREBASE_CORE_VERSION=16.0.0 --save`

or

`phonegap plugin add cordova-plugin-firebase-crashlytics --variable ANDROID_FIREBASE_CORE_VERSION=16.0.0`

Omitting `FIREBASE_VERSION` will use a default value.

## Firebase configuration
### Android

You must ensure that `google-services.json` is put in the correct location. This can be achieved using the following in your `config.xml`:

```
<platform name="android">
    <resource-file src="google-services.json" target="google-services.json" />
</platform>
```

#### Dependencies
##### cordova-support-google-services

In order to ensure Firebase initialises correctly on Android this plugin can be used. This is not automatically added as a dependency to allow for the configuration it performs to be done manually if desired.

### iOS
iOS requires `GoogleService-Info.plist` is put in the correct location. Similarly this can be done as follows:
```
<platform name="ios">
    <resource-file src="GoogleService-Info.plist" />
</platform>
```

#### Podfile configuration
At this time it is necessary to manually add the `use_frameworks!` directive to this file.

#### Keychain Sharing Capability
If using multiple Firebase plugins it may be necessary to enable this.

# How to use it
Simply add the plugin to get the default Crashlytics functionality. Note that crashes and logged exceptions will only be reported when the application restarts.

In order to log caught exceptions the following can be used:

```
var crashlytics = FirebaseCrashlytics.initialise();
crashlytics.logException("my caught exception");
```

## Methods
### crash()
Generate a forced crash. Visible in console after restart of application.

### logPriority(priority, tag, message)
Log a priority message. Will only be logged in the event of a crash.

Available priorities are compatible with most Android [Log constants](https://developer.android.com/reference/android/util/Log#constants_2):
- FirebaseCrashlytics.LOG.VERBOSE
- FirebaseCrashlytics.LOG.DEBUG
- FirebaseCrashlytics.LOG.INFO
- FirebaseCrashlytics.LOG.WARN
- FirebaseCrashlytics.LOG.ERROR

Example usage
```js
crashlytics.logPriority(FirebaseCrashlytics.LOG.WARN, 'dashboard', 'This should not happened')
```

### initialise(hasConsent):Promise<boolean>
Initialise Crashlytics and send any logs files if the user has given consent, otherwise delete them.

Returns a true if there was a previous crash.

### log(message)
Log a message. Will only be logged in the event of a crash.

### logException(message)
Log when a handled exception has happened. Visible in console after restart of application.

### setString(key, value)
Set extra key/value string value. Will only be logged in the event of a crash.

### setBool(key, value)
Set extra key/value bool value. Will only be logged in the event of a crash.

### setDouble(key, value)
Set extra key/value double value. Will only be logged in the event of a crash.

### setFloat(key, value)
Set extra key/value float value. Will only be logged in the event of a crash.

### setInt(key, value)
Set extra key/value integer value. Will only be logged in the event of a crash.

### setUserIdentifier(identifier)
Set the identifier for the user. Take care when using this method and ensure you privacy policy is updated accordingly.

## Typescript
Support is now included for typescript. Use the following to reference the typescript definitions:

```
/// <reference types="cordova-plugin-firebase-crashlytics" />

private static crashlytics: FirebaseCrashlytics.FirebaseCrashlytics = FirebaseCrashlytics.initialise();
crashlytics.logException("my message");
```

You may also need to add an external to webpack.config.ls:

```
  externals: {
    'cordova-plugin-firebase-crashlytics': "cordova-plugin-firebase-crashlytics"
    '/exec':"cordova/exec"
  },
```

## 1.1.0
- Update dependencies
- Refactor Android and iOS code
- Add initialise method to give consent for uploading logs

## 1.0.0
- Added types
- Updated dependencies for iOS
- Updated dependencies for Android

## 0.1.0
- Dependency updates
- Addition of log priority constants

## 0.0.9
- Update Android Firebase dependency
- Fix podspec for cordova-ios 5
- Fix xcode issue

## 0.0.8
- Remove podspec version for firebase

## 0.0.7
- Update Android dependency versions
- Update iOS dependency versions
- Update plugin dependencies
- WARNING: The Android update may require you to update com.google.gms:google-services to 4.0.0, com.android.tools.build:gradle to 3.1.2 and gradle to 4.4.4 (look in platforms/android/cordova/lib/builders/GradleBuilder.js)

## 0.0.6
- Add SetUserIdentifier()
- Fix iOS set() methods with wrong types

## 0.0.5
- Merge back in some iOS updates (https://github.com/kanodeveloper/cordova-plugin-firebase-crashlytics-ka)
- Add xcode npm dependency

## 0.0.4
- Updated gradle dependencies

## 0.0.3
- Fix typo in README
- Added embarrassing fix for logException()

## 0.0.2
- Add grunt to run jshint
- Fix some grunt warnings

## 0.0.1
- Initial release
