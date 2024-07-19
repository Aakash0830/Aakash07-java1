import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Word_Break {

	public class Solution_dp {
	    public boolean wordBreak(String s, Set<String> dict) {

	        if (s == null || dict == null || dict.size() == 0)  return false;

	        int length = s.length();

	      
	        boolean[] dp = new boolean[length + 1];
	        dp[0] = true; 

	        for (int i = 0; i < length + 1; i++) {

	            if (dp[i] == false)  {
	            	continue;

	            } else { 
		            for (String each: dict) {

		                if (i + each.length() > length)  continue;

		                if (s.substring(i, i + each.length()).equals(each)) {

		                    dp[i + each.length()] = true;
		                }
		            }
	            }
	        }

	        return dp[length];
	    }
	}




	public class Solution_bfs_over_time {
        public boolean wordBreak(String s, Set<String> wordDict) {

            if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
                return false;
            }

            Queue<String> q = new LinkedList<>();

            q.offer(s);

            while (!q.isEmpty()) {

                String current = q.poll();

             

                for (int i = 0; i < current.length(); i++) {

                    String sub = current.substring(0, i + 1);

                    if (wordDict.contains(sub)) {

                        if (s.endsWith(sub)) { 
                            return true;
                        }

                        q.offer(current.substring(i + 1));
                    }
                }
            }

            return false;
        }
	}


	public class Solution_dfs_over_time {

	    public boolean wordBreak(String s, Set<String> wordDict) {

	        if (s == null || wordDict == null) {
	            return false;
	        }

	        if (s.length() == 0) {
	            return true;
	        }

	        for (int i = 0; i < s.length(); i++) {
	            String sub = s.substring(0, i + 1);

	            if (wordDict.contains(sub)) {
	                boolean isBreakable = wordBreak(s.substring(i + 1), wordDict);

	                if (isBreakable) {
	                    return true;
	                }
	            }
	        }

	        return false;
	    }
	}

}


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}