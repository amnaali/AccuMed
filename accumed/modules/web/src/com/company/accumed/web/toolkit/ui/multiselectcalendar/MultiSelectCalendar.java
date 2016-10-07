package com.company.accumed.web.toolkit.ui.multiselectcalendar;

import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.annotations.JavaScript;
import elemental.json.JsonArray;

@JavaScript({"multiselectcalendar-connector.js", "jquery-ui.js", "jquery.datepick.js"})
@StyleSheet({"jquery-ui.css", "datepick.css"})
public class MultiSelectCalendar extends AbstractJavaScriptComponent {

    @Override
    protected MultiSelectCalendarState getState() {
        return (MultiSelectCalendarState) super.getState();
    }

    public interface ValueChangeListener {
        void valueChanged(String[] newValue);
    }

    private ValueChangeListener listener;

    public MultiSelectCalendar() {
        addFunction("valueChanged", arguments -> {
            JsonArray array = arguments.getArray(0);
            String[] values = new String[array.length()];
            for (int i=0; i<array.length(); i++) {
                values[i] = array.getString(i);
            }
            listener.valueChanged(values);
        });
    }


    public void setValue(String[] value) {
        getState().values = value;
    }

    public String[] getValue() {
        return getState().values;
    }
}