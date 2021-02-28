import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindGeneralWorkingHoursForEveryone {
    private WorkingHours workingHours;

    public FindGeneralWorkingHoursForEveryone(List<WorkingHours> allWorkingHours) {
        workingHours = findStartTimeAndStopTime(allWorkingHours);
        roundDatesToHalfAnHour();
    }

    private WorkingHours findStartTimeAndStopTime(List<WorkingHours> workingHoursList) {
        List<Integer> startList = workingHoursList.stream().map(h -> h.getStartDate()).collect(Collectors.toList());
        List<Integer> stopList = workingHoursList.stream().map(h -> h.getStopDate()).collect(Collectors.toList());

        Collections.reverse(startList);
        Collections.sort(stopList);

        WorkingHours generalWorkingHours = new WorkingHours(startList.get(0), stopList.get(0));
        return generalWorkingHours;
    }

    private void roundDatesToHalfAnHour() {
        workingHours.setStartDate(roundOff(workingHours.getStartDate(), true));
        workingHours.setStopDate(roundOff(workingHours.getStopDate(), false));
    }

    public int roundOff(int date, boolean isStartWorkDate) {
        if (date >= 1000 && date <= 2400) {
            int hour = date / 100;
            int min = date % 100;
            String s1, s2, s;
            if (min > 0 && min <= 30) {
                s1 = Integer.toString(hour);
                if (isStartWorkDate) {
                    s2 = "30";
                } else {
                    s2 = "00";
                }
                s = s1 + s2;
                return Integer.parseInt(s);
            } else if (min > 30 && min < 59) {
                s1 = Integer.toString(hour + 1);
                if (isStartWorkDate) {
                    s2 = "00";
                } else {
                    s2 = "30";
                }

                s = s1 + s2;
                return Integer.parseInt(s);
            }
        } else {
            System.out.println("bad time");
        }
        return date;
    }

    public WorkingHours getWorkingHours() {
        return workingHours;
    }
}
