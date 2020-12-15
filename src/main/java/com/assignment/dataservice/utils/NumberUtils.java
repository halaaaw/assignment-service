package com.assignment.dataservice.utils;

import java.util.Arrays;

/**
 * Number utilities
 *
 * @author HALAALI
 *
 */
public class NumberUtils {

  /**
   * checks if the provided String represents a number (including negative and decimal points)
   *
   * @param strNum the string to be checked
   * @return true if the string is a valid number
   */
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

  /**
   * calculates the median value of the provided array values.
   * 
   * @param array unsorted list of values used to calculate the median.
   * @return median value
   */
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
