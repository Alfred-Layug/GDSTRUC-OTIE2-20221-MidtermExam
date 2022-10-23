package com.otie.gdstruc.midterms;

import java.util.EmptyStackException;

public class CardStack {
    private Card[] stack;
    private int top;

    // constructor that specifies the initial capacity of the stack
    public CardStack(int capacity) {
        stack = new Card[capacity];
        top = 0;
    }

    public void push(Card card) {
        // reallocate the array if the stack is full
        if (isFull()) {
            Card[] newStack = new Card[stack.length * 2];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }

        stack[top++] = card;
    }

    public Card pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack[--top];
    }

    public Card peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack[top - 1];
    }

    public boolean isFull() {
        return top == stack.length;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public int size()
    {
        return top;
    }

    public void printStack() {
        for(int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}