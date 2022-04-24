package utils;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
@ToString
public class Student {
    private int id;
    private String name;
    private int idGroup;
    private int comingYear;
}
