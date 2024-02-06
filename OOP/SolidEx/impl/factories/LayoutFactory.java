package SolidEx.impl.factories;

import SolidEx.interfaces.Factory;
import SolidEx.interfaces.Layout;
import SolidEx.impl.layouts.SimpleLayout;
import SolidEx.impl.layouts.XmlLayout;

public class LayoutFactory implements Factory<Layout> {
    @Override
    public Layout produce(String input) {
        Layout layout = null;

        if(input.equals("SimpleLayout")){
            layout = new SimpleLayout();
        } else if (input.equals("XmlLayout")){
            layout = new XmlLayout();
        }

        return layout;
    }
}