package com.company.accumed.web.toolkit.ui.multidate;

import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.annotations.JavaScript;

@JavaScript({"multidate-connector.js"})
public class MultiDate extends AbstractJavaScriptComponent {
    public MultiDate() {
    }

    @Override
    protected MultiDateState getState() {
        return (MultiDateState) super.getState();
    }
}