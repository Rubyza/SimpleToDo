package sg.edu.rp.c346.id22019799.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAdd,btnDelete,btnClear;
    EditText editTask,editPosition;

    Spinner spnAddDelete;

    ListView lvTask;

    ArrayList<String> tasksList =new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd=findViewById(R.id.buttonAdd);
        btnDelete=findViewById(R.id.buttonRemove);
        btnClear=findViewById(R.id.buttonClear);
        editTask=findViewById(R.id.editTextTask);
        editPosition=findViewById(R.id.editTextPosition);
        spnAddDelete=findViewById(R.id.spinner);
        lvTask=findViewById(R.id.tasklist);

        ArrayAdapter taskky = new ArrayAdapter(this,android.R.layout.simple_list_item_1,tasksList);

        lvTask.setAdapter(taskky);

        spnAddDelete.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                switch (i){
                    case 0:
                        btnAdd.setEnabled(true);
                        btnDelete.setEnabled(false);
                        break;
                    case 1:
                        btnAdd.setEnabled(false);
                        btnDelete.setEnabled(true);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String task= editTask.getText().toString();

                String position= editPosition.getText().toString();
                int positionn = Integer.parseInt(position);
                
                if(positionn>tasksList.size() && tasksList.size()!=0){
                    Toast.makeText(MainActivity.this, "Wrong index number", Toast.LENGTH_SHORT).show();
                }
                else{
                    tasksList.add(positionn-1,task);
                    taskky.notifyDataSetChanged();
                    editTask.setText("");
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String task= editTask.getText().toString();

                String position= editPosition.getText().toString();
                int positionn = Integer.parseInt(position);
                if((positionn)>tasksList.size()){
                    Toast.makeText(MainActivity.this, "Wrong index number", Toast.LENGTH_SHORT).show();
                }
                else{
                    tasksList.remove(positionn-1);
                    taskky.notifyDataSetChanged();
                }
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