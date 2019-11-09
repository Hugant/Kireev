package com.example.testsuniversity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
	private RecyclerView recyclerViewThemes;
	private RecyclerView.Adapter mAdapter;
	private RecyclerView.LayoutManager layoutManager;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		recyclerViewThemes = findViewById(R.id.recycler_view_themes);

		layoutManager = new LinearLayoutManager(this);
		recyclerViewThemes.setLayoutManager(layoutManager);

		ArrayList<Theme> themes = new ArrayList<>();
		themes.add(new Theme(12, "My first theme", "My first description, i'm feel lucky today", null));
		themes.add(new Theme(13, "My second theme", "My second description, i'm feel lucky today or not", null));
		themes.add(new Theme(14, "My third theme", "Cash me outside, how about that?", null));

		mAdapter = new ThemesAdapter(themes);
		recyclerViewThemes.setAdapter(mAdapter);
	}
}
