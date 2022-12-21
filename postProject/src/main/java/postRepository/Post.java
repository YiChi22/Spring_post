package postRepository;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import postDto.PostRequestDto;

@Getter
@Entity
@NoArgsConstructor
public class Post extends TimeStamped {
	/*
CREATE TABLE IF NOT EXISTS POST
(
    id varchar(100) primary key comment '게시글id',
    pw varchar(12) not null comment '게시글 비밀번호',
    title varchar(100) not null comment '게시글 제목',
    content varchar(100) not null comment '게시글 내용',
    author varchar(20) not null comment '작성자명',
    createtime varchar(100) not null comment '생성시간',
    modifytime varchar(100) null comment '수정시간'
)


	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@JsonIgnore
	@Column(nullable = false)
	private String pw;

	@Column(nullable = false)
	private String title;

	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;

	@Column(nullable = false)
	private String author;

	public Post(PostRequestDto requestDto){
		this.pw = requestDto.getPassword();
		this.title = requestDto.getTitle();
		this.content = requestDto.getContent();
		this.author = requestDto.getAuthor();
	}


	public void update(PostRequestDto requestDto) {
		this.pw = requestDto.getPassword();
		this.title = requestDto.getTitle();
		this.content = requestDto.getContent();
	}
}
