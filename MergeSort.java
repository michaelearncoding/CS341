public class MergeSort {
    // 合并两个子数组
    void merge(int arr[], int l, int m, int r) {
        System.err.println("They are merging right now");
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];


        // 将数据复制到临时数组
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        // 合并两个子数组
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // 将剩余元素复制到数组
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // 递归地进行归并排序
    void sort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            System.err.println("left: " + l + " middle: " + m + " right: " + r);
            sort(arr, l, m);
            System.out.println("Fuction return");
            System.err.println("l: " + l + " m: " + m + " r: " + r + "Keep going");

            // first time : 0+1-> left , 1 -> right, 所以直接跳過 並 Keep going
            sort(arr, m + 1, r);
            System.out.println("Fuction2 return");
            merge(arr, l, m, r);
        }
    }

    public static void main(String args[]) {
        int arr[] = {12, 11, 13};

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}