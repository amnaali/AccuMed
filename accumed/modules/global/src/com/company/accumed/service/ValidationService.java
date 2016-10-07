package com.company.accumed.service;


import com.company.accumed.entity.ClaimLine;

public interface ValidationService {
    String NAME = "accumed_ValidationService";
    public boolean validateServiceCode(ClaimLine cl);
}