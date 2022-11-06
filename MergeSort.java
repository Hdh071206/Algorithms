public class MergeSort {

    void merge_sort(int st, int en) {
        if (en == st + 1) return;
        int mid = (st + en) / 2;
        merge_sort(st, mid);
        merge_sort(mid+1, en);
        merge(st, en);
    }

    void merge(int st, int en) {
        int mid = (st + en) / 2;
        int l = st;
        int r = mid;
        for (int i = st; i < en; i++) {
            if (l == mid) temp[i] = list[r++];
            else if (r == en) temp[i] = list[l++];
            else if (list[l] < list[r]) temp[i] = list[l++];
            else temp[i] = list[r++];
        }
        for (int i = st; i < en; i++) list[i] = temp[i];
    }
    
}
