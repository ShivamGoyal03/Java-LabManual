import java.util.*;

public class Practical10 {
    static class Item implements Comparable<Item> {
        int weight;
        int value;
        double ratio;

        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.ratio = (double) value / weight;
        }

        public int compareTo(Item o) {
            if (this.ratio > o.ratio)
                return -1;
            else if (this.ratio < o.ratio)
                return 1;
            else
                return 0;
        }
    }

    static class Node {
        int level;
        int profit;
        int weight;
        double bound;

        Node(int level, int profit, int weight, double bound) {
            this.level = level;
            this.profit = profit;
            this.weight = weight;
            this.bound = bound;
        }
    }

    public static int knapsack(int W, int[] weights, int[] values) {
        int n = weights.length;
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(weights[i], values[i]);
        }
        Arrays.sort(items);

        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingDouble(node -> -node.bound));
        queue.add(new Node(-1, 0, 0, bound(-1, 0, 0, items, W)));

        int maxProfit = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.bound < maxProfit)
                continue;

            if (node.level == n - 1)
                continue;

            int level = node.level + 1;

            Node leftNode = new Node(level, node.profit + items[level].value, node.weight + items[level].weight,
                    bound(level, node.profit + items[level].value, node.weight + items[level].weight, items, W));

            if (leftNode.weight <= W && leftNode.profit > maxProfit)
                maxProfit = leftNode.profit;

            queue.add(leftNode);

            Node rightNode = new Node(level, node.profit, node.weight, bound(level, node.profit, node.weight, items, W));

            if (rightNode.bound >= maxProfit)
                queue.add(rightNode);
        }

        return maxProfit;
    }

    private static double bound(int level, int profit, int weight, Item[] items, int W) {
        if (weight > W)
            return 0;

        double bound = profit;

        int i = level + 1;
        int totalWeight = weight;

        while (i < items.length && totalWeight + items[i].weight <= W) {
            totalWeight += items[i].weight;
            bound += items[i].value;
            i++;
        }

        if (i < items.length) {
            bound += (W - totalWeight) * items[i].ratio;
        }

        return bound;
    }

    public static void main(String[] args) {
        int W = 50;
        int[] weights = { 10, 20, 30 };
        int[] values = { 60, 100, 120 };
        int maxProfit = knapsack(W, weights, values);
        System.out.println("Maximum profit for Knapsack problem: " + maxProfit);
    }
}