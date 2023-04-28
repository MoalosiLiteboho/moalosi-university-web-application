package com.moalosi.id;

import java.util.Calendar;
import java.util.function.Supplier;

public class IdGenerator implements Supplier<Integer> {
    public Integer get() {
        Calendar calendar = Calendar.getInstance();
        return Integer.parseInt(
                String.valueOf(calendar.get(Calendar.MONTH))
                        + calendar.get(Calendar.DAY_OF_MONTH)
                        + calendar.get(Calendar.HOUR_OF_DAY)
                        + calendar.get(Calendar.MINUTE)
                        + calendar.get(Calendar.SECOND)
        );
    }
}