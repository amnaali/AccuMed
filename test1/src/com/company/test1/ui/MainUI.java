
package com.company.test1.ui;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.xdev.security.authentication.ui.XdevAuthenticationNavigator;
import com.xdev.ui.XdevUI;

@Push
@Theme("test1")
public class MainUI extends XdevUI {
	public MainUI() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(VaadinRequest request) {
		this.initUI();
	}

	/*
	 * WARNING: Do NOT edit!<br>The content of this method is always regenerated
	 * by the UI designer.
	 */
	// <generated-code name="initUI">
	private void initUI() {
		this.navigator = new XdevAuthenticationNavigator(this, this);
	
		this.navigator.setRedirectViewName("home");
		this.navigator.addView("", AuthView.class);
		this.navigator.addView("home", HomeView.class);
	
		this.setSizeFull();
	} // </generated-code>

	// <generated-code name="variables">
	private XdevAuthenticationNavigator navigator; // </generated-code>
	
}