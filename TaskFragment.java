package com.cocosw.taskfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;

/**
 * TaskFragment is designed to provide a container for complex &amp; reusable
 * functions in Android platform.
 * 
 * @author soar
 * 
 */
public abstract class TaskFragment<V> extends Fragment {

	private CallBack<V> callback;
	// You can even use targetFragment's UI
	protected View view;

	@Override
	public void onActivityCreated(final Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		if (getTargetFragment() != null) {
			view = (getTargetFragment().getView());
		}
		work(getArguments());
	}

	protected abstract void work(final Bundle b);

	protected void run(final Fragment f, final Bundle b,
			final CallBack<V> callback) {
		final TaskFragment<?> lasttask = TaskFragment.getTaskFragment(f
				.getFragmentManager());
		if (lasttask != null) {
			f.getFragmentManager().beginTransaction().remove(lasttask).commit();
		}
		if (b != null) {
			setArguments(b);
		}
		setCallback(callback);
		setTargetFragment(f, 0);
		f.getFragmentManager().beginTransaction().add(this, "_taskfragment_")
				.commit();
	}

	public static TaskFragment<?> getTaskFragment(final FragmentManager fm) {
		return (TaskFragment<?>) fm.findFragmentByTag("_taskfragment_");
	}

	private void setCallback(final CallBack<V> callback) {
		this.callback = callback;
	}

	protected void run(final Fragment f) {
		run(f, null, null);
	}

	protected CallBack<V> getCallback() {
		if (callback == null) {
			callback = new CallBack<V>() {

				@Override
				public void callback(final V object) {
				}

				@Override
				public void failback(final V object, final Exception status) {
				}
			};
		}
		return callback;
	}

	public interface CallBack<T> {

		public void callback(T object);

		public void failback(T object, Exception status);
	}

}