package ru.spbu.apcyb.svp.tasks;

import java.util.Arrays;
import java.util.Scanner;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Задание 1.
 */
public class Task1 {

  private static final Logger logger = LogManager.getLogger(Task1.class);
  private static final String SYNTAX_ERROR = "Ошибка: неверный ввод;";

  /**
   * Проверка число на положительность.
   *
   * @param number число для проверки.
   * @return новое число.
   */

  public static long check(long number) {
    Scanner in = new Scanner(System.in);
    while (number <= 0) {
      logger.log(Level.ERROR, "Ошибка; Введите значение > 0: ");
      try {
        number = in.nextLong();
      } catch (Exception e) {
        throw new IllegalArgumentException(SYNTAX_ERROR);
      }
    }
    return number;
  }

  /**
   * Вводим необходимую сумму .
   */

  public static long enterSum() {
    long sum;
    Scanner in = new Scanner(System.in);
    logger.log(Level.INFO, "Введите сумму S = ");
    try {
      sum = in.nextLong();
    } catch (Exception e) {
      throw new IllegalArgumentException(SYNTAX_ERROR);
    }
    sum = check(sum);
    return sum;
  }


  /**
   * Вводим кол- во монет.
   */

  public static long enterAmount() {
    long n;
    Scanner in = new Scanner(System.in);
    logger.log(Level.INFO, "Введите количество монет n = ");
    try {
      n = in.nextLong();
    } catch (Exception e) {
      throw new IllegalArgumentException(SYNTAX_ERROR);
    }
    n = check(n);
    return n;
  }

  /**
   * Вводим номиналы монеты .
   *
   * @param n Кол- во монет.
   * @return массив монет.
   */

  public static long[] enterCoins(long n) {
    int size = (int) n;
    long[] coins = new long[size];
    Scanner in = new Scanner(System.in);
    logger.log(Level.INFO, "Введите номиналы:\n");
    for (int i = 0; i < size; i++) {
      logger.log(Level.INFO, "a[{}] = ", i);
      try {
        coins[i] = in.nextLong();
      } catch (Exception e) {
        throw new IllegalArgumentException(SYNTAX_ERROR);
      }
      coins[i] = check(coins[i]);
    }
    return coins;
  }

  /**
   * Сортируем и убираем повторяющиеся номиналы .
   *
   * @param arr массив для обработки.
   * @return отсортированный массив без повторяющихся элементов .
   */

  public static long[] order(long[] arr) {
    int i;
    int j;
    int k = 0;
    long[] temp = new long[arr.length];
    for (i = 0; i < arr.length; i++) {
      for (j = 0; j < k; j++) {
        if (arr[i] == temp[j]) {
          break;
        }
      }
      if (j == k) {
        temp[k] = arr[i];
        k++;
      }
    }
    long[] arrayWithoutDupclicate = Arrays.copyOfRange(temp, 0, k);
    Arrays.sort(arrayWithoutDupclicate);
    return arrayWithoutDupclicate;
  }

  /**
   * Убираем неположительные номиналы и те, что больше заданной суммы.
   *
   * @param coins массив номиналов .
   * @param sum   сумма.
   * @return обработанный массив.
   */

  public static long[] deleteUselessElements(long[] coins, long sum) {
    int i;
    for (i = coins.length - 1; i > 0; i--) {
      if (coins[i] <= sum) {
        break;
      }
    }
    if (coins[i] > sum) {
      logger.log(Level.INFO, "Все номиналы больше суммы;");
      return new long[1];
    }
    return Arrays.copyOfRange(coins, 0, i + 1);
  }

  /**
   * Красивый вывод.
   *
   * @param coins        массив номиналов .
   * @param numberOfUses массив использований каждого номинала .
   * @param num          номер размена .
   */

  public static void print(long[] coins, long[] numberOfUses, long num) {
    logger.log(Level.INFO, "Размен № {} - ", num);
    for (int i = 0; i < numberOfUses.length; i++) {
      if (numberOfUses[i] != 0) {
        logger.log(Level.INFO, "{}x({}); ", numberOfUses[i], coins[i]);
      }
    }
    logger.log(Level.INFO, "\n");
  }


  /**
   * Поиск комбинаций.
   *
   * @param sum          Необходимая сумма .
   * @param tempSum      Сумма после вычета номинала .
   * @param coins        Массив номиналов .
   * @param numberOfUses Массив использований каждого номинала .
   * @param index        Индекс указывающий на используемый номинал.
   * @param num          Счётчик размена .
   * @return Номер размена.
   */

  public static int searchOfOptions(long sum, long tempSum, long[] coins, long[] numberOfUses,
      int index, int num) {
    long div = sum / coins[index];
    for (long i = 0; i <= div; i++) {
      if (tempSum >= 0) {
        numberOfUses[index] = i;
        if (tempSum == 0) {
          num++;
          print(coins, numberOfUses, num);
        } else if (index + 1 < coins.length) {
          num = searchOfOptions(sum, tempSum, coins, numberOfUses, index + 1, num);
        }
      }
      tempSum -= coins[index];
    }
    return num;
  }

  /**
   * Мэйн .
   *
   * @param args вспомгательный аргумент .
   */

  public static void main(String[] args) {
    long sum = enterSum();
    long amountOfCoins = enterAmount();
    long[] coins = enterCoins(amountOfCoins);
    coins = order(coins);
    coins = deleteUselessElements(coins, sum);
    long[] numberOfUses = new long[coins.length];
    searchOfOptions(sum, sum, coins, numberOfUses, 0, 0);
  }
}