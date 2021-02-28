import java.util.*;

public class InitializeDate {
    private List<CalendarOfDay> allCalendar;
    public InitializeDate() {
        initial();
    }

    private void initial() {
        allCalendar= new ArrayList<>();
        WorkingHours workingHoursClientFirst = new WorkingHours(900, 1955);
        Map<Integer, Integer> meetsFurClientFirst= new HashMap<>();
        meetsFurClientFirst.put(900, 1030);
        meetsFurClientFirst.put(1200, 1300);
        meetsFurClientFirst.put(1600, 1800);
        CalendarOfDay clientFirst = new CalendarOfDay(workingHoursClientFirst,meetsFurClientFirst);

        allCalendar.add(clientFirst);

        WorkingHours workingHoursClientSecond = new WorkingHours(1000, 1830);
        Map<Integer, Integer>meetsFurClientSecond= new HashMap<>();
        meetsFurClientSecond.put(1000, 1130);
        meetsFurClientSecond.put(1230, 1430);
        meetsFurClientSecond.put(1430, 1500);
        meetsFurClientSecond.put(1600, 1700);
        CalendarOfDay clientSecond = new CalendarOfDay(workingHoursClientSecond,meetsFurClientSecond);

        allCalendar.add(clientSecond);
    }

    public List<CalendarOfDay> getAllCalendar() {
        return allCalendar;
    }
}
