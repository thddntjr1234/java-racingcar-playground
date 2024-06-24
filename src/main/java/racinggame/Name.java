package racinggame;

import java.util.Objects;
import javax.naming.InvalidNameException;

public class Name {
    public static final int MAX_NAME_LENGTH = 5;
    private String name;

    public Name(String driverName) {
        if (driverName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("드라이버 이름은 5글자를 초과할 수 없습니다.");
        }
        this.name = driverName;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
