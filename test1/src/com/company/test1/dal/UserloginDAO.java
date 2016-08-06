
package com.company.test1.dal;

import com.xdev.dal.JPADAO;
import com.company.test1.entities.Userlogin;

/**
 * Home object for domain model class Userlogin.
 * 
 * @see Userlogin
 */
public class UserloginDAO extends JPADAO<Userlogin, Integer> {
	public UserloginDAO() {
		super(Userlogin.class);
	}
}