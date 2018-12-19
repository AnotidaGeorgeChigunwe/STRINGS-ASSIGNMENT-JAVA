
/**
 * Write a description of Week2Quiz : This is a Practice Quiz of my course 2 week 2.
 * 
 * @author (Anotida George Chigunwe ) 
 * @version (01)
 */
public class Week2Quiz {

    
 public void findAbc(String input) {
    int index = input.indexOf("abc");
    while (true) {
        if (index == -1 || index >= input.length() - 3) {
            break;
        }
        
        String found = input.substring(index+1, index+4);
        
        System.out.println(index);
        System.out.println(found);
        index = input.indexOf("abc", index+3);
    }
}

public String mystery(String dna) {
  int pos = dna.indexOf("T");
  int count = 0;
  int startPos = 0;
  String newDna = "";
  if (pos == -1) {
    return dna;
  }
  while (count < 3) {
    count += 1;
    newDna = newDna + dna.substring(startPos,pos);
    startPos = pos+1;
    pos = dna.indexOf("T", startPos);
    if (pos == -1) {
      break;
    }
  }
  newDna = newDna + dna.substring(startPos);
  return newDna;
}

   
   public void test() {
     //findAbc("abcd");
     findAbc("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj");
}

  public void testmystery() {
     //findAbc("abcd");
     String dna = "ABCDTABCDTABCDTABCDTABCDTABCDTABCDTABCDTABCDT";
     String result = mystery(dna);
     System.out.println(result);
}
}
