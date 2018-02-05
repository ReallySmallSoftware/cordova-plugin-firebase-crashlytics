Cordova Firebase Crashlytics Plugin
==

A Google Firebase Crashlytics plugin to enable capture of crash reports.

What is Crashlytics?
--

From the Google documentation (https://firebase.google.com/products/crashlytics/):

> Firebase Crashlytics helps you track, prioritize, and fix stability issues that erode app quality, in realtime. Spend less time triaging and troubleshooting crashes and more time building app features that delight users

Supported platforms
--
This plugin supports the following platforms:

- Android
- iOS (untested)

Installation
--

`cordova plugin add cordova-plugin-firestore --variable ANDROID_FIREBASE_VERSION=11.6.0 --save`

or

`phonegap plugin add cordova-plugin-firestore --variable ANDROID_FIREBASE_VERSION=11.6.0`

Omitting FIREBASE_VERSION will use a default value.

Firebase configuration
--
Android
--
You must ensure that `google-services.json` is put in the correct location. This can be achieved using the following in your `config.xml`:

```
<platform name="android">
    <resource-file src="google-services.json" target="google-services.json" />
</platform>
```
iOS
--
iOS requires `GoogleService-Info.plist` is put in the correct location. Similarly this can be done as follws:
```
<platform name="ios">
    <resource-file src="GoogleService-Info.plist" />
</platform>
```

How to use it
--
Simply add the plugin to get the default Crashlytics functionality. Note that crashes and logged exceptions will only be reported when the app restarts.

Methods
==

crash()
--
Generate a forced crash.

logPriority(priority, tag, message)
--
Log a priority message. Will only be logged in the event of a crash.

log(message)
--
Log a message. Will only be logged in the event of a crash.

logException(message)
--
Log when a handled exception has happened.

setString(key, value)
--
Set extra key/value string value. Will only be logged in the event of a crash.

setBool(key, value)
--
Set extra key/value bool value. Will only be logged in the event of a crash.

setDouble(key, value)
--
Set extra key/value double value. Will only be logged in the event of a crash.

setFloat(key, value)
--
Set extra key/value float value. Will only be logged in the event of a crash.

setInt(key, value)
--
Set extra key/value integer value. Will only be logged in the event of a crash.

History
==
0.0.1
--
- Initial release
