package com.example.todolist;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;



public class CustomListAdapter extends BaseAdapter {
	public static Context appContext;
	
	// boolean array for storing
	   //the state of each CheckBox
	   boolean[] checkBoxState;
	
	public static Context getAppContext(){
		return appContext;
	}
	 
    private ArrayList<TodoItem> listData;
 
    private LayoutInflater layoutInflater;
    
    
 
    public CustomListAdapter(Context context, ArrayList listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
        checkBoxState=new boolean[listData.size()];
    }
 
    @Override
    public int getCount() {
        return listData.size();
    }
 
    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }
 
    @Override
    public long getItemId(int position) {
        return position;
    }
 
    public View getView( int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_row_layout, null);
            holder = new ViewHolder();
            holder.contextView = (TextView) convertView.findViewById(R.id.listcontent);
            holder.chkbxView = (CheckBox) convertView.findViewById(R.id.chkbx);
         //   holder.reportedDateView = (TextView) convertView.findViewById(R.id.date);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
 
        final int pos = position;
        holder.contextView.setText(listData.get(position).getitem());
     // holder.chkbxView.setChecked(false);
        holder.chkbxView.setChecked(checkBoxState[position]);
        
    /*    holder.headlineView.setText(listData.get(position).getHeadline());
        holder.reporterNameView.setText("By, " + listData.get(position).getReporterName());
        holder.reportedDateView.setText(listData.get(position).getDate());
   */
        holder.chkbxView.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            if(((CheckBox)v).isChecked()){
             checkBoxState[pos]=true;
            	Toast.makeText(v.getContext(),listData.get(pos).getitem()+"     "+pos, Toast.LENGTH_SHORT).show();
            	Log.d("The clicked one", listData.get(pos).getitem()+"     "+pos);
            	//holder.chkbxView.setChecked(true);
            	ApplicationSession.addvals(pos);
            
            }
            else{
            // holder.chkbxView.setChecked(false);
            	 checkBoxState[pos]=false;
            	 ApplicationSession.delvals(pos);
            }
              
            }
           });
     
        return convertView;
    }
 
    static class ViewHolder {
        /*TextView headlineView;
        TextView reporterNameView;
        TextView reportedDateView;
        */
    	TextView contextView;
    	CheckBox chkbxView;
    }
 
}
