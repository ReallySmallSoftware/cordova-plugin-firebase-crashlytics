var exec = require('cordova/exec');

var PLUGIN_NAME = 'FirebaseCrashlytics';
var PARSE_STACK_GENERIC = /^\s*(at)?\s*(\S+)\s*[\@|\(]+(\S+):(\d+):(\d+)[)]?$/i;
var PARSE_STACK_FALLBACK = /^(.*)\s+[(]?(\S+):(\d+):(\d+)[)]?$/i;

function Crashlytics() {
}

Crashlytics.prototype = {
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
  logError: function(error, stackFrames) {
	stackFrames = stackFrames || parseStack(error);	
    exec(null, null, PLUGIN_NAME, 'logError', [error.toString(), stackFrames]);
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
  }
};

// Parse Error.stack
function parseStack(error) {
	if(!error || !error.stack) {
		return [];
	}
	
	var stackLines = error.stack.split('\n');
	var stackFrames = [];
	for(var i=0; i<stackLines.length; i++) {
		if(!stackLines[i]) {
			continue;
		}
		var parseResult = stackLines[i].match(PARSE_STACK_GENERIC);
		if(!parseResult) {
			parseResult = stackLines[i].match(PARSE_STACK_FALLBACK);
		}
		if(!parseResult) {
			continue;
		}
		
		stackFrames.push({
			functionName: parseResult[2],
			fileName: parseResult[3],
			lineNumber: parseResult[4],
			columnNumber: parseResult[5]
		});
	}
	return stackFrames;
}

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
