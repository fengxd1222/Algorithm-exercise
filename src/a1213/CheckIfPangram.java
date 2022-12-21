package a1213;

public class CheckIfPangram {
    public boolean checkIfPangram(String sentence) {
        if(sentence.length()<26){
            return false;
        }
        char[] chars = sentence.toCharArray();
        int[] dict = new int[26];
        for (int i = 0; i < chars.length; i++) {
            dict[chars[i]-'a']++;
        }
        for (int i = 0; i < dict.length; i++) {
            if(dict[i]==0){
                return false;
            }
        }
        return true;
    }
}
