
import domain.model.Unit;
import domain.model.Value;
import framework.Initializr;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        System.out.println("Enter from unit (Kilometer, Mile, MarineMile):");
        var from = Unit.builder().name(in.nextLine()).build();
        System.out.println("Enter to unit (Kilometer, Mile, MarineMile):");
        var to = Unit.builder().name(in.nextLine()).build();
        System.out.println("Enter value:");
        var value =
                Value.builder().value(in.nextBigDecimal()).unit(from).build();


        var initializer = new Initializr();
        var result = initializer.getConverter().convert(value, to);

        System.out.println(result);
    }
}
