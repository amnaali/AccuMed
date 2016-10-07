package com.company.accumed.web.claim;

import com.company.accumed.entity.BillableServiceCode;
import com.company.accumed.entity.ClaimLine;
import com.company.accumed.entity.Patient;
import com.company.accumed.web.toolkit.ui.datepick.DatepickServerComponent;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.PersistenceHelper;
import com.haulmont.cuba.gui.components.*;
import com.company.accumed.entity.Claim;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.haulmont.cuba.gui.components.BoxLayout;
import com.haulmont.cuba.gui.components.HBoxLayout;
import com.haulmont.cuba.web.gui.components.WebComponentsHelper;
import com.vaadin.ui.Layout;
import org.apache.commons.lang.StringUtils;
import javax.inject.Inject;
import java.util.*;

public class ClaimEdit extends AbstractEditor<Claim> {
    @Inject
    protected CollectionDatasource<ClaimLine, UUID> claimLineDs;

    @Inject
    protected CollectionDatasource<Patient, UUID> patientsByNamesDs;

    @Inject
    protected CollectionDatasource<Patient, UUID> patientsByBirthDateDs;

    @Inject
    protected CollectionDatasource<Patient, UUID> patientsByIdDs;

    @Inject
    protected Datasource<Claim> claimDs;

    @Inject
    private Metadata metadata;

    @Inject
    protected Table claimLineTable;

    @Inject 
    private BoxLayout dateBox;

    @Inject
    protected Table patientsTable;

    @Inject
    protected Button searchPatients;

    @Inject
    protected TextField byMemberNumber;

    @Inject
    protected TextField byFirstName;

    @Inject
    protected TextField byLastName;

    @Inject
    protected DateField byBirthDate;

    @Inject
    protected ComponentsFactory componentsFactory;

    @Inject
    protected CollectionDatasource<BillableServiceCode, UUID> billableServiceCodesDs;

    @Inject
    protected CollectionDatasource<BillableServiceCode, UUID> quickServiceCodesDs;

    public void refreshPatientList() {
        boolean found = false;
        Map<String, Object> params = new HashMap<>();
        params.put("firstName", "(?i)"+StringUtils.trimToEmpty(byFirstName.getValue()) + "%");
        params.put("lastName", "(?i)"+StringUtils.trimToEmpty(byLastName.getValue()) + "%");
        params.put("memberNumber", "(?i)"+StringUtils.trimToEmpty(byMemberNumber.getValue()) + "%");
        if (byBirthDate.getValue() != null) {
            //showNotification("Adding Birth Date", NotificationType.HUMANIZED);
            params.put("birthDate", byBirthDate.getValue());
            patientsByBirthDateDs.refresh(params);
            found = (patientsByBirthDateDs.getItems().size()>0);
            patientsTable.setDatasource(patientsByBirthDateDs);
        }else {
            patientsByNamesDs.refresh(params);
            found = (patientsByNamesDs.getItems().size()>0);
            patientsTable.setDatasource(patientsByNamesDs);
        }

        patientsTable.refresh();
        if (found) {
            toggleSelect(true);
        }
    }

    private void toggleSelect(boolean enable) {
        patientsTable.getColumn("select").setCollapsed(!enable);
        patientsTable.getColumn("select").setWidth(enable ? 70 : 0);
    }

    private void selectPatient() {
        claimDs.getItem().setPatient((Patient)patientsTable.getSingleSelected());
        loadSinglePatient();
    }

    private void loadSinglePatient() {
        Map<String, Object> params = new HashMap<>();
        params.put("patientId",getItem().getPatient().getId());
        patientsByIdDs.refresh(params);
        patientsTable.setDatasource(patientsByIdDs);
        patientsTable.refresh();
        toggleSelect(false);
    }

    @Override
    public void postInit()  {
        if (!PersistenceHelper.isNew(getItem())) {
            loadSinglePatient();
        }
    }

    @Override
    public void init(Map<String, Object> params) {

        patientsTable.setItemClickAction(patientsTable.getAction("selectPatient"));

        patientsTable.addGeneratedColumn("select", new Table.ColumnGenerator() {
            @Override
            public Component generateCell(Entity entity) {
                CheckBox selected = (CheckBox)componentsFactory.createComponent(CheckBox.NAME);
                selected.addValueChangeListener(new ValueChangeListener() {
                    @Override
                    public void valueChanged(ValueChangeEvent e) {
                        if (Boolean.TRUE.equals(e.getValue())) {
                            selectPatient();
                        }
                    }
                });
                return selected;
            }
        });


        claimLineTable.addGeneratedColumn("serviceDate", new Table.ColumnGenerator() {
            @Override
            public Component generateCell(Entity entity) {
                DatepickServerComponent datepicker = new DatepickServerComponent();
                datepicker.setWidth("192px");
                datepicker.setListener(newValue -> {
                    ClaimLine cl = claimLineDs.getItem();
                    if (newValue.length > 0) {
                        int idx[]={0}; //to work-around the requirement for finals in lambda exprs
                        Arrays.stream(newValue).forEach(val -> { if(cl != null) addClaimLine(cl, datepicker.parseDate(val), idx[0]++);});
                    }
                });
                MaskedField tf = (MaskedField) componentsFactory.createComponent(MaskedField.NAME);
                tf.setWidth("82px");
                tf.setMask("##/##/####");
                tf.addValidator(new com.haulmont.cuba.gui.components.validators.DateValidator());
                tf.setDatasource(claimLineTable.getItemDatasource(entity), "serviceDate");
                HBoxLayout hbox = (HBoxLayout) componentsFactory.createComponent(HBoxLayout.NAME);
                hbox.add(tf);
                ((Layout)WebComponentsHelper.unwrap(hbox)).addComponent(datepicker);
                return hbox;
            }
        });

        claimLineTable.addGeneratedColumn("serviceCode", new Table.ColumnGenerator() {
            @Override
            public Component generateCell(Entity entity) {
                LookupPickerField  field = (LookupPickerField ) componentsFactory.createComponent(LookupPickerField.NAME);
                field.setDatasource(claimLineTable.getItemDatasource(entity), "serviceCode");
               // field.setOptionsDatasource(billableServiceCodesDs);
                field.setOptionsDatasource(quickServiceCodesDs);
                field.setEditable(true);
                field.addOpenAction();
                field.setWidth("140px");
                return field;
            }
        });

        /* claimLineTable.addGeneratedColumn("dates", new Table.ColumnGenerator() {
            @Override
            public Component generateCell(Entity entity) {
                Button field = (Button) componentsFactory.createComponent(Button.NAME);
                field.setId("dates");
                field.setCaption("...");
                field.setAction(new BaseAction("openPopUp") {
                    @Override
                    public void actionPerform(Component component) {
                        Calendar window = (Calendar) openWindow("calendar", WindowManager.OpenType.DIALOG);
                        window.addCloseWithCommitListener(() -> {
                            for (Date date: window.d){
                                ClaimLine cl = claimLineDs.getItem();
                                cl.setServiceDate(date);
                                addClaimLine(cl);
                            }
                        });
                    }});
                return field;
            }
        });*/

    }

    public void addClaimLine() {
        ClaimLine cl = metadata.create(ClaimLine.class);
        cl.setClaim(claimDs.getItem());
        claimLineDs.addItem(cl);
    }

    public void addClaimLine(ClaimLine cl1, java.util.Date serviceDate, int idx) {
        if (idx == 0 && cl1 != null) {
            cl1.setServiceDate(serviceDate);  //if its the current line, just update the date
        } else if (cl1.getServiceCode() != null){
            ClaimLine cl = metadata.create(ClaimLine.class);
            cl.setServiceCode(cl1.getServiceCode());
            cl.setDiagnosticCode(cl1.getDiagnosticCode());
            cl.setNoOfServices(cl1.getNoOfServices());
            cl.setFee(cl1.getFee());
            cl.setServiceDate(serviceDate);
            cl.setClaim(claimDs.getItem());
            claimLineDs.addItem(cl);
        }
    }
}
       