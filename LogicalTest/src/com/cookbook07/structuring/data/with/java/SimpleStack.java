package com.cookbook07.structuring.data.with.java;

public interface SimpleStack<T> {
	/** empty - return true if the stack is empty */
	abstract boolean empty();

	/** push - add an element onto the stack */
	abstract void push(T n);

	/** pop - return and remove the top element */
	abstract T pop();

	/** peek - return the top element but don't remove it */
	abstract T peek();
}