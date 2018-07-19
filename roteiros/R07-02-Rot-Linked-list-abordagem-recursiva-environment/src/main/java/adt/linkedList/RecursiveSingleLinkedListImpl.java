package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	public RecursiveSingleLinkedListImpl(T data, RecursiveSingleLinkedListImpl<T> next) {
		this.data = data;
		this.next = next;
	}

	@Override
	public boolean isEmpty() {
		return isNil();
	}

	public boolean isNil() {
		return data == null;
	}

	@Override
	public int size() {
		if (isNil()) {
			return 0;
		} else {
			return 1 + next.size();
		}
	}

	@Override
	public T search(T element) {
		if (isNil()) {
			return null;
		} else {
			if (data.equals(element)) {

				return data;

			} else {
				return next.search(element);
			}

		}
	}

	@Override
	public void insert(T element) {
		if (isEmpty()) {
			data = element;
			next = new RecursiveSingleLinkedListImpl<T>();
		} else {
			next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if (isEmpty()) {
		} else {
			if (data.equals(element)) {
				data = next.data;
				next = next.next;
			} else {
				next.remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[size()];

		toArray(array, this, 0);

		return array;
	}

	public void toArray(T[] array, RecursiveSingleLinkedListImpl<T> current, int i) {
		if (current.isNil())
			return;

		array[i] = current.getData();
		toArray(array, current.getNext(), i + 1);
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
