package com.pandownload.android.up;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
    }
	
	@Override

	public boolean onCreateOptionsMenu(Menu menu) 
	{
		MenuInflater inflater=getMenuInflater();
		inflater.inflate(R.menu.menu,menu);
		
		return true;
	}
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()){
			case R.id.license:
				startActivity(
				new Intent(MainActivity.this,License.class));
				return true;
		}
		return false;
	}
}
