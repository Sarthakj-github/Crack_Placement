class TrieNode {
    TrieNode[] d;
    int end;

    TrieNode() {
        this.d = new TrieNode[26];
        this.end = 0;
    }
}

class Trie {
    TrieNode root;
    public Trie() {
        this.root=new TrieNode();
    }
    
    public void insert(String word) {
        int n = word.length();
        TrieNode temp = root;
        for (int i = 0; i < n; i++) {
            char p = word.charAt(i);
            int index = p - 'a';
            if (temp.d[index] == null) {
                temp.d[index] = new TrieNode();
            }
            temp = temp.d[index];
        }
        temp.end += 1;
    }
    
    public boolean search(String word) {
        TrieNode temp = root;
        for(int i=0;i<word.length();i++){
            int p=word.charAt(i)-'a';
            if(temp.d[p]==null)   return false;
            temp=temp.d[p];
        }
        return temp.end>0;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for(int i=0;i<prefix.length();i++){
            int p=prefix.charAt(i)-'a';
            if(temp.d[p]==null)   return false;
            temp=temp.d[p];
        }
        return true;
    }
}
