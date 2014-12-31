package net.mike.other;

import java.util.*;

/**
 * Created by doliu on 12/20/14.
 */
public class MergingIterator<E> implements Iterator<E> {

	private List<Iterator<E>> iterators;
	private PriorityQueue<E> minHeap;

	public MergingIterator(List<Iterator<E>> iterators) {
		this.iterators = iterators == null ? new ArrayList<Iterator<E>>() : iterators;
		minHeap = new PriorityQueue<>(this.iterators.size());
	}

	@Override
	public boolean hasNext() {
		if (!minHeap.isEmpty()) return true;
		for (Iterator<E> iter : iterators) {
			if (iter.hasNext()) return true;
		}
		return false;
	}

	@Override
	public E next() {
		for (Iterator<E> iter : iterators) {
			if (iter.hasNext()) minHeap.add(iter.next());
		}
		return minHeap.poll();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	public static class MergingIteratorWithMap<E> implements Iterator<E> {

		private SortedMap<E, Iterator<E>> values;

		MergingIteratorWithMap(List<Iterator<E>> iterators) {
			if (iterators != null) {
				values = new TreeMap<>();
				for (Iterator<E> iter : iterators) {
					if (iter != null && iter.hasNext()) {
						values.put(iter.next(), iter);
					}
				}
			}
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public E next() {
			if (values.isEmpty()) throw new NoSuchElementException();
			E key = values.firstKey();
			Iterator<E> value = values.get(key);
			if (value.hasNext()) {
				values.put(value.next(), value);
			}
			values.remove(key);
			return key;
		}

		@Override
		public boolean hasNext() {
			return !values.isEmpty();
		}
	}
}
