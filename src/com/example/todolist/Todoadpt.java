package com.example.todolist;


import java.util.ArrayList;


import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;

public class Todoadpt extends Activity{
	
	  private ListView monthsListView;
	  
	   private ArrayAdapter arrayAdapter;
	  
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Resources resources = this.getResources();
        setContentView(R.layout.todo_adpt);
       
        
       // String[] monthsArray = { "JAN", "FEB", "MAR", "APR", "MAY", "JUNE", "JULY","AUG", "SEPT", "OCT", "NOV", "DEC" };
 	
        ArrayList <String>foundlist = new ArrayList<String>();
    
    	foundlist = ApplicationSession.getUser().gettodolist();
    //	String arr[]=foundlist.toArray(new String[foundlist.size()]);
    	
    	
        // Initialize the UI components
        monthsListView = (ListView) findViewById(R.id.months_list);
        // For this moment, you have ListView where you can display a list.
        // But how can we put this data set to the list?
        // This is where you need an Adapter
 
        // context - The current context.
        // resource - The resource ID for a layout file containing a layout 
                // to use when instantiating views.
        // From the third parameter, you plugged the data set to adapter
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,foundlist);
        
 
        // By using setAdapter method, you plugged the ListView with adapter
        monthsListView.setAdapter(arrayAdapter);
    }

}
