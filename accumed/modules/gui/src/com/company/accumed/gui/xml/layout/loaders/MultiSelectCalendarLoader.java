package com.company.accumed.gui.xml.layout.loaders;

import com.company.accumed.gui.components.MultiSelectCalendar;
import com.haulmont.cuba.gui.xml.layout.loaders.AbstractComponentLoader;

public class MultiSelectCalendarLoader extends AbstractComponentLoader<MultiSelectCalendar> {
    @Override
    public void createComponent() {
        resultComponent = factory.createComponent(MultiSelectCalendar.class);
        loadId(resultComponent, element);
    }

    @Override
    public void loadComponent() {
    }
}
