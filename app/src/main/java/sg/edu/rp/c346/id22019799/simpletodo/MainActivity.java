package sg.edu.rp.c346.id22019799.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAdd,btnClear;
    EditText editTask,editPosition;

    ListView lvTask;

    ArrayList<String> tasksList =new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd=findViewById(R.id.buttonAdd);
        btnClear=findViewById(R.id.buttonClear);
        editTask=findViewById(R.id.editTextTask);
        editPosition=findViewById(R.id.editTextPosition);
        lvTask=findViewById(R.id.tasklist);

        ArrayAdapter taskky = new ArrayAdapter(this,android.R.layout.simple_list_item_1,tasksList);

        lvTask.setAdapter(taskky);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String task= editTask.getText().toString();

                String position= editPosition.getText().toString();
                int positionn = Integer.parseInt(position);
                tasksList.add(positionn-1,task);
                taskky.notifyDataSetChanged();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tasksList.clear();
                taskky.notifyDataSetChanged();
            }
        });

    }
}