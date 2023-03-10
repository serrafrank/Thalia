package org.thalia.blog.notification;

import java.time.LocalDateTime;
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
public class Notification {

    @GenericGenerator(name = "notification_id_sequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
                      parameters = {
                          @Parameter(name = "notification_id_sequence", value = "notification_id_sequence"),
                          @Parameter(name = "increment_size", value = "1")})
    @Id
    @GeneratedValue(generator = "notification_id_sequence")
    private Integer notificationId;
    private String message;
    private String sender;
    private LocalDateTime sentAt;
    private Long commentId;
    private Long articleId;
}
