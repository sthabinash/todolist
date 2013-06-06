package com.example.todolist;

import java.util.ArrayList;


import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
public class Todo extends Activity{

	ArrayList<String> todolist = new ArrayList<String>();
	
	LinearLayout todoview;
	EditText to_add_item;
	int count = 0;
	protected int m_nDarkColor;
	protected int m_nLightColor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		Resources resources = this.getResources();
		m_nDarkColor = resources.getColor(R.color.dark);
		m_nLightColor = resources.getColor(R.color.light);
		setContentView(R.layout.todofile);
		
		initlayout();
	}
	
	protected void initlayout(){
		todoview = (LinearLayout)this.findViewById(R.id.addlist);
		to_add_item = (EditText)this.findViewById(R.id.todo);
		
		ArrayList <String>foundlist = new ArrayList<String>();
		//foundlist = gettodolist();
		foundlist = ApplicationSession.getUser().gettodolist();
		//foundlist.add("aaa");
		
		for (int i = 0; i < foundlist.size(); i++){
			   String item = foundlist.get(i);
			   //username = item.substring(2, item.indexOf("**"));
				//password = item.substring(item.indexOf("**")+2, item.indexOf("@@"));
				//Toast.makeText(getApplicationContext(), "User = "+username+"\nPassword="+password, Toast.LENGTH_SHORT).show();
			   /*if(username.toLowerCase().equals(uname.toLowerCase()))
				{
					user_flag = 1;
					break;
				}*/
			   addlistinview(item);
			   
			}
		todoview.invalidate();
		
		Button add_btn = (Button)this.findViewById(R.id.btn_add);
			
		
		add_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//User us = new User("admin","admin");
				String add_item = to_add_item.getText().toString();
				addlistinview(add_item);
				
				ApplicationSession.getUser().addtodolist(add_item);
				to_add_item.setText("");
				todoview.invalidate();
			}
		});
	}
	
/*	//Get the to dolist from the file or where it is saved
	protected ArrayList gettodolist(){
		todolist.add("This is the first todo");
		return todolist;
	}
	*/
	protected void addlistinview(String todolist){
		TextView tv = new TextView(this.getApplicationContext());
		   tv.setText(todolist);
		   tv.setTextSize(16);
		   //tv.setWidth(fill_parent);
		   //tv.setLayoutParams();
		   tv.setLayoutParams(new TableLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT, 1f));
		  
			if(count==0)
			{
				tv.setBackgroundColor(this.m_nLightColor);
				//tv.setTextColor(R.color.dark);
				this.count = 1;
			}
			else
			{
				this.count = 0;
				//tv.setBackgroundColor(001000);
				tv.setBackgroundColor(this.m_nDarkColor);
			}
			//tv.setBackgroundColor(m_nLightColor);
			//m_vwJokeLayout.addView(tv);
			
			todoview.addView(tv);
		   
	}
	
}
