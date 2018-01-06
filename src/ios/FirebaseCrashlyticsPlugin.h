#import <Cordova/CDVPlugin.h>
@import Firebase;
#import <Crashlytics/Crashlytics.h>

@interface FirebaseCrashlyticsPlugin : CDVPlugin <UIAlertViewDelegate>

- (void)crash:(CDVInvokedUrlCommand *)command;
- (void)logPriority:(CDVInvokedUrlCommand *)command;
- (void)log:(CDVInvokedUrlCommand *)command;
- (void)setString:(CDVInvokedUrlCommand *)command;
- (void)setInt:(CDVInvokedUrlCommand *)command;
- (void)setBool:(CDVInvokedUrlCommand *)command;
- (void)setDouble:(CDVInvokedUrlCommand *)command;
- (void)setFloat:(CDVInvokedUrlCommand *)command;

@end
