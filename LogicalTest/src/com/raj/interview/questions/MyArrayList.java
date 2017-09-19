package com.raj.interview.questions;

import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

public class MyArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public E get(int index) {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}

}
