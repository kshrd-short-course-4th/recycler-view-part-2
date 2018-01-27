package com.example.rathana.recyclerviewdemostrate;

import android.content.Intent;
import android.opengl.ETC1;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNewSongActivity extends AppCompatActivity {

    private EditText edTitle;
    private EditText edChannelName;
    private EditText edViewer;
    private Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_song);
        edTitle=findViewById(R.id.ed_song_title);
        edChannelName=findViewById(R.id.ed_channel);
        edViewer=findViewById(R.id.ed_viewer);
        btnSave=findViewById(R.id.btn_add_new_song);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("TITLE", edTitle.getText().toString());
                intent.putExtra("CHANNEL", edChannelName.getText().toString());
                intent.putExtra("VIEWER", edViewer.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
