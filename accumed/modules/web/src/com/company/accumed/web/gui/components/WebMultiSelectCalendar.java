package com.company.accumed.web.gui.components;

import com.company.accumed.gui.components.MultiSelectCalendar;
import com.haulmont.cuba.web.gui.components.WebAbstractComponent;

public class WebMultiSelectCalendar extends WebAbstractComponent<com.company.accumed.web.toolkit.ui.multiselectcalendar.MultiSelectCalendar> implements MultiSelectCalendar {
    public WebMultiSelectCalendar() {
        this.component = new com.company.accumed.web.toolkit.ui.multiselectcalendar.MultiSelectCalendar();
    }
}