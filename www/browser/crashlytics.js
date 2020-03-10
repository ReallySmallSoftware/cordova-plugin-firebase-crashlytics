/*global alert */
var PLUGIN_NAME = 'Crashlytics';

function Crashlytics() {
}

Crashlytics.prototype = {
  crash: function() {
    alert("Crash! Bang!");
  },
  logPriority: function(priority, tag, message) {
    console.debug("P: " + priority + "   T: " + tag + "   M: " + message);
  },
  log: function(message) {
    console.debug(message);
  },
  logException: function(message) {
    console.debug(message);
  },
  logError: function(error, stackFrames) {
	console.error(error.stack);
  },
  setString: function(key, value) {
    console.debug(key + ":" + value);
  },
  setBool: function(key, value) {
    console.debug(key + ":" + value);
  },
  setDouble: function(key, value) {
    console.debug(key + ":" + value);
  },
  setFloat: function(key, value) {
    console.debug(key + ":" + value);
  },
  setInt: function(key, value) {
    console.debug(key + ":" + value);
  },
  setUserIdentifier: function(identifier) {
    console.debug(identifier);
  }
};

// Log levels
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
