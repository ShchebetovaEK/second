package by.tms.project.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Patient extends User {

    private boolean insurance;
    private BigDecimal moneyAccount;
    private int discount;

    public Patient() {
    }

    public Patient(boolean insurance, BigDecimal moneyAccount, int discount) {
        this.insurance = insurance;
        this.moneyAccount = moneyAccount;
        this.discount = discount;
    }

    public Patient(long id, Role role, String login, String password, String firstName, String lastName,
                   LocalDate dataBirthday, String address, String phoneNumber, String email, boolean insurance, BigDecimal moneyAccount, int discount) {
        super(id, role, login, password, firstName, lastName, dataBirthday, address, phoneNumber, email);
        this.insurance = insurance;
        this.moneyAccount = moneyAccount;
        this.discount = discount;
    }

    public boolean isInsurance() {
        return insurance;
    }

    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }

    public BigDecimal getMoneyAccount() {
        return moneyAccount;
    }

    public void setMoneyAccount(BigDecimal moneyAccount) {
        this.moneyAccount = moneyAccount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Patient patient = (Patient) o;

        if (insurance != patient.insurance) return false;
        if (discount != patient.discount) return false;
        return moneyAccount.equals(patient.moneyAccount);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (insurance ? 1 : 0);
        result = 31 * result + moneyAccount.hashCode();
        result = 31 * result + discount;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Patient{");
        sb.append("insurance=").append(insurance);
        sb.append(", moneyAccount=").append(moneyAccount);
        sb.append(", discount=").append(discount);
        sb.append('}');
        return sb.toString();
    }

    public static class PatientBuilder {
        private Patient patient = new Patient();

        public PatientBuilder() {
        }

        public PatientBuilder setId(long id) {
            patient.setId(id);
            return this;
        }

        public PatientBuilder setRole(Role role) {
            patient.setRole(role);
            return this;
        }

        public PatientBuilder setLogin(String login) {
            patient.setLogin(login);
            return this;
        }

        public PatientBuilder setPassword(String password) {
            patient.setPassword(password);
            return this;
        }

        public PatientBuilder setFirstName(String firstName) {
            patient.setFirstName(firstName);
            return this;
        }

        public PatientBuilder setLastName(String lastName) {
            patient.setLastName(lastName);
            return this;
        }

        public PatientBuilder setDataBirthday(LocalDate dataBirthday) {
            patient.setDataBirthday(dataBirthday);
            return this;
        }

        public PatientBuilder setAddress(String address) {
            patient.setAddress(address);
            return this;
        }

        public PatientBuilder setPhoneNumber(String phoneNumber) {
            patient.setPhoneNumber(phoneNumber);
            return this;
        }

        public PatientBuilder setEmail(String email) {
            patient.setEmail(email);
            return this;
        }

        public PatientBuilder setInsurance(Boolean insurance) {
            patient.setInsurance(insurance);
            return this;
        }

        public PatientBuilder setMoneyAccount(BigDecimal moneyAccount) {
            patient.setMoneyAccount(moneyAccount);
            return this;
        }

        public PatientBuilder setDiscount(Integer discount) {
            patient.setDiscount(discount);
            return this;
        }
        public Patient buildPatient() {
            return patient;
        }
    }
}
