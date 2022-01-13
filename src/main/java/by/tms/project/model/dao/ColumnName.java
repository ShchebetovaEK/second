package by.tms.project.model.dao;

public final class ColumnName {

    /* TABLE USERS*/
    public static final String USERS_ID = "id";
    public static final String USERS_ROLE = "role";
    public static final String USERS_LOGIN = "login";
    public static final String USERS_PASSWORD = "password";
    public static final String USERS_FIRST_NAME = "first_name";
    public static final String USERS_LAST_NAME = "last_name";
    public static final String USERS_DATA_BIRTHDAY = "data_birthday";
    public static final String USERS_ADDRESS = "address";
    public static final String USERS_PHONE_NUMBER = "phone_number";
    public static final String USERS_EMAIL = "email";

    /*TABLE PATIENTS*/
    public static final String PATIENTS_INSURANCE = "insurance";
    public static final String PATIENTS_MONEY_ACCOUNT = "money_account";
    public static final String PATIENTS_DISCOUNT = "discount";
    public static final String PATIENTS_USERS_ID = "users_id";

    /*TABLE DOCTORS*/
    public static final String DOCTORS_CATEGORY = "category";
    public static final String DOCTORS_EXPERIENCE = "experience";
    public static final String DOCTORS_SPECIALITY = "speciality";
    public static final String DOCTORS_USERS_ID = "users_id";

    /*TABLE CAPABILITIES*/
    public static final String CAPABILITIES_CAPABILITY_ID = "capability_id";
    public static final String CAPABILITIES_CAPABILITY_NAME = "capability_name";
    public static final String CAPABILITIES_CAPABILITY_COST = "capability_cost";
    public static final String CAPABILITIES_PROTOCOLS_PROTOCOL_ID = "protocols_protocol_id";
    public static final String CAPABILITIES_SPECIALITIES_ID_SPECIALITY = "specialities_id_speciality";

    /*TABLE PROTOCOLS*/
    public static final String PROTOCOLS_PROTOCOL_ID = "protocol_id";
    public static final String PROTOCOLS_PROTOCOL_DATA = "protocol_data";
    public static final String PROTOCOLS_PROTOCOL_PAYER = "protocol_payer";
    public static final String PROTOCOLS_PROTOCOL_COST = "protocol_cost";
    public static final String PROTOCOLS_PATIENTS_USERS_ID = "patients_users_id";
    public static final String PROTOCOLS_DOCTORS_USER_ID = "doctors_users_id";

    private ColumnName(){

    }
}
