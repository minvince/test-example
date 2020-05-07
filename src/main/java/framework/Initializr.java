package framework;

import config.Configuration;
import config.Loader;
import domain.model.Unit;
import domain.service.Converter;
import domain.service.SimpleConverter;

import java.math.BigDecimal;
import java.util.List;

public class Initializr {

    public Converter getConverter() {

        var loader = new Loader() {

            @Override
            public List<Configuration> load() {
                return List.of(
                        new Configuration(Unit.builder().name("Mile").build(), Unit.builder().name("Kilometer").build(), BigDecimal.valueOf(1.609)),
                        new Configuration(Unit.builder().name("MarineMile").build(), Unit.builder().name("Mile").build(), BigDecimal.valueOf(1.151)),
                        new Configuration(Unit.builder().name("MarineMile").build(), Unit.builder().name("Kilometer").build(), BigDecimal.valueOf(1.852))
                );
            }
        };

        return new SimpleConverter(loader.load());
    }
}
