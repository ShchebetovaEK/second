package by.tms.project.model.entity;
import java.util.Date;

public class User extends Entity {
    private long id;
    private Role role;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private Date dataBirthday;
    private String address;
    private String phoneNumber;
    private String email;

    public User() {
    }

    public User(String login, String password, String firstName, String lastName, Date dataBirthday, String address, String phoneNumber, String email) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dataBirthday = dataBirthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public User(Role role, String login, String password, String firstName, String lastName, Date dataBirthday, String address, String phoneNumber, String email) {
        this.role = role;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dataBirthday = dataBirthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public User(long id, Role role, String login, String password, String firstName, String lastName,
                Date dataBirthday, String address, String phoneNumber, String email) {
        this.id = id;
        this.role = role;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dataBirthday = dataBirthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDataBirthday() {
        return dataBirthday;
    }

    public void setDataBirthday(Date dataBirthday) {
        this.dataBirthday = dataBirthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (role != user.role) return false;
        if (!login.equals(user.login)) return false;
        if (!password.equals(user.password)) return false;
        if (!firstName.equals(user.firstName)) return false;
        if (!lastName.equals(user.lastName)) return false;
        if (!dataBirthday.equals(user.dataBirthday)) return false;
        if (!address.equals(user.address)) return false;
        if (!phoneNumber.equals(user.phoneNumber)) return false;
        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + role.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + dataBirthday.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", role=").append(role);
        sb.append(", login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", dataBirthday=").append(dataBirthday);
        sb.append(", address='").append(address).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();

    }

    public static class UserBuilder {
        private User user = new User();

        public UserBuilder() {
        }

        public UserBuilder setId(long id) {
            user.setId(id);
            return this;
        }

        public UserBuilder setRole(Role role) {
            user.setRole(role);
            return this;
        }

        public UserBuilder setLogin(String login) {
            user.setLogin(login);
            return this;
        }

        public UserBuilder setPassword(String password) {
            user.setPassword(password);
            return this;
        }

        public UserBuilder setFirstName(String firstName) {
            user.setFirstName(firstName);
            return this;
        }

        public UserBuilder setLastName(String lastName) {
            user.setLastName(lastName);
            return this;
        }

        public UserBuilder setDataBirthday(Date dataBirthday) {
            user.setDataBirthday(dataBirthday);
            return this;
        }

        public UserBuilder setAddress(String address) {
            user.setAddress(address);
            return this;
        }

        public UserBuilder setPhoneNumber(String phoneNumber) {
            user.setPhoneNumber(phoneNumber);
            return this;
        }

        public UserBuilder setEmail(String email) {
            user.setEmail(email);
            return this;
        }

        public User buildUser() {
            return user;
        }
    }
}
