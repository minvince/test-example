package domain.service;

import config.Configuration;
import lombok.RequiredArgsConstructor;
import domain.model.Unit;
import domain.model.Value;

import java.math.RoundingMode;
import java.util.List;

@RequiredArgsConstructor
public class SimpleConverter implements Converter {

    private final List<Configuration> config;

    @Override
    public Value convert(Value value, Unit to) throws Exception {

        var result = Value.builder().unit(to);

        var configuration = config
                .stream()
                .filter(x -> x.getFrom().equals(value.getUnit()) && x.getTo().equals(to))
                .findFirst()
                .orElse(null);

        if (configuration != null) {
            result.value(value.getValue().multiply(configuration.getCoefficient()));
            return result.build();
        }

        configuration = config
                .stream()
                .filter(x -> x.getTo().equals(value.getUnit()) && x.getFrom().equals(to))
                .findFirst()
                .orElse(null);

        if (configuration != null) {
            result.value(value.getValue().divide(configuration.getCoefficient(), 2, RoundingMode.HALF_UP));
            return result.build();
        }

        throw new Exception(String.format("config.Configuration for %s and %s not found", value.getUnit(), to));
    }
}
