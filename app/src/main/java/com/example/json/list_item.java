package com.example.json;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class  list_item extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);
        final ListView listView = (ListView)findViewById(R.id.ListView);
        /***
         * Sample JSON Code ***'
         [{
         "MemberID":"1",
         "Name":"Елена",
         "Tel":"4954876107"
         },
         {
         "MemberID":"2",
         "Name":"Сергей",
         "Tel":"4954780121"
         },
         {
         "MemberID":"3",
         "Name":"Витюша",
         "Tel":"4954543211"
         }]
         */
        String rawJSON = "[{\"MemberID\":\"1\",\"Name\":\"Елена\",\"Tel\":\"4954876107\"}"
                + ",{\"MemberID\":\"2\",\"Name\":\"Сергей\",\"Tel\":\"4954780121\"}"
                + ",{\"MemberID\":\"3\",\"Name\":\"Витя\",\"Tel\":\"4954543211\"}]";
        try {
            JSONArray data = new JSONArray(rawJSON);
            ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
            HashMap<String, String> map;
            for (int i = 0; i < data.length(); i++)
            {
                JSONObject jsonObject = data.getJSONObject(i);
                map = new HashMap<>();
                map.put("MemberID", jsonObject.getString("MemberID"));
                map.put("Name", jsonObject.getString("Name"));
                map.put("Tel", jsonObject.getString("Tel"));
                arrayList.add(map);
            }
            SimpleAdapter simpleAdapter;
            simpleAdapter = new SimpleAdapter(this, arrayList,
                    R.layout.list_item, new String[]{"MemberID",
                    "Name", "Tel"}, new int[]{R.id.item_textViewMemberID,
                    R.id.item_textViewName, R.id.item_textViewNumber});
            listView.setAdapter(simpleAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public void onClick(View view) {
        ListView listView = findViewById(R.id.ListView);
        try {
            JSONArray data = createJSON();
            ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
            HashMap<String, String> hashMap;
            for(int i = 0; i < data.length(); i++){
                JSONObject jsonObject = data.getJSONObject(i);
                hashMap = new HashMap<>();
                hashMap.put("MemberID", jsonObject.getString("MemberID"));
                hashMap.put("Name", jsonObject.getString("Name"));
                hashMap.put("Tel", jsonObject.getString("Tel"));
                arrayList.add(hashMap);
            }
            SimpleAdapter simpleAdapter;
            simpleAdapter = new SimpleAdapter(this, arrayList,
                    R.layout.list_item, new String[]{"MemberID",
                    "Name", "Tel"}, new int[]{R.id.item_textViewMemberID,
                    R.id.item_textViewName, R.id.item_textViewNumber});
            listView.setAdapter(simpleAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private JSONArray createJSON() throws JSONException {
        ArrayList<JSONObject> jsonArrayList = new ArrayList<>();
        JSONObject object;
        /*** Ряд 1 ***/
        object = new JSONObject();
        object.put("MemberID", "1");
        object.put("Name", "Анна");
        object.put("Tel", "4954876107");
        jsonArrayList.add(object);
        /*** Ряд 2 ***/
        object = new JSONObject();
        object.put("MemberID", "2");
        object.put("Name", "Николай");
        object.put("Tel", "4954780121");
        jsonArrayList.add(object);
        /*** Ряд 3 ***/
        object = new JSONObject();
        object.put("MemberID", "3");
        object.put("Name", "Сардана");
        object.put("Tel", "4954543211");
        jsonArrayList.add(object);
        JSONArray jsonArray = new JSONArray(jsonArrayList);
        return jsonArray;
    }

}

