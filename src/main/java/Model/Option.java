package Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by nikita on 25.10.2020.
 */
@Getter
@Setter
@NoArgsConstructor
public class Option implements Serializable {

    private Integer id;

    private String name;

    private BigDecimal cost;

    private BigDecimal connectCost;

    private String description;

    private Tariff tariff;

    private Set<Option> forbiddenWith = new HashSet<>();

    private Set<Option> requiredFrom = new HashSet<>();

    private Set<Option> requiredMe = new HashSet<>();

    private Set<Tariff> possibleTariffsOfOption = new HashSet<>();

    public Option(String name, BigDecimal cost, BigDecimal connectCost, String description) {
        this.name = name;
        this.cost = cost;
        this.connectCost = connectCost;
        this.description = description;
    }
}
