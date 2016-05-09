-- user data
-- init sql
use SSO;


INSERT INTO user_authorization (USER_LOGIN_NAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, UPDATED_DATE, CREATED_DATE)
  VALUE ('admin', 'admin123', 'admin', '', sysdate(), sysdate());
set @admin_user_id = LAST_INSERT_ID();

INSERT INTO user_authorization (USER_LOGIN_NAME, PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, UPDATED_DATE, CREATED_DATE)
  VALUE ('ai', 'abc123', 'Hua', 'Ai', sysdate(), sysdate());
set @ai_user_id = LAST_INSERT_ID();

INSERT INTO user_role (SYSTEM, NAME, DESC_EN, DESC_CN, UPDATED_DATE, CREATED_DATE)
  VALUE ('EORDER', 'Admin', 'Administrator-have access to all resources', '管理员', sysdate(), sysdate());
set @admin_role_id = LAST_INSERT_ID();
INSERT INTO user_role (SYSTEM, NAME, DESC_EN, DESC_CN, UPDATED_DATE, CREATED_DATE)
  VALUE ('EORDER', 'Checker', 'Check the order only', '核单员', sysdate(), sysdate());
set @checker_role_id = LAST_INSERT_ID();

INSERT INTO user_roles (user_id, user_role_id) VALUE (@admin_user_id, @admin_role_id);
INSERT INTO user_roles (user_id, user_role_id) VALUE (@ai_user_id, @checker_role_id);

INSERT INTO user_resource (NAME, DESC_EN, DESC_CN, PATH, ACTION, UPDATED_DATE, CREATED_DATE)
  VALUE ('OrderMainPage', 'Order Main Page', '订单首页', 'order', 'GET', sysdate(), sysdate());
set @order_mainpage_get_id = LAST_INSERT_ID();
INSERT INTO user_resource (NAME, DESC_EN, DESC_CN, PATH, ACTION, UPDATED_DATE, CREATED_DATE)
  VALUE ('OrderPage', 'Order Main Page', '订单首页', 'order', 'POST', sysdate(), sysdate());
set @order_mainpage_post_id = LAST_INSERT_ID();

INSERT INTO user_role_resource (user_role_id, user_resource_id) VALUE (@admin_role_id, @order_mainpage_get_id);
INSERT INTO user_role_resource (user_role_id, user_resource_id) VALUE (@admin_role_id, @order_mainpage_post_id);

commit;
