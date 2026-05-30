class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];

        
        //每个节点现在的parent都是他们自己
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int parentU = find(parent, u);
            int parentV = find(parent, v);

            if (parentU == parentV) return edge;
            
            //更新parent是谁
            parent[parentU] = parentV;
        }
        return new int[0];
        

        
    }

    private int find(int[] parent, int k) {
        while (parent[k] != k) {
            k = parent[k];
        }
        return k;
    }
}
