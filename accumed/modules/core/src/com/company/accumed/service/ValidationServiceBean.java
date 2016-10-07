package com.company.accumed.service;

import com.company.accumed.entity.ClaimLine;
import org.springframework.stereotype.Service;

@Service(ValidationService.NAME)
public class ValidationServiceBean implements ValidationService {

    @Override
    public boolean validateServiceCode(ClaimLine cl) {
        return false;
    }
}