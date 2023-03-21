package ru.spbu.apcyb.svp.tasks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
/**
 * Тесты Task 2.
 */

@SuppressWarnings("ALL")
class LinearListTest {
  LinearList list = new LinearList();
  LinearList list2 = new LinearList();

  @Test
  void containsAll() throws UnsupportedOperationException {
    assertThrows(UnsupportedOperationException.class, () -> list.containsAll(list2));
  }

  @Test
  void addAll() throws UnsupportedOperationException {
    assertThrows(UnsupportedOperationException.class, () -> list.addAll(list2));
  }

  @Test
  void addAll2() throws UnsupportedOperationException {
    assertThrows(UnsupportedOperationException.class, () -> list.addAll(0, list2));

  }

  @Test
  void testAddAll()throws UnsupportedOperationException {
    assertThrows(UnsupportedOperationException.class, () -> list.addAll(list2));
  }

  @Test
  void removeAll() throws UnsupportedOperationException {
    assertThrows(UnsupportedOperationException.class, () -> list.removeAll(list2));
  }

  @Test
  void retainAll() throws UnsupportedOperationException {
    assertThrows(UnsupportedOperationException.class, () -> list.retainAll(list2));
  }

  @Test
  void clear() throws UnsupportedOperationException {
    assertThrows(UnsupportedOperationException.class, () -> list.clear());
  }

  @Test
  void set() throws UnsupportedOperationException {
    assertThrows(UnsupportedOperationException.class, () -> list.set(0, null));
  }

  @Test
  void indexOf() throws UnsupportedOperationException {
    assertThrows(UnsupportedOperationException.class, () -> list.indexOf(null));
  }

  @Test
  void lastIndexOf() throws UnsupportedOperationException {
    assertThrows(UnsupportedOperationException.class, () -> list.lastIndexOf(null));
  }

  @Test
  void listIterator() throws UnsupportedOperationException {
    assertThrows(UnsupportedOperationException.class, list::listIterator);
  }

  @Test
  void testListIterator() throws UnsupportedOperationException {
    assertThrows(UnsupportedOperationException.class, () -> list.listIterator(0));
  }

  @Test
  void testSubList() throws UnsupportedOperationException {
    assertThrows(UnsupportedOperationException.class, () -> list.subList(0, 1));
  }

  @Test
  void testToArray() throws UnsupportedOperationException {
    assertThrows(UnsupportedOperationException.class, () -> {
      Object[] elements = new Object[0];
      list.toArray(elements);
    });
  }

  @Test
  void testToArray2() throws UnsupportedOperationException {
    assertThrows(UnsupportedOperationException.class, list::toArray);
  }

  @Test
  void testIterator() throws UnsupportedOperationException {
    assertThrows(UnsupportedOperationException.class, list::iterator);
  }

  @Test
  void size() {
    assertEquals(5, list.size());
  }

  @Test
  void resize() {
    list.resize();
    assertEquals(6, list.size());
  }

  @Test
  void isEmpty() {
    assertTrue(list.isEmpty());
  }

  @Test
  void addToEnd() {
    list.addToEnd(5);
    assertFalse(list.isEmpty());
  }

  @Test
  void remove1() {
    assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-5));
  }

  @Test
  void remove2() {
    list.addToEnd(6);
    list.addToEnd(5);
    list.addToEnd(4);
    list.addToEnd(3);
    list.addToEnd(2);
    list.addToEnd(1);
    assertEquals(2, list.remove(4));
  }

  @Test
  void contains() {
    list.addToEnd(6);
    list.addToEnd(5);
    list.addToEnd(4);
    list.addToEnd(3);
    list.addToEnd(2);
    list.addToEnd(1);
    assertFalse(list.contains(-5));
  }

  @Test
  void add1() {
    assertThrows(IndexOutOfBoundsException.class, () -> list.add(-5, 5));
  }

  @Test
  void add2() {
    list.addToEnd(6);
    list.addToEnd(5);
    list.addToEnd(4);
    list.add(3, "word");
    assertEquals("word", list.get(3));
  }
}
