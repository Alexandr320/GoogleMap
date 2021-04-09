package GoogleMap.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class GoogleMap {
    @Id
    @GeneratedValue(generator = "increment")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "center_point_id")
    private GooglePoint center;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)  // каскадные операции
    @JoinColumn(name = "map_id")
    private List<GooglePoint> paths;
}
