package eduard.vitko.Internet_Service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDto {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String phone;
    private String email;



}
