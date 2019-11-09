package com.example.testsuniversity;

import androidx.collection.ArrayMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Theme {
	private Integer id;
	private String name;
	private String description;
	private List<Task> tasks = new ArrayList<>();
	private Map<String, Integer> map;
	private Integer numberAnswered = 0;

	public String getDescription() {
		return description;
	}

	public Theme(Integer id, String name, String description, Map map) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.map = map;
	}

	public String getMark() {
		String mark = null;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (numberAnswered >= entry.getValue()) {
				mark = entry.getKey();
			} else {
				break;
			}
		}

		if (mark == null) {
			return "Тест не пройден";
		}

		return mark;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
