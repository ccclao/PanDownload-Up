package com.pandownload.android.up;
import android.app.*;
import android.widget.*;
import de.robv.android.xposed.*;
import de.robv.android.xposed.callbacks.*;
import java.lang.reflect.*;

public class PanDownload implements IXposedHookLoadPackage
{
	@Override
	public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable
	{
		if(lpparam.packageName.equals("top.linesoft.kiryuu.pandownload"))
		{
			XposedHelpers.findAndHookMethod("android.app.Dialog",lpparam.classLoader,"show",new XC_MethodHook(){
				@Override 
				protected void afterHookedMethod(XC_MethodHook.MethodHookParam param)
				{
					XposedBridge.log("FindMethodAndHook");
					AlertDialog dialog = (AlertDialog) param.thisObject;
					String message="";
					try {
						Field mAlert = AlertDialog.class.getDeclaredField("mAlert");
						mAlert.setAccessible(true);
						Object mController = mAlert.get(dialog);
						Field mMessage = mController.getClass().getDeclaredField("mMessageView");
						mMessage.setAccessible(true);
						TextView mMessageView = (TextView) mMessage.get(mController);
						message=mMessageView.getText().toString();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (NoSuchFieldException e) {
						e.printStackTrace();
					}
					if(message.equals("本软件已停用"))
					{
						dialog.hide();
						Toast.makeText(
							dialog.getContext(),
							"PanDownload for Android Started",
							Toast.LENGTH_SHORT).show();
					}
					
						
						
				}
			});
		}
	}
	
}
