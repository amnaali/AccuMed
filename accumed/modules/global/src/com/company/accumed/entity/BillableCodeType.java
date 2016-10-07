package com.company.accumed.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum BillableCodeType implements EnumClass<String> {

    GeneralPhysicianOrSpecialist("General Physician / Specialist"),
    PhysicianAssistant("Physician Assistant"),
    Anesthesiologist("Anesthesiologist");

    private String id;

    BillableCodeType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static BillableCodeType fromId(String id) {
        for (BillableCodeType at : BillableCodeType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}