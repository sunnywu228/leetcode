package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
 * Only one letter can be changed at a time 
 * Each intermediate word must exist in the dictionary
 * For example,
 * Given:
 * start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"]
 * 
 * Return
 * [
 *    ["hit","hot","dot","dog","cog"],
 *    ["hit","hot","lot","log","cog"]
 * ]
 * 
 * @author chengyangwu
 *
 */
public class WordLadderII {
	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Queue<String> q = new LinkedList<String> ();
        
        int curLevel = 1;
        int nextLevel = 0;
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>> ();
        
        Queue<ArrayList<String>> paths = new LinkedList<ArrayList<String>> ();
        ArrayList<String> first = new ArrayList<String> ();
        first.add(start);
        paths.add(first);
        
        q.add (start);
        
        boolean found = false;
        
        while (!q.isEmpty()) {
            String curStr = q.poll();
            ArrayList<String> curSeq = paths.poll();
            curLevel --;
            if (curStr.equals(end)) {
                result.add(curSeq);
                found = true;
            } else {
                if (!found) {
                    char[] cur = curStr.toCharArray();
                    for (int i = 0; i < cur.length; i ++) {
                        char tmp = cur[i];
                        for (char c = 'a'; c <= 'z'; c ++) {
                            if (tmp == c) continue;
                            cur[i] = c;
                            String newStr = new String(cur);
                            boolean in = false;
                            for (String str : curSeq) {
                                if (newStr.equals(str)) {
                                    in = true;
                                    break;
                                }
                            }
                            if (dict.contains(newStr) && !in) {
                                q.add (newStr);
                                ArrayList<String> nextSeq = new ArrayList<String>(curSeq);
                                nextSeq.add(newStr);
                                paths.add(nextSeq);
                                nextLevel ++;
                            }
                        }
                        cur[i] = tmp;
                    }
                }
                
            }
            
            if (curLevel == 0) {
                if (found)
                    break;
                else {
                    curLevel = nextLevel;
                    nextLevel = 0;
                }
            }
            
        }
        return result;
    }
}
