package main;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {
    private static List<CalendarOfDay> allCalendar;
    private static List<Interval> allInterval;

    public static void main(String[] args) {
        //initial data
        allCalendar = new InitializeDate().getAllCalendar();
        //give all main.WorkingHours for all callendarsOfDay
        List<WorkingHours> allWorkingHours = allCalendar.stream().map(calendarOfDay -> calendarOfDay.getWorkingHours()).collect(Collectors.toList());
        //give start and stop dates for analysis
        WorkingHours startTimeAndStopTime = new FindGeneralWorkingHoursForEveryone(allWorkingHours).getWorkingHours();
        //getAllInterwalToOnewList
        allInterval = Stream.concat(allCalendar.get(0).getIntervalList().stream(),
                allCalendar.get(1).getIntervalList().stream())
                .collect(Collectors.toList());

        //if the meeting exceeds the overall working day
        cutTheMeetWhenExceedsGeneralWorkingDay(allInterval, startTimeAndStopTime);
        //add general start Work and stop work to listAllMeets
        allInterval.add(new Interval(startTimeAndStopTime.getStartDate(), startTimeAndStopTime.getStartDate()));
        allInterval.add(new Interval(startTimeAndStopTime.getStopDate(), startTimeAndStopTime.getStopDate()));
        //sort by meeting start date
        Collections.sort(allInterval, (o1, o2) -> o1.getStartMeet() - o2.getStartMeet());

        //merge overlapping intervals
        List<Interval> freeTimeToMeet = combineOverlappingIntervals(allInterval);
        //find distances between intervals
        List<Interval> resultToMeets = checkTheIntervalsBetweenIntervals(freeTimeToMeet);
        System.out.println(resultToMeets);
    }

    public static List<Interval> cutTheMeetWhenExceedsGeneralWorkingDay(List<Interval> allInterval, WorkingHours startTimeAndStopTime) {
        for (Interval interval : allInterval) {
            if (interval.getStartMeet() < startTimeAndStopTime.getStartDate()) {
                interval.setStartMeet(startTimeAndStopTime.getStartDate());
            }
            if (interval.getStopMeet() > startTimeAndStopTime.getStopDate()) {
                interval.setStopMeet(startTimeAndStopTime.getStopDate());
            }
        }
        return allInterval;
    }

    public static List<Interval> checkTheIntervalsBetweenIntervals(List<Interval> intervals) {
        List<Interval> hoursMeeting = new ArrayList<>();
        int start, end;
        for (int i = 0; i < intervals.size() - 1; i++) {
            start = intervals.get(i).getStopMeet();
            end = 0;
            if (start < intervals.get(i + 1).getStartMeet()) {
                end = intervals.get(i + 1).getStartMeet();
            }
            if (end > 0) {
                hoursMeeting.add(new Interval(start, end));
            }
        }
        return hoursMeeting;
    }

    public static List<Interval> combineOverlappingIntervals(List<Interval> allInterval) {
        List<Interval> merged = new ArrayList<>();
        int[] temp = new int[2];
        temp[0] = 0;
        temp[1] = 0;
        for (int i = 0; i < allInterval.size(); i++) {
            if (temp[0] == 0 && temp[1] == 0) {
                temp[0] = allInterval.get(i).getStartMeet();
                temp[1] = allInterval.get(i).getStopMeet();
            }
            if (allInterval.get(i).getStartMeet() >= temp[0] && allInterval.get(i).getStartMeet() <= temp[1]) {
                temp[1] = max(allInterval.get(i).getStopMeet(), temp[1]);
            } else {
                merged.add(new Interval(temp[0], temp[1]));
                temp[0] = allInterval.get(i).getStartMeet();
                temp[1] = allInterval.get(i).getStopMeet();
            }
        }
        merged.add(new Interval(temp[0], temp[1]));
        return merged;
    }

    private static int max(int stopMeet, int i) {
        if (stopMeet > i) {
            return stopMeet;
        } else {
            return i;
        }
    }
}
