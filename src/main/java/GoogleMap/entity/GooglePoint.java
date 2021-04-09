package GoogleMap.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class GooglePoint {
    @JsonIgnore
    @Id
    @GeneratedValue(generator = "increment")
    private Long id;

    @Column
    private BigDecimal lat; // широта

    @Column
    private BigDecimal lng; // долгота

}
