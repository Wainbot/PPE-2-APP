package com.jeremy.ppe_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jeremy.ppe_2.dummy.DummyContent;

public class FormationSearchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formation_search);

        final EditText searchText = (EditText) findViewById(R.id.textSearch);
        final Button searchButton = (Button) findViewById(R.id.buttonValider);

        searchButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DummyContent.setSearch(searchText.getText().toString());

                Intent detailIntent = new Intent(FormationSearchActivity.this, FormationListActivity.class);
                startActivity(detailIntent);
            }

        });
    }
}

