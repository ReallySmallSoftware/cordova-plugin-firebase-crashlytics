//sourced from https://github.com/sarriaroman/FabricPlugin/blob/master/hooks/after_plugin_add.js

var iosHelper = require("./lib/ios-helper");
var utilities = require("./lib/utilities");
var os = require('os');

module.exports = function(context) {

    var platforms = context.opts.cordova.platforms;

    // Add a build phase which runs a shell script that executes the Crashlytics
    // run command line tool which uploads the debug symbols at build time.
    if (platforms.indexOf("ios") !== -1 && os.platform() === 'darwin') {
        var xcodeProjectPath = utilities.getXcodeProjectPath(context);
        iosHelper.removeShellScriptBuildPhase(context, xcodeProjectPath);
        iosHelper.addShellScriptBuildPhase(context, xcodeProjectPath);
    }
};
