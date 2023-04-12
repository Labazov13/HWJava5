package org.example;
public class Exam3 {
            public static void heapSort(int[] arr)
            {
                int n = arr.length;
                for (int i = n / 2 - 1; i >= 0; i--){
                    heapify(arr, n, i);
                }
                for (int i = n-1; i >= 0; i--)
                {
                    int temp = arr[0];
                    arr[0] = arr[i];
                    arr[i] = temp;
                    heapify(arr, i, 0);
                }
            }
            public static void heapify(int[] arr, int n, int i)
            {
                int largest = i;
                int l = 2 * i + 1;
                int r = 2 * i + 2;
                if (l < n && arr[l] > arr[largest])
                    largest = l;
                if (r < n && arr[r] > arr[largest])
                    largest = r;
                if (largest != i)
                {
                    int swap = arr[i];
                    arr[i] = arr[largest];
                    arr[largest] = swap;
                    heapify(arr, n, largest);
                }
            }
            static void printArray(int[] arr)
            {
                int n = arr.length;
                for (int j : arr) System.out.print(j + " ");
                System.out.println();
            }

            // Управляющая программа
            public static void main(String[] args)
            {
                int [] array = new int []{100, 65, 41, 1, 0, 66, 115, 3, 6};
                int n = array.length;
                heapSort(array);
                printArray(array);
            }
        }
