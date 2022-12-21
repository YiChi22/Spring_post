package postRepository;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AutoCloseable.class)
public class TimeStamped {
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime createTime;

	@CreatedDate
	@Column
	private LocalDateTime modifyTime;
}
