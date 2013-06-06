package com.example.todolist;

import java.io.*;
import java.util.ArrayList;

import android.app.Activity;
import android.widget.Toast;


public class User{
	protected String username;
	protected String password;
	
	ArrayList<String> user_pass = new ArrayList<String>();
	
	ArrayList<String> user_todolist; //= new ArrayList<String>();
	
	public User()
	{
		//user_pass.add("##admin**admin@@");
	}
	
	public User(String username,String password)
	{
		this.username = username;
		this.password = password;
	}
	
	public User(String username)
	{
		this.username = username;
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	//adds user to file
	public void adduser(){
		
		try{
    		String data = "##"+this.username+"**"+this.password+"@@";
    		int flag = 1;
    		String filePath = Signin.getAppContext().getFilesDir().getPath().toString();
    		//File f = new File(filePath);
    		File file =new File(filePath,"Users.txt");
    		
    		//if file doesnt exists, then create it
    		if(!file.exists()){
    			file.createNewFile();
    			flag = 0;
    			Toast.makeText(Signin.getAppContext(), "File Created", Toast.LENGTH_LONG);
    			
    		}
    		
    		/*if(file.canWrite()){
    			Toast.makeText(Signin.getAppContext(), "Yes dude file can be written", Toast.LENGTH_LONG).show();
    		}
    		else{
    			Toast.makeText(Signin.getAppContext(), "No dude file can't be written", Toast.LENGTH_LONG).show();
    		}*/
 
    		//true = append file
    		
    		FileWriter fileWriter = new FileWriter(file,true);
    		
    		//FileWriter fileWritter = new FileWriter(file.getName(),true);
    	        BufferedWriter bufferWritter = new BufferedWriter(fileWriter);
    	        
    	        if(flag==1){
    	        	bufferWritter.newLine();
                
    	        }
    	        
    	        bufferWritter.write(data);
    	        
    	        bufferWritter.close();
    	        fileWriter.close();
	        System.out.println("Done");
	        Toast.makeText(Signin.getAppContext(), "User added", 1000).show();
 
    	}catch(IOException e){
    		e.printStackTrace();
    		System.out.println("TO hell with error");
	        Toast.makeText(Signin.getAppContext(), "Cannot add user", 1000).show();
    	}
	}
	
	
	
	public ArrayList<String> verify_user(){
		user_pass = new ArrayList<String>();
		
		
		try{
			
    		String filePath = Signin.getAppContext().getFilesDir().getPath().toString();
			File file =new File(filePath,"Users.txt");
    		
    		//if file doesnt exists, then create it
    		if(!file.exists()){
    		//	user_todolist.add("found nothing");
    			Toast.makeText(Signin.getAppContext(), "File Not found", Toast.LENGTH_LONG).show();
    		return user_pass;	
    			//Toast.makeText(Signin.getAppContext(), "File Created", Toast.LENGTH_LONG);
    			
    		}
    		else{
    			
    			String sCurrentLine=null;
    			
    			FileReader fr = new FileReader(file);
    			BufferedReader br = new BufferedReader(fr);
    			//Toast.makeText(Signin.getAppContext(), "Entered the read file", Toast.LENGTH_SHORT).show();
    			while ((sCurrentLine = br.readLine()) != null) {
    				//System.out.println(sCurrentLine);
    				user_pass.add(sCurrentLine);
    				//Toast.makeText(Signin.getAppContext(), sCurrentLine, Toast.LENGTH_SHORT).show();
					
					/**
					if(username.equals(got_user))
					{
						//user_flag = 1;
						Toast.makeText(Signin.getAppContext(), "Found user", Toast.LENGTH_SHORT).show();
						list_item = sCurrentLine.substring(sCurrentLine.indexOf("**")+2, sCurrentLine.indexOf("@@"));
						user_pass.add(list_item);
					}*/
    			}
    			fr.close();
    			br.close();
    			return user_pass;
    		}
		}
		catch(Exception e){
			e.printStackTrace();
			Toast.makeText(Signin.getAppContext(), "Error in retrieving user item", 1000).show();
		}
		
		
		
		
		
		return user_pass;
	}
	
	
	
	//Get the to dolist from the file or where it is saved
		public ArrayList<String> gettodolist(){
			//user_todolist.add("This is the first todo");
			user_todolist = new ArrayList<String>();
			
			
			try{
				int flag = 1;
	    		String filePath = Signin.getAppContext().getFilesDir().getPath().toString();
				File file =new File(filePath,"Users_List.txt");
	    		
	    		//if file doesnt exists, then create it
	    		if(!file.exists()){
	    		//	user_todolist.add("found nothing");
	    		return user_todolist;	
	    			//Toast.makeText(Signin.getAppContext(), "File Created", Toast.LENGTH_LONG);
	    			
	    		}
	    		else{
	    			ArrayList<String> alldata = new ArrayList<String>();
	    			String sCurrentLine=null;
	    			String list_item = null;
	    			String got_user=null;
	    			FileReader fr = new FileReader(file);
	    			BufferedReader br = new BufferedReader(fr);
	    			
	    			while ((sCurrentLine = br.readLine()) != null) {
	    				//System.out.println(sCurrentLine);
	    				got_user = sCurrentLine.substring(2, sCurrentLine.indexOf("**"));
						
						
						if(username.equals(got_user))
						{
							//user_flag = 1;
							list_item = sCurrentLine.substring(sCurrentLine.indexOf("**")+2, sCurrentLine.indexOf("@@"));
							user_todolist.add(list_item);
						}
	    			}
	    			return user_todolist;
	    		}
			}
			catch(Exception e){
				e.printStackTrace();
				Toast.makeText(Signin.getAppContext(), "Error in retrieving todo item", 1000).show();
			}
			
			
			return user_todolist;
		}
		
		
		//Add todo list
		public int addtodolist(String item){
			int flag_return = 0;
			String data = "##"+this.username+"**"+item+"@@";
			try{
	    		
	    		int flag = 1;
	    		String filePath = Signin.getAppContext().getFilesDir().getPath().toString();
	    		//File f = new File(filePath);
	    		File file =new File(filePath,"Users_List.txt");
	    		
	    		//if file doesnt exists, then create it
	    		if(!file.exists()){
	    			file.createNewFile();
	    			flag = 0;
	    			//Toast.makeText(Signin.getAppContext(), "File Created", Toast.LENGTH_LONG);
	    			
	    		}
	    	  	
	 
	    		//true = append file
	    		
	    		FileWriter fileWriter = new FileWriter(file,true);
	    		
	    		//FileWriter fileWritter = new FileWriter(file.getName(),true);
	    	        BufferedWriter bufferWritter = new BufferedWriter(fileWriter);
	    	        
	    	        if(flag==1){
	    	        	bufferWritter.newLine();
	                }
	    	        
	    	        bufferWritter.write(data);
	    	        
	    	        bufferWritter.close();
	 
		        System.out.println("Done");
		        Toast.makeText(Signin.getAppContext(), "List added", 1000).show();
	 
	    	}catch(IOException e){
	    		e.printStackTrace();
	    		System.out.println("TO hell with error");
		        //Toast.makeText(Signin.getAppContext(), "TO hell with error", Toast.LENGTH_LONG).show();
	    		Toast.makeText(Signin.getAppContext(), "Error in adding the item", 1000).show();
	    	}
			
			return flag_return;
		}

}
