package ru.spbu.apcyb.svp.tasks;

import java.util.Stack;


/**
 * Стек на основе списка.
 */

// Ругался, что в классе написаны не все методы для аннотации @Override
@SuppressWarnings("squid:S2160")
public class ListStack extends Stack<Object> {

  private final transient LinearList stack;

  public ListStack() {
    stack = new LinearList();
  }

  @Override
  public Object push(Object element) {
    stack.add(0, element);
    return element;
  }

  @Override
  public synchronized Object pop() {
    return stack.remove(0);
  }

  @Override
  public synchronized Object peek() {
    return stack.get(0);
  }

  @Override
  public synchronized boolean empty() {
    return stack.isEmpty();
  }
}

