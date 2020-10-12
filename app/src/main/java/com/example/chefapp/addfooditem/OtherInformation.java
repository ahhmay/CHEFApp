package com.example.chefapp.addfooditem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.chefapp.LoadingScreen;
import com.example.chefapp.R;
import com.example.chefapp.RestaurantHelperClass;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OtherInformation extends AppCompatActivity {

    CheckBox c1, c2, c3,c4,c5,c6, c7, c8, c9, c10,c11, c12, c13, c14,c15, c16, c17,c18, c19;
    Button proceedButton;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_information);

        c1=findViewById(R.id.checkBox1);
        c2=findViewById(R.id.checkBox2);
        c3=findViewById(R.id.checkBox3);
        c4=findViewById(R.id.checkBox4);
        c5=findViewById(R.id.checkBox5);
        c6=findViewById(R.id.checkBox6);
        c7=findViewById(R.id.checkBox7);
        c8=findViewById(R.id.checkBox8);
        c9=findViewById(R.id.checkBox9);
        c10=findViewById(R.id.checkBox10);
        c11=findViewById(R.id.checkBox11);
        c12=findViewById(R.id.checkBox12);
        c13=findViewById(R.id.checkBox13);
        c14=findViewById(R.id.checkBox14);
        c15=findViewById(R.id.checkBox15);
        c16=findViewById(R.id.checkBox16);
        c17=findViewById(R.id.checkBox17);
        c18=findViewById(R.id.checkBox18);
        c19=findViewById(R.id.checkBox19);
        proceedButton=findViewById(R.id.DoneButton);

        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode=FirebaseDatabase.getInstance();
                reference=rootNode.getReference("OtherFacilityAvailable");

                String cb1=c1.getText().toString();
                String cb2=c2.getText().toString();
                String cb3=c3.getText().toString();
                String cb4=c4.getText().toString();
                String cb5=c5.getText().toString();
                String cb6=c6.getText().toString();
                String cb7=c7.getText().toString();
                String cb8=c8.getText().toString();
                String cb9=c9.getText().toString();
                String cb10=c10.getText().toString();
                String cb11=c11.getText().toString();
                String cb12=c12.getText().toString();
                String cb13=c13.getText().toString();
                String cb14=c14.getText().toString();
                String cb15=c15.getText().toString();
                String cb16=c16.getText().toString();
                String cb17=c17.getText().toString();
                String cb18=c18.getText().toString();
                String cb19=c19.getText().toString();


                RestaurantHelperClass helperClass=new RestaurantHelperClass(cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10,cb11,cb12,cb13,cb14,cb15,cb16,cb17,cb18,cb19);
                String resPhone=getIntent().getStringExtra("resPhone");
                String primaryKey = reference.push().getKey();

                if(c1.isChecked() || c2.isChecked() || c3.isChecked() || c4.isChecked() || c5.isChecked()
                                  || c6.isChecked() || c7.isChecked() || c8.isChecked() || c9.isChecked()
                                 || c10.isChecked() || c11.isChecked() || c12.isChecked() || c13.isChecked()
                                 || c14.isChecked() || c15.isChecked() || c16.isChecked() || c17.isChecked()
                                 || c18.isChecked() || c19.isChecked()){
                    reference.child("ID" + resPhone).child(primaryKey).setValue(helperClass);
                    Intent intent=new Intent(OtherInformation.this, LoadingScreen.class);
                    startActivity(intent);
                }
            }
        });
    }
}