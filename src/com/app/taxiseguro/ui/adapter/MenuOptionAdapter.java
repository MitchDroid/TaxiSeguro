package com.app.taxiseguro.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.taxiseguro.R;

public class MenuOptionAdapter extends ArrayAdapter<String> {

	private final Context context;
	private final String[] values;

	public MenuOptionAdapter(Context context, String[] values) {
		super(context, R.layout.option_menu_list_adapter, values);
		this.context = context;
		this.values = values;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View rowView = convertView;
		if (rowView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rowView = inflater.inflate(R.layout.option_menu_list_adapter,
					parent, false);
			ViewHolder viewHolder = new ViewHolder();
			viewHolder.text = (TextView) rowView.findViewById(R.id.label);
			viewHolder.image = (ImageView) rowView.findViewById(R.id.icon);
			rowView.setTag(viewHolder);

		}

		// fill data
		ViewHolder holder = (ViewHolder) rowView.getTag();
		String name = values[position];
		holder.text.setText(name);
		holder.image.setImageResource(R.drawable.ic_action_search);
		

		return rowView;
	}

	static class ViewHolder {
		public TextView text;
		public ImageView image;
	}
}