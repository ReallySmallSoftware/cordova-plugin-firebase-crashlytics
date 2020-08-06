#import "FirebaseCrashlyticsPlugin.h"

#import <Cordova/CDVAvailability.h>

#import <Firebase/Firebase.h>
@import FirebaseCrashlytics;

@implementation FirebaseCrashlyticsPlugin

- (void)pluginInitialize {
    if(![FIRApp defaultApp]) {
        [FIRApp configure];
    }
}

- (void)initialise:(CDVInvokedUrlCommand *)command {
    NSNumber *hasConsent = [command argumentAtIndex:0];

    NSNumber *result = [NSNumber numberWithInt:0];

    [[FIRCrashlytics crashlytics] setCrashlyticsCollectionEnabled:false];

    [[FIRCrashlytics crashlytics] checkForUnsentReportsWithCompletion:^(BOOL hasUnsentReports) {

        if (hasConsent && hasUnsentReports) {
            [[FIRCrashlytics crashlytics] sendUnsentReports];
        } else {
            [[FIRCrashlytics crashlytics] deleteUnsentReports];
        }
    }];

    if ([[FIRCrashlytics crashlytics] didCrashDuringPreviousExecution]) {
        result = [NSNumber numberWithInt:1];
    }

    CDVPluginResult *pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsDictionary:result];

    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)crash:(CDVInvokedUrlCommand *)command {
    assert(NO);
}

- (void)logPriority:(CDVInvokedUrlCommand *)command {
    NSString *message = [command argumentAtIndex:2];
    [[FIRCrashlytics crashlytics] logWithFormat:@"%@", message];
}

- (void)logException:(CDVInvokedUrlCommand *)command {
    NSString *message = [command argumentAtIndex:0];

    NSDictionary *userInfo = @{
                               NSLocalizedDescriptionKey: NSLocalizedString(@"Unexpected excerption", nil),
                               NSLocalizedFailureReasonErrorKey: NSLocalizedString(message, nil),
                               NSLocalizedRecoverySuggestionErrorKey: NSLocalizedString(@"", nil)};

    NSError *error = [NSError errorWithDomain:@"uk.co.trssc" code:-1 userInfo:userInfo];
    [[FIRCrashlytics crashlytics] recordError:error];

}

- (void)log:(CDVInvokedUrlCommand *)command {
    NSString *message = [command argumentAtIndex:0];
    [[FIRCrashlytics crashlytics] logWithFormat:@"%@", message];
}

- (void)setString:(CDVInvokedUrlCommand *)command {
    NSString *key = [command argumentAtIndex:0];
    NSString *value = [command argumentAtIndex:1];

    [[FIRCrashlytics crashlytics] setCustomValue:value forKey:key];
}

- (void)setInt:(CDVInvokedUrlCommand *)command {
    NSString *key = [command argumentAtIndex:0];
    NSNumber *value = [command argumentAtIndex:1];

    [[FIRCrashlytics crashlytics] setCustomValue:value forKey:key];
}

- (void)setBool:(CDVInvokedUrlCommand *)command {
    NSString *key = [command argumentAtIndex:0];
    NSNumber *value = [command argumentAtIndex:1];

    [[FIRCrashlytics crashlytics] setCustomValue:value forKey:key];
}

- (void)setDouble:(CDVInvokedUrlCommand *)command {
    NSString *key = [command argumentAtIndex:0];
    NSNumber *value = [command argumentAtIndex:1];

    [[FIRCrashlytics crashlytics] setCustomValue:value forKey:key];
}

- (void)setFloat:(CDVInvokedUrlCommand *)command {
    NSString *key = [command argumentAtIndex:0];
    NSNumber *value = [command argumentAtIndex:1];

    [[FIRCrashlytics crashlytics] setCustomValue:value forKey:key];
}

- (void)setUserIdentifier:(CDVInvokedUrlCommand *)command {
    NSString *identifier = [command argumentAtIndex:0];
    
    [[FIRCrashlytics crashlytics] setUserID:identifier];
}

@end

