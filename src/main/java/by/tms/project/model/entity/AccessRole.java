package by.tms.project.model.entity;

public enum AccessRole {
    ADMIN("Admin"),
    PATIENT("Patient"),
    DOCTOR("Doctor");
    private final String role;

    AccessRole(String role) {
        this.role = role;
    }

    public String getRole(){
        return role;
    }

    public static AccessRole getRoleType(String role){
        for(AccessRole accessRole: AccessRole.values()){
            if(accessRole.getRole().equals(role)){
                return accessRole;
            }
        }
        return PATIENT;
    }
}
