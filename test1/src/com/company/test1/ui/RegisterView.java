
package com.company.test1.ui;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.company.test1.dal.UserloginDAO;
import com.company.test1.entities.Userlogin;
import com.vaadin.data.Validator;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.event.ShortcutAction;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Notification;
import com.xdev.ui.XdevButton;
import com.xdev.ui.XdevGridLayout;
import com.xdev.ui.XdevPanel;
import com.xdev.ui.XdevPasswordField;
import com.xdev.ui.XdevTextField;
import com.xdev.ui.XdevView;
public class RegisterView extends XdevView implements com.xdev.security.authentication.ui.LoginView {

	/**
	 * 
	 */
	public RegisterView() {
		super();
		this.initUI();
		this.txtPassword2.addValidator(new Validator() {
			@Override
			public void validate(Object value) throws InvalidValueException {				
				String password = (String) value;
				if (!password.equals(txtPassword.getValue())) {
					throw new InvalidValueException("Passwords must match!");
				}
			}
		});
	}

	@Override
	public String getPassword() {
		return txtPassword.getValue();
	}

	@Override
	public String getUsername() {
		return txtUsername.getValue();
	}

	/**
	 * Event handler delegate method for the {@link XdevButton}
	 * {@link #cmdLogin}.
	 * @throws NoSuchAlgorithmException 
	 *
	 * @see Button.ClickListener#buttonClick(Button.ClickEvent)
	 * @eventHandlerDelegate
	 */
	private void cmdLogin_buttonClick(Button.ClickEvent event) {
		try{
			byte[] hashedPassword = hash(getPassword());
			Userlogin u = new Userlogin(getUsername(), hashedPassword);
			new UserloginDAO().save(u);	
			Notification.show("Saved!");
		}
		catch (NoSuchAlgorithmException e){
			Notification.show("Password could not be hashed!");
		}
	}
	public byte[] hash(String password) throws NoSuchAlgorithmException {
	    MessageDigest sha256 = MessageDigest.getInstance("SHA-256");        
	    byte[] passBytes = password.getBytes();
	    byte[] passHash = sha256.digest(passBytes);
	    return passHash;
	}
	
	/*
	 * WARNING: Do NOT edit!<br>The content of this method is always regenerated
	 * by the UI designer.
	 */
	// <generated-code name="initUI">
	private void initUI() {
		this.gridLayout = new XdevGridLayout();
		this.panel = new XdevPanel();
		this.gridLayout2 = new XdevGridLayout();
		this.txtUsername = new XdevTextField();
		this.txtPassword = new XdevPasswordField();
		this.txtPassword2 = new XdevPasswordField();
		this.cmdLogin = new XdevButton();
	
		this.panel.setCaption("Register");
		this.panel.setTabIndex(0);
		this.txtUsername.setCaption("Email");
		this.txtUsername.addValidator(new EmailValidator("Please enter correct email address"));
		this.txtPassword.setCaption("Password");
		this.txtPassword2.setColumns(20);
		this.txtPassword2.setCaption("Confirm Password");
		this.txtPassword2.setPersistValue(true);
		this.cmdLogin.setCaption("Register");
		this.cmdLogin.addStyleName("friendly");
		this.cmdLogin.setClickShortcut(ShortcutAction.KeyCode.ENTER);
	
		this.gridLayout2.setColumns(1);
		this.gridLayout2.setRows(5);
		this.txtUsername.setSizeUndefined();
		this.gridLayout2.addComponent(this.txtUsername, 0, 0);
		this.txtPassword.setSizeUndefined();
		this.gridLayout2.addComponent(this.txtPassword, 0, 1);
		this.txtPassword2.setSizeUndefined();
		this.gridLayout2.addComponent(this.txtPassword2, 0, 2);
		this.cmdLogin.setSizeUndefined();
		this.gridLayout2.addComponent(this.cmdLogin, 0, 3);
		this.gridLayout2.setComponentAlignment(this.cmdLogin, Alignment.MIDDLE_RIGHT);
		this.gridLayout2.setColumnExpandRatio(0, 0.1F);
		CustomComponent gridLayout2_vSpacer = new CustomComponent();
		gridLayout2_vSpacer.setSizeFull();
		this.gridLayout2.addComponent(gridLayout2_vSpacer, 0, 4, 0, 4);
		this.gridLayout2.setRowExpandRatio(4, 1.0F);
		this.gridLayout2.setSizeFull();
		this.panel.setContent(this.gridLayout2);
		this.gridLayout.setColumns(1);
		this.gridLayout.setRows(1);
		this.panel.setSizeUndefined();
		this.gridLayout.addComponent(this.panel, 0, 0);
		this.gridLayout.setComponentAlignment(this.panel, Alignment.MIDDLE_CENTER);
		this.gridLayout.setColumnExpandRatio(0, 0.1F);
		this.gridLayout.setRowExpandRatio(0, 0.1F);
		this.gridLayout.setSizeFull();
		this.setContent(this.gridLayout);
		this.setSizeFull();
	
		cmdLogin.addClickListener(event -> this.cmdLogin_buttonClick(event));
	} // </generated-code>
	// <generated-code name="variables">
	private XdevPanel panel;
	private XdevPasswordField txtPassword, txtPassword2;
	private XdevTextField txtUsername;
	private XdevGridLayout gridLayout, gridLayout2;
	private XdevButton cmdLogin; // </generated-code>


}
