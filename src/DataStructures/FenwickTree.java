package DataStructures;

public class FenwickTree {
    long[] tree;
    int n;

    FenwickTree(int size) {
        n = size;
        tree = new long[n + 2];
    }

    void update(int i, long val) {
        for (++i; i <= n; i += i & -i)
            tree[i] += val;
    }

    long query(int i) {
        long res = 0;
        for (++i; i > 0; i -= i & -i)
            res += tree[i];
        return res;
    }
}
