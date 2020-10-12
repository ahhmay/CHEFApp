package com.example.chefapp.addfooditem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.chefapp.R;
import com.example.chefapp.RestaurantHelperClass;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WorkingDays extends AppCompatActivity {

    TimePicker start_picker, end_picker;
    EditText start, end;
    Button proceedButton;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_working_days);

        start_picker=(TimePicker)findViewById(R.id.startTime);
        end_picker=(TimePicker)findViewById(R.id.endTime);
        start=findViewById(R.id.start_ed);
        end=findViewById(R.id.end_ed);
        proceedButton=(Button)findViewById(R.id.proceedBtn);
        start_picker.setIs24HourView(true);
        end_picker.setIs24HourView(true);


        rootNode=FirebaseDatabase.getInstance();
        reference=rootNode.getReference("OperatingTime");

        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                FOR START TIME
                int shour, sminute;
                String sam_pm;
                if (Build.VERSION.SDK_INT >= 23 ){
                    shour = start_picker.getHour();
                    sminute = start_picker.getMinute();
                }
                else{
                    shour = start_picker.getHour();
                    sminute = start_picker.getMinute();
                }
                if(shour > 12) {
                    sam_pm = "PM";
                    shour = shour - 12;
                }
                else
                {
                    sam_pm="AM";
                }

//                FOR END TIME
                int ehour, eminute;
                String eam_pm;
                if (Build.VERSION.SDK_INT >= 23 ){
                    ehour = end_picker.getHour();
                    eminute = end_picker.getMinute();
                }
                else{
                    ehour = end_picker.getHour();
                    eminute = end_picker.getMinute();
                }
                if(ehour > 12) {
                    eam_pm = "PM";
                    ehour = ehour - 12;
                }
                else
                {
                    eam_pm="AM";
                }
                start.setText(shour+":"+sminute+""+sam_pm);
                end.setText(ehour+":"+eminute+""+eam_pm);
                String ended=end.getEditableText().toString();
                String started=start.getEditableText().toString();



                RestaurantHelperClass helperClass=new RestaurantHelperClass(started, ended);
                String primaryKey = reference.push().getKey();
                String resPhone=getIntent().getStringExtra("resPhone");

                if(!started.equalsIgnoreCase(ended)) {
                    reference.child("ID" + resPhone).child(primaryKey).setValue(helperClass);
                    Intent intent=new Intent(WorkingDays.this, OtherInformation.class);
                    intent.putExtra("resPhone",resPhone);

                    //Toast Message
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_container));
                    TextView tv = (TextView) layout.findViewById(R.id.txtvw);
                    tv.setText("   OPERTING TIME ADDED   ");
                    tv.setBackgroundResource(R.color.green);
                    Toast toast = new Toast(getApplicationContext());
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setView(layout);
                    toast.show();
                    //TOAST ENDS

                    startActivity(intent);
                }
                else{
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_container));
                    TextView tv = (TextView) layout.findViewById(R.id.txtvw);
                    tv.setText("   INVALID TIME   ");
                    tv.setBackgroundResource(R.color.red);
                    Toast toast = new Toast(getApplicationContext());
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setView(layout);
                    toast.show();
                }
            }
        });
    }
}