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
    NSString *message = [command argumentAtIndex:2];
    CLSLog(@"%@", message);
}

- (void)log:(CDVInvokedUrlCommand *)command {
    NSString *message = [command argumentAtIndex:0];
    CLSLog(@"%@", message);
}

- (void)setString:(CDVInvokedUrlCommand *)command {
    NSString *key = [command argumentAtIndex:0];
    NSString *value = [command argumentAtIndex:1];

    [CrashlyticsKit setObjectValue:value forKey:key];
}

- (void)setInt:(CDVInvokedUrlCommand *)command {
    NSString *key = [command argumentAtIndex:0];
    NSNumber *value = [command argumentAtIndex:1];

    [CrashlyticsKit setIntValue:[value integerValue] forKey:key];
}

- (void)setBool:(CDVInvokedUrlCommand *)command {
    NSString *key = [command argumentAtIndex:0];
    NSNumber *value = [command argumentAtIndex:1];

    [CrashlyticsKit setIntValue:[value boolValue] forKey:key];
}

- (void)setDouble:(CDVInvokedUrlCommand *)command {
    NSString *key = [command argumentAtIndex:0];
    NSNumber *value = [command argumentAtIndex:1];

    [CrashlyticsKit setIntValue:[value doubleValue] forKey:key];
}

- (void)setFloat:(CDVInvokedUrlCommand *)command {
    NSString *key = [command argumentAtIndex:0];
    NSNumber *value = [command argumentAtIndex:1];

    [CrashlyticsKit setIntValue:[value floatValue] forKey:key];
}

@end
