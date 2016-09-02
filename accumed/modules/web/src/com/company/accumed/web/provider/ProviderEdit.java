package com.company.accumed.web.provider;

import com.company.accumed.entity.MinistryOfHealthOffice;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.accumed.entity.Provider;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import java.util.UUID;
import java.util.Map;
import java.util.Iterator;
import java.util.LinkedHashMap;
import javax.inject.Inject;

import javax.inject.Inject;

public class ProviderEdit extends AbstractEditor<Provider> {

    @Inject
    protected LookupField ministryOfHealthOffice;

    @Inject
    protected CollectionDatasource<MinistryOfHealthOffice,UUID> ministryOfHealthOfficeDs;

    @Override
    public void init(Map<String, Object> params) {
        Map<String, Object> map = new LinkedHashMap<>();
        ministryOfHealthOfficeDs.refresh();
        for (Iterator it = ministryOfHealthOfficeDs.getItems().iterator(); it.hasNext(); ) {
            MinistryOfHealthOffice f = (MinistryOfHealthOffice) it.next();
            String code = f.getOfficeCode();
            String name = f.getOfficeCity();
            map.put(name,code);
        }
       ministryOfHealthOffice.setOptionsMap(map);
    }
}