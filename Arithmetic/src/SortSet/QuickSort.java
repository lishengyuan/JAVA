package SortSet;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 1, 2, 7, 10, 3, 4, 5, 9, 8};
        for (int item :
                arr) {
            System.out.print(item + ",");
        }
        QuickSort.sort(arr);
        System.out.println("");
        for (int item :
                arr) {
            System.out.print(item+",");
        }
    }

    public static void sort(int[] arr) {
        if (arr.length > 0)
            sort(arr, 0, arr.length - 1);
    }


    public static void sort(int[] arr, int left, int right) {
        //1找到递归算法的出口
        if (left > right) {
            return;
        }

        int i = left;
        int j = right;
        //选择一个基准值
        int key = arr[left];
        while (i < j) {
            //j从右往左找，找当前数小于key的，找到后j停止
            while (i < j && arr[j] > key) {
                j--;
            }

            //然后让i从左往右，找到当前数大于key的，找到后i停止
            while (i < j && arr[i] <= key) {
                i++;
            }

            //把i和j 进行交换
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }//i++和j--到最后肯定会相等,当i==j时，结束本次循环

        //然后把arr[left](也就是key 基准值)与arr[i]交换
        int temp = arr[i];
        arr[i] = arr[left];
        arr[left] = temp;
        //然后以i为中间线 分成左右两个数组，分别执行（递归）这个（sort)方法
        sort(arr, left, i - 1);
        sort(arr, i + 1, right);
    }
}
