package com.example.chefapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.chefapp.addfooditem.AddFoodItem1;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddRestaurant extends AppCompatActivity {

    EditText rname, raddress, rtype, rphone, remail, rtime;
    Button add_restaurant;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant);

        rname=findViewById(R.id.restaurantName);
        raddress=findViewById(R.id.restaurantAddress);
        rtype=findViewById(R.id.resType);
        rphone=findViewById(R.id.restaurantPhone);
        remail=findViewById(R.id.restaurantEmail);
        rtime=findViewById(R.id.resTime);
        add_restaurant=findViewById(R.id.goOnline);
        String phoneNo=getIntent().getStringExtra("phoneNumber");
        rphone.setText(phoneNo);
        //Saving data in Realtime Firebase on button Click
        add_restaurant.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                rootNode=FirebaseDatabase.getInstance();
                reference=rootNode.getReference("restaurant");

                //Get All the values
                String resName= rname.getEditableText().toString();
                String resAddress= raddress.getEditableText().toString();
                String resType= rtype.getEditableText().toString();
                String resPhone= rphone.getEditableText().toString();
                String resEmail= remail.getEditableText().toString();
                String resTime= rtime.getEditableText().toString();

                //VALIDATIONS on Fields
                if(TextUtils.isEmpty(resName)){
                    rname.setError("Restaurant Name is Compulsary.");
                    return;
                }

                if(TextUtils.isEmpty(resAddress)){
                    raddress.setError("Address cannot be Empty.");
                    return;
                }

                if(TextUtils.isEmpty(resType)){
                    rtype.setError("Restaurant Type cannot be Empty.");
                    return;
                }

                if(TextUtils.isEmpty(resType)){
                    rtype.setError("Restaurant Type cannot be Empty.");
                    return;
                }

                if(!TextUtils.isEmpty(resPhone)){
                    if(resPhone.length()!=10) {
                        rphone.setError("Invalid PhoneNumber.");
                        return;
                    }
                }
                else{
                    rphone.setError("PhoneNumber field cannot be Empty.");
                    return;
                }

                if(TextUtils.isEmpty(resTime)){
                    rtime.setError("Timing needs to be specified.");
                    return;
                }

                RestaurantHelperClass helperClass=new RestaurantHelperClass(resName,resAddress,resType,resPhone,resEmail,resTime);
                reference.child("ID"+resPhone).setValue(helperClass);

                Intent intent=new Intent(AddRestaurant.this, AddFoodItem1.class);
                intent.putExtra("resPhone",resPhone);
                startActivity(intent);
                finish();

            }
        });
    }
}