package assignment1;

public class UrlMappings {
    public static final String API_PATH = "/api";

    public static final String ADMIN = API_PATH + "/admin";

    public static final String ALL_USERS = "/users";
    public static final String CREATE_USER = "/create-user";
    public static final String EDIT_USER = "/edit-user";
    public static final String DELETE_USER = "/delete-user/{user_id}";

    public static final String ALL_DEVICES = "/devices";
    public static final String CREATE_DEVICE = "/create-device";
    public static final String EDIT_DEVICE = "/edit-device";
    public static final String DELETE_DEVICE = "/delete-device/{device_id}";
    public static final String ASSIGN_DEVICE = "/assign-device/{user_id}/{device_id}";


    public static final String USER = API_PATH + "/user";
    public static final String USER_DEVICES = "/user-devices/{user_id}";
    public static final String ADD_ENERGY_CONSUMPTION = "/add-energy-consumption/{device_id}/{energy}";
    public static final String USER_CONSUMPTIONS = "/user-consumptions/{user_id}";
    public static final String CONSUMPTIONS_BY_DATE = "/consumptions-date/{device_id}";

    public static final String AUTH = API_PATH + "/auth";
    public static final String LOGIN = "/login";
    public static final String SIGN_IN = "/sign-in";
    public static final String SIGN_UP = "/sign-up";

    public static final String GET_ADMIN = "/get_admin";
}
