package me.duckdoom5.RpgEssentials.util;

public class StringUtils {
    public static String UCFirst(String string) {
        String ucf = String.valueOf(string.charAt(0)).toUpperCase();
        return ucf + string.substring(1);
    }
    
    public static String UCWords(String string) {
        String[] words = string.split(" ");
        StringBuffer b = new StringBuffer();
        for(int i = 0; i < words.length; i++){
            b.append(String.valueOf(words[i].charAt(0)).toUpperCase());
            b.append(words[i].substring(1));
            if(i < words.length-1){
                b.append(" ");
            }
        }
        return b.toString();
    }
    
    public static String replaceChatColors(String string){
        return string == null ? null : string.replace('§', '&');
    }
}
