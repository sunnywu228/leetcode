package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 * 
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * 
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * 
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
 * 
 * @author chengyangwu
 *
 */
public class WordLadder {
	public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashSet<String> set = new HashSet<String> ();
        Queue<String> q = new LinkedList<String> ();
        set.add(start);
        q.add(start);
        int steps = 1;
        
        int curLevel = 1;
        int nextLevel = 0;
        
        while (!q.isEmpty()) {
            char[] cur = q.poll().toCharArray();
            curLevel --;
            
            for (int i = 0; i < cur.length; i ++) {
                char temp = cur[i];
                for (char c = 'a'; c <= 'z'; c ++) {
                    if (c == temp) continue;
                    cur[i] = c;
                    String newStr = new String(cur);
                    if (newStr.equals(end)) return steps + 1;
                    if (dict.contains(newStr) && !set.contains(newStr)) {
                        q.add(newStr);
                        set.add(newStr);
                        nextLevel ++;
                    }
                }
                cur[i] = temp;
            }
            
            if (curLevel == 0) {
                steps ++;
                curLevel = nextLevel;
                nextLevel = 0;
            }
        }
        
        return 0;
    }
}
