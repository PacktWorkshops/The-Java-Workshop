package com.packtpub.reflection;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class IssPosition {
    private String message;
    private long timestamp;

    private LatLong issPosition;

    public String toString() {
        return "message: " + message +
            ", timestamp: " + convertToDate() +
            ", iss_position: " + issPosition.toString();
    }

    // Generated
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty(value="iss_position")
    public LatLong getIssPosition() {

        return issPosition;
    }

    public void setIssPosition(LatLong issPosition) {
        this.issPosition = issPosition;
    }

    public String convertToDate() {
        ZonedDateTime utc =
                Instant.ofEpochMilli(timestamp * 1000L)
                        .atZone(ZoneOffset.UTC);
        return utc.toString();
    }
}
