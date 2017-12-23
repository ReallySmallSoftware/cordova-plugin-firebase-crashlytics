#import <Cordova/CDVPlugin.h>
#import <Crashlytics/Crashlytics.h>

@interface FirebaseCrashlyticsPlugin : CDVPlugin

- (void)crash:(CDVInvokedUrlCommand *)command;
- (void)logPriority:(CDVInvokedUrlCommand *)command;
- (void)log:(CDVInvokedUrlCommand *)command;
- (void)setString:(CDVInvokedUrlCommand *)command;
- (void)setInt:(CDVInvokedUrlCommand *)command;
- (void)setBool:(CDVInvokedUrlCommand *)command;
- (void)setDouble:(CDVInvokedUrlCommand *)command;
- (void)setFloat:(CDVInvokedUrlCommand *)command;

@end
