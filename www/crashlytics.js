var exec = require('cordova/exec');
var utils = require("cordova/utils");

var PLUGIN_NAME = 'Crashlytics';

function Crashlytics() {
}

Crashlytics.prototype = {
  crash: function() {
    exec(function() {}, null, PLUGIN_NAME, 'crash', []);
  },
  logPriority: function(priority, tag, message) {
    exec(function() {}, null, PLUGIN_NAME, 'logPriority', [priority, tag, message]);
  },
  log: function(message) {
    exec(function() {}, null, PLUGIN_NAME, 'log', [message]);
  },
  setString: function(key, value) {
    exec(function() {}, null, PLUGIN_NAME, 'setString', [key, value]);
  },
  setBool: function(key, value) {
    exec(function() {}, null, PLUGIN_NAME, 'setBool', [key, value]);
  },
  setDouble: function(key, value) {
    exec(function() {}, null, PLUGIN_NAME, 'setDouble', [key, value]);
  },
  setFloat: function(key, value) {
    exec(function() {}, null, PLUGIN_NAME, 'setFloat', [key, value]);
  },
  setInt: function(key, value) {
    exec(function() {}, null, PLUGIN_NAME, 'setInt', [key, value]);
  }
};

module.exports = {
  initialise: function() {
    return new Crashlytics();
  }
};
