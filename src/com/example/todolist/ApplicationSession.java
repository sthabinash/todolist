package com.example.todolist;

/**
 * Stores application wide static objects
 * 
 * @author abinash
 *
 */
public class ApplicationSession {

	protected static User user;
	
	public static User getUser(){
		return user;
	}
	
	public static void setUser(User user){
		ApplicationSession.user = user;
	}
}
