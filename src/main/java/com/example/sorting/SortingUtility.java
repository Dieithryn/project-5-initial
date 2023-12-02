package com.example.sorting;

import java.util.ArrayList;

public class SortingUtility {


    public static <T extends Comparable<T>> void gnomeSort(T[] data) {

        //initialize position
        int pos = 0;

        //while list has data
        while (pos < data.length) {

            //either position is 0, or position value is greater than last position value increment. If not, swap positions values.
            if (pos == 0 || data[pos].compareTo(data[pos - 1]) >= data[pos - 1].compareTo(data[pos])) {
                pos++;
            } else {
                swap(data, pos, pos - 1);
                pos--;
            }
        }


    }


    public static <T extends Comparable<T>> void cocktailShakerSort(T[] data) {

        boolean swapped;

        do {

            //initialize swapped flag
            swapped = false;

            for (int i = 0; i < data.length - 1; i++) {
                if (data[i].compareTo(data[i + 1]) > data[i + 1].compareTo(data[i])) {

                    swap(data, i, i + 1);
                    swapped = true;
                }
            }

            if (swapped == false) {
                break;
            }

            swapped = false;

            for (int i = data.length - 1; i > 0;) {

                i--;

                if (data[i].compareTo(data[i + 1]) > data[i + 1].compareTo(data[i])) {

                    swap(data, i, i + 1);
                    swapped = true;

                }
            }

        } while (swapped == true);
    }


    public static <T extends Comparable<T>> void shellSort(T[] data) {

        //I know this is an awful way of doing this, but I can't remember how to do it otherwise.
        ArrayList<Integer> gaps = new ArrayList<>();

        gaps.add(701);
        gaps.add(301);
        gaps.add(132);
        gaps.add(57);
        gaps.add(23);
        gaps.add(10);
        gaps.add(4);
        gaps.add(1);

        for (int gap : gaps) {

            for (int i = gap; i < data.length; i++) {

                T temp = data[i];
                int j;

                for (j = i; (j >= gap) && (data[j - gap].compareTo(temp) > temp.compareTo(data[j - gap])); j -= gap){

                    data[j] = data[j - gap];
                }
                data[j] = temp;
            }

        }


    }

    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {

        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;

    }
}





