package com.example.testsuniversity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ThemesAdapter extends RecyclerView.Adapter<ThemesAdapter.ThemesViewHolder> {
	private List<Theme> themes = new ArrayList<>();


	public static class ThemesViewHolder extends RecyclerView.ViewHolder {
		public TextView themeName;
		public TextView themeDescription;

		public ThemesViewHolder(View v) {
			super(v);

			themeDescription = v.findViewById(R.id.theme_description);
			themeName = v.findViewById(R.id.theme_name);
		}

		public void bind(Theme theme) {
			themeName.setText(theme.getName());
			themeDescription.setText(theme.getDescription());
		}
	}

	public ThemesAdapter(Collection<Theme> themes) {
		this.themes.addAll(themes);
	}

	@NonNull
	@Override
	public ThemesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		MaterialCardView view = (MaterialCardView) LayoutInflater.from(parent.getContext())
						.inflate(R.layout.theme_item_view, parent, false);

		view.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), TaskActivity.class);
				v.getContext().startActivity(intent);
			}
		});
		return new ThemesViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull ThemesViewHolder holder, int position) {
		holder.bind(themes.get(position));
	}

	@Override
	public int getItemCount() {
		return themes.size();
	}
}
