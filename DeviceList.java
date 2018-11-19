package com.example.rjgoo.recentrify;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;




public class DeviceList extends AppCompatActivity {

    Button b_on, b_off, b_disc, b_list;
    ListView list;

    private static final int REQUEST_ENABLED = 0;
    private static final int REQUEST_DISCOVERABLE = 0;

    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_list);


        b_on =  findViewById(R.id.b_on);
        b_off =  findViewById(R.id.b_off);
        b_disc =  findViewById(R.id.b_disc);
        b_list =  findViewById(R.id.b_list);

        list = findViewById(R.id.list);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        //check if bluetooth is supported
        if(bluetoothAdapter == null)
        {
            Toast.makeText(this,"Bluetooth not supported", Toast.LENGTH_SHORT).show();
            finish();
        }

        b_on.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // turn on bluetooth
                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(intent,REQUEST_ENABLED);
            }
        });

        b_off.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // turn off bluetooth
                bluetoothAdapter.disable();
            }
        });

        b_disc.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (!bluetoothAdapter.isDiscovering())
                {
                    // make device discoverable
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    startActivityForResult(intent,REQUEST_DISCOVERABLE);
                }
            }
        });

        b_list.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // list paired devices
                Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();
                ArrayList<String> devices = new ArrayList<>();

                for(BluetoothDevice bt : pairedDevices)
                {
                    devices.add(bt.getName());
                }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(DeviceList.this, android.R.layout.simple_list_item_1, devices);

                list.setAdapter(arrayAdapter);
            }
        });

    }
}
