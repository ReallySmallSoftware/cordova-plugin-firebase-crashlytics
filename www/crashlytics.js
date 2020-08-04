var exec = require('cordova/exec');

var PLUGIN_NAME = 'FirebaseCrashlytics';

function Crashlytics() {
}

Crashlytics.prototype = {
  initialise: function(hasConsent) {
    return new Promise(function (resolve, reject) {
      exec(resolve, reject, PLUGIN_NAME, 'initialise', [hasConsent]);
    })
  },
  crash: function() {
    exec(null, null, PLUGIN_NAME, 'crash', []);
  },
  logPriority: function(priority, tag, message) {
    exec(null, null, PLUGIN_NAME, 'logPriority', [priority, tag, message]);
  },
  log: function(message) {
    exec(null, null, PLUGIN_NAME, 'log', [message]);
  },
  logException: function(message) {
    exec(null, null, PLUGIN_NAME, 'logException', [message]);
  },
  setString: function(key, value) {
    exec(null, null, PLUGIN_NAME, 'setString', [key, value]);
  },
  setBool: function(key, value) {
    exec(null, null, PLUGIN_NAME, 'setBool', [key, value]);
  },
  setDouble: function(key, value) {
    exec(null, null, PLUGIN_NAME, 'setDouble', [key, value]);
  },
  setFloat: function(key, value) {
    exec(null, null, PLUGIN_NAME, 'setFloat', [key, value]);
  },
  setInt: function(key, value) {
    exec(null, null, PLUGIN_NAME, 'setInt', [key, value]);
  },
  setUserIdentifier: function(identifier) {
    exec(null, null, PLUGIN_NAME, 'setUserIdentifier', [identifier]);
  },
  logError: function(message, stackTrace) {
      exec(null, null, PLUGIN_NAME, 'logError', [message, stackTrace]);
  },
};

// Log levels
// See https://developer.android.com/reference/android/util/Log
Crashlytics.LOG = {
  VERBOSE: 2,
  DEBUG: 3,
  INFO: 4,
  WARN: 5,
  ERROR: 6
}

// Backward compatibility instantiation
Crashlytics.initialise = function() {
  return new Crashlytics();
};

module.exports = Crashlytics;
