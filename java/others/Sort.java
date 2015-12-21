import java.util.Arrays;

/**
 * hujiawei 15/9/12
 */
public class Sort {

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 8, 4, 9, 5, 7};

        minHeapSort(array);
        //array = countSort(array, 9);
        //mergeSort(array, 0, array.length-1);
        //quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    // 拓扑排序
    public static void topsort(){
        //Map<String, Set<String>> graph = new HashMap<String, Set<String>>();
    }

    // 计数排序，c用来统计每个数字出现的次数，b用来保存最终的排序结果
    public static int[] countSort(int[] a, int max) {
        int[] b = new int[a.length];
        int[] c = new int[max + 1];
        for (int item : a) {
            c[item] += 1;
        }
        for (int i = 1; i <= max; i++) {
            c[i] = c[i] + c[i - 1];//迭代递增c
        }
        for (int k = a.length - 1; k >= 0; k--) {
            b[c[a[k]] - 1] = a[k];//这里要减1，否则会对不上
            c[a[k]] -= 1;
        }
        return b;
    }

    // heap sort --- time: O(n*log(n))
    public static void maxHeapSort(int[] s) {
        int n = s.length;
        int last = (n - 2) / 2;// the last node that is not leaf node = the parent of last node is (n-1-1)/2
        int i, j;//
        for (i = last; i >= 0; i--) {// first:build a min heap，从最后一个非叶子节点开始向上不断调整堆，因为叶子节点在它们调整的时候会得到调整的机会
            adjustMinHeap(s, i, n - 1);// then adjust the heap
        }
        System.out.println("Build Heap: " + Arrays.toString(s));// Build Heap: [2, 3, 5, 4, 9, 8, 7]
        for (j = n - 1; j > 0; j--) {//前面建立了最小堆，那么每次都将当前剩下的最小的元素放到最后面
            swap(s, 0, j);// first:change the start node and the end node
            adjustMinHeap(s, 0, j - 1);// after change,adjust the heap
            System.out.println("Current Heap: " + " j = " + j + "   " + Arrays.toString(s));
        }
    }

    // adjust the heap from start node to end node
    // -> 这个堆调整的实现只是调整start节点和它之后的节点，所以一般外面会套一个循环来控制调整的起点节点的范围
    // 调整堆的时候总是从某个节点作为起点开始调整，看这个起点的左右子节点与当前节点的大小关系
    // 如果发生了调整，完了之后可能需要继续调整下去；如果没有发生调整，那么说明已经满足堆的性质了
    private static void adjustMinHeap(int[] s, int start, int end) {
        int j, l, r, min, minIndex, temp;// minIndex = the index of the min node
        j = start;
        temp = s[start];// save it!
        while (2 * j + 1 <= end) {//2 * j + 1 <= end means in giving range,node j still has child
            l = 2 * j + 1;// left node
            r = 2 * j + 2;// right node --- not always exist
            if (r <= end && s[r] < s[l]) {// find the min node of child nodes
                min = s[r];// right node is smaller
                minIndex = r;
            } else {
                min = s[l];// left node is smaller
                minIndex = l;
            }
            if (temp > min) {// parent is bigger,so change!
                s[j] = min;
                s[minIndex] = temp;
                j = minIndex;// change the index of the node,it means the current node has moved to index j
            } else {
                break;// if not,break the while loop
            }
        }
    }

    //////////

    // heap sort --- time: O(n*log(n))
    public static void minHeapSort(int[] s) {
        int n = s.length;
        int last = (n - 2) / 2;// the last node that is not leaf node = the parent of last node is (n-1-1)/2
        int i, j;//
        for (i = last; i >= 0; i--) {// first:build a min heap，从最后一个非叶子节点开始向上不断调整堆，因为叶子节点在它们调整的时候会得到调整的机会
            adjustMaxHeap(s, i, n - 1);// then adjust the heap
        }
        System.out.println("Build Heap: " + Arrays.toString(s));// Build Heap: [2, 3, 5, 4, 9, 8, 7]
        for (j = n - 1; j > 0; j--) {//前面建立了最小堆，那么每次都将当前剩下的最小的元素放到最后面
            swap(s, 0, j);// first:change the start node and the end node
            adjustMaxHeap(s, 0, j - 1);// after change,adjust the heap
            System.out.println("Current Heap: " + " j = " + j + "   " + Arrays.toString(s));
        }
    }

    // adjust the heap from start node to end node -> 这里实际上是建立最大堆
    private static void adjustMaxHeap(int[] s, int start, int end) {
        int j, l, r, max, maxIndex, temp;// maxIndex = the index of the max node
        j = start;
        temp = s[start];// save it!
        while (2 * j + 1 <= end) {//2 * j + 1 <= end means in giving range,node j still has child
            l = 2 * j + 1;// left node
            r = 2 * j + 2;// right node --- not always exist
            if (r <= end && s[r] > s[l]) {// find the max node of child nodes
                max = s[r];// right node is smaller
                maxIndex = r;
            } else {
                max = s[l];// left node is smaller
                maxIndex = l;
            }
            if (temp < max) {// parent is bigger,so change!
                s[j] = max;
                s[maxIndex] = temp;
                j = maxIndex;// change the index of the node,it means the current node has moved to index j
            } else {
                break;// if not,break the while loop
            }
        }
    }

    /////////

    // 快速排序
    public static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = partition(array, start, end);
            quickSort(array, start, mid - 1);//区别于归并排序
            quickSort(array, mid + 1, end);
        }
    }

    // 每次都使用最后一个元素作为pivot
    private static int partition(int[] array, int start, int end) {
        int k = array[end], i = start - 1;
        for (int j = start; j < end; j++) {
            if (array[j] < k) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, end);
        return i + 1;
    }

    // 归并排序
    public static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    // 归并排序的合并操作
    private static void merge(int[] array, int start, int mid, int end) {
        int n1 = mid - start + 1, n2 = end - mid;
        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];
        System.arraycopy(array, start, left, 0, n1);
        System.arraycopy(array, mid + 1, right, 0, n2);
        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;
        int i = 0, j = 0;
        for (int k = start; k <= end; k++) {
            if (left[i] < right[j]) {
                array[k] = left[i++];
            } else {
                array[k] = right[j++];
            }
        }
    }

    // 数组元素交换
    private static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    // half find insert sort --- time: O(n^2)
    public static void halfFindInsertSort(int[] s) {
        int n = s.length;
        int i, j, temp;
        int low, high, mid;
        for (i = 1; i < n; i++) {// begin with 1,end with (n-1)
            temp = s[i];
            low = 0;
            high = i - 1;
            while (low <= high) {// find the insert position --- low
                mid = (low + high) / 2;
                if (s[mid] > temp) {
                    high = mid - 1;
                } else {// equal in here! equal can be ignored
                    low = mid + 1;
                }
            }
            for (j = i; j > low; j--) {// move back one step
                s[j] = s[j - 1];
            }
            s[low] = temp;
        }
    }

    // direct insert sort --- time: O(n^2)
    public static void directInsertSort(int[] s) {
        int n = s.length;
        int i, j, temp;
        for (i = 1; i < n; i++) {// begin with 1,end with (n-1)
            temp = s[i];
            for (j = i - 1; j >= 0 && s[j] > temp; j--) {// condition: current one (s[i]) is smaller
                s[j + 1] = s[j];// move back one step
            }
            s[j + 1] = temp;// final position:j+1
        }

    }

    // select sort --- time: O(n^2)
    public static void selectSort(int[] s) {
        int n = s.length;
        int i, j, min, minIndex, temp;// minIndex: the index of the min number
        for (i = 0; i < n - 1; i++) {// every time select the min number
            minIndex = i;
            min = s[minIndex];
            for (j = i + 1; j <= n - 1; j++) {
                if (s[j] < min) {
                    minIndex = j;
                    min = s[j];
                }
            }
            if (minIndex != i) {// only one change
                temp = s[i];
                s[i] = s[minIndex];
                s[minIndex] = temp;
            }
        }
    }

    // bubble sort --- time: O(n^2)
    public static void bubbleSort(int[] s) {
        int n = s.length;
        int i, j, temp, flag;// flag: change happened?
        for (i = n - 1; i >= 1; i--) {// number from end to begin
            flag = 0;
            for (j = 0; j < i; j++) {// range is smaller
                if (s[j] > s[j + 1]) {
                    temp = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = temp;
                    flag = 1;
                }
            }
            if (flag == 0) {// nothing change, sort is done
                break;
            }
        }
    }

}
