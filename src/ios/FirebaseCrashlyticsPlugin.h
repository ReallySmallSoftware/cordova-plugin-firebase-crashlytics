#import <Cordova/CDVPlugin.h>

@interface FirebaseCrashlyticsPlugin : CDVPlugin <UIAlertViewDelegate>

- (void)crash:(CDVInvokedUrlCommand *)command;
- (void)logPriority:(CDVInvokedUrlCommand *)command;
- (void)logException:(CDVInvokedUrlCommand *)command;
- (void)log:(CDVInvokedUrlCommand *)command;
- (void)setString:(CDVInvokedUrlCommand *)command;
- (void)setInt:(CDVInvokedUrlCommand *)command;
- (void)setBool:(CDVInvokedUrlCommand *)command;
- (void)setDouble:(CDVInvokedUrlCommand *)command;
- (void)setFloat:(CDVInvokedUrlCommand *)command;
- (void)setUserIdentifier:(CDVInvokedUrlCommand *)command;
- (void)initialise:(CDVInvokedUrlCommand *)command;

@end
