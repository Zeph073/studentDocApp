package com.example.student_doctor_healthapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Dr.Chebet Sharon", "Hospital Address : Nairobi", "Exp : 15yrs", "Mobile No:0792744763","2500"},
                    {"Doctor Name : Dr.Melany Nafula  ", "Hospital Address : Nakuru", "Exp : 13yrs", "Mobile No:0714228749","2000"},
                    {"Doctor Name : Dr.Joy Wanjala", "Hospital Address : Kitale", "Exp : 8yrs", "Mobile No:0790074955","1800"},
                    {"Doctor Name : Dr.Nancy Kemei", "Hospital Address : Kisumu", "Exp : 13yrs", "Mobile No:0724949342","2000"},
                    {"Doctor Name : Dr.Angela Oduor", "Hospital Address : Kakamega", "Exp : 14yrs", "Mobile No:0769319921","2300"},
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Dr.Deborah Adhiambo", "Hospital Address : Kajiado", "Exp : 15yrs", "Mobile No:0721577451","2500"},
                    {"Doctor Name : Dr.Joseph Etolo", "Hospital Address : Kabarak", "Exp : 13yrs", "Mobile No:0714228749","2000"},
                    {"Doctor Name : Dr.Sharon Chebet", "Hospital Address : Kericho", "Exp : 8yrs", "Mobile No:0790074955","1800"},
                    {"Doctor Name : Dr.Ivy Chebet", "Hospital Address : Transnzoia", "Exp : 13yrs", "Mobile No:0724949342","2000"},
                    {"Doctor Name : Dr.Esther Kimani", "Hospital Address : Lodwar", "Exp : 14yrs", "Mobile No:0769319921","2300"},
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Dr.Reuben Oluyali", "Hospital Address : Kibish", "Exp : 15yrs", "Mobile No:0721577451","2500"},
                    {"Doctor Name : Dr.Chebet Rono", "Hospital Address : Vihiga", "Exp : 13yrs", "Mobile No:0714228749","2000"},
                    {"Doctor Name : Dr.David Nasilo", "Hospital Address : Lokori", "Exp : 8yrs", "Mobile No:0790074955","1800"},
                    {"Doctor Name : Dr.Tabitha Njoki", "Hospital Address : TransAfrica", "Exp : 13yrs", "Mobile No:0724949342","2000"},
                    {"Doctor Name : Dr.Charlotte Akothe", "Hospital Address : GreatRift", "Exp : 14yrs", "Mobile No:0769319921","2300"},
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Dr.Brian Kipchumba", "Hospital Address : Nakwamekwi", "Exp : 15yrs", "Mobile No:0721577451","2500"},
                    {"Doctor Name : Dr.Loice Awoton", "Hospital Address : Kilifi", "Exp : 13yrs", "Mobile No:0714228749","2000"},
                    {"Doctor Name : Dr.Faith Kamar", "Hospital Address : Nairobi", "Exp : 8yrs", "Mobile No:0790074955","1800"},
                    {"Doctor Name : Dr.Bethany Ewoi", "Hospital Address : Machakos", "Exp : 13yrs", "Mobile No:0724949342","2000"},
                    {"Doctor Name : Dr.Dorah Ereng", "Hospital Address : Nandi", "Exp : 14yrs", "Mobile No:0769319921","2300"},
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Dr.Esther Elaar", "Hospital Address : Salga", "Exp : 15yrs", "Mobile No:0721577451","2500"},
                    {"Doctor Name : Dr.Magdalene Lotwei", "Hospital Address : Mombasa", "Exp : 13yrs", "Mobile No:0714228749","2000"},
                    {"Doctor Name : Dr.Wendy Atieno", "Hospital Address : Eldoret", "Exp : 8yrs", "Mobile No:0790074955","1800"},
                    {"Doctor Name : Dr.MarryAnne Atiir", "Hospital Address : Coast", "Exp : 13yrs", "Mobile No:0724949342","2000"},
                    {"Doctor Name : Dr.Reuben Omolo", "Hospital Address : South DG", "Exp : 14yrs", "Mobile No:0769319921","2300"},
            };
    TextView tv, tv1;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonLDAddToCart);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if (title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if (title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if (title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });



        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees"+" "+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}