package com.company.test.web.customer;

import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.test.entity.Customer;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.FieldGroup;
import com.haulmont.cuba.gui.components.VBoxLayout;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.haulmont.cuba.web.gui.components.WebComponentsHelper;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import fi.jasoft.simplecalendar.SimpleCalendar;

import javax.inject.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CustomerEdit extends AbstractEditor<Customer> {
    @Inject
    private ComponentsFactory componentsFactory;
    @Inject
    private FieldGroup fieldGroup;
    
    private SimpleCalendar calendar = new SimpleCalendar();

    @Override
    public void init(Map<String, Object> params) {
        fieldGroup.addCustomField("dates", (datasource, propertyId) -> {
            Component box = componentsFactory.createComponent(VBoxLayout.class);
            Layout layout = (Layout) WebComponentsHelper.unwrap(box);
            layout.addComponent(calendar);
            calendar.setMultiSelect(true);
            calendar.addValueChangeListener(event -> {
                            datasource.getItem().setValue(propertyId, event.getProperty().getValue().toString());
                    }
            );
            return box;
        });
    }

    @Override
    protected void postInit() {
        SimpleDateFormat fmt = new SimpleDateFormat("EEEE MMMM dd HH:mm:ss z yyyy");
        String DateCollectionString = getItem().getDates();
        if (DateCollectionString!=null) {
            String[] strings = DateCollectionString.replace("[", "").replace("]", "").split(", ");
            List<Date> dates = new ArrayList<Date>();
            for (String s : strings) {
                Date d = null;
                try {
                    d = fmt.parse(s);
                    dates.add(d);
                } catch (ParseException e) {
                    e.printStackTrace();
                    Notification.show(e.toString());
                }
            }
            if (dates != null)
                calendar.setValue(dates);
        }
    }
}