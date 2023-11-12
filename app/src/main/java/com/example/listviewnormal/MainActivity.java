package com.example.listviewnormal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import android.view.KeyEvent;


public class MainActivity extends AppCompatActivity {


    EditText editText;
    ListView listView;
    List<String> items;
    ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.listView);
        editText = findViewById(R.id.editText);


        Button addBtn = findViewById(R.id.addButton);
        Button searchBtn = findViewById(R.id.searchButton);
        Button deleteBtn = findViewById(R.id.deleteButton);
        Button updateBtn = findViewById(R.id.updateButton);
        Button readBtn = findViewById(R.id.readButton);




        items = new ArrayList<>();


        listAdapter = new ArrayAdapter<>(this, R.layout.list_item, items);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
            }
        });


        editText.setOnKeyListener((v, keyCode, event) ->
        {
            if (event.getAction() == KeyEvent.ACTION_DOWN) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    addItem();
                    return true;
                }
            }
            return false;
        });


        addBtn.setOnClickListener(v -> {
            addItem();
        });

        searchBtn.setOnClickListener(v -> {

        });

        deleteBtn.setOnClickListener(v -> {
            removeItem();
        });

//        updateBtn.setOnClickListener(v ->{
//
//        });
//
//        readBtn.setOnClickListener(v ->{
//
//        });

    }

    public void addItem() {
        String text = editText.getText().toString();
        if (!text.isEmpty()) {
            items.add(0, text);
            listAdapter.notifyDataSetChanged();
            editText.setText("");
        }
    }

    public void removeItem() {
        String text = editText.getText().toString();
        if (!text.isEmpty()) {
            items.remove(text);
            listAdapter.notifyDataSetChanged();
            editText.setText("");
        }
    }


}











