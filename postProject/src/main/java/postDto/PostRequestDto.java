package postDto;

import lombok.Getter;

@Getter
public class PostRequestDto {
	private String id;
	private String password;
	private String title;
	private String content;
	private String author;
}
