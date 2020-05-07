package config;

import domain.model.Configuration;

import java.util.List;

public interface Loader {
    List<Configuration> load();
}
