package com.company.accumed.web.patient;

import com.company.accumed.entity.Facility;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.components.*;
import com.company.accumed.entity.Patient;
import com.company.accumed.entity.Facility;
import com.company.accumed.entity.PatientAdmission;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.util.*;

public class PatientEdit extends AbstractEditor<Patient> {
    @Inject
    protected CollectionDatasource<PatientAdmission, UUID> admissionsDs;

    @Inject
    protected Datasource<Patient> patientDs;

    @Inject
    protected Table pAdmissionTable;

    @Inject
    protected ComponentsFactory componentsFactory;

    @Inject
    protected CollectionDatasource<Facility, UUID> facilityDs;

    @Inject
    private Metadata metadata;

    @Override
    public void init(Map<String, Object> params) {
        pAdmissionTable.addGeneratedColumn("facility", new Table.ColumnGenerator() {
            @Override
            public Component generateCell(Entity entity) {
                LookupPickerField  field = (LookupPickerField ) componentsFactory.createComponent(LookupPickerField.NAME);
                field.setDatasource(pAdmissionTable.getItemDatasource(entity), "facility");
                field.setOptionsDatasource(facilityDs);
                field.setEditable(true);
                field.setId("facility");
                field.addLookupAction();
                field.addOpenAction();
                field.setWidth("300px");
                field.setOptionsDatasource(facilityDs);
                return field;
            }
        });
    }

   public void addAdmission() {
       PatientAdmission admission = metadata.create(PatientAdmission.class);
       admission.setPatient(patientDs.getItem());
       admissionsDs.addItem(admission);
    }


}