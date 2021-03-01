package main;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static main.MainClass.*;

public class MainClassTest {
    private static List<Interval> allInterval;
    private List<Interval> mergeIntervals = new ArrayList<>();

    private WorkingHours startTimeAndStopTime;

    @Before
    public void initialize() {
        allInterval = new ArrayList<>();
        allInterval.add(new Interval(900, 930));
        allInterval.add(new Interval(1200, 1300));
        allInterval.add(new Interval(1000, 1100));
        allInterval.add(new Interval(1200, 1300));


        startTimeAndStopTime = new WorkingHours(930, 1230);

        mergeIntervals = new ArrayList<>();
        mergeIntervals.add(new Interval(900, 930));
        mergeIntervals.add(new Interval(1200, 1300));
        mergeIntervals.add(new Interval(1000, 1100));
        mergeIntervals.add(new Interval(1200, 1300));
    }

    @Test
    public void combineOverlappingIntervalsTest() {
        Assert.assertEquals(mergeIntervals, MainClass.combineOverlappingIntervals(allInterval));

    }

    @Test
    public void checkTheIntervalsBetweenIntervalsTest() {
        List<Interval> result = new ArrayList<>();

        result.add(new Interval(930, 1200));
        result.add(new Interval(1100, 1200));
        Assert.assertEquals(result, MainClass.checkTheIntervalsBetweenIntervals(mergeIntervals));

    }


    @Test
    public void cutTheMeetWhenExceedsGeneralWorkingDayTest() {
        List<Interval> allIntervalCut = new ArrayList<>();
        allIntervalCut.add(new Interval(1000, 1030));
        allIntervalCut.add(new Interval(1100, 1130));
        allIntervalCut.add(new Interval(1130, 1200));
        allIntervalCut.add(new Interval(1000, 1000));
        allIntervalCut.add(new Interval(1100, 1100));
        allIntervalCut.add(new Interval(1100, 1130));
        allIntervalCut.add(new Interval(1200, 1300));
        Assert.assertEquals(allIntervalCut, cutTheMeetWhenExceedsGeneralWorkingDay(allInterval, startTimeAndStopTime));

    }


    @After
    public void clear() {
        allInterval.clear();
        mergeIntervals.clear();
    }

}
