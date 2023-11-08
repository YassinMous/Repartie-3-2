package activite32;

import java.io.Serializable;

public class Operation  implements Serializable{
	 char op;
	 int op1,op2;
	 int res;
	 public Operation(char op, int op1, int op2) {
		super();
		this.op = op;
		this.op1 = op1;
		this.op2 = op2;
	}
	public char getOp() {
		return op;
	}
	public void setOp(char op) {
		this.op = op;
	}
	public int getOp1() {
		return op1;
	}
	public void setOp1(int op1) {
		this.op1 = op1;
	}
	public int getOp2() {
		return op2;
	}
	public void setOp2(int op2) {
		this.op2 = op2;
	}
	public int getRes() {
		return res;
	}
	public void setRes(int res) {
		this.res = res;
	}


	 
	}