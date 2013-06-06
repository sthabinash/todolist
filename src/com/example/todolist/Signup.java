package com.example.todolist;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class Signup extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);
		initlayout();
	}

	
	protected void initlayout(){
		final EditText user = (EditText)this.findViewById(R.id.up_username);
		final EditText pass = (EditText)this.findViewById(R.id.up_password);
		final EditText repass = (EditText)this.findViewById(R.id.up_repassword);
		Button submit = (Button)this.findViewById(R.id.up_submit);
		
	
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String uname = user.getText().toString();
				String pword = pass.getText().toString();
				String rpword = repass.getText().toString();
				int user_flag = 0;
				if(!pword.equals("") && !uname.equals("") && !rpword.equals(""))
				{
					if(pword.equals(rpword))
					{
						 //Toast.makeText(getApplicationContext(), "correct", Toast.LENGTH_LONG).show();
						 User u = new User();
						 String username = "";
						 String password = "";
						 ArrayList <String>stringList = new ArrayList<String>();
						 for (int i = 0; i < stringList.size(); i++){
							   String item = stringList.get(i);
							   username = item.substring(2, item.indexOf("**"));
								password = item.substring(item.indexOf("**")+2, item.indexOf("@@"));
								Toast.makeText(getApplicationContext(), "User = "+username+"\nPassword="+password, Toast.LENGTH_SHORT).show();
							   if(username.toLowerCase().equals(uname.toLowerCase()))
								{
									user_flag = 1;
									break;
								}
							}
						 if(user_flag==1){
							 Toast.makeText(getApplicationContext(),"Username already exist", Toast.LENGTH_SHORT).show();
						 }
						 else{
							 u.setUsername(uname);
							 u.setPassword(pword);
							 u.adduser();
							 Toast.makeText(getApplicationContext(), "User Successfully created\nWelcome "+uname, Toast.LENGTH_LONG).show();
							 ApplicationSession.setUser(u);
							 Intent intent = new Intent(Signup.this,Todo.class);
							 //intent.putExtra("kkey",uname);
							 startActivity(intent);
						 }

					}
					else
					{
						 Toast.makeText(getApplicationContext(), "incorrect", Toast.LENGTH_LONG).show();
					}
				}//end of if(pword!=null && uname!=null && rpword!=null)
				else
				{
					Toast.makeText(getApplicationContext(), "Enter all the fields", Toast.LENGTH_LONG).show();
				}
			}
		});
		
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
