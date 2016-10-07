com_company_accumed_web_toolkit_ui_datepick_DatepickServerComponent = function() {
 var connector = this;
    var element = connector.getElement();
    var state = connector.getState();
    $(element).html("<input type=\"hidden\" id=\"d1\">");
    var datepicker = $('#d1', element).datepick({
            multiSelect: 999,
            dateFormat: 'mm/dd/yyyy',
            defaultDate : state.startDate,
            onClose: function(dates) {
                connector.pickerClosed(dates);
            },
            showTrigger: '<button type="button">...</button>'
        });
}

/*com_company_widgets_web_toolkit_ui_datepick_DatepickServerComponent = function() {
 var connector = this;
    var element = connector.getElement();
    var state = connector.getState();
    $(element).html("<input type=\"text\" id=\"d1\">");
    var datepicker = $('#d1', element).datepick({
            multiSelect: 999,
            dateFormat: 'mm/dd/yyyy',
            defaultDate : state.startDate,
            onClose: function(dates) {
                connector.pickerClosed(dates);
            },
            icons: {
                 primary: "ui-icon-calendar"
            },
             showOn: "button",
             buttonImage: "calendar.gif",
             buttonImageOnly: true
        });
}*/