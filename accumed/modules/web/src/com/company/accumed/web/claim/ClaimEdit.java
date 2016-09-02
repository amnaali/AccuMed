package com.company.accumed.web.claim;

import com.company.accumed.entity.ClaimLine;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.accumed.entity.Claim;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.Datasource;

import javax.inject.Inject;
import java.util.UUID;

public class ClaimEdit extends AbstractEditor<Claim> {
    @Inject
    protected CollectionDatasource<ClaimLine, UUID> claimLineDs;

    @Inject
    protected Datasource<Claim> claimDs;

    @Inject
    private Metadata metadata;

    public void addClaimLine() {
        ClaimLine cl = metadata.create(ClaimLine.class);
        cl.setClaim(claimDs.getItem());
        claimLineDs.addItem(cl);
    }
}