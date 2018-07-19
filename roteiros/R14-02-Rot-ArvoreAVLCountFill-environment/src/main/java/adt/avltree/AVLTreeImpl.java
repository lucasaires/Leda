package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	@Override
	public void remove(T element) {

		BSTNode<T> node = search(element);
		BSTNode<T> rebalance;

		if (!node.isEmpty() && element != null) {

			if (!node.isLeaf()) {
				rebalance = (BSTNode<T>) super.sucessor(element);
			} else {
				rebalance = (BSTNode<T>) node;
			}

			super.remove(node);
			rebalanceUp((BSTNode<T>) rebalance);

		}

	}

	@Override
	public void insert(T element) {
		if (element != null) {
			BSTNode<T> node = super.insert(element, this.getRoot());
			rebalanceUp(node);
		}
	}

	protected int calculoBalance(BSTNode<T> node) {
		if (node != null && !node.isEmpty()) {
			return height((BSTNode<T>) node.getRight()) - height((BSTNode<T>) node.getLeft());
		}
		return 0;
	}

	protected void rebalance(BSTNode<T> node) {
		int height = calculoBalance(node);
		if (height > 1) {
			if (calculoBalance((BSTNode<T>) node.getRight()) < 0) {
				doubleLeftRotation(node);
			} else {
				leftRotation(node);
			}
		} else if (height < -1) {
			if (calculoBalance((BSTNode<T>) node.getLeft()) > 0) {
				doubleRightRotation(node);
			} else
				rightRotation(node);
		}
	}

	protected void rebalanceUp(BSTNode<T> node) {
		if (node != null) {
			BSTNode<T> parent = (BSTNode<T>) node.getParent();
			if (parent != null) {
				rebalance(parent);
				rebalanceUp((BSTNode<T>) parent);
			}
		}
	}

	private void doubleLeftRotation(BSTNode<T> node) {
		rightRotation((BSTNode<T>) node.getRight());
		leftRotation(node);
	}

	private void doubleRightRotation(BSTNode<T> node) {
		leftRotation((BSTNode<T>) node.getLeft());
		rightRotation(node);
	}

	protected void leftRotation(BSTNode<T> node) {
		BSTNode<T> pivot = (BSTNode<T>) node.getRight();

		if (this.getRoot() == node) {
			this.root = pivot;
		}

		Util.leftRotation(node);
	}

	protected void rightRotation(BSTNode<T> node) {
		BSTNode<T> pivot = (BSTNode<T>) node.getLeft();

		if (this.getRoot() == node) {
			this.root = pivot;
		}

		Util.rightRotation(node);
	}
}