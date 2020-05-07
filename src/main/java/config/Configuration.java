package config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import domain.model.Unit;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Configuration {
    private Unit from;
    private Unit to;
    private BigDecimal coefficient;
}
