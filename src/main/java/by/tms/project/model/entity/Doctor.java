package by.tms.project.model.entity;

import java.util.Date;
import java.util.List;

public class Doctor extends User {
    private Category category;
    private Speciality speciality;
    private List<Capability> capabilityList;

    public Doctor() {
    }

    public Doctor(Category category,  Speciality speciality) {
        this.category = category;
        this.speciality = speciality;
    }

    public Doctor(Role role, String login, String password, String firstName, String lastName, Date dataBirthday,
                  String address, String phoneNumber, String email, Category category, Speciality speciality) {
        super(role, login, password, firstName, lastName, dataBirthday, address, phoneNumber, email);
        this.category = category;

        this.speciality = speciality;
    }

    public Doctor(Role role, String login, String password, String firstName, String lastName, Date dataBirthday, String address, String phoneNumber,
                  String email, Archiv archiv, Category category, Speciality speciality) {
        super(role, login, password, firstName, lastName, dataBirthday, address, phoneNumber, email, archiv);
        this.category = category;
        this.speciality = speciality;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public List<Capability> getCapabilityList() {
        return capabilityList;
    }

    public void setCapabilityList(List<Capability> capabilityList) {
        this.capabilityList = capabilityList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Doctor doctor = (Doctor) o;

        if (category != doctor.category) return false;
        if (speciality != doctor.speciality) return false;
        return capabilityList.equals(doctor.capabilityList);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + category.hashCode();
        result = 31 * result + speciality.hashCode();
        result = 31 * result + capabilityList.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Doctor{");
        sb.append("category=").append(category);
        sb.append(", speciality=").append(speciality);
        sb.append(", capabilityList=").append(capabilityList);
        sb.append('}');
        return sb.toString();
    }

    public static class DoctorBuilder {
        private Doctor doctor = new Doctor();

        public DoctorBuilder() {
        }

        public DoctorBuilder setId(long id) {
            doctor.setId(id);
            return this;
        }

        public DoctorBuilder setRole(Role role) {
            doctor.setRole(role);
            return this;
        }

        public DoctorBuilder setLogin(String login) {
            doctor.setLogin(login);
            return this;
        }

        public DoctorBuilder setPassword(String password) {
            doctor.setPassword(password);
            return this;
        }

        public DoctorBuilder setFirstName(String firstName) {
            doctor.setFirstName(firstName);
            return this;
        }

        public DoctorBuilder setLastName(String lastName) {
            doctor.setLastName(lastName);
            return this;
        }

        public DoctorBuilder setDataBirthday(Date dataBirthday) {
            doctor.setDataBirthday(dataBirthday);
            return this;
        }

        public DoctorBuilder setAddress(String address) {
            doctor.setAddress(address);
            return this;
        }

        public DoctorBuilder setPhoneNumber(String phoneNumber) {
            doctor.setPhoneNumber(phoneNumber);
            return this;
        }

        public DoctorBuilder setEmail(String email) {
            doctor.setEmail(email);
            return this;
        }

        public  DoctorBuilder setArchiv(Archiv archiv) {
            doctor.setArchiv(archiv);
            return  this;
        }

        public DoctorBuilder setCategory(Category category) {
            doctor.setCategory(category);
            return this;
        }

        public DoctorBuilder setSpeciality(Speciality speciality) {
            doctor.setSpeciality(speciality);
            return this;
        }

        public Doctor buildDoctor() {
            return doctor;
        }
    }

}