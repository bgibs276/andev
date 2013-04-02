package technologies.cayuse.todo.list;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class ToDoListActivity extends Activity 
{
	Context context = this;
	Button btnAdd;
	EditText txtInput;
	ListView lvContent;
	final String TAG = "Cayuse ToDoList";
	ArrayList<ToDoListItem> toDoList;
	ArrayAdapter<ToDoListItem> aa;
	
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        txtInput = (EditText) findViewById(R.id.txtInput);
        lvContent = (ListView) findViewById(R.id.lvContent);
        toDoList = new ArrayList<ToDoListItem>();
        aa = new myArrayAdapter(context, R.layout.todolist_item, toDoList);
        lvContent.setAdapter(aa);
        
        
        btnAdd.setOnClickListener(new View.OnClickListener() 
        {
			public void onClick(View v) 
			{
				if (txtInput.getVisibility() == View.GONE)
				{
					txtInput.setVisibility(View.VISIBLE);
					txtInput.setEnabled(true);
				}
				else if (!txtInput.getText().toString().equals(""))
				{
					ToDoListItem item = new ToDoListItem(txtInput.getText().toString());
					toDoList.add(item);
					aa.notifyDataSetChanged();
					Log.i(TAG, "Input: " + item);
					Log.i(TAG, Integer.toString(toDoList.size()));
					txtInput.setText("");
					txtInput.setVisibility(View.GONE);
					txtInput.setEnabled(false);
				}
			}
		});         
    }
    public class myArrayAdapter extends ArrayAdapter<ToDoListItem>
    {
    	
    	 Context context; 
    	    int layoutResourceId;  
    	    ArrayList<ToDoListItem> data;
    	    
    	    public myArrayAdapter(Context context, int layoutResourceId, ArrayList<ToDoListItem> data) {
    	        super(context, layoutResourceId, data);
    	        this.layoutResourceId = layoutResourceId;
    	        this.context = context;
    	        this.data = data;
    	    }

    	    @Override
    	    public View getView(int position, View convertView, ViewGroup parent) {
    	        View row = convertView;
    	      	        
    	        if(row == null)
    	        {
    	            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
    	            row = inflater.inflate(layoutResourceId, parent, false);
    	        }
    	        
    	        ToDoListItem theItem = data.get(position);
    	       TextView lblText = (TextView) row.findViewById(R.id.lblText);
    	       TextView lblDate = (TextView) row.findViewById(R.id.lblDate);
    	       lblText.setText(theItem.getText());
    	       lblDate.setText(theItem.getDate());
    	       
    	        return row;
    	    }
    	  
    }
}


