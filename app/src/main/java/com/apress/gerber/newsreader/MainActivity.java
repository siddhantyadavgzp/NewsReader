/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.apress.gerber.newsreader;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends Activity {

    private static final String apiKey = "330e6b67a332453a9915a3a244b22d4a";
    private InterFaceAPI service;
    private static final String date = "2019-04-06";
    private static final String sortBy = "publishedAt";
    private Button searchButton;
    private EditText searchContent;
    private TextView result;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchButton = findViewById(R.id.search_button);
        searchContent = findViewById(R.id.search);
        result = findViewById(R.id.text);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNews();
            }
        });
        service = BuilderAPI.getClient().create(InterFaceAPI.class);
    }

    public void getNews() {
        service.getNews(searchContent.getText().toString(), date, sortBy, apiKey).enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                assert response.body() != null;

                result.setText(response.body().getStats());
                Toast.makeText(getApplicationContext(), "wha thte fuck", Toast.LENGTH_LONG).show();
                List<Content> contents= response.body().getContent();
                for ( Content content:contents)
                {
                    String post="";
                    post+="Title"+content.getTitle()+"\n";
                    post+="Description" + content.getDescription()+"\n\n\n";
                    result.append(post);
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "the fuck", Toast.LENGTH_LONG).show();
            }
        });

    }

}
