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
    int getDiffCount(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) count++;
        }
        return count;
    }
    public int solution(String begin, String target, String[] words) {
        Set<String> visited = new HashSet<>();
        Queue<Word> q = new ArrayDeque<>();
        q.offer(new Word(begin, 0));
        visited.add(begin);
        
        while(!q.isEmpty()) {
            Word cur = q.poll();
            if (cur.word.equals(target)) return cur.count;
            
            for (String next : words) {
                if (getDiffCount(cur.word, next) == 1) {
                    if (!visited.contains(next)) {
                        q.offer(new Word(next, cur.count + 1));
                        visited.add(next);
                    }
                }
            }
        }
    
        return 0;
    }
}