package com.raj.string;

public class CharCount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*Scanner sc = new Scanner(System.in);
		System.out.print("Enter String: ");
		*/
		String str = "aaaee";
		CharCount cc = new CharCount();
		cc.charCount(str);
	}

	public void charCount(String str) {
		int count = 0;
		for(int i=0; i<str.length(); i++){
			for(int j=0; j<str.length(); j++)
				if(str.charAt(i)==str.charAt(j))
					count++;
			//printChars(str.charAt(i),count, str);
			System.out.println(str.charAt(i)+" "+count);
			count = 0;
		}
	}
	
	public void printChars(char str, int count, String st){
		System.out.println(str+" "+count);
	}
}