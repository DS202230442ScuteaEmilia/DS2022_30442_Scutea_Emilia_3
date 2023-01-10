package assignment1.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(schema = "ds_assignment1")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    private Long id;

    @Column
    @JsonProperty
    private String username;

    @Column
    @JsonProperty
    private String email;

    @Column(nullable = false)
    @JsonProperty
    private String password;

    @Column
    @JsonProperty
    private Integer age;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;;

    @OneToMany(fetch=FetchType.EAGER)
    private List<Device> devices;
}
