package com.sample.m3.sales.random;

import static com.sample.m3.sales.random.RandomUtil.randomElement;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

import com.sample.m3.sales.*;

public class RandomItems {

  public static Stream<Item> infiniteStream() {
    return Stream.generate(new RandomItems().itemSupplier);
  }

  private Supplier<Item> itemSupplier = () ->
          new Item(pickAnIdentity(), pickAPrice());

  private Random random = new Random();

  private static final double MAX_PRICE = 150.00;
  private Double pickAPrice() {
    return Math.round(random.nextDouble() * MAX_PRICE * 100) / 100.0; // might be free
  }

  private static final String[] AVAILABLE_ITEMS = new String[] {
  "carrot", "eggs", "lizard", "cookie", "pickle", "cow", "rug"};
  private String pickAnIdentity() {
     return randomElement(AVAILABLE_ITEMS);
  }
}
