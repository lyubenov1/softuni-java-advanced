package SolidEx.impl.factories;


import SolidEx.interfaces.Appender;
import SolidEx.interfaces.Factory;
import SolidEx.interfaces.Layout;
import SolidEx.enums.ReportLevel;
import SolidEx.impl.appenders.ConsoleAppender;
import SolidEx.impl.appenders.FileAppender;

public class AppenderFactory implements Factory<Appender> {

    private LayoutFactory layoutFactory;

    public AppenderFactory() {
        this.layoutFactory = new LayoutFactory();
    }

    @Override
    public Appender produce(String input) {
        String[] tokens = input.split(" ");

        String appenderType = tokens[0];
        String layoutType = tokens[1];

        Layout layout = layoutFactory.produce(layoutType);
        Appender appender = null;
        if (appenderType.equals("ConsoleAppender")) {
            appender = new ConsoleAppender(layout);
        } else if (appenderType.equals("FileAppender")) {
            appender = new FileAppender(layout);
        }

        if (tokens.length >= 3) {
            appender.setReportLevel(ReportLevel.valueOf(tokens[2]));
        }

        return appender;
    }
}