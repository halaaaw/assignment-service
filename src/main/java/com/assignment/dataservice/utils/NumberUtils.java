package com.assignment.dataservice.utils;

import java.util.Arrays;

public class NumberUtils {

  public static boolean isNumeric(String strNum) {
    if (strNum == null) {
      return false;
    }
    try {
      Double.parseDouble(strNum);
    } catch (NumberFormatException nfe) {
      return false;
    }
    return true;
  }

  public static double findMedian(Object[] array) {
    int n = array.length;
    // 1. Sort the array
    Arrays.sort(array);
    // 2. Check for even case
    if (n % 2 != 0) {
      return (Double) array[n / 2];
    }
    // Return Median
    return (((Double) array[(n - 1) / 2] + (Double) array[n / 2]) / 2.0);
  }
}
