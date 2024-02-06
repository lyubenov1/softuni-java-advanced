package SolidEx.impl.layouts;

import SolidEx.interfaces.Layout;
import SolidEx.enums.ReportLevel;


public class SimpleLayout implements Layout {
    @Override
    public String format(String time, String message, ReportLevel reportLevel) {
        return String.format("%s - %s - %s", time, reportLevel, message);
    }
}