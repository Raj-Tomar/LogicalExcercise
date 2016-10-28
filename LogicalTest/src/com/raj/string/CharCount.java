package com.raj.string;

public class CharCount {

	public static void main(String[] args) {
		String str = "abcdefaaabbbcccdddeeefff";
		CharCount cc = new CharCount();
		String uni = cc.getUniqueChar(str);
		cc.charCount(uni, str);
	}
	
	/**
	 * @param originalString
	 * @return
	 */
	public String getUniqueChar(String originalString){
	      String uniqueCharacters = "";
	      for ( int i = 0; i < originalString.length(); i++ ) {
	         if( uniqueCharacters.indexOf(originalString.charAt(i)) == -1 )
	        	 uniqueCharacters += originalString.charAt(i);
	      }
	      return uniqueCharacters;
	}
	
	/**
	 * @param uniqueCharacters
	 * @param originalString
	 */
	public void charCount(String uniqueCharacters, String originalString) {
		int count = 0;
		for ( int i = 0; i < uniqueCharacters.length(); i++ ) {
			for ( int j = 0; j < originalString.length(); j++ )
				if( uniqueCharacters.charAt(i) == originalString.charAt(j) )
					count++;
			System.out.println(uniqueCharacters.charAt(i)+" "+count);
			count = 0;
		}
	}
}