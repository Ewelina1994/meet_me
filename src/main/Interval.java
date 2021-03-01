package main;

import java.util.Objects;

public class Interval {
    private int startMeet;
    private int stopMeet;

    public Interval(int startMeet, int stopMeet) {
        this.startMeet = startMeet;
        this.stopMeet = stopMeet;
    }


    public int getStartMeet() {
        return startMeet;
    }

    public void setStartMeet(int startMeet) {
        this.startMeet = startMeet;
    }

    public int getStopMeet() {
        return stopMeet;
    }

    public void setStopMeet(int stopMeet) {
        this.stopMeet = stopMeet;
    }

    @Override
    public String toString() {
        return "Interwal{" +
                "startMeet=" + startMeet +
                ", stopMeet=" + stopMeet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval interwal = (Interval) o;
        return startMeet == interwal.startMeet &&
                stopMeet == interwal.stopMeet;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startMeet, stopMeet);
    }
}
