package org.mariotaku.twidere.adapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class ArrayAdapter<T> extends BaseAdapter {

	private final LayoutInflater mInflater;
	private final int mLayoutRes;

	private final ArrayList<T> mData = new ArrayList<T>();

	public ArrayAdapter(final Context context, int layoutRes) {
		mInflater = LayoutInflater.from(context);
		mLayoutRes = layoutRes;
	}

	@Override
	public final int getCount() {
		return mData.size();
	}

	@Override
	public final T getItem(int position) {
		return mData.get(position);
	}

	public final void add(final T item) {
		if (item == null) return;
		mData.add(item);
		notifyDataSetChanged();
	}

	public final void clear() {
		mData.clear();
		notifyDataSetChanged();
	}

	public final void addAll(Collection<? extends T> collection) {
		mData.addAll(collection);
		notifyDataSetChanged();
	}

	public final void sort(Comparator<? super T> comparator) {
		Collections.sort(mData, comparator);
		notifyDataSetChanged();
	}

	public final T findItem(final long id) {
		final int count = getCount();
		for (int i = 0; i < count; i++) {
			if (getItemId(i) == id) return getItem(i);
		}
		return null;
	}

	public final int findItemPosition(final long id) {
		final int count = getCount();
		for (int i = 0; i < count; i++) {
			if (getItemId(i) == id) return i;
		}
		return -1;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return convertView != null ? convertView : mInflater.inflate(mLayoutRes, null);
	}

}
