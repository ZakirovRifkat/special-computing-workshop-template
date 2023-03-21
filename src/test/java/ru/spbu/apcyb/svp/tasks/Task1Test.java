package ru.spbu.apcyb.svp.tasks;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

/**
 * Тесты для задания 1.
 */
class Task1Test {

  @Test
  void print() {
    long[] coins = {1};
    long[] use = {0, 2, 3};
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> Task1.print(coins, use, 5));
  }

  @Test
  void enterSum() {
    System.setIn(new ByteArrayInputStream("5".getBytes()));
    assertEquals(5, Task1.enterSum());
    System.setIn(System.in);
  }

  @Test
  void enterSum1() {
    System.setIn(new ByteArrayInputStream("asadasd".getBytes()));
    assertThrows(IllegalArgumentException.class, Task1::enterSum);
    System.setIn(System.in);
  }

  @Test
  void enterAmount1() {
    System.setIn(new ByteArrayInputStream("5".getBytes()));
    assertEquals(5, Task1.enterAmount());
    System.setIn(System.in);
  }

  @Test
  void enterAmount2() {
    System.setIn(new ByteArrayInputStream("asdfsa".getBytes()));
    assertThrows(IllegalArgumentException.class, Task1::enterSum);
    System.setIn(System.in);
  }

  @Test
  void enterCoins() {
    System.setIn(new ByteArrayInputStream("3 5 4".getBytes()));
    long[] actual = Task1.enterCoins(3);
    System.setIn(System.in);
    long[] expected = {3, 5, 4};
    assertArrayEquals(expected, actual);
  }

  @Test
  void check1() {
    assertEquals(6, Task1.checkForPositive(6));
  }

  @Test
  void check2() {
    assertDoesNotThrow(() -> Task1.checkForPositive(1));
  }

  @Test
  void order() {
    long[] arr = {5, 22, 22, 0, -5, 0, 0, 0, 7, 5};
    long[] actual = Task1.order(arr, 22);
    long[] expected = {-5, 0, 5, 7, 22};
    assertArrayEquals(expected, actual);
  }

  @Test
  void order1() {
    long[] arr = {};
    long[] actual = Task1.order(arr, 5);
    long[] expected = {};
    assertArrayEquals(expected, actual);
  }

  @Test
  void searchOfOptions() {
    long[] coins = {1, 2};
    long[] use = new long[coins.length];
    long actual = Task1.searchOfOptions(5, 5, coins, use, 0, 0);
    assertEquals(3, actual);
  }

  @Test
  void searchOfOptions1() {
    long[] coins = {0};
    long[] use = new long[coins.length];
    assertThrows(ArithmeticException.class,
        () -> Task1.searchOfOptions(1, 1, coins, use, 0, 0));
  }


  @Test
  void searchOfOptions2() {
    long[] coins = {5};
    long[] use = new long[coins.length];
    long actual = Task1.searchOfOptions(5, 0, coins, use, 0, 0);
    assertEquals(1, actual);
  }

  @Test
  void searchOfOptions3() {
    long[] coins = {1};
    long[] use = new long[coins.length];
    long actual = Task1.searchOfOptions(-4, -4, coins, use, 0, 0);
    assertEquals(0, actual);
  }

  @Test
  void searchOfOptions4() {
    long[] coins = {1};
    long[] use = new long[coins.length];
    assertThrows(ArrayIndexOutOfBoundsException.class,
        () -> Task1.searchOfOptions(5, 5, coins, use, 3, 0));
  }

  @Test
  void searchOfOptions5() {
    long[] coins = {1};
    long[] use = {0, 1, 2};
    assertThrows(ArrayIndexOutOfBoundsException.class,
        () -> Task1.searchOfOptions(5, 5, coins, use, 0, 0));
  }

  @Test
  void searchOfOptions6() {
    long[] coins = {1, 2, 3};
    long[] use = {0};
    assertThrows(ArrayIndexOutOfBoundsException.class,
        () -> Task1.searchOfOptions(5, 5, coins, use, 0, 0));
  }
}
