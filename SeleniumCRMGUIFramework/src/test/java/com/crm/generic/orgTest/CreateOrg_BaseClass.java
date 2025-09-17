package com.crm.generic.orgTest;
import org.testng.annotations.Test;

import com.crm.generic.baseUtility.BaseClass;

public class CreateOrg_BaseClass extends BaseClass {

	@Test (groups={"smoke"})
	public void createOrg(){
		System.out.println("Execute createOrg & verify");
	}
	@Test (groups= {"regression"})
	public void createOrgWithInd() {
		System.out.println("Execute createOrgWithInd & verify ");
	}
}

