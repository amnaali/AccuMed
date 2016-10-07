package com.company.accumed.web.servicecoderule;

import com.company.accumed.entity.ServiceCodeRule;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.actions.CreateAction;
import com.haulmont.cuba.gui.components.actions.EditAction;
import com.haulmont.cuba.gui.components.actions.RemoveAction;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.gui.data.DataSupplier;
import com.haulmont.cuba.gui.data.Datasource;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

public class ServiceCodeRuleBrowse extends AbstractLookup {

    @Inject
    private CollectionDatasource<ServiceCodeRule, UUID> serviceCodeRulesDs;

    @Inject
    private Datasource<ServiceCodeRule> serviceCodeRuleDs;

    @Inject
    private Table<ServiceCodeRule> serviceCodeRulesTable;

    @Inject
    private BoxLayout lookupBox;

    @Inject
    private BoxLayout actionsPane;

    @Named("serviceCodeRulesTable.remove")
    private RemoveAction serviceCodeRulesTableRemove;
    
    @Inject
    private DataSupplier dataSupplier;

    @Inject
    private TextField ruleName;

    @Inject
    LookupField ruleOperator;

    @Inject
    LookupField propertyName;

    private String[] operators = {"=", "<>", ">=", "<=", "Exists", "Not Exists"};
    private String[] properties =  {"patientGender","manualReview","patientAge","diagnosticCode","referringDoctor",
            "facilityNumber","admitDate"};

    private boolean creating;

    @Override
    public void init(Map<String, Object> params) {
        propertyName.setOptionsList(Arrays.asList(properties));
        ruleOperator.setOptionsList(Arrays.asList(operators));

        serviceCodeRulesDs.addItemChangeListener(e -> {
            if (e.getItem() != null) {
                ServiceCodeRule reloadedItem = dataSupplier.reload(e.getDs().getItem(), serviceCodeRuleDs.getView());
                serviceCodeRuleDs.setItem(reloadedItem);
            }
        });
        
        serviceCodeRulesTable.addAction(new CreateAction(serviceCodeRulesTable) {
            @Override
            protected void internalOpenEditor(CollectionDatasource datasource, Entity newItem, Datasource parentDs, Map<String, Object> params) {
                serviceCodeRulesTable.setSelected(Collections.emptyList());
                serviceCodeRuleDs.setItem((ServiceCodeRule) newItem);
                enableEditControls(true);
            }
        });

        serviceCodeRulesTable.addAction(new EditAction(serviceCodeRulesTable) {
            @Override
            protected void internalOpenEditor(CollectionDatasource datasource, Entity existingItem, Datasource parentDs, Map<String, Object> params) {
                if (serviceCodeRulesTable.getSelected().size() == 1) {
                    enableEditControls(false);
                }
            }
        });
        
        serviceCodeRulesTableRemove.setAfterRemoveHandler(removedItems -> serviceCodeRuleDs.setItem(null));
        
        disableEditControls();
    }

    public void save() {
        getDsContext().commit();

        ServiceCodeRule editedItem = serviceCodeRuleDs.getItem();
        if (creating) {
            serviceCodeRulesDs.includeItem(editedItem);
        } else {
            serviceCodeRulesDs.updateItem(editedItem);
        }
        serviceCodeRulesTable.setSelected(editedItem);

        disableEditControls();
    }

    public void cancel() {
        ServiceCodeRule selectedItem = serviceCodeRulesDs.getItem();
        if (selectedItem != null) {
            ServiceCodeRule reloadedItem = dataSupplier.reload(selectedItem, serviceCodeRuleDs.getView());
            serviceCodeRulesDs.setItem(reloadedItem);
        } else {
            serviceCodeRuleDs.setItem(null);
        }

        disableEditControls();
    }

    private void enableEditControls(boolean creating) {
        this.creating = creating;
        initEditComponents(true);
        ruleName.requestFocus();
    }

    private void disableEditControls() {
        initEditComponents(false);
        serviceCodeRulesTable.requestFocus();
    }

    private void initEditComponents(boolean enabled) {
        //ruleN.setEditable(enabled);
        actionsPane.setVisible(enabled);
        lookupBox.setEnabled(!enabled);
    }
}