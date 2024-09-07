package fpc.aoc.year2015.day8;

public class StrTools {


  public static long codeLength(String str) {
    return str.length();
  }

  public static long newEncodeLength(String str) {
    return str.chars().filter(c -> c=='"' || c=='\\').count()+str.length()+2;
  }

  public static long memoryLength(String str) {
    int i = 0;
    int length = 0;
    while(i<str.length()) {
      final var c1=  str.charAt(i);
      if (c1 == '\\') {
        if (str.charAt(i+1) == 'x') {
          i+=3;
        } else {
          i+=1;
        }
      }
      i++;

      length++;
    }
    return length-2;
  }


}
