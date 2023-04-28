// 0/1 Knapsack Problem using branch and bound
// Shivam
// 21CSU090

import java.util.*;

class Item {
    int weight;
    int value;

    Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

class Node {
    int level;
    int profit;
    int bound;
    int weight;
}

public class Practical10 {
    public static int N = 3;
    public static int W = 50;
    public static void main(String[] args) {
        Item[] items = new Item[N];
        items[0] = new Item(10, 60);
        items[1] = new Item(20, 100);
        items[2] = new Item(30, 120);
        System.out.println(knapsack(items));

    }

    public static int knapsack(Item[] items) {
        Arrays.sort(items, (a, b) -> b.value * a.weight - a.value * b.weight);
        Queue<Node> Q = new LinkedList<>();
        Node u = new Node();
        Node v = new Node();
        u.level = -1;
        u.profit = u.weight = 0;
        Q.offer(u);
        int maxProfit = 0;

        while (!Q.isEmpty()) {
            u = Q.poll();
            if (u.level == -1)
                v.level = 0;
            if (u.level == N - 1)
                continue;
            v.level = u.level + 1;
            v.weight = u.weight + items[v.level].weight;
            v.profit = u.profit + items[v.level].value;
            if (v.weight <= W && v.profit > maxProfit)
                maxProfit = v.profit;
            v.bound = bound(v, N, W, items);

            if (v.bound > maxProfit)
                Q.offer(v);
            v.weight = u.weight;
            v.profit = u.profit;
            v.bound = bound(v, N, W, items);
            if (v.bound > maxProfit)
                Q.offer(v);
        }
        return maxProfit;
    }

    public static int bound(Node u, int n, int W, Item[] items) {
        if (u.weight >= W)
            return 0;
        int profitBound = u.profit;
        int j = u.level + 1;
        int totweight = u.weight;
        while ((j < n) && (totweight + items[j].weight <= W)) {
            totweight += items[j].weight;
            profitBound += items[j].value;
            j++;
        }

        if (j < n)
            profitBound += (W - totweight) * items[j].value / items[j].weight;

        return profitBound;
    }
}