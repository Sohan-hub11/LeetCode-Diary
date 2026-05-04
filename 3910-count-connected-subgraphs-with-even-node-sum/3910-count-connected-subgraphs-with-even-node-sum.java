class Solution {
    public int evenSumSubgraphs(int[] nums, int[][] edges) {
        int n = nums.length;

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        int count = 0;

        for(int mask = 1; mask < (1 << n); mask++){

            int sum = 0;
            for(int i = 0; i < n; i++){
                if((mask & (1 << i)) != 0){
                    sum += nums[i];
                }
            }

            if(sum % 2 != 0) continue;

            if(isConnected(mask, graph, n)){
                count++;
            }
        }

        return count;
    }

    private boolean isConnected(int mask, List<List<Integer>> graph, int n){

        boolean[] visited = new boolean[n];

        int start = -1;
        for(int i = 0; i < n; i++){
            if((mask & (1 << i)) != 0){
                start = i;
                break;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        int visitedCount = 0;

        while(!q.isEmpty()){
            int node = q.poll();
            visitedCount++;

            for(int nei : graph.get(node)){
                if(!visited[nei] && (mask & (1 << nei)) != 0){
                    visited[nei] = true;
                    q.add(nei);
                }
            }
        }

        int total = Integer.bitCount(mask);

        return visitedCount == total;
    }
}