package com.sist.main;
class Reply
{
	private int rno;
	private String id;
	private String name;
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Reply(int rno, String id, String name) {
		super();
		this.rno = rno;
		this.id = id;
		this.name = name;
	}
	
	public void print()
	{
		System.out.println("번호:"+rno);
		System.out.println("아이디:"+id);
		System.out.println("이름:"+name);
	}
	
}
public class MainClass4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 클래스를 메모리에 저장 => 생성자
		Reply r=new Reply(1, "hong", "홍길동");
		r.print();
		r.setRno(2);
		r.setId("shim");
		r.setName("심청이");
		r.print();
	}

}
