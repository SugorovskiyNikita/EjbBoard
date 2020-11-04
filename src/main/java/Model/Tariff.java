package Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by nikita on 21.10.2020.
 */
@Getter
@Setter
@NoArgsConstructor
public class Tariff implements Serializable {

    private Integer id;

    private String name;

    private BigDecimal cost;

    private String description;

    private Set<Option> possibleOptions = new HashSet<>();

    public Tariff(String name, BigDecimal cost, String description) {
        this.name = name;
        this.cost = cost;
        this.description = description;
    }
}
