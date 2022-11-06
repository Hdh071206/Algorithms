import java.util.Scanner;

public class MinHeap {
    static int[] heap = new int[100005];
    static int size = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            push(sc.nextInt());
        }

        System.out.println("top : " + top());
        for (int i = 1; i <= 10; i++) {
            System.out.print(heap[i] + " ");
        }
        pop();
        pop();
        pop();
        System.out.println("\ntop : " + top());
        for (int i = 1; i <= 10; i++) {
            System.out.print(heap[i] + " ");
        }

        sc.close();
    }
    
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
