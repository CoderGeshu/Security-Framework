# 数据库
CREATE DATABASE `user_db` CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';

# 用户信息表
CREATE TABLE `t_user`
(
    `id`       varchar(32) NOT NULL COMMENT '用户id',
    `username` varchar(64) NOT NULL,
    `password` varchar(64) NOT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC;

# CoderGeshu 的对应密码是 123456 加密后的密文
INSERT INTO `t_user`
VALUES ('1', 'CoderGeshu', '$2a$10$FB/RJLJ7wgUAiCX8IunmDOwk0eHywunRHUHnJWVzKqn5emSo6nkou');
# Eric 的对应密码是 456789 加密后的密文
INSERT INTO `t_user`
VALUES ('2', 'Eric', '$2a$10$CwUdWsOvOYT7e0K1svHswuhBHEDMhD9X04Do5kJzEhu9W4ue1wfVG');

# 角色信息表
CREATE TABLE `t_role`
(
    `id`          varchar(32) NOT NULL,
    `role_name`   varchar(255) DEFAULT NULL,
    `description` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `unique_role_name` (`role_name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO `t_role`(`id`, `role_name`, `description`)
VALUES ('1', '管理员', '管理员角色'),
       ('2', '用户', '普通用户角色');

# 用户角色关联表
CREATE TABLE `t_user_role`
(
    `user_id` varchar(32) NOT NULL,
    `role_id` varchar(32) NOT NULL,
    PRIMARY KEY (`user_id`, `role_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO `t_user_role`(`user_id`, `role_id`)
VALUES ('1', '1'),
       ('2', '2');

# 权限表
CREATE TABLE `t_permission`
(
    `id`          varchar(32) NOT NULL,
    `code`        varchar(32) NOT NULL COMMENT '权限标识符',
    `description` varchar(64)  DEFAULT NULL COMMENT '描述',
    `url`         varchar(128) DEFAULT NULL COMMENT '请求地址',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO `t_permission`(`id`, `code`, `description`, `url`)
VALUES ('1', 'p1', '测试资源1', '/resource/r1'),
       ('2', 'p2', '测试资源2', '/resource/r2');

# 角色权限关联表
CREATE TABLE `t_role_permission`
(
    `role_id`       varchar(32) NOT NULL,
    `permission_id` varchar(32) NOT NULL,
    PRIMARY KEY (`role_id`, `permission_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO `t_role_permission`(`role_id`, `permission_id`)
VALUES ('1', '1'),
       ('1', '2'),
       ('2', '2');