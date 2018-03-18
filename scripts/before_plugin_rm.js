//sourced from https://github.com/sarriaroman/FabricPlugin/blob/master/hooks/before_plugin_rm.js

var iosHelper = require("./lib/ios-helper");
var utilities = require("./lib/utilities");
var os = require('os');

module.exports = function(context) {

    var platforms = context.opts.cordova.platforms;

    // Remove the build script that was added when the plugin was installed.
    if (platforms.indexOf("ios") !== -1 && os.platform() === 'darwin') {
        var xcodeProjectPath = utilities.getXcodeProjectPath(context);
        iosHelper.removeShellScriptBuildPhase(context, xcodeProjectPath);
    }
};
