package ke.co.nevon.stdportal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class Units extends AppCompatActivity {
    GridView gridView;
    ArrayList<UnitDetails> unitDetails;
    private static final String TAG = "Units";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_units);
        unitDetails=new ArrayList<>();
        UnitGridAdapter unitGridAdapter=new UnitGridAdapter(getApplicationContext(),unitDetails);
        gridView=findViewById(R.id.unitGrid);
        unitDetails.add(new UnitDetails("Operation reseach","sma3560","unregistered"));
        unitDetails.add(new UnitDetails("Operation reseach","sma3560","unregistered"));
        unitDetails.add(new UnitDetails("Operation reseach","sma3560","unregistered"));
        unitDetails.add(new UnitDetails("Operation reseach","sma3560","unregistered"));
        unitDetails.add(new UnitDetails("Operation reseach","sma3560","unregistered"));
        unitDetails.add(new UnitDetails("Operation reseach","sma3560","unregistered"));
        unitDetails.add(new UnitDetails("Operation reseach","sma3560","unregistered"));
        unitDetails.add(new UnitDetails("Operation reseach","sma3560","unregistered"));
        unitDetails.add(new UnitDetails("Operation reseach","sma3560","unregistered"));
        unitDetails.add(new UnitDetails("Operation reseach","sma3560","unregistered"));
        unitDetails.add(new UnitDetails("Operation reseach","sma3560","unregistered"));
        unitDetails.add(new UnitDetails("Operation reseach","sma3560","unregistered"));
        unitDetails.add(new UnitDetails("Operation reseach","sma3560","unregistered"));
        unitDetails.add(new UnitDetails("Operation reseach","sma3560","unregistered"));
        unitDetails.add(new UnitDetails("Operation reseach","sma3560","unregistered"));
        unitDetails.add(new UnitDetails("Operation reseach","sma3560","unregistered"));
        gridView.setAdapter(unitGridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemValue=(String)gridView.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),itemValue,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
