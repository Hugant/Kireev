package com.example.testsuniversity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskActivity extends AppCompatActivity {
	private ImageView imageView;
	private TextView textView;
	private LinearLayout linearLayout;
	private Button prevButton;
	private Button nextButton;
	private int current = 0;
	private List<Task> tasks = new ArrayList<>();

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		this.finish();
	}
	@Override
	public boolean onSupportNavigateUp() {
		onBackPressed();
		return true;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.task_view);
//		Toolbar toolbar = findViewById(R.id.toolbar);
//		setSupportActionBar(toolbar);
//		getSupportActionBar().setHomeButtonEnabled(true);
//		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		imageView = findViewById(R.id.task_image);
		textView = findViewById(R.id.task_question);
		linearLayout = findViewById(R.id.task_answers);
		prevButton = findViewById(R.id.task_prev);
		nextButton = findViewById(R.id.task_next);

		prevButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (current > 0) {
					current--;
					bindTask(tasks.get(current));
				}
			}
		});

		nextButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (current < tasks.size() - 1) {
					current++;
					bindTask(tasks.get(current));
				}
			}
		});

		parseData();

		bindTask(tasks.get(current));
	}

	public void parseData() {
		ArrayList<Task> tasks = new ArrayList<>();
		ArrayList<Answer> answers = new ArrayList<>();
		answers.add(new Answer("It's true answer", true));
		answers.add(new Answer("It's false answer", false));
		tasks.add(new Task(12, "The 4:25 bus to the metro airport has a travel time of 1 hour and 45 minutes. The bus is running late today though. What will be the arrival time to the airport?", null, answers));
		tasks.add(new Task(13, "Do the words fruitful and prolific have opposite meanings, similar meanings or no relation?", null, answers));
		tasks.add(new Task(43, "Janine’s shoes cost $44.50, her pants cost $20.80 and her t-shirt cost $14.95. What is the total of her purchases?", null, answers));
		this.tasks.addAll(tasks);
	}

	public void bindTask(Task task) {
		textView.setText(task.getQuestion());

		linearLayout.removeAllViews();
		for (Answer answer : task.getAnswers()) {
			View view = LayoutInflater.from(this)
							.inflate(R.layout.answer_item_view, null, false);
			TextView textView = view.findViewById(R.id.answer_item_text);
			textView.setText(answer.getAnswer());
			linearLayout.addView(view);
		}
	}
}
