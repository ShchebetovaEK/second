package by.tms.project.model.entity;

public enum Role {
    GUEST("Guest"),
    ADMIN("Admin"),
    PATIENT("Patient"),
    DOCTOR("Doctor");
    private final String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole(){
        return role;
    }

    public static Role getRoleType(String role){
        for(Role accessRole: Role.values()){
            if(accessRole.getRole().equals(role)){
                return accessRole;
            }
        }
        return PATIENT;
    }
}
