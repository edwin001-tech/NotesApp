package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

public class NoteEditorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);

        EditText editText = findViewById(R.id.editText);
        Intent intent = getIntent();
        final int noteId = intent.getIntExtra("noteId",-1);

        if (noteId!= -1){
            editText.setText(MainActivity.notes.get(noteId));
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    MainActivity.notes.set(noteId,String.valueOf(s));
                    MainActivity.arrayAdapter.notifyDataSetChanged();

                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }
    }
}