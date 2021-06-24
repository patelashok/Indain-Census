package com.opencsv;



/**
 * this is a child class of Exception which will print the exception message.
 */
public class CensusAnalyserException extends Exception {
    enum ExceptionType {
        CENSUS_FILE_PROBLEM
    }
    ExceptionType type;
    /**
     * here i have created custom exception.
     * @param message
     * @param type
     */
    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
    public CensusAnalyserException(String message, ExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;
    }
}