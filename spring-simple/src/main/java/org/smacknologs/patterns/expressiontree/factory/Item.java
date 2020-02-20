package org.smacknologs.patterns.expressiontree.factory;

public class Item {
	private String date;
	private String sequence;
	private String accountNumber;

	private byte[] img0;
	private byte[] img1;

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public byte[] getImg0() {
		return img0;
	}

	public void setImg0(byte[] img0) {
		this.img0 = img0;
	}

	public byte[] getImg1() {
		return img1;
	}

	public void setImg1(byte[] img1) {
		this.img1 = img1;
	}
}
class CheckItem extends Item {

	public CheckItem(String date, String sequence) {
		this.setDate(date);
		this.setSequence(sequence);
	}
}

class MRDChecks extends Item {
	public MRDChecks(String sequence) {
		this.setSequence(sequence);
	}
}

class AccountStatement extends Item {
	public AccountStatement(String date, String acct) {
		this.setDate(date);
		this.setAccountNumber(acct);
	}
}
