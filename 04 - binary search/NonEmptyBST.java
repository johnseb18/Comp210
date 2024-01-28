package assn04;

public class NonEmptyBST<T extends Comparable<T>> implements BST<T> {
	private T _element;
	private BST<T> _left;
	private BST<T> _right;

	public NonEmptyBST(T element) {
		_left = new EmptyBST<T>();
		_right = new EmptyBST<T>();
		_element = element;
	}

	@Override
	public BST<T> insert(T element){
		if (this.getElement().compareTo(element) <= 0) {
			_right = _right.insert(element);
		}

		if (this.getElement().compareTo(element) > 0) {
			_left = _left.insert(element);

		}
		return this;
	}

	@Override
	public T findMin() {
		if (_left.isEmpty()) {
			return _element;
		}
		return _left.findMin();
	}

	@Override
	public BST<T> remove(T element) {
		if (this.getElement().compareTo(element) > 0) {
			_left = _left.remove(element);
		}
		else if (this.getElement().compareTo(element) < 0) {
			_right = _right.remove(element);
		}
		else if (_right.isEmpty()) {
			return _left;
		}
		else if (_left.isEmpty()) {
			return _right;
		}
		else {


			T minValue = _right.findMin();
			_element = minValue;
			_right = _right.remove(minValue);
		}
		return this;
	}

	@Override
	public void printPreOrderTraversal() {
		if (this.isEmpty()) {
			return;
		}
		System.out.print(_element + " ");

		if (!_left.isEmpty()) {
			_left.printPreOrderTraversal();
		}


		if (!_right.isEmpty()) {
			_right.printPreOrderTraversal();
		}}

	@Override
	public BST<T> printPostOrderTraversal() {
		if (!_left.isEmpty()) {
			_left.printPostOrderTraversal();
		}
		if (!_right.isEmpty()) {
			_right.printPostOrderTraversal();
		}
		System.out.print(_element + " ");

		return this;
	}


	@Override
	public int getHeight() {
			return Math.max(_left.getHeight(), _right.getHeight())+1;
		}


	@Override
	public BST<T> getLeft() {
		return _left;
	}

	@Override
	public BST<T> getRight() {
		return _right;
	}

	@Override
	public T getElement() {
		return _element;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}
}
