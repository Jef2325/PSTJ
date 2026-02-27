class task8 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }
        
        return result;
    }
    
    private boolean matches(String word, String pattern) {
        if (word.length() != pattern.length()) return false;
        
        Map<Character, Character> wToP = new HashMap<>();
        Map<Character, Character> pToW = new HashMap<>();
        
        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            
            if (wToP.containsKey(w) && wToP.get(w) != p) return false;
            if (pToW.containsKey(p) && pToW.get(p) != w) return false;
            
            wToP.put(w, p);
            pToW.put(p, w);
        }
        
        return true;
    }
}