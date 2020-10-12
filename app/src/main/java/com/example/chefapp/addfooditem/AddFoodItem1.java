package com.example.chefapp.addfooditem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chefapp.R;
import com.example.chefapp.RestaurantHelperClass;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddFoodItem1 extends AppCompatActivity {

    Button addButton, proceedButton, resetButton;
    EditText addFoodName, addFoodType, addFoodCategory, addFoodPrice, addFoodSize;
    EditText rphone,remail;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    long maxid=0;
    int FLAG=0;
    int entryCount=1;

//    String phoneNumberFromPreviousActivity = getIntent().getStringExtra("resPhone");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fooditem1);

        //Hooks
        addFoodName=findViewById(R.id.foodName3);
        addFoodType=findViewById(R.id.foodType3);
        addFoodCategory=findViewById(R.id.foodCategory3);
        addFoodPrice=findViewById(R.id.foodPrice3);
        addFoodSize=findViewById(R.id.portionSize3);
        addButton=findViewById(R.id.addMoreButton);
        proceedButton=findViewById(R.id.proceedButton);
        resetButton=findViewById(R.id.resetButton);
        rphone=findViewById(R.id.restaurantPhone);
        remail=findViewById(R.id.restaurantEmail);

        rootNode=FirebaseDatabase.getInstance();
        reference=rootNode.getReference("foodItem");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                    maxid=(snapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        proceedButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_container));
                TextView tv = (TextView) layout.findViewById(R.id.txtvw);
                tv.setText("   FOOD ITEMS UPLOADED   \nSUCCESSFULLY");
                tv.setBackgroundResource(R.color.green);
                Toast toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(layout);
                toast.show();


                String resPhone=getIntent().getStringExtra("resPhone");
                Intent intent=new Intent(AddFoodItem1.this, WorkingDays.class);
                intent.putExtra("resPhone",resPhone);
                startActivity(intent);

            }
        });

        //RESET FIELD'S using button click
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emptyF=addFoodName.getText().toString();
                String emptyS=addFoodSize.getText().toString();
                String emptyP=addFoodPrice.getText().toString();
                String emptyC=addFoodCategory.getText().toString();
                String emptyT=addFoodType.getText().toString();
                if(emptyC.isEmpty() && emptyF.isEmpty() && emptyP.isEmpty() && emptyS.isEmpty() && emptyT.isEmpty()){
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_container));
                    TextView tv = (TextView) layout.findViewById(R.id.txtvw);
                    tv.setText("  ALREADY EMPTY !!  ");
                    tv.setBackgroundResource(R.color.red);
                    Toast toast = new Toast(getApplicationContext());
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setView(layout);
                    toast.show();
                }
                else {
                    addFoodName.getText().clear();
                    addFoodSize.getText().clear();
                    addFoodPrice.getText().clear();
                    addFoodCategory.getText().clear();
                    addFoodType.getText().clear();
                }
            }
        });


        // Button onClick event on
        //ADD-MORE BUTTON
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                rootNode=FirebaseDatabase.getInstance();
//                reference=rootNode.getReference("foodItem");
                FLAG=0;

                String fname= addFoodName.getEditableText().toString();
                String ftype=addFoodType.getEditableText().toString();
                String fcategory=addFoodCategory.getEditableText().toString();
                String fprice=addFoodPrice.getEditableText().toString();
                String fportion=addFoodSize.getEditableText().toString();
//
                if(TextUtils.isEmpty(fname)){
                    addFoodName.setError("Invalid name.");
                    FLAG=1;
                    return;
                }

                if(TextUtils.isEmpty(ftype)){
                    addFoodType.setError("Invalid type :(");
                    FLAG=1;
                    return;
                }

                if(TextUtils.isEmpty(fcategory)){
                    addFoodCategory.setError("Invalid Category :(");
                    FLAG=1;
                    return;
                }

                if(TextUtils.isEmpty(fprice)){
                    addFoodPrice.setError("Price cannot be zero.");
                    FLAG=1;
                    return;
                }

                if(TextUtils.isEmpty(fportion)){
                    addFoodSize.setError("Portion size invalid!!.");
                    FLAG=1;
                    return;
                }


                //Runtime Error will occur if below code is CUT-PASTE on TOP isEmpty() method
                //Reason:- Conversion error from STRING to INT , INT to STRING
                //DO NOT TOUCH
                int valuePortion=Integer.parseInt(fportion);
                if(valuePortion>10 || valuePortion<1){
                    addFoodSize.setError("Minimum portion size >1 \nMaximum portion size<10");
                    FLAG=1;
                    return;
                }

                int valuePrice=Integer.parseInt(fprice);
                if(valuePrice>3000 || valuePrice<10) {
                    addFoodPrice.setError("Minimum price >10\nMaximum price<3000");
                    FLAG = 1;
                    return;
                }
                //DO NOT TOUCH



                RestaurantHelperClass helperClass=new RestaurantHelperClass(fname,ftype,fcategory,fprice,fportion);
                String phoneNumberFromPreviousActivity = getIntent().getStringExtra("resPhone");
                if(FLAG==0) {
                    //Custom Toast
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_container));
                    TextView tv = (TextView) layout.findViewById(R.id.txtvw);
                    tv.setText("   FOOD ITEM STORED   ");
                    tv.setBackgroundResource(R.color.green);
                    Toast toast = new Toast(getApplicationContext());
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setView(layout);
                    toast.show();
                    //Custom Toast ENDS


                    String primaryKey = reference.push().getKey();
                    reference.child("ID" + phoneNumberFromPreviousActivity).child(primaryKey).setValue(helperClass);
                    maxid = 0;
                }
            }
        });
    }
}