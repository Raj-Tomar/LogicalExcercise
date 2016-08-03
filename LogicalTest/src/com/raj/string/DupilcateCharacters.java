package com.raj.string;


public class DupilcateCharacters {

	public static void main(String[] args) {
		DupilcateCharacters d = new DupilcateCharacters();
		String[] str ={"a","b","a","c","b","c","d"}; 
		d.findDuplication(str);
	}

	public void findDuplication(String[] str) {
		for(int i=0; i<str.length; i++){
			for(int j=0; j<str.length; j++){
				if(i!=j){
					if(str[i] == str[j])
						System.out.println(str[i]+" "+i);
				}
			}
		}
	}

}
