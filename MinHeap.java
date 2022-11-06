import java.util.Scanner;

public class MinHeap {
    static int[] heap = new int[100005];
    static int size = 1;
    
    static int top() { // perfect
        return heap[1];
    }

    static void push(int x) { // perfect
        heap[size] = x;
        for (int i = size; i >= 1;) {
            if (heap[i] < heap[i/2]) {
                swap(i, i/2);
            }
            else break;
            i /= 2;
        }
        size++;
    }

    static void pop() {
        swap(1, size); heap[size--] = 0;
        for (int i = 1; i < size;) {
            int ch1 = i * 2, ch2 = i * 2 + 1;
            if (heap[i] < heap[ch1] && heap[i] < heap[ch2]) break;
            else if (heap[ch1] < heap[ch2]) {
                swap(ch1, i);
                i = ch1;
            }
            else {
                swap(ch2, i);
                i = ch2;
            }
        }
    }

    static void swap(int ix, int iy) {  // perfect
        int temp = heap[ix];
        heap[ix] = heap[iy];
        heap[iy] = temp; 
    }
}
