package com.company.accumed.gui.xml.layout.loaders;

import com.company.accumed.gui.components.MultiDate;
import com.haulmont.cuba.gui.xml.layout.loaders.AbstractComponentLoader;

public class MultiDateLoader extends AbstractComponentLoader<MultiDate> {
    @Override
    public void createComponent() {
        resultComponent = factory.createComponent(MultiDate.class);
        loadId(resultComponent, element);
    }

    @Override
    public void loadComponent() {
    }
}
