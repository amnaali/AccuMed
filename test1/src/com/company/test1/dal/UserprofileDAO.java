
package com.company.test1.dal;

import com.xdev.dal.JPADAO;
import com.company.test1.entities.Userprofile;

/**
 * Home object for domain model class Userprofile.
 * 
 * @see Userprofile
 */
public class UserprofileDAO extends JPADAO<Userprofile, Integer> {
	public UserprofileDAO() {
		super(Userprofile.class);
	}
}