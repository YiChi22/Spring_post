package postService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import postDto.PostRequestDto;
import postRepository.Post;
import postRepository.PostJpaRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
	private final PostJpaRepo postJpaRepo;

	@Transactional
	public Post createPost(PostRequestDto postRequestDto){
		Post post = new Post(postRequestDto);
		postJpaRepo.save(post);
		return post;
	}
	public List<Post> getPosts(){
		return postJpaRepo.findAllPosts();
	}
	@Transactional
	public Post updatePost(Long id, PostRequestDto postRequestDto){
		Post post = postJpaRepo.findById(id).orElseThrow(() -> new RuntimeException("아이디가 존재하지 않습니다."));
		post.update(postRequestDto);
		return post;
	}
	@Transactional
	public Long deletePost(Long id, String password) {
	    postJpaRepo.deleteById(id, password);
		return id;
	}
}
