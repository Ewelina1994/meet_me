import java.util.*;
import java.util.stream.Collectors;

public class MainClass {
    private static List<CalendarOfDay> allCalendar;
    private static Map<Integer, Boolean> allDaysMap;

    public static void main(String[] args) {
        //initial data
        allCalendar = new InitializeDate().getAllCalendar();
        //give all WorkingHours for all callendarsOfDay
        List<WorkingHours> allWorkingHours = allCalendar.stream().map(calendarOfDay -> calendarOfDay.getWorkingHours()).collect(Collectors.toList());
        //give start and stop dates for analysis
        WorkingHours startTimeAndStopTime = new FindGeneralWorkingHoursForEveryone(allWorkingHours).getWorkingHours();
        //initialize the hours from start to stop with true value, i.e. available hours until the meeting
        initialAllDayCalendar(startTimeAndStopTime);
        //go through all people and change the hours to false when they have an appointment
        Map<Integer, Boolean> integerBooleanMap = setAllDayCalendarNotFreeHoursToFalse(allCalendar);
        //extract available hours for meeting
        extractAvailableDatesFromAllDay(integerBooleanMap);
    }

    private static void extractAvailableDatesFromAllDay(Map<Integer, Boolean> mapAllHoursInDay) {
        Map<Integer, Integer> result = new TreeMap<>();

        Set<Integer> keys = mapAllHoursInDay.keySet();
        List<Integer> listKeys = new ArrayList<Integer>(keys);
        boolean czyJuzRozpoczeteNoweSpotkanie = false;
        int startIndex = 0;
        int stopIndex = 0;
        for (Map.Entry<Integer, Boolean> entry : mapAllHoursInDay.entrySet()) {
            if (entry.getValue()) {
                if (!czyJuzRozpoczeteNoweSpotkanie) {
                    //startIndex= listKeys.indexOf(entry.getKey());
                    startIndex = entry.getKey();
                    czyJuzRozpoczeteNoweSpotkanie = true;
                }
                stopIndex = entry.getKey();
                if (listKeys.indexOf(entry.getKey()) == mapAllHoursInDay.size() - 1) {
                    result.put(startIndex, stopIndex);
                }
            } else {
                if (czyJuzRozpoczeteNoweSpotkanie) {
                    result.put(startIndex, stopIndex);
                }
                czyJuzRozpoczeteNoweSpotkanie = false;
            }
        }
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
        }
    }

    private static Map<Integer, Boolean> setAllDayCalendarNotFreeHoursToFalse(List<CalendarOfDay> allCalendar) {
        for (CalendarOfDay onCallender : allCalendar) {
            Map<Integer, Integer> meetsMap = onCallender.getMeetsMap();
            for (Map.Entry<Integer, Integer> entry : meetsMap.entrySet())
                for (Map.Entry<Integer, Boolean> mapDay : allDaysMap.entrySet()) {
                    if ((mapDay.getKey() > entry.getKey() && mapDay.getKey() < entry.getValue()) || (meetsMap.containsKey(mapDay.getKey()) && meetsMap.containsValue(mapDay.getKey()))) {
                        mapDay.setValue(false);
                    }
                    if (mapDay.getKey() > entry.getValue()) {
                        break;
                    }
                }
        }
        System.out.println(allDaysMap);
        return allDaysMap;
    }


    private static void initialAllDayCalendar(WorkingHours startTimeAndStopTime) {
        System.out.println(startTimeAndStopTime.getStopDate());
        allDaysMap = new TreeMap<>();
        int h;
        int data = startTimeAndStopTime.getStartDate();
        String s, s1, s2;
        h = data / 100;

        allDaysMap.put(data, true);
        while (data < startTimeAndStopTime.getStopDate()) {
            if (data % 100 == 0) {
                s1 = String.valueOf(h);
                s2 = "30";
                s = s1 + s2;
                data = Integer.parseInt(s);
                allDaysMap.put(data, true);
            } else {
                h++;
                s1 = String.valueOf(h);
                s2 = "00";
                s = s1 + s2;
                data = Integer.parseInt(s);
                allDaysMap.put(data, true);
            }
        }

    }


}
