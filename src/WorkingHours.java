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
}
