//package in.jsroyal.apiconsume.controller;
//
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//
//import in.jsroyal.apiconsume.R;
//
//public class DataEntry extends AppCompatActivity {
//    public EditText location, language;
//    public Button submit;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_data_entry);
//
//        location = (EditText) findViewById(R.id.location);
//        language = (EditText) findViewById(R.id.language);
//        submit = (Button) findViewById(R.id.submit);
//
//
//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String loca = location.getText().toString().trim();
//                String lang = language.getText().toString().trim();
//                Intent intent = new Intent(DataEntry.this, MainActivity.class);
//                intent.putExtra("location", loca);
//                intent.putExtra("language", lang);
//                startActivity(intent);
//            }
//        });
//    }
//}
