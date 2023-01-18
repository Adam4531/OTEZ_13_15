package pl.otez.user.employee.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class EmployeeLoginDto{
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String aEmail) {
        email = aEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String aPassword) {
        password = aPassword;
    }
}
