package ru.spbu.apcyb.svp.tasks;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


/**
 * Связный список на основе массива.
 * */
public class LinearList implements List<Object> {

  private Object[] list;
  private int size;
  private int elementCount;

  /**
   * Конструктор связного списка.
   * */
  public LinearList() {
    int defaultSize = 5;
    list = new Object[defaultSize];
    size = list.length;
    elementCount = 0;
  }

  /**
   * Изменение размера.
   */
  public void resize() {
    int newSize = size + 1;
    list = Arrays.copyOf(list, newSize);
    size = newSize;
  }

  /**
   * Добавление элемента в конец списка.
   *
   * @param element элемент добавления.
   */
  public void addToEnd(Object element) {
    if (elementCount >= size) {
      resize();
    }
    list[elementCount] = element;
    elementCount += 1;
  }

  @Override
  public Object remove(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index > elementCount) {
      throw new IndexOutOfBoundsException("Неправильный индекс");
    }
    final Object removeElement = list[index];
    for (int i = index; i < elementCount - 1; i++) {
      list[index] = list[index + 1];
    }
    list[elementCount - 1] = null;
    elementCount -= 1;
    return removeElement;
  }

  @Override
  public boolean remove(Object o) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("");
  }

  @Override
  public boolean contains(Object element) {
    for (int i = 0; i < size; i++) {
      if (list[i] == element) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean isEmpty() {
    return elementCount == 0;
  }

  @Override
  public Object get(int index) {
    return list[index];
  }

  @Override
  public void add(int index, Object element) throws IndexOutOfBoundsException {
    if (index < 0 || index > elementCount) {
      throw new IndexOutOfBoundsException("Неправильный индекс");
    }
    if (elementCount >= size) {
      resize();
    }
    System.arraycopy(list, index, list, index + 1, elementCount - index);
    list[index] = element;
    elementCount += 1;
  }

  @Override
  public boolean add(Object o) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("");
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public Object[] toArray() throws UnsupportedOperationException {
    throw new UnsupportedOperationException("");
  }

  @Override
  public <T> T[] toArray(T[] a) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("");
  }

  @Override
  public boolean addAll(Collection<?> c) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("");
  }

  @Override
  public boolean addAll(int index, Collection<?> c) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("");
  }

  @Override
  public void clear() throws UnsupportedOperationException {
    throw new UnsupportedOperationException("");
  }

  @Override
  public Object set(int index, Object element) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("");
  }

  @Override
  public int indexOf(Object o) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("");
  }

  @Override
  public int lastIndexOf(Object o) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("");
  }

  @Override
  public ListIterator<Object> listIterator() throws UnsupportedOperationException {
    throw new UnsupportedOperationException("");
  }

  @Override
  public ListIterator<Object> listIterator(int index) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("");
  }

  @Override
  public Iterator<Object> iterator() throws UnsupportedOperationException {
    throw new UnsupportedOperationException("");
  }

  @Override
  public List<Object> subList(int fromIndex, int toIndex) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("");
  }

  @Override
  public boolean retainAll(Collection c) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("");
  }

  @Override
  public boolean removeAll(Collection c) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("");
  }

  @Override
  public boolean containsAll(Collection c) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("");
  }
}

