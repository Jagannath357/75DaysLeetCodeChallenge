import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Create adjacency list and in-degree array
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] inDegree = new int[numCourses];
        
        // Populate the graph: b -> a means b must be taken before a
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];
            adj.get(prerequisite).add(course);
            inDegree[course]++;
        }
        
        // Step 2: Queue up all courses with no prerequisites (in-degree == 0)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // Step 3: Process the courses
        int completedCoursesCount = 0;
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            completedCoursesCount++;
            
            // Reduce the in-degree for all neighboring courses depending on currentCourse
            for (int neighbor : adj.get(currentCourse)) {
                inDegree[neighbor]--;
                
                // If a neighbor has no more dependencies left, add it to the queue
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // Step 4: If we completed all courses, no cycle was detected
        return completedCoursesCount == numCourses;
    }
}