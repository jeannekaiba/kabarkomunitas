package com.example.ervin.kabarkomunitas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

public class koma extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedIsntanceState) {
        super.onCreate(savedIsntanceState);
        setContentView(R.layout.koma);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void intent (View view)
    {
        Intent i = new Intent(koma.this,foto.class);
        startActivity(i);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}

