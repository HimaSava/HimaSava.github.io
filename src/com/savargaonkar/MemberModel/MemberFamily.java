package com.savargaonkar.MemberModel;

import com.savargaonkar.MemberModel.Member;
import java.util.*;

public class MemberFamily {
	public Member head;
	public Member spouse;
	public Member father;
	public Member mother;
	public List < Member > children= new ArrayList< Member >();
	public int number_children;
	
	
	public Member getHead() {
		return head;
	}
	public void setHead(Member head) {
		this.head = head;
	}
	public Member getSpouse() {
		return spouse;
	}
	public void setSpouse(Member spouse) {
		this.spouse = spouse;
	}
	public List<Member> getChildren() {
		return children;
	}
	public void setChildren(List<Member> children) {
		this.children = children;
	}	
	
	public Member getFather() {
		return father;
	}
	public void setFather(Member father) {
		this.father = father;
	}
	public Member getMother() {
		return mother;
	}
	public void setMother(Member mother) {
		this.mother = mother;
	}
		
	public int getNumber_children() {
		return number_children;
	}
	public void setNumber_children(int number_children) {
		this.number_children = number_children;
	}
	public MemberFamily(Member head, Member spouse, List<Member> children) {
		super();
		this.head = head;
		this.spouse = spouse;
		this.children = children;
	}
	
	public MemberFamily(Member head, Member spouse, Member father, Member mother, List<Member> children,int number_children) {
		super();
		this.head = head;
		this.spouse = spouse;
		this.father = father;
		this.mother = mother;
		this.children = children;
		this.number_children = number_children;
	}
	public MemberFamily(){
		super();
	}
	public MemberFamily(MemberFamily a){
		this.head = a.head;
		this.spouse = a.spouse;
		this.children = a.children;
		this.father = a.father;
		this.mother = a.mother;
		this.number_children = a.number_children;
		
		
	}
}
