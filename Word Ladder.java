class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        int n = beginWord.length();
        Map<Integer, Set<Character>> d = new HashMap<>();
        for (String word : wordSet) {
            for (int i = 0; i < n; i++) {
                if (!d.containsKey(i)) {
                    d.put(i, new HashSet<>());
                }
                d.get(i).add(word.charAt(i));
            }
        }
        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Q.add(new Pair<>(beginWord, 1));
        while (!Q.isEmpty()) {
            Pair<String, Integer> pair = Q.poll();
            String a = pair.getKey();
            int b = pair.getValue();
            b++;
            for (int i = 0; i < n; i++) {
                for (char j : d.get(i)) {
                    StringBuilder sb = new StringBuilder(a);
                    sb.setCharAt(i, j);
                    String x = sb.toString();
                    if (wordSet.contains(x) && !visited.contains(x)) {
                        if (x.equals(endWord)) {
                            return b;
                        }
                        visited.add(x);
                        Q.add(new Pair<>(x, b));
                    }
                }
            }
        }
        return 0;
    }
}
