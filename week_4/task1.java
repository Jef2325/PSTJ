class task_1 {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int mid = n / 2;
        int count1 = 0, count2 = 0;
        
        String vowels = "aeiouAEIOU";
        
        for (int i = 0; i < mid; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) count1++;
        }
        
        for (int i = mid; i < n; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) count2++;
        }
        
        return count1 == count2;
    }
}
