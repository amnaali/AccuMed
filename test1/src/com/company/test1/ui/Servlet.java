
package com.company.test1.ui;

import javax.servlet.annotation.WebServlet;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.xdev.communication.XdevServlet;

@WebServlet(value = "/*", asyncSupported = true)
@VaadinServletConfiguration(productionMode = false, ui = MainUI.class)
public class Servlet extends XdevServlet {
	public Servlet() {
		super();
	}
}