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

CREATE TABLE `t_student` (
`id`  int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id' ,
`name`  varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生姓名' ,
`sex`  tinyint(2) NOT NULL COMMENT '性别：1男、2女' ,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `t_client` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `t_employee` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `sn` varchar(50) NOT NULL COMMENT '编号',
  `salary` decimal(8,2) NOT NULL COMMENT '工资',
  `deptId` int(10) DEFAULT NULL COMMENT '部门id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8