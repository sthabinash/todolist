//http://javatechig.com/android/android-listview-tutorial/              ->>>>>>>>>>reference
package com.example.todolist;


import java.util.ArrayList;


import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Todoadpt extends Activity{
	
	  private ListView monthsListView;
	  EditText to_add_item;
	   private ArrayAdapter arrayAdapter;
	   ArrayList <String>foundlist = new ArrayList<String>();
	   ArrayList customlist = new ArrayList();
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Resources resources = this.getResources();
        setContentView(R.layout.todo_adpt);
        add_todo_item();
        to_add_item = (EditText)this.findViewById(R.id.editTodo);
       // String[] monthsArray = { "JAN", "FEB", "MAR", "APR", "MAY", "JUNE", "JULY","AUG", "SEPT", "OCT", "NOV", "DEC" };
        	Button add_btn = (Button)this.findViewById(R.id.button_add);
			
        	final EditText edittext = (EditText) findViewById(R.id.editTodo);
		add_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//User us = new User("admin","admin");
				String add_item = to_add_item.getText().toString();
							
				ApplicationSession.getUser().addtodolist(add_item); // add todo item to arraylist
				to_add_item.setText("");
				add_todo_item();  //call the adapter
			}
		});
		
		
		edittext.setOnKeyListener(new OnKeyListener() {
		    public boolean onKey(View v, int keyCode, KeyEvent event) {
		        // If the event is a key-down event on the "enter" button
		        if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
		            (keyCode == KeyEvent.KEYCODE_ENTER)) {
		          // Perform action on key press
		        	String add_item = to_add_item.getText().toString();
					
					ApplicationSession.getUser().addtodolist(add_item); // add todo item to arraylist
					to_add_item.setText("");
					add_todo_item();
		          return true;
		        }
		        return false;
		    }
		});
       
    
    	
    }
	
	protected void add_todo_item(){
		//foundlist = ApplicationSession.getUser().gettodolist();       //for regular arrayadaptor
		
		//for custom adapter
		customlist = ApplicationSession.getUser().customlist();
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
	     //   arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,foundlist);
	        
	 
	        // By using setAdapter method, you plugged the ListView with adapter
	       // monthsListView.setAdapter(arrayAdapter);
	        monthsListView.setAdapter(new CustomListAdapter(this, customlist));
	}

}
