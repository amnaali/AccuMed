package com.company.accumed.web.servicecode;

import com.company.accumed.entity.BillableCodeType;
import com.company.accumed.entity.BillableServiceCode;
import com.company.accumed.entity.ServiceCodeRule;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.components.*;
import com.company.accumed.entity.ServiceCode;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.Datasource;
import org.apache.commons.lang.StringUtils;

import javax.inject.Inject;
import java.util.Map;
import java.util.UUID;

public class ServiceCodeEdit extends AbstractEditor<ServiceCode> {
    @Inject
    private Metadata metadata;

    @Inject
    private Datasource<ServiceCode> serviceCodeDs;

    @Inject
    private TextField serviceCode;

    @Inject CollectionDatasource<BillableServiceCode, UUID> billableCodesDs;


    @Override
    public void init(Map<String, Object> params) {


    }

    private boolean billableCodeExists(String code) {
        for (BillableServiceCode item : billableCodesDs.getItems()) {
            if (item.getBillableCode().equals(code)) {
                return true;
            }
        }
        return false;
    }

    private void addNewBillableCode(String code,  BillableCodeType codeType) {
        BillableServiceCode billableCode = metadata.create(BillableServiceCode.class);
        billableCode.setServiceCode(serviceCodeDs.getItem());
        billableCode.setBillableCode(code);
        billableCode.setCodeType(codeType);
        billableCode.setUnits(1.0);
        billableCodesDs.addItem(billableCode);
    }

    private void addBillableCode(String suffix, BillableCodeType codeType) {
        String serviceCode = serviceCodeDs.getItem().getServiceCode();
        if (StringUtils.isNotBlank(serviceCode) && !billableCodeExists(serviceCode+suffix)) {
            addNewBillableCode(serviceCode + suffix, codeType);
        }
    }

    public void addPhysicianOrSpecialist(Component source) {
        this.addBillableCode("A", BillableCodeType.GeneralPhysicianOrSpecialist);
    }

    public void addPhysicianAssistant(Component source) {
        this.addBillableCode("A", BillableCodeType.GeneralPhysicianOrSpecialist);
        this.addBillableCode("B", BillableCodeType.PhysicianAssistant);
    }

    public void addAnesthesiologist(Component source) {
        this.addBillableCode("C", BillableCodeType.Anesthesiologist);
    }
}