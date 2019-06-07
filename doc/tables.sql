CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(20) CHARACTER SET utf8mb4 NOT NULL COMMENT '用户名称',
  `salary` decimal(8,2) NOT NULL COMMENT '工资',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `t_user_new` (
  `u_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `u_name` varchar(20) CHARACTER SET utf8mb4 NOT NULL COMMENT '用户名称',
  `u_salary` decimal(8,2) NOT NULL COMMENT '工资',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8