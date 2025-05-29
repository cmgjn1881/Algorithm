import java.util.*;

class Solution {
    class Word {
        String word;
        int count;
        Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    
    int diffCount(String word1, String word2) {
        int cnt = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        
        Queue<Word> q = new ArrayDeque<>();
        q.offer(new Word(begin, 0));
        
        while(!q.isEmpty()) {
            Word cur = q.poll();
            
            if (cur.word.equals(target)) return cur.count;
            
            for (int i = 0; i < words.length; i++) {
                
                if (diffCount(cur.word, words[i]) == 1 && !visited[i]) {
                    q.offer(new Word(words[i], cur.count + 1));
                    visited[i] = true;
                }
            }
        }
        
        return 0;
    }
}