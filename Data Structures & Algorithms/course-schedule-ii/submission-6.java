class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];

            indegree[course]++;
            map.get(prereq).add(course);
        }
        
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offerLast(i);
            }
        }
        

        int index = 0;
        int[] result = new int[numCourses];

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result[index++] = cur;

            for (int next : map.get(cur)) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return index == numCourses ? result : new int[0];

    }
}
