/**
 * This Class contains all the methods in the Top China Suppliers Action
 * Created: Wed 06 Jan 2016
 * @author Teng Shyh Wei
 * @version 1.01 Date: 2016/01/06
 * 
 * Copyright (c) 2003 Media Data Systems Pte Ltd All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Media Data Systems Pte Ltd. You shall not disclose such Confidential
 * Information.
 */

package appModules;

import pageObjects.TopChinaSuppliers_Page;

/**
 * Contain all the methods in the Top China Suppliers action.
 * @author Teng Shyh Wei
 *
 */
public class TopChinaSuppliers_Action {

	/**
	 * Click on the L2 & L3 category in Top China Suppliers page.
	 * 
	 * @param dataL2Category
	 * @param dataL3Category
	 * @throws Exception
	 */
	public static void ExecuteChinaSuppliers_ClickL3CategoryLink(String dataL2Category,
			String dataL3Category) throws Exception{
		
		// Click on the L2 Category link
		TopChinaSuppliers_Page.lnk_clickL2CategoryKeyword(dataL2Category).click();
		
		// Click on the L3 Category link
		TopChinaSuppliers_Page.lnk_clickL3CategoryKeyword(dataL3Category).click();
		
	}
	
}
