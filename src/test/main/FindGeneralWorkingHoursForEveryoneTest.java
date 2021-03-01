package main;

import main.FindGeneralWorkingHoursForEveryone;
import main.WorkingHours;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FindGeneralWorkingHoursForEveryoneTest {
    FindGeneralWorkingHoursForEveryone findGeneralWorkingHoursForEveryone;
    List<WorkingHours> listWorkingHours;

    @Before
    public void initialize() {
        WorkingHours workingHours = new WorkingHours(1005, 1755);
        WorkingHours workingHours2 = new WorkingHours(959, 1601);
        listWorkingHours = new ArrayList<>();
        listWorkingHours.add(workingHours);
        listWorkingHours.add(workingHours2);
        findGeneralWorkingHoursForEveryone = new FindGeneralWorkingHoursForEveryone(listWorkingHours);
    }

    @Test
    public void roundOffTestMethod() {
        Assert.assertEquals(1030, findGeneralWorkingHoursForEveryone.roundOff(1005, true));
        Assert.assertEquals(1730, findGeneralWorkingHoursForEveryone.roundOff(1755, false));
        Assert.assertEquals(1000, findGeneralWorkingHoursForEveryone.roundOff(959, true));
        Assert.assertEquals(1600, findGeneralWorkingHoursForEveryone.roundOff(1601, false));
    }

    @Test
    public void findStartTimeAndStopTimeTest() {
        Assert.assertEquals(new WorkingHours(1005, 1601), findGeneralWorkingHoursForEveryone.findStartTimeAndStopTime(listWorkingHours));
    }

    @Test
    public void findStartTimeAndStopTimeTestNotAssert() {
        Assert.assertNotEquals(new WorkingHours(959, 1601), findGeneralWorkingHoursForEveryone.findStartTimeAndStopTime(listWorkingHours));
    }


}
