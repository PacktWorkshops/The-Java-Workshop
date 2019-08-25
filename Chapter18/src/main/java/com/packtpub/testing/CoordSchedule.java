package com.packtpub.testing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class CoordSchedule {
    public static final int MAX_FREQUENCY = 1440;
    public static final int MIN_FREQUENCY = 5;

    private String startingTimestamp;
    private String endingTimestamp;
    private int frequency;

    public CoordSchedule(String startingTimestamp, String endingTimestamp, int frequency) {
        this.startingTimestamp = startingTimestamp;
        this.endingTimestamp = endingTimestamp;
        this.frequency = frequency;
    }


    public String getStartingTimestamp() {
        return startingTimestamp;
    }

    public void setStartingTimestamp(String startingTimestamp) {
        this.startingTimestamp = startingTimestamp;
    }

    public String getEndingTimestamp() {
        return endingTimestamp;
    }

    public void setEndingTimestamp(String endingTimestamp) {
        this.endingTimestamp = endingTimestamp;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Date getStartingTimestampAsDate() {
        return parseTimestamp(startingTimestamp);
    }

    public Date getEndingTimestampAsDate() {
        return parseTimestamp(endingTimestamp);
    }

    private Date parseTimestamp(String timestamp) {
        Date date = null;
        SimpleDateFormat format =
                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'",
                        Locale.getDefault());

        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            date = format.parse(timestamp);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
}
