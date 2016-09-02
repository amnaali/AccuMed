package com.company.accumed.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum ClaimType implements EnumClass<Integer> {

    HCP_P(1),
    HCP_S(2),
    RMB(3),
    WCB(4),
    Direct(5),
    ThirdParty(6);

    private Integer id;

    ClaimType(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static ClaimType fromId(Integer id) {
        for (ClaimType at : ClaimType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}