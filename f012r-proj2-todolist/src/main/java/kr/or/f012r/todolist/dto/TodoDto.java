package kr.or.f012r.todolist.dto;

public class TodoDto {
	private Long id;
	private String name;
	private String regdate;
	private int sequence;
	private String title;
	private String type;
	
	public TodoDto() {

	}
	
	public TodoDto(Long id, String title, String name, int sequence, String type,  String regdate) {
		super();
		this.id=id;
		this.title=title;
		this.name=name;
		this.sequence=sequence;		
		this.type=type;
		this.regdate=regdate;
	}
	
	// 추가한 생성자 (title, name, sequence, type만 받음)
    public TodoDto(String title, String name, int sequence, String type) {
        this.title = title;
        this.name = name;
        this.sequence = sequence;
        this.type = type;
    }

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String getRegdate() {
		return regdate;
	}
	
	public int getSequence() {
		return sequence;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getType() {
		return type;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}	

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}	

	public void setTitle(String title) {
		this.title = title;
	}	

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "To"
				+ ""
				+ ""
				+ ""
				+ "doDto [id=" + id + ", title=" + title + ", name=" + name + ", sequence=" + sequence + ", type="
				+ type + ", regdate=" + regdate + "]";
	}

	
	
	

}
