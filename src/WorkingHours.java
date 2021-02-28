import java.util.Objects;

public class WorkingHours {
    private int startDate;
    private int stopDate;

    public WorkingHours(int startDate, int stopDate) {
        this.startDate = startDate;
        this.stopDate = stopDate;
    }

    public WorkingHours() {

    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getStopDate() {
        return stopDate;
    }

    public void setStopDate(int stopDate) {
        this.stopDate = stopDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkingHours that = (WorkingHours) o;
        return startDate == that.startDate &&
                stopDate == that.stopDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, stopDate);
    }
}
