package com.raj.logical;

public class NumberConversion {

	public static void main(String[] args) {
		decimalToBinary(5);
		decimalToBinary2(5);
	}
	
	public static void decimalToBinary(int number){
		if(number > 0){
			decimalToBinary(number/2);
			if(number%2==0){
				System.out.print(0);
			} else {
				System.out.print(1);
			}
		}
	}
	
	public static void decimalToBinary2(int number) {
		int binary = 0, remainder;
		int temp = 1;
		if (number < 1) {
			System.out.println("Enter greator number");
		} else {
			while (number > 0) {
				remainder = number % 2;
				number = number / 2;
				binary = binary + temp * remainder;
				temp = temp * 10;
			}
			System.out.println("Binary Number = " + binary);
		}
	}
	
	public static int binaryToDecimal(int number, int temp){
		if(number>0){
			return (number%10)*temp + binaryToDecimal(number/10, temp*2);
		} else {
			return 0;
		}
	}
	
	public static void binaryToDecimal2(int number){
		int decimal = 0, remainder;
		int base = 2;
		int power = 0;
		while (number > 0) {
			remainder = number % 10;
			int p = power(base, power);
			decimal = decimal + remainder * p;
			number = number / 10;
			power++;
		}
		System.out.println("Decimal = " + decimal);
	}
	
	public static int power(int base, int power) {
		int pow = 1;
		if (power == 0) {
			return pow;
		} else {
			for (int i = 1; i <= power; i++) {
				pow = pow * base;
			}
			return pow;
		}
	}
}
