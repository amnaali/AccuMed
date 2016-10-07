package com.company.accumed.web.gui.components;

import com.company.accumed.gui.components.MultiDate;
import com.haulmont.cuba.web.gui.components.WebAbstractComponent;

public class WebMultiDate extends WebAbstractComponent<com.company.accumed.web.toolkit.ui.multidate.MultiDate> implements MultiDate {
    public WebMultiDate() {
        this.component = new com.company.accumed.web.toolkit.ui.multidate.MultiDate();
    }
}