package org.thalia.service.comment;

import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {

    public static final String ENTITY_TYPE = "Comment";
    private static final long serialVersionUID = 1L;
    @GenericGenerator(name = "comment_id_sequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
                      parameters = {
                          @Parameter(name = "comment_id_sequence", value = "comment_id_sequence"),
                          @Parameter(name = "increment_size", value = "1")})
    @Id
    @GeneratedValue(generator = "comment_id_sequence")
    private Long id;
    private Long articleId;
    private String body;
    private Instant createdAt;
    private Instant updatedAt;
}
