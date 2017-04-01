package com.cscnu.group13.CalCulate;

import java.util.ArrayList;

class Parse{
	public ArrayList<Object> List = new ArrayList<Object>();
	
	private String calString;	// 계산 입력 식
	private char ch;	// 문자열의 한글자 한글자
	
	public Parse(String calString){
		this.setCalString(calString);
		this.setCh(this.getCalString().charAt(0));
	}
	private void setCalString(String calString){
		this.calString = calString;
	}
	private String getCalString(){
		return this.calString;
	}
	private void setCh(char ch){
		this.ch = ch;
	}
	private char getCh() {
		return this.ch;
	}
	public boolean parseCalString(){
		while(this.getCh() != '\0'){
			String number = new String();
			int i = 0;
			if(this.getCh() == ('+'|'-'|'*'|'/') ){		// 연산기호일 경우 리스트에 추가
				this.List.add(this.getCh());
				this.setCh(this.getCalString().charAt(++i));	//Ch를 calString의 다음 char로 설정
			}else if(Character.isDigit(this.getCh())){			//ch가 숫자일 때
				while(Character.isDigit(this.getCh())){			//ch가 숫자인 동안 String number에 숫자를 이어서 저장
					number += this.getCh();
					this.setCh(this.getCalString().charAt(++i));
				}
				this.List.add(number);
			}else {
				throw new NumberFormatException("잘못된 형식입니다.");		// 이외의 문자가 들어왔을 경우 에러를 발생
			}
		}
		return true;
	}
}
