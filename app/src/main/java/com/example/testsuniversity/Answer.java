package com.example.testsuniversity;

public class Answer {
	private String answer;
	private boolean truth;
	private boolean checked;

	public Answer(String answer, boolean truth) {
		this.answer = answer;
		this.truth = truth;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean isChecked() {
		return checked;
	}

	public boolean isTruth() {
		return truth;
	}

	public String getAnswer() {
		return answer;
	}
}
