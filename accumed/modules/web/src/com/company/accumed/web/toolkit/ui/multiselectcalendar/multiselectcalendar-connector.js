/* http://keith-wood.name/datepick.html
   Date picker for jQuery v5.0.1.
   Written by Keith Wood (kbwood{at}iinet.com.au) February 2010.
   Licensed under the MIT (http://keith-wood.name/licence.html) licence. 
   Please attribute the author if you use it. */

com_company_accumed_web_toolkit_ui_multiselectcalendar_MultiSelectCalendar = function() {
         var connector = this;
         var element = connector.getElement();
         $(element).html("<div/>");
         $(element).css("padding", "5px 10px");

         var multiSelect = $('#rangePicker').datepick({rangeSelect: true, showTrigger: '#calImg',
                            selected: function(event, ui) {
                                       connector.valueChanged(ui.values);
                            }}

         );

         connector.onStateChange = function() {

         }
}