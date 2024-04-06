package com.example.listviewatv;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ListView lvSystem;
    String[] items = {"Terra", "Marte", "Júpiter",
            "Mercúrio", "Sol", "Netuno", "Plutão",
            "Saturno", "Urano", "Vênus", "Lua"};
    String[] subitems = {"d: 12.742 km", "d: 6.779 km", "d: 139.820 km",
            "d: 4.879,4 km", "d: 1.392.700 km", "d: 49.244 km", "d: 2.376,6 km",
            "d: 116.460 km", "d: 50.724 km", "d: 12.104 km", "d: 3.474,8 km"};

    int[] images = {R.drawable.earth, R.drawable.mars, R.drawable.jupiter, R.drawable.mercury,
            R.drawable.sun, R.drawable.neptune, R.drawable.pluto, R.drawable.saturn,
            R.drawable.uranus, R.drawable.venus, R.drawable.moon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        lvSystem = findViewById(R.id.lv_system);
        ListViewCustomAdapter adapter = new ListViewCustomAdapter(this, items, subitems, images);
        lvSystem.setAdapter(adapter);


        lvSystem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, items[position] + " tem " + subitems[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}