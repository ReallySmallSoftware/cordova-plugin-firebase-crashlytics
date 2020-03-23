#import "FirebaseCrashlyticsPlugin.h"

#import <Cordova/CDVAvailability.h>

#import <Firebase/Firebase.h>

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

- (void)logError:(CDVInvokedUrlCommand *)command {
    NSString *message = [command argumentAtIndex:0];
    NSArray *stackLines = [command argumentAtIndex:1];

    NSMutableArray *stackFrames = [NSMutableArray arrayWithCapacity: [stackLines count]];
    @try {
        for (NSDictionary *line in stackLines) {
            if (line == nil) {
                continue;
            }
            
            CLSStackFrame *sf = [CLSStackFrame stackFrame];

            NSString *symbol = [line valueForKey:@"functionName"];
            NSString *filename = [line valueForKey:@"fileName"];

            if ([symbol isEqual:[NSNull null]]) {
                symbol = @"unknown";
            }

            if ([fileName isEqual:[NSNull null]]) {
                filename = @"unknown";
            }

            [sf setSymbol: symbol];
            [sf setFileName: filename];
            [sf setLineNumber: line[@"lineNumber"] unsignedIntValue]];
            
            [stackFrames addObject:sf];
        }

        [[Crashlytics sharedInstance] recordCustomExceptionName:@"HandledException" reason:message frameArray:stackFrames];
    } @catch(NSException *exception) {
        [[Crashlytics sharedInstance] recordCustomExceptionName:@"HandledException" reason:message frameArray:@[]];
    }    
}

- (void)logException:(CDVInvokedUrlCommand *)command {
    NSString *message = [command argumentAtIndex:0];

    NSDictionary *userInfo = @{
                               NSLocalizedDescriptionKey: NSLocalizedString(@"Unexpected exception", nil),
                               NSLocalizedFailureReasonErrorKey: NSLocalizedString(message, nil),
                               NSLocalizedRecoverySuggestionErrorKey: NSLocalizedString(@"", nil)};

    NSError *error = [NSError errorWithDomain:@"uk.co.trssc" code:-1 userInfo:userInfo];
    [CrashlyticsKit recordError:error];
    [[Crashlytics sharedInstance] recordCustomExceptionName:@"HandledException" reason:message frameArray:@[]];
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

    [CrashlyticsKit setBoolValue:[value boolValue] forKey:key];
}

- (void)setDouble:(CDVInvokedUrlCommand *)command {
    NSString *key = [command argumentAtIndex:0];
    NSNumber *value = [command argumentAtIndex:1];

    [CrashlyticsKit setFloatValue:[value doubleValue] forKey:key];
}

- (void)setFloat:(CDVInvokedUrlCommand *)command {
    NSString *key = [command argumentAtIndex:0];
    NSNumber *value = [command argumentAtIndex:1];

    [CrashlyticsKit setFloatValue:[value floatValue] forKey:key];
}

- (void)setUserIdentifier:(CDVInvokedUrlCommand *)command {
    NSString *identifier = [command argumentAtIndex:0];
    
    [CrashlyticsKit setUserIdentifier:identifier];
}

@end
