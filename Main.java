class Main {
  public static void main(String[] args) {
    /*
    int base = 44032;
    for(int x = base; x <= 55215; x++){
      char ch = (char)x;
      System.out.print(ch);
    }
    */
    System.out.println("Enter Message/Text to encode: ");
    String msg = Input.readString();
    String encode = encode(msg);
    System.out.println("-------------------------------------------------------------");
    System.out.println("Encode: " + encode);
    
    String decode = decode(encode);
    System.out.println("Decode: " + decode); 
  }

  public static String encode(String txt){

    //Level 1
    String encodedMsg = "";

    for(int idx=0; idx+1 <= txt.length(); idx++){
      char ch = txt.charAt(idx);
      int asci = (int)ch;
      asci+=1;
      ch = (char)asci;
      encodedMsg += ch;
    }
    
    //Level 2
    String encodedMsg2 = "";
    for(int idx = encodedMsg.length()-1; idx >= 0; idx--){
      char ch = encodedMsg.charAt(idx);
      encodedMsg2 += ch;
    }

    //Level 3
    String encodedMsg3 = "";
    int shifter;
    for(int idx=0; idx+1 <= encodedMsg2.length(); idx++){
      if((int)(encodedMsg2.charAt(idx)) >= 32 && (int)(encodedMsg2.charAt(idx)) <= 126){
        shifter = (int)(encodedMsg2.charAt(idx));
        shifter += 44032;
        encodedMsg3 += (char)shifter;
      }
    }

    //Level 4
    String encodedMsg4 = "";
    int convert;
    for(int idx=0; idx+1 <= encodedMsg3.length(); idx++){
      convert = (int)(encodedMsg3.charAt(idx));
      encodedMsg4 += convert;
    }

    //Level 5
    String encodedMsg5 = "";
    String grab;
    String mix;
    for(int idx=0; idx+5 <= encodedMsg4.length(); idx+=5){
      grab = encodedMsg4.substring(idx,idx+5);
      
      mix = grab.substring(grab.length()/2) + grab.substring(0,grab.length()/2);
      encodedMsg5+=mix;
    }

    //Level 6
    String encodedMsg6 = "";
    for(int idx = encodedMsg5.length()-1; idx >= 0; idx--){
      char ch = encodedMsg5.charAt(idx);
      encodedMsg6 += ch;
    }

    return encodedMsg6;
  }
  
  public static String decode(String txt){
    //Level 6 decode
    String decodedMsg6 = "";
    for(int idx = txt.length()-1; idx >= 0; idx--){
      char ch = txt.charAt(idx);
      decodedMsg6 += ch;
    }

    //Level 5 decode
    String decodedMsg5 = "";
    String grab;
    String unmix;
    for(int idx=0; idx+5 <= decodedMsg6.length(); idx+=5){
      grab = decodedMsg6.substring(idx,idx+5);
      
      unmix = grab.substring(grab.length()-2) + grab.substring(0,grab.length()-2);
      decodedMsg5+=unmix;
    }

    //Level 4 decode
    String decodedMsg4 = "";
    char convert;
    for(int idx=0; idx+5 <= decodedMsg5.length(); idx+=5){
      int convert1 = Integer.parseInt(decodedMsg5.substring(idx,idx+5));
      convert = (char)convert1;
      decodedMsg4 += convert;
    }

    //Level 3 decode
    String decodedMsg3 = "";
    int shifter;
    for(int idx=0; idx+1 <= decodedMsg4.length(); idx++){
      if((int)(decodedMsg4.charAt(idx)) >= 44032 && (int)(decodedMsg4.charAt(idx)) <= 55215){
        shifter = (int)(decodedMsg4.charAt(idx));
        shifter -= 44032;
        decodedMsg3 += (char)shifter;
      }
    }

    //Level 2 decode
    String decodedMsg2 = "";
    for(int idx = decodedMsg3.length()-1; idx >= 0; idx--){
      char ch = decodedMsg3.charAt(idx);
      decodedMsg2 += ch;
    }
    
    //Level 1 decode
    String decodedMsg = "";
    for(int idx=0; idx+1 <= decodedMsg2.length(); idx++){
      char ch2 = decodedMsg2.charAt(idx);
      int asci = (int)ch2;
      asci-=1;
      ch2 = (char)asci;
      decodedMsg+= ch2;
    }

    return decodedMsg;  
  }
}