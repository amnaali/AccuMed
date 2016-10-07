package com.company.accumed.web.claim;

import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.FieldGroup;
import com.haulmont.cuba.gui.components.VBoxLayout;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.haulmont.cuba.web.gui.components.WebComponentsHelper;
import com.vaadin.ui.Layout;
import fi.jasoft.simplecalendar.SimpleCalendar;

import javax.inject.Inject;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;

public class Calendar extends AbstractWindow {
    public Date[] d = new Date[0];
    private SimpleCalendar calendar = new SimpleCalendar();

    @Inject
    private FieldGroup fieldGroup;

    @Inject
    private ComponentsFactory componentsFactory;

    @Override
    public void init(Map<String, Object> params) {
        getDialogOptions().setForceDialog(true);
        getDialogOptions().setWidth(255);
        getDialogOptions().setCloseable(true);
        fieldGroup.addCustomField("dates", (datasource, propertyId) -> {
            Component box = componentsFactory.createComponent(VBoxLayout.class);
            Layout layout = (Layout) WebComponentsHelper.unwrap(box);
            layout.addComponent(calendar);
            calendar.setMultiSelect(true);
            calendar.addValueChangeListener(event -> {
                HashSet<Date> s = (HashSet<Date>) event.getProperty().getValue();
                d = new Date[s.size()];
                d = s.toArray(d);
            });
            return box;
        });

    }

    public void cancelaction(Component source) {
        this.close(CLOSE_ACTION_ID);
    }

    public void okaction(Component source) {
        this.close(COMMIT_ACTION_ID);
    }
}