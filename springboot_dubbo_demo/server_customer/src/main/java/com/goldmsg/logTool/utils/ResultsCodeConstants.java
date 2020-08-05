package com.goldmsg.logTool.utils;


/**
 * 返回结果代码常量定义
 * Created with IntelliJ IDEA
 * Created by HEQI
 * DATE : 2017/8/15.
 * TIME : 17:41
 * EMAIL : qhs_dream@163.com
 */
public interface ResultsCodeConstants {
    public static final String LOGIN_KICKED_OUT = "LOGIN_KICKED_OUT";
    public static final String ACCOUNT_NOT_EXISTS = "ACCOUNT_NOT_EXISTS";
    public static final String CHANGE_PASSWORD_FAIL = "CHANGE_PASSWORD_FAIL";
    public static final String ERROR = "ERROR";
    public static final String ERROR_PASSWORD = "ERROR_PASSWORD";
    public static final String LOGOUT = "LOGOUT";
    public static final String MENU_HAS_BIND_TO_APP_ERROR = "MENU_HAS_BIND_TO_APP_ERROR";
    public static final String MENU_HAS_BIND_TO_ROLES_ERROR = "MENU_HAS_BIND_TO_ROLES_ERROR";
    public static final String MENU_HAS_CHILDS_ERROR = "MENU_HAS_CHILDS_ERROR";
    public static final String NO_SESSION = "NO_SESSION";
    public static final String ORGANIZE_NOT_EXIST = "ORGANIZE_NOT_EXIST";
    public static final String ORGANIZE_HAS_CHILDS_ERROR = "ORGANIZE_HAS_CHILDS_ERROR";
    public static final String ORGANIZE_HAS_USER_ERROR = "ORGANIZE_HAS_USER_ERROR";
    public static final String ORGANIZE_MGR_HAS_USER_ERROR = "ORGANIZE_MGR_HAS_USER_ERROR";
    public static final String ORGANIZE_ORGCODE_HAS_EXIST = "ORGANIZE_ORGCODE_HAS_EXIST";
    public static final String ORGANIZE_DELETE_ERROR = "ORGANIZE_DELETE_ERROR";
    public static final String ORGANIZE_ORGNAME_HAS_EXIST = "ORGANIZE_ORGNAME_HAS_EXIST";
    public static final String ORGNAME_PATTERN_ILLEGAL = "ORGNAME_PATTERN_ILLEGAL";
    public static final String ROLE_HAS_BIND_USERS_ERROR = "ROLE_HAS_BIND_USERS_ERROR";
    public static final String ROLE_HAS_BIND_USER_ROLES_SCOPE_ERROR = "ROLE_HAS_BIND_USER_ROLES_SCOPE_ERROR";
    public static final String SUCCESS = "SUCCESS";
    public static final String UNAUTHORIZED_ERROR = "UNAUTHORIZED_ERROR";
    public static final String USER_ACCOUNT_EXISTS = "USER_ACCOUNT_EXISTS";
    public static final String USER_ID_CARD_EXISTS = "USER_ID_CARD_EXISTS";
    public static final String USER_ACCOUNT_EXPIRED = "USER_ACCOUNT_EXPIRED";
    public static final String USER_CODE_EXISTS = "USER_CODE_EXISTS";
    public static final String ROLE_NAME_EXISTS = "ROLE_NAME_EXISTS";
    public static final String ROLE_NOT_EXISTS = "ROLE_NOT_EXISTS";
    public static final String USER_HAS_BIND_ROLES_ERROR = "USER_HAS_BIND_ROLES_ERROR";
    public static final String USER_HAS_BIND_ROLESSCOPE_ERROR = "USER_HAS_BIND_ROLESSCOPE_ERROR";
    public static final String USER_HAS_BIND_MGRSCOPES_ERROR = "USER_HAS_BIND_MGRSCOPES_ERROR";
    public static final String CAN_NOT_DELETE_ADMIN_USER = "CAN_NOT_DELETE_ADMIN_USER";
    public static final String TYPE_ERROR = "TYPE_ERROR";
    public static final String OBJECT_NOT_EXISTS = "OBJECT_NOT_EXISTS";
    public static final String SYSTEM_MACHINE_CODES_CHANGED = "SYSTEM_MACHINE_CODES_CHANGED";

    public static final String USER_NOT_EXISTS = "USER_NOT_EXISTS";
    public static final String DICTIONARY_NAME_EXISTS = "DICTIONARY_NAME_EXISTS";
    public static final String DICTIONARY_CODE_EXISTS = "DICTIONARY_CODE_EXISTS";
    public static final String DICTIONARY_SYSTEM_INTERNALLY = "DICTIONARY_SYSTEM_INTERNALLY";
    public static final String SHORTCUT_EXISTS = "SHORTCUT_EXISTS";
    public static final String PATTERN_SYNTAX_EXCEPTION = "PATTERN_SYNTAX_EXCEPTION";
    public static final String INVALID_PARAM = "INVALID_PARAM";

    //配置中心新增
    public static final String IP_WAS_LOCKED = "IP_WAS_LOCKED";
    public static final String IP_WAS_LIMITED = "IP_WAS_LIMITED";
    public static final String ACCOUNT_IS_BLACKLIST = "ACCOUNT_IS_BLACKLIST";
    public static final String ACCOUNT_WAS_EXPIRED = "ACCOUNT_WAS_EXPIRED";
    public static final String ACCOUNT_IS_PAST_DUE = "ACCOUNT_IS_PAST_DUE";
    public static final String ACCOUNT_WAS_STOP_USE = "ACCOUNT_WAS_STOP_USE";
    public static final String ACCOUNT_IS_NOT_IN_TIME = "ACCOUNT_IS_NOT_IN_TIME";

    //用户Excel导入和导出出错提示语
    public static final String USER_USERCODE_ACCOUNT_NULL_ERROR = "USER_USERCODE_ACCOUNT_NULL_ERROR";
    public static final String EMAIL_PATTERN_ILLEGAL = "EMAIL_PATTERN_ILLEGAL";
    public static final String TIME_IPATTERN_LLEGAL = "TIME_IPATTERN_LLEGAL";
    public static final String IDCARD_PATTERN_ILLEGAL = "IDCARD_PATTERN_ILLEGAL";
    public static final String MOBILEPHONE_PATTERN_ILLEGAL = "MOBILEPHONE_PATTERN_ILLEGAL";
    public static final String PASSWORD_PATTERN_ILLEGAL = "PASSWORD_PATTERN_ILLEGAL";
    public static final String NO_DATA = "NO_DATA";
    public static final String USER_ORGANIZE_NOT_EXIST = "USER_ORGANIZE_NOT_EXIST";
    public static final String USERACCOUNT_PATTERN_ILLEGAL = "USERACCOUNT_PATTERN_ILLEGAL";
    public static final String USERCODE_PATTERN_ILLEGAL = "USERCODE_PATTERN_ILLEGAL";
    public static final String USERNAME_PATTERN_ILLEGAL = "USERNAME_PATTERN_ILLEGAL";
    public static final String SEARCH_PATTERN_ILLEGAL = "SEARCH_PATTERN_ILLEGAL";
    public static final String NO_EXPIRATION_DATE = "NO_EXPIRATION_DATE";
    public static final String INCORRECT_GENDER_TYPE = "INCORRECT_GENDER_TYPE";
    public static final String INCORRECT_USER_TYPE = "INCORRECT_USER_TYPE";
    public static final String INCORRECT_ACCOUNT_TYPE = "INCORRECT_ACCOUNT_TYPE";
    public static final String IDCARD_NULL_ERROR = "IDCARD_NULL_ERROR";
    public static final String ACCOUNTDATE_NULL_ERROR = "ACCOUNTDATE _NULL_ERROR";
    public static final String INPUT_ERROR = "INPUT_ERROR";
    public static final String DATA_NULL_ERROR = "DATA_NULL_ERROR";

    /**
     * 媒体文件相关提示
     */
    public static final String FILE_NOT_EXISTS = "FILE_NOT_EXISTS";
    public static final String FILE_EXP_SUCH_A_SHORT_TIME = "FILE_EXP_SUCH_A_SHORT_TIME";
    public static final String FILE_IS_NOT_OURS = "FILE_IS_NOT_OURS";

    /**
     * 视音频
     */
    public static final String POLICE_SITUATION_NOT_EXIST = "POLICE_SITUATION_NOT_EXIST";

    /**
     * 授权管理
     */
    public static final String SYSTEM_UNAUTHORIZED = "SYSTEM_UNAUTHORIZED";
    public static final String SYSTEM_AUTHORIZED_EXPIRED = "SYSTEM_AUTHORIZED_EXPIRED";
    public static final String LICENSE_TOKEN_AUTHC_ERROR = "LICENSE_TOKEN_AUTHC_ERROR";
    public static final String LICENSE_TOKEN_ERROR = "LICENSE_TOKEN_ERROR";
    public static final String LICENSE_TOKEN_FORMAT_ERROR = "LICENSE_TOKEN_FORMAT_ERROR";
    public static final String LICENSE_DESC_ERROR = "LICENSE_DESC_ERROR";
    public static final String LICENSE_COUNTER_ERROR = "LICENSE_COUNTER_ERROR";
    public static final String LICENSE_EXPIRE_TIME_ERROR = "LICENSE_EXPIRE_TIME_ERROR";
    public static final String LICENSE_EXPIRE_TIME_EXPIRED_ERROR = "LICENSE_EXPIRE_TIME_EXPIRED_ERROR";
    public static final String LICENSE_EXPIRE_PROTECT_ERROR = "LICENSE_EXPIRE_PROTECT_ERROR";
    public static final String LICENSE_EXTEND_INFO_ERROR = "LICENSE_EXTEND_INFO_ERROR";
    public static final String LICENSE_FUNCTION_INFO_ERROR = "LICENSE_FUNCTION_INFO_ERROR";
    public static final String LICENSE_MACHINE_CODE_ERROR = "LICENSE_MACHINE_CODE_ERROR";
    public static final String LICENSE_PRODUCT_INFO_ERROR = "LICENSE_PRODUCT_INFO_ERROR";
    public static final String LICENSE_PRODUCT_NAME_ERROR = "LICENSE_PRODUCT_NAME_ERROR";
    public static final String LICENSE_SOFTWARE_ID_ERROR = "LICENSE_SOFTWARE_ID_ERROR";
    public static final String LICENSE_SYSTEM_ID_ERROR = "LICENSE_SYSTEM_ID_ERROR";
    public static final String LICENSE_USER_INFO_ERROR = "LICENSE_USER_INFO_ERROR";
    public static final String LICENSE_USER_NAME_ERROR = "LICENSE_USER_NAME_ERROR";
    public static final String LICENSE_SUMMARY_ERROR = "LICENSE_SUMMARY_ERROR";
    public static final String LICENSE_SUMMARY_2_ERROR = "LICENSE_SUMMARY_2_ERROR";
    public static final String LICENSE_TOTAL_COUNTER_TOO_SMALL_ERROR = "LICENSE_TOTAL_COUNTER_TOO_SMALL_ERROR";
    public static final String LICENSE_SYSID_MISMATCHING_ERROR = "LICENSE_SYSID_MISMATCHING_ERROR";

    /**
     * excel
     */
    public static final String INVALID_DOCUMENT_CONTENT = "INVALID_DOCUMENT_CONTENT";
    public static final String INVALID_DOCUMENT_TYPE = "INVALID_DOCUMENT_TYPE";

    /**
     * 权重配置相关错误码--公安
     */
    public static final String CONFIG_DSJ_EQ_RATE_ERROR = "CONFIG_DSJ_EQ_RATE_ERROR";
    public static final String CONFIG_DSJ_USAGE_RATE_ERROR = "CONFIG_DSJ_USAGE_RATE_ERROR";
    public static final String CONFIG_IMPORT_ON_TIME_RATE_ERROR = "CONFIG_IMPORT_ON_TIME_RATE_ERROR";
    public static final String CONFIG_PS_MATCH_RATE_ERROR = "CONFIG_PS_MATCH_RATE_ERROR";
    public static final String CONFIG_CM_MATCH_RATE_EROR = "CONFIG_CM_MATCH_RATE_EROR";
    public static final String CONFIG_BASIC_EVA_RATE_ERROR = "CONFIG_BASIC_EVA_RATE_ERROR";
    public static final String CONFIG_LEGAL_EVA_RATE_ERROR = "CONFIG_LEGAL_EVA_RATE_ERROR";

    public static final String CONFIG_TOTAL_POINT_ERROR = "CONFIG_TOTAL_POINT_ERROR";
    public static final String CONFIG_RATE_EQUALS_ERROR = "CONFIG_RATE_EQUALS_ERROR";
    public static final String CONFIG_RATE_NOT_CONTINUOUS_ERROR = "CONFIG_RATE_NOT_CONTINUOUS_ERROR";

    /**
     * 权重配置相关错误码--交警
     */
    public static final String CONFIG_DAYLE_OFHOUR_WEIGHT_ERROR = "CONFIG_DAYLE_OFHOUR_WEIGHT_ERROR";
    public static final String CONFIG_WEEKLE_OFDAY_WEIGHT_ERROR = "CONFIG_WEEKLE_OFDAY_WEIGHT_ERROR";
    public static final String CONFIG_MONTHLE_OFDAY_WEIGHT_ERROR = "CONFIG_MONTHLE_OFDAY_WEIGHT_ERROR";
    public static final String CONFIG_FILE_WEIGHT_ERROR = "CONFIG_FILE_WEIGHT_ERROR";
    public static final String CONFIG_USAGE_WEIGHT_ERROR = "CONFIG_USAGE_WEIGHT_ERROR";
    public static final String CONFIG_DURATION_WEIGHT_ERROR = "CONFIG_DURATION_WEIGHT_ERROR";
    public static final String CONFIG_MATCH_WEIGHT_ERROR = "CONFIG_MATCH_WEIGHT_ERROR";
    public static final String CONFIG_SPOT_CHECK_WEIGHT_ERROR = "CONFIG_SPOT_CHECK_WEIGHT_ERROR";

    /**
     * 运维管理相关
     */
    public static final String NOT_ENOUGH_WS_COUNTS = "NOT_ENOUGH_WS_COUNTS";

    /**
     * 监督考评
     */
    public static final String CANNOT_DELETE_REFERENCE_ERROR = "CANNOT_DELETE_REFERENCE_ERROR";



    public static final String CAR_TYPE_NAME_PATTERN_ILLEGAL = "CAR_TYPE_NAME_PATTERN_ILLEGAL";
    public static final String CAR_TYPE_NAME_HAS_EXIST = "CAR_TYPE_NAME_HAS_EXIST";
    public static final String CAR_TYPE_HAS_CHILDS_ERROR = "CAR_TYPE_HAS_CHILDS_ERROR";
    public static final String CAR_NUMBER_HAS_EXIST = "CAR_NUMBER_HAS_EXIST";
    public static final String PIC_TYPE_ILLEGAL = "PIC_TYPE_ILLEGAL";
    public static final String NOT_EXISTS = "NOT_EXISTS";


    /**
     * 验证码相关
     */
    public static final String CAPTCHA_INPUT_ERROR = "CAPTCHA_INPUT_ERROR"; //验证码输入不对

}
