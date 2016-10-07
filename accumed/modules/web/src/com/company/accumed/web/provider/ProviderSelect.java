package com.company.accumed.web.provider;

import com.company.accumed.entity.Provider;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.security.global.UserSession;

import javax.inject.Inject;
import java.util.Map;

public class ProviderSelect extends AbstractWindow {
    @Inject
    UserSession userSession;

    @Inject
    LookupField selectedProvider;

    @Inject
    Button selectProvider;

    public void selectProvider() {
        if (selectedProvider.getValue() != null) {
            userSession.setAttribute("provider", selectedProvider.getValue());
            //showNotification(selectedProvider.getValue().toString(), NotificationType.HUMANIZED);
            close("providerSelected");
        }
    }

    @Override
    public void init(Map<String, Object> params) {
        selectedProvider.addValueChangeListener(new ValueChangeListener() {
            @Override
            public void valueChanged(ValueChangeEvent e) {
                //userSession.setAttribute("provider", selectedProvider.getValue());
            }
        });
    }
}