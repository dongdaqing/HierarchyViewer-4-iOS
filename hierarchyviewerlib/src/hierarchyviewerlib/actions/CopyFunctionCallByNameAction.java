/*
 * Copyright (c) Shanghai Zhiping Technology Co.,Limited
 * Author: Binhua Liu
 * Web Site: www.vowei.com
 * License: GPL v3 (http://www.gnu.org/copyleft/gpl.html)
 */

package hierarchyviewerlib.actions;

import hierarchyviewerlib.common.ClipboardHelper;
import hierarchyviewerlib.common.CustomString;
import hierarchyviewerlib.common.ViewNode;
import hierarchyviewerlib.controllers.TreeViewController;

import org.eclipse.jface.action.Action;

public class CopyFunctionCallByNameAction extends Action {

public ViewNode mSelectedViewNode;
	
	public CopyFunctionCallByNameAction(ViewNode selectedViewNode)
	{
		this.setText(CustomString.getString("ACTION_COPY_FUNCTION_CALL_BY_NAME"));
		mSelectedViewNode=selectedViewNode;
	}
	
	@Override
	public void run() {
		String functionCallStr = 
				TreeViewController.getController().getFunctionCallByName(mSelectedViewNode);
		ClipboardHelper.setClipboard(functionCallStr);
	}
	
	@Override
	public boolean isEnabled() {
		if(mSelectedViewNode==null)
		{
			return false;
		}
		return true;
	}
}
