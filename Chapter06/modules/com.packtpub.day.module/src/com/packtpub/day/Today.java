package com.packtpub.day;

import java.time.LocalDate;

public class Today {
    public String getToday() {
        return LocalDate.now().getDayOfWeek().toString();
    }
}
