import java.util.Map;
import java.util.Objects;

public class CalendarOfDay {
    private WorkingHours workingHours;
    private Map<Integer, Integer> meetsMap;

    public CalendarOfDay(WorkingHours workingHours, Map<Integer, Integer> meetsMap) {
        this.workingHours = workingHours;
        this.meetsMap = meetsMap;
    }

    public WorkingHours getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(WorkingHours workingHours) {
        this.workingHours = workingHours;
    }

    public Map<Integer, Integer> getMeetsMap() {
        return meetsMap;
    }

    public void setMeetsMap(Map<Integer, Integer> meetsMap) {
        this.meetsMap = meetsMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalendarOfDay that = (CalendarOfDay) o;
        return Objects.equals(workingHours, that.workingHours) &&
                Objects.equals(meetsMap, that.meetsMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workingHours, meetsMap);
    }
}
