declare namespace FirebaseCrashlytics {
    export function initialise(): FirebaseCrashlytics;

    export interface FirebaseCrashlytics {

        crash(): void;
        logPriority(priority: string, tag: string, message: string): void;
        log(message: string): void;
        logException(message: string): void;
        setString(key: string, value: string): void;
        setBool(key: string, value: boolean): void;
        setDouble(key: string, value: number): void;
        setFloat(key: string, value: number): void;
        setInt(key: string, value: number): void;
        setUserIdentifier(identifier: string): void;
        logError(message: string, stackTrace: StackTraceLine[]): void;
        initialise(hasConsent: boolean): Promise<boolean>;
    }

    export interface StackTraceLine {
        className: string;
        functionName: string;
        fileName: string;
        lineNumber: number;
    }
}

