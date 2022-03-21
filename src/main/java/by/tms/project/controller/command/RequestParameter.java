package by.tms.project.controller.command;

public final class RequestParameter {
    /*user*/
    public static final String COMMAND = "command";
    public static final String ID = "id";
    public static final String ROLE = "role";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String DATA_BIRTHDAY = "data_birthday";
    public static final String ADDRESS = "address";
    public static final String PHONE_NUMBER = "phone_number";
    public static final String EMAIL = "email";

    /*doctor*/
    public static final String CATEGORY = "category";
    public static final String EXPERIENCE = "experience";
    public static final String SPECIALITY = "speciality";
    public static final String USERS_ID = "users_id";

    /*patient*/
    public static final String INSURANCE = "insurance";
    public static final String MONEY_ACCOUNT = "money_account";
    public static final String BALANCE = "balance";
    public static final String FIRST_RANGE = "first_range";
    public static final String SECOND_RANGE = "second_range";


    public static final String DISCOUNT = "discount";
    /*protocol*/
    public static final String PROTOCOL_ID = "protocol_id";
    public static final String PROTOCOL_PAYER = "protocol_payer";
    public static final String PROTOCOL_DATA = "protocol_data";
    public static final String PROTOCOL_COST = "protocol_cost";
    public static final String PROTOCOL_APPLICATION = "application";
    public static final String PROTOCOL_STATUS = "status";

    public static final String PROTOCOL_DOCTOR_USERS_ID = "doctors_users_id";
    public static final String PROTOCOL_PATIENTS_USERS_ID = "patients_users_id";
    public static final String PROTOCOL_ID_SUM = "forestmed.capabilities.protocols_protocol_id";

    public static final String TRUE = "true";
    public static final String FALSE = "false";

    /* registration*/
    public static final String INVALID_LOGIN = "invalid_login";
    public static final String INVALID_PASSWORD = "invalid_password";
    public static final String INVALID_FIRST_NAME = "invalid_firstName";
    public static final String INVALID_LAST_NAME = "invalid_lastName";
    public static final String INVALID_DATA_BIRTHDAY = "invalid_dataBirthday";
    public static final String INVALID_ADDRESS = "invalid_address";
    public static final String INVALID_PHONE_NUMBER = "invalid_phone_number";
    public static final String INVALID_EMAIL = "invalid_email";
    public static final String INVALID_CATEGORY = "invalid_category";
    public static final String INVALID_SPECIALITY = "invalid_speciality";
    public static final String INVALID_DISCOUNT = "invalid_discount";

    public static final String TYPE = "type";
    public static final String VALUE = "value";
    public static final String EMPTY = "";
}
