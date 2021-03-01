package main;

import java.util.*;

public class InitializeDate {
    private List<CalendarOfDay> allCalendar;

    public InitializeDate() {
        initial();
    }

    private void initial() {
        allCalendar = new ArrayList<>();
        WorkingHours workingHoursClientFirst = new WorkingHours(900, 1955);
        List<Interval> meetsFurClientFirst = new ArrayList<>();
        meetsFurClientFirst.add(new Interval(900, 1030));
        meetsFurClientFirst.add(new Interval(1200, 1300));
        meetsFurClientFirst.add(new Interval(1600, 1800));
        CalendarOfDay clientFirst = new CalendarOfDay(workingHoursClientFirst, meetsFurClientFirst);

        allCalendar.add(clientFirst);

        WorkingHours workingHoursClientSecond = new WorkingHours(1000, 1830);
        List<Interval> meetsFurClientSecond = new ArrayList<>();
        meetsFurClientSecond.add(new Interval(1000, 1130));
        meetsFurClientSecond.add(new Interval(1230, 1430));
        meetsFurClientSecond.add(new Interval(1430, 1500));
        meetsFurClientSecond.add(new Interval(1600, 1700));
        CalendarOfDay clientSecond = new CalendarOfDay(workingHoursClientSecond, meetsFurClientSecond);

        allCalendar.add(clientSecond);

    }

    public List<CalendarOfDay> getAllCalendar() {
        return allCalendar;
    }
}
