package com.example.testsuniversity;

import android.media.Image;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Task {
	private Integer id;
	private String question;
	private Image image;

	private List<Answer> answers = new ArrayList<>();

	public Task(Integer id, String question, Image image, List<Answer> answers) {
		this.id = id;
		this.question = question;
		this.image = image;
		this.answers.addAll(answers);
	}

	public boolean isAnswered() {
		for (Answer answer : answers) {
			if (answer.isTruth() && !answer.isChecked()) {
				return false;
			}

			if (!answer.isTruth() && answer.isChecked()) {
				return false;
			}
		}

		return true;
	}

	public Integer getId() {
		return id;
	}

	public String getQuestion() {
		return question;
	}

	public Image getImage() {
		return image;
	}

	public List<Answer> getAnswers() {
		return answers;
	}
}
