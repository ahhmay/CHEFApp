package com.example.chefapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button logoutButton, paymentButton, profileButton, changeButton;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        builder = new AlertDialog.Builder(this);

//        paymentButton=findViewById(R.id.paymentButton);
//        changeButton=findViewById(R.id.changeButton);
//        profileButton=findViewById(R.id.profileButton);
        logoutButton=findViewById(R.id.logoutBtn);
//
//        //Add Restaurant Button/ UPDATE RESTAURANT DETAILS
//        changeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(getApplicationContext(), AddRestaurant.class);
//                startActivity(intent);
//            }
//        });
//
//        //Payment Button
//        paymentButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(getApplicationContext(), DifferentPaymentMode.class);
//                startActivity(intent);
//            }
//        });

        //Logout Functionality
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Uncomment the below code to Set the message and title from the strings.xml file
                builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);

                //Setting message manually and performing action on button click
                builder.setMessage(R.string.dialog_message)
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // CODE (signs out CurrentUser with whose credential we logged in)
                                FirebaseAuth.getInstance().signOut();
                                //CODE ENDS
                                Intent intent=new Intent(getApplicationContext(),RegisterActivity.class);
                                startActivity(intent);
                                LayoutInflater inflater = getLayoutInflater();
                                View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_container));
                                TextView tv = (TextView) layout.findViewById(R.id.txtvw);
                                tv.setText("   LOGGING OUT :(   ");
                                tv.setBackgroundResource(R.color.colorAccent);
                                Toast toast = new Toast(getApplicationContext());
                                toast.setDuration(Toast.LENGTH_SHORT);
                                toast.setView(layout);
                                toast.show();
                                finish();
                            }
                        })
                        .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();
                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Confirm logout");
                alert.show();
            }
        });
    }
}