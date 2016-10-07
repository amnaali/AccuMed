package com.company.accumed.web.toolkit.ui.datepick;

import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.ui.Button;
import com.vaadin.annotations.JavaScript;
import elemental.json.JsonArray;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@JavaScript({"datepick-connector.js","jquery.min.js","jquery.plugin.js","jquery.datepick.js"})
@StyleSheet({"jquery.datepick.css"})
public class DatepickServerComponent extends AbstractJavaScriptComponent {

    private static SimpleDateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    private static SimpleDateFormat targetFormat = new SimpleDateFormat("MM/dd/yyyy");

    public interface PickerCloseListener {
        void pickerClosed(String[] newDates);
    }

    private PickerCloseListener listener;
    public DatepickServerComponent() {
        addFunction("pickerClosed", arguments -> {
        JsonArray array = arguments.getArray(0);
        String[] dates = new String[array.length()];
        for (int i=0;i<array.length();i++)   {
            dates[i]=array.getString(i);
        }
        listener.pickerClosed(dates);
    });
    }

    @Override
    protected DatepickState getState() {
        return (DatepickState) super.getState();
    }

    public PickerCloseListener getListener() {
        return listener;
    }

    public void setListener(PickerCloseListener listener) {
        this.listener = listener;
    }

    public void setStartDate(String startDate) {
        this.getState().startDate = startDate;
    }

    public String getStartDate() {
         return this.getState().startDate;
     }

    public static String simpleFormat(String value) {
         try {
             java.util.Date date = sourceFormat.parse(value);
             return targetFormat.format(date);
         } catch(ParseException e) {
         }
         return "";
    }

    public static java.util.Date parseDate(String value) {
        try {
            return sourceFormat.parse(value);
        } catch(ParseException e) {
        }
        return null;
    }
}
