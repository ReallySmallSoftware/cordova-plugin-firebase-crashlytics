#import "FirebaseCrashlyticsPlugin.h"

#import <Cordova/CDVAvailability.h>

@implementation FirebaseCrashlyticsPlugin

- (void)pluginInitialize {
    if(![FIRApp defaultApp]) {
        [FIRApp configure];
    }
}

- (void)crash:(CDVInvokedUrlCommand *)command {
    [[Crashlytics sharedInstance] crash];
}

- (void)logPriority:(CDVInvokedUrlCommand *)command {
}

- (void)log:(CDVInvokedUrlCommand *)command {
}

- (void)setString:(CDVInvokedUrlCommand *)command {
}

- (void)setInt:(CDVInvokedUrlCommand *)command {
}

- (void)setBool:(CDVInvokedUrlCommand *)command {
}

- (void)setDouble:(CDVInvokedUrlCommand *)command {
}

- (void)setFloat:(CDVInvokedUrlCommand *)command {
}

@end
