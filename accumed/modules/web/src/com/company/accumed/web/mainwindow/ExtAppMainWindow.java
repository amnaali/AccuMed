package com.company.accumed.web.mainwindow;

import com.company.accumed.entity.ClaimLine;
import com.company.accumed.entity.Provider;
import com.company.accumed.web.provider.ProviderSelect;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.security.global.UserSession;
import com.haulmont.cuba.web.app.mainwindow.AppMainWindow;

import javax.inject.Inject;
import java.util.Map;

public class ExtAppMainWindow extends AppMainWindow {
    @Inject
    UserSession userSession;

    @Inject
    Label currentProvider;

    @Inject
    LookupField selectedProvider;


    public void providerSelected() {
        if (selectedProvider.getValue() != null) {
            userSession.setAttribute("provider", selectedProvider.getValue());
        }
    }

    @Override
    public void init(Map<String, Object> params) {
        selectedProvider.addValueChangeListener(new ValueChangeListener() {
            @Override
            public void valueChanged(ValueChangeEvent e) {
                providerSelected();
            }
        });
    }
}
