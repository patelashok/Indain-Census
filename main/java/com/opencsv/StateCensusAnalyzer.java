package com.opencsv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

class CensusAnalyser {
    /**
     * this method will load all the datas from csv files.
     * @param csvFilePath
     * @return No.of Entries.
     * @throws CensusAnalyserException
     */
    public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyserException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IndiaCensusCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.build();
            Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();;
            int noOfEntries = 0;
            while (censusCSVIterator.hasNext()) {
                noOfEntries++;
                IndiaCensusCSV censusData = censusCSVIterator.next();
            }
            return noOfEntries;
        } catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(),
                    CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }
    /**
     * Added welcome message.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Welcome to Indian State Census Analyser");
    }
}