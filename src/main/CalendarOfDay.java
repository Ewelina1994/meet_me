package main;

import java.util.List;
import java.util.Objects;

public class CalendarOfDay {
    private WorkingHours workingHours;
    private List<Interval> intervalList;

    public CalendarOfDay(WorkingHours workingHours, List<Interval> meetsMap) {
        this.workingHours = workingHours;
        this.intervalList = meetsMap;
    }

    public WorkingHours getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(WorkingHours workingHours) {
        this.workingHours = workingHours;
    }

    public List<Interval> getIntervalList() {
        return intervalList;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalendarOfDay that = (CalendarOfDay) o;
        return Objects.equals(workingHours, that.workingHours) &&
                Objects.equals(intervalList, that.intervalList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workingHours, intervalList);
    }
}
