package com.cscnu.group13.CalCulate;

import java.util.ArrayList;

class Parse{
	public ArrayList<Object> list = new ArrayList<Object>();
	
	private String calString;	// ��� �Է� ��
	private char ch;	// ���ڿ��� �ѱ��� �ѱ���
	
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
			if(this.getCh() == ('+'|'-'|'*'|'/'|'('|')') ){		// �����ȣ�� ��� ����Ʈ�� �߰�
				this.list.add(this.getCh());
				this.setCh(this.getCalString().charAt(++i));	//Ch�� calString�� ���� char�� ����
			}else if(Character.isDigit(this.getCh())){			//ch�� ������ ��
				while(Character.isDigit(this.getCh())){			//ch�� ������ ���� String number�� ���ڸ� �̾ ����
					number += this.getCh();
					this.setCh(this.getCalString().charAt(++i));
				}
				this.list.add(number);
			}else {
				throw new NumberFormatException();		// �̿��� ���ڰ� ������ ��� ������ �߻�
			}
		}
		return true;
	}
}
