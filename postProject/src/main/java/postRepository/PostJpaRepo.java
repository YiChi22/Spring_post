package postRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostJpaRepo extends JpaRepository <Post, Long> {
	List<Post> findAllPosts();
	//id가 일치하는 post 1개 조회
	Post findPostById(Long id, String password);
	void deleteById(Long id, String password);
}
