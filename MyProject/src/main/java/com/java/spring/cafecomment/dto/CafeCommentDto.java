package com.java.spring.cafecomment.dto;



public class CafeCommentDto {
	private int num; 
	private String writer;
	private String content;
	private int ref;
	private int ref_group;
	private int seq;
	private String regdate;
	
	public CafeCommentDto(){}

	public CafeCommentDto(int num, String writer, String content, int ref, int ref_group, int seq, String regdate) {
		super();
		this.num = num;
		this.writer = writer;
		this.content = content;
		this.ref = ref;
		this.ref_group = ref_group;
		this.seq = seq;
		this.regdate = regdate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getRef_group() {
		return ref_group;
	}

	public void setRef_group(int ref_group) {
		this.ref_group = ref_group;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
}
