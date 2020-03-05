declare namespace FirebaseCrashlytics {
    export function initialise(): FirebaseCrashlytics;

    export interface StackTraceLine {
        columnNumber: number;
        lineNumber: number;
        fileName: string;
        functionName: string;
    }

    export interface FirebaseCrashlytics {

        crash(): void;
        logPriority(priority: string, tag: string, message: string): void;
        log(message: string): void;
        logError(error: Error, stackFrames?: Array<StackTraceLine>): void;
        logException(message: string): void;
        setString(key: string, value: string): void;
        setBool(key: string, value: boolean): void;
        setDouble(key: string, value: number): void;
        setFloat(key: string, value: number): void;
        setInt(key: string, value: number): void;
        setUserIdentifier(identifier: string): void;
    }
}

