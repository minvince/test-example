package domain.service;


import domain.model.Unit;
import domain.model.Value;

public interface Converter {
    Value convert(Value value, Unit to) throws Exception;
}
