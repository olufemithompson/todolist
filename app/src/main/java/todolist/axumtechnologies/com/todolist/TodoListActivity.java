package todolist.axumtechnologies.com.todolist;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class TodoListActivity extends Activity {

    private ArrayList<String> items;//todolist datastore
    private ArrayAdapter<String> itemsAdapter;//todolist adapter
    ListView lvItems;
    EditText etNewItem;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);//setting the layout for this activity

        lvItems = (ListView) findViewById(R.id.lvItems);//initialising the listview components that displays the todolist
        etNewItem = (EditText) findViewById(R.id.etNewItem);//initialise the textbox that allows user to enter todolist item
        button = (Button) findViewById(R.id.btnAddItem);//initialise the button that adds a todolist item to the list when clicked

        items = new ArrayList<String>();//initialising the todolist datastore
        itemsAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, items);//initialising the todolist adapter

        items.add("First Todo Item"); //adding default items to the todolist
        items.add("Second Todo Item");

        lvItems.setAdapter(itemsAdapter);//making the listview component to use the itemsAdapter as its  default adapter
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemText = etNewItem.getText().toString();
                items.add(itemText);
                itemsAdapter.notifyDataSetChanged();
                etNewItem.setText("");
            }
        });
    }
}
