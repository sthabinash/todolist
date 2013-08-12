package com.example.todolist;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Stores application wide static objects
 * 
 * @author abinash
 *
 */
public class ApplicationSession {

	protected static User user;
	
	static ArrayList<Integer> vals = new ArrayList<Integer>();
	
	public static User getUser(){
		return user;
	}
	
	public static void setUser(User user){
		ApplicationSession.user = user;
	}
	
	
	public static void addvals(int num){
		vals.add(num);
	}
	
	public static ArrayList<Integer> getvals(){
		return vals;
	}
	
	public static void delvals(int num){
		Iterator itr = vals.iterator();
		Integer strElement = new Integer(0);
		while(itr.hasNext()){

		  strElement = (Integer) itr.next();
		  if(strElement.equals(num))
		  {
		    itr.remove();
		  }


		    }
	}
}
