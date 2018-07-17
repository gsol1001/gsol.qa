/**
 * This Class contains all the methods in the Top Products Action
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

import pageObjects.TopProducts_Page;

/**
 * Contain all the methods in the Top Products action.
 * @author Teng Shyh Wei
 *
 */
public class TopProducts_Action {

	public static void ExecuteTopProducts_ClickL2CategoryLink() throws Exception{
	
		// ProductInquiry_Action.ExecuteTPEntryPoint(dataSearchKeyword);
		
	}
	
	/**
	 * Click on the L2 & L3 category in Top Products page.
	 * 
	 * @param dataL2Category
	 * @param dataL3Category
	 * @throws Exception
	 */
	public static void ExecuteTopProducts_ClickL3CategoryLink(String dataL2Category,
			String dataL3Category) throws Exception{
		
		// Click on the L2 Category link
		TopProducts_Page.lnk_clickL2CategoryKeyword(dataL2Category).click();
		
		// Click on the L3 Category link
		TopProducts_Page.lnk_clickL3CategoryKeyword(dataL3Category).click();
		
	}
}
