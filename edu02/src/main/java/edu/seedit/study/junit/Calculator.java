package edu.seedit.study.junit;

public class Calculator {

	/**
	  * @Method Name : sum
	  * @작성일 : 2017. 1. 3.
	  * @작성자 : 조용근
	  * @변경이력 : 
	  * @Method 설명 :두 인수를 합하여 반환
	  * @param num1
	  * @param num2
	  * @return
	  */
	public int sum(int num1, int num2) {
		return num1 + num2;
	}

	/**
	  * @Method Name : fibo
	  * @작성일 : 2017. 1. 3.
	  * @작성자 : 조용근
	  * @변경이력 : 
	  * @Method 설명 : 피보나치 수열
	  * @param n
	  * @return
	  */
	public int fibo(int n) {
		if (n == 1 || n == 2)
			return 1;
		return fibo(n - 2) + fibo(n - 1);
	}
}