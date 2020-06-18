package com.example.tinderv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;


public class HomeActivity extends AppCompatActivity {

    Button startBTN;
    TextView txtPP;
    String url = "http://178.128.242.32/test";
    String validURL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        startBTN = findViewById(R.id.startBTN);
        txtPP = findViewById(R.id.txtPrivatePolice);

        txtPP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, PrivacyPolice.class);
                startActivity(i);
            }
        });




        startBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Parsing par = new Parsing();
                par.execute();


            }
        });

    }


    class Parsing extends AsyncTask<Void, Void, Void> {





        @Override
        protected Void doInBackground (Void... voids) {
            Document doc = null;
            try {

                doc = Jsoup.connect(url).get();
                Element textElem = doc.selectFirst("body");
                validURL = textElem.text();

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        protected void onPostExecute(Void list){

            if (!validURL.equals(""))   {

                Intent i = new Intent(HomeActivity.this, webView.class);
                i.putExtra("URL", validURL);
                startActivity(i);

            }

            if (validURL.equals(""))   {

                Intent j = new Intent(HomeActivity.this, Anket_class.class);
                startActivity(j);

            }

        }

    }



}
