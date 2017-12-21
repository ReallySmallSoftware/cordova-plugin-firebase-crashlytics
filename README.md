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
- iOS

Status
--
This is very much a work in progress.

Installation
--

`cordova plugin add cordova-plugin-firestore --variable ANDROID_FIREBASE_VERSION=11.6.0 --save`

or

`phonegap plugin add cordova-plugin-firestore --variable ANDROID_FIREBASE_VERSION=11.6.0`

Omitting FIREBASE_VERSION will use a default value.

How to use it
--
Simply add the plugin to get the default Crashlytics functionality.

History
==
0.0.1
--
- Initial release
