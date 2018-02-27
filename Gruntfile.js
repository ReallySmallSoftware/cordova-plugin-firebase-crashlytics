module.exports = function(grunt) {

  // Project configuration.
  grunt.initConfig({
    jshint: {
      options: {
        reporter: require("jshint-junit-reporter"),
        reporterOutput: "test-reports/jshint.xml",
        curly: true,
        eqeqeq: true,
        immed: true,
        latedef: true,
        newcap: true,
        noarg: true,
        sub: true,
        undef: true,
        boss: true,
        eqnull: true,
        node: true,
        es5: false,
        globals: {
          jasmine: false,
          describe: false,
          beforeEach: false,
          afterEach: false,
          expect: false,
          it: false,
          spyOn: false,
          $: false,
          cordova: false,
          launchnavigator: false,
          window: false,
          document: false,
          ons: false,
          navigator: false,
          google: false,
          FCMPlugin: false,
          device: false,
          plugins: false,
          addFixture: false,
          truncateSql: false
        }
      },
      all: ['Gruntfile.js', 'www/**/*.js']
    }
  });

  grunt.loadNpmTasks('grunt-contrib-jshint');
};
