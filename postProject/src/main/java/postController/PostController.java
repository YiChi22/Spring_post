package postController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import postDto.PostRequestDto;
import postRepository.Post;
import postService.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;

	@GetMapping("/")
	public ModelAndView index() {
	    return new ModelAndView("index");
	}
	@GetMapping("/api/posts")
	public List<Post> allPosts(){
		return postService.getPosts();
	}

	@PostMapping("/api/posts")
	public Post createPost(@RequestBody PostRequestDto postRequestDte) {
	    return postService.createPost(postRequestDte);
	}
	@PutMapping("/api/posts/{id}")
	public Post updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto){
		return postService.updatePost(id, postRequestDto);
	}
	@DeleteMapping("api/posts/{id, password}")
	public Long deletePost(@PathVariable Long id, String password) {
	    return postService.deletePost(id, password);
	}
}
