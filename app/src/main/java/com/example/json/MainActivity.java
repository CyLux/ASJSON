package com.example.json;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView JsonSrcTextView = (TextView) findViewById(R.id.tv1);
        TextView JsonObjectTextView = (TextView) findViewById(R.id.tv2);
        TextView JsonResultTextView = (TextView) findViewById(R.id.tv3);
        TextView JsonMySiteTextView = (TextView) findViewById(R.id.tv4);
        TextView JsonUrlTextView = (TextView) findViewById(R.id.tv5);
        String json_source = getString(R.string.simple_json);
        TextView JsonArrayTextView = (TextView) findViewById(R.id.textView6);

        try {
            JSONObject jsonObject = new JSONObject(json_source);
            JSONObject results = jsonObject.getJSONObject("results");
            String mySiteName = results.getString("sitename");
            String myUrl = results.getString("url");
            JsonObjectTextView.setText("jsonObject:\n" + jsonObject.toString());
            JsonResultTextView.setText("results:\n" + results.toString());
            JsonMySiteTextView.setText("Имя сайта:\n" + mySiteName);
            JsonUrlTextView.setText("Адрес сайта:\n" + myUrl);
            // Получаем данные из массива в JSON
            String stringArrayElement = "\n";
            JSONArray jsonArray = results.getJSONArray("array");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject arrayElement =
                        jsonArray.getJSONObject(i);
                stringArrayElement +=
                        arrayElement.getString("element") + "\n";
            }
            // выводим данные, полученные из массива
            JsonArrayTextView.setText(stringArrayElement);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        Button list_item = (Button)findViewById(R.id.list_item);
        list_item.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        i = new Intent(this, list_item.class);
        startActivity(i);
    }
}