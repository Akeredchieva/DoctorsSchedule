package diplomna.to;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by akere on 08/12/2017.
 */
@NoArgsConstructor
@AllArgsConstructor
public class PatientTO {

    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String middleName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private int age;

    @Getter
    @Setter
    private String address;

    @Getter
    @Setter
    private String email;
}
