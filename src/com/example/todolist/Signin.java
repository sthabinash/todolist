package com.example.todolist;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class Signin extends Activity{
	public static Context appContext;
	
	public static Context getAppContext(){
		return appContext;
	}
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		appContext = this.getApplicationContext();
		setContentView(R.layout.signin);
		initlayout();
	}
	
	protected void initlayout(){
		final EditText user = (EditText)this.findViewById(R.id.signin_username);
		final EditText pass = (EditText)this.findViewById(R.id.signin_password);
		final Button btn_signin = (Button)this.findViewById(R.id.signin_signin);
		final Button btn_signup = (Button)this.findViewById(R.id.signin_signup);
		
		
		btn_signup.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent signup_clc = new Intent(Signin.this,Signup.class);
				//signin_clc.setAction(Signin.this,Signup.class);
				startActivity(signup_clc);
				
			}
		});
		
		
		btn_signin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String userinput = user.getText().toString();
				String passwordinput = pass.getText().toString();
				//Toast.makeText(getApplicationContext(), "Signin button", Toast.LENGTH_SHORT).show();
				if(!userinput.equals("") && !passwordinput.equals("")){
					User u = new User();
					
					ArrayList userlist = u.verify_user();
					
				
					int user_flag=0;
					String username=null;
					String password = null;
					for(int i=0;i<userlist.size();i++){
						String item = (String) userlist.get(i);
						//System.out.println("retrieved element: " + item);
					//	Toast.makeText(getApplicationContext(), item, Toast.LENGTH_LONG).show();
						username = item.substring(2, item.indexOf("**"));
						password = item.substring(item.indexOf("**")+2, item.indexOf("@@"));
						if(username.equals(userinput) && password.equals(passwordinput))
						{
							user_flag = 1;
							break;
						}
						}
					
						if(user_flag==1)
						{
							u.setUsername(userinput);
							ApplicationSession.setUser(u);
							Toast.makeText(getApplicationContext(), "Welcome "+username, Toast.LENGTH_LONG).show();
							Intent signin_clc = new Intent(Signin.this,Todo.class);
							
							startActivity(signin_clc);
						}
						else
						{
							Toast.makeText(getApplicationContext(), "Invalid login parameters", Toast.LENGTH_SHORT).show();
						}
					}//end of if(user!=null && pass!=null)
				else
				{
					Toast.makeText(getApplicationContext(), "Enter Username and Password", Toast.LENGTH_SHORT).show();
				}
				}
		});
		
	}
}
