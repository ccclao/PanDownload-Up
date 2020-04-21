package com.pandownload.android.up;
import android.app.*;
import android.os.*;
import android.webkit.*;
import android.widget.TableRow.*;

public class License extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		WebView web=new WebView(License.this);
	    web.loadUrl("file:////android_asset/LICENSE.txt");
		LayoutParams l=new LayoutParams();
		l.height=l.FILL_PARENT;
		l.width=l.FILL_PARENT;
		web.setLayoutParams(l);
		setContentView(web);
	}
	
}
