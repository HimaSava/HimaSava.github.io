package com.savargaonkar.MemberModel;

public class Member {
	public int id;
	public int spouse_id;
	public int father_id;
	public int mother_id;
	public String name;
	public String gender;
	
	public Member() {
		super();
	}
	public Member(int id, int spouse_id, String name, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.spouse_id = spouse_id;
	}
	
	
	public Member(int id, int spouse_id, int father_id, int mother_id, String name, String gender) {
		super();
		this.id = id;
		this.spouse_id = spouse_id;
		this.father_id = father_id;
		this.mother_id = mother_id;
		this.name = name;
		this.gender = gender;
	}

	public Member(String name, String gender) {
		super();
		this.name = name;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSpouse_id() {
		return spouse_id;
	}

	public void setSpouse_id(int spouse_id) {
		this.spouse_id = spouse_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getFather_id() {
		return father_id;
	}


	public void setFather_id(int father_id) {
		this.father_id = father_id;
	}


	public int getMother_id() {
		return mother_id;
	}


	public void setMother_id(int mother_id) {
		this.mother_id = mother_id;
	}
	
	
	
}
