package com.analyser;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IplCricketTest {
    private static final String IPL_MOST_RUN_CSV_FILE_PATH = "./src/test/resources/IPLFactsheetMostRuns.csv";
    private static final String IPL_MOST_Wkts_CSV_FILE_PATH = "./src/test/resources/IPLFactsheetMostWkts.csv";
    //private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IPLFactsheetMostRuns.csv";

    IplCricketAnalyser iplAnalyser = new IplCricketAnalyser();

    @Test
    public void givenIplMostRun_whenSortedOnBatingAverage_shouldReturnShortedResult() throws IplAnalyserException {

        int numberOfRecord = iplAnalyser.loadIplMostWicketData(IPL_MOST_RUN_CSV_FILE_PATH);
        Assert.assertEquals(100, numberOfRecord);

    }

    @Test
    public void givenIplMostRunCSV_whenSortedOnBattingAverage_shouldReturnShortedResult() {

        try {

            iplAnalyser.loadIplMostWicketData(IPL_MOST_RUN_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.loadSortedOnBattingAverage();
            IplMostRunsCSV[] IplDataCSV = new Gson().fromJson( sortedResult , IplMostRunsCSV[].class);
            Assert.assertEquals(0.0, IplDataCSV[0].average,0.001);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostRunCSV_whenSortedOnStrikeRate_shouldReturnShortedResult() {

        try {

            iplAnalyser.loadIplMostWicketData(IPL_MOST_RUN_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.loadSortedOnStrikeRate();
            IplMostRunsCSV[] IplDataCSV = new Gson().fromJson( sortedResult , IplMostRunsCSV[].class);
            Assert.assertEquals(4.0, IplDataCSV[0].average,0.001);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostRunCSV_whenSortedOnMaxSix_shouldReturnShortedResult() {

        try {

            iplAnalyser.loadIplMostWicketData(IPL_MOST_RUN_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.loadMaximumSixInIpl();
            IplMostRunsCSV[] iplBatsManData = new Gson().fromJson( sortedResult , IplMostRunsCSV[].class);
            Assert.assertEquals("Andre Russell",iplBatsManData[99].player);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostRunCSV_whenSortedOnMaxFour_shouldReturnShortedResult() {

        try {

            iplAnalyser.loadIplMostWicketData(IPL_MOST_RUN_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.loadMaximumFourInIpl();
            IplMostRunsCSV[] iplBatsManData = new Gson().fromJson( sortedResult , IplMostRunsCSV[].class);
            Assert.assertEquals("Shikhar Dhawan",iplBatsManData[99].player);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostRunCSV_whenSortedOnBestHighestStrike_shouldReturnShortedResult() {

        try {

            iplAnalyser.loadIplMostWicketData(IPL_MOST_RUN_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.loadHighestStrikeInIpl();
            IplMostRunsCSV[] iplBatsManData = new Gson().fromJson( sortedResult , IplMostRunsCSV[].class);
            Assert.assertEquals("Rohit Sharma",iplBatsManData[99].player);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostRunCSV_whenSortedOnHighestRun_shouldReturnShortedResult() {

        try {

            iplAnalyser.loadIplMostWicketData(IPL_MOST_RUN_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.loadHighestRunInIpl();
            IplMostRunsCSV[] iplBatsManData = new Gson().fromJson( sortedResult , IplMostRunsCSV[].class);
            Assert.assertEquals("David Warner",iplBatsManData[99].player);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostWicket_whenCountNumberOfRecord_shouldReturnShortedResult() throws IplAnalyserException {

        int numberOfRecord = iplAnalyser.loadIplMostWicketData(IPL_MOST_Wkts_CSV_FILE_PATH);
        Assert.assertEquals(99, numberOfRecord);

    }

    @Test
    public void givenIplMostWicketCSV_whenSortedOnBollingAverage_shouldReturnShortedResult() {

        try {

            iplAnalyser.loadIplMostWicketData(IPL_MOST_Wkts_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.loadSortedOnBollingAverage();
            IplMostWktsCSV[] IplDataCSV = new Gson().fromJson( sortedResult , IplMostWktsCSV[].class);
            Assert.assertEquals(0.0, IplDataCSV[0].average,0.001);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostWktsCSV_whenSortedStrikeRate_shouldReturnShortedResult() {

        try {

            iplAnalyser.loadIplMostWicketData(IPL_MOST_Wkts_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.loadBestStrikeRateOfPlayerFromIplWktsData();
            IplMostWktsCSV[] IplDataCSV = new Gson().fromJson( sortedResult , IplMostWktsCSV[].class);
            Assert.assertEquals("Krishnappa Gowtham", IplDataCSV[98].player);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostWktsCSV_whenSortedBestEconomy_shouldReturnShortedResult() {

        try {

            iplAnalyser.loadIplMostWicketData(IPL_MOST_Wkts_CSV_FILE_PATH);
            String sortedResult = iplAnalyser.loadBesteconomyRateOfPlayerFromIplWktsData();
            IplMostRunsCSV[] iplBatsManData = new Gson().fromJson( sortedResult , IplMostRunsCSV[].class);
            Assert.assertEquals("Ben Cutting", iplBatsManData[98].player);
        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplMostWktsCSV_whenSortedOnBestStriking4W5W_shouldReturnShortedResult() {

        try {

            iplAnalyser.loadIplMostWicketData(IPL_MOST_Wkts_CSV_FILE_PATH);
            String sorted4WResult = iplAnalyser.loadBestFourWckStrikeRateOfPlayerFromIplWktsData();
            String sorted5WResult = iplAnalyser.loadBestFiveWcktStrikeRateOfPlayerFromIplWktsData();
            IplMostWktsCSV[] IplDataCSV1 = new Gson().fromJson( sorted4WResult , IplMostWktsCSV[].class);
            IplMostWktsCSV[] IplDataCSV2 = new Gson().fromJson( sorted5WResult , IplMostWktsCSV[].class);

            if (IplDataCSV1[98].strikeRate > IplDataCSV2[98].strikeRate)
            {  Assert.assertEquals("Lasith Malinga", IplDataCSV1[98].player);}
            else
            {  Assert.assertEquals("Alzarri Joseph", IplDataCSV2[98].player);}

        } catch ( IplAnalyserException e) {
            e.printStackTrace();
        }
    }

}
