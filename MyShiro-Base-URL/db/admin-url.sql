SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS permission;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS role_permission;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS user_role;




/* Create Tables */

-- 权限表 : 菜单表
CREATE TABLE permission
(
	id varchar(64) NOT NULL COMMENT '编号 : 编号',
	parent_id varchar(32) NOT NULL COMMENT '父级id',
	parent_ids varchar(2000) NOT NULL COMMENT '所有的父级ID',
	permission_name varchar(64) COMMENT '权限名称',
	url varchar(2000) COMMENT '访问路径 : 链接',
	target varchar(20) COMMENT '目标 : 目标（mainFrame、 _blank、_self、_parent、_top）',
	icon varchar(100) COMMENT '图标 : 图标',
	permission_type tinyint(1) NOT NULL COMMENT '权限类型 0 菜单 1 按钮',
	permission_code varchar(200) COMMENT '权限标识 : 权限标识',
	sort int COMMENT '排序',
	create_date datetime NOT NULL COMMENT '创建时间 : 创建时间',
	update_date datetime NOT NULL COMMENT '更新时间 : 更新时间',
	remarks varchar(255) COMMENT '备注信息 : 备注信息',
	del_flag char(1) DEFAULT '0' NOT NULL COMMENT '删除标记 : 删除标记（0：正常；1：删除）',
	PRIMARY KEY (id)
) COMMENT = '权限表 : 菜单表';


-- 角色表 : 角色表
CREATE TABLE role
(
	id varchar(64) NOT NULL COMMENT '编号 : 编号',
	group_id varchar(64) COMMENT '归属机构 : 归属机构',
	role_name varchar(100) NOT NULL COMMENT '角色名称 : 角色名称',
	enname varchar(255) COMMENT '英文名称 : 英文名称',
	role_type tinyint(1) COMMENT '角色类型 : 角色类型',
	useable char(1) COMMENT '是否可用 0 可用 1 不可用',
	create_date datetime NOT NULL COMMENT '创建时间 : 创建时间',
	update_date datetime NOT NULL COMMENT '更新时间 : 更新时间',
	remarks varchar(255) COMMENT '备注信息 : 备注信息',
	del_flag char(1) DEFAULT '0' NOT NULL COMMENT '删除标记 : 删除标记（0：正常；1：删除）',
	PRIMARY KEY (id)
) COMMENT = '角色表 : 角色表';


-- 角色-权限 : 角色-菜单
CREATE TABLE role_permission
(
	id varchar(32) NOT NULL COMMENT '主键',
	role_id varchar(32) NOT NULL COMMENT '角色id : 角色编号',
	permission_id varchar(32) NOT NULL COMMENT '权限id : 菜单编号',
	create_date datetime NOT NULL COMMENT '创建时间 : 创建时间',
	update_date datetime NOT NULL COMMENT '更新时间 : 更新时间',
	remarks varchar(255) COMMENT '备注信息 : 备注信息',
	del_flag char(1) DEFAULT '0' NOT NULL COMMENT '删除标记 : 删除标记（0：正常；1：删除）',
	PRIMARY KEY (id)
) COMMENT = '角色-权限 : 角色-菜单';


-- 用户
CREATE TABLE user
(
	id varchar(32) NOT NULL COMMENT 'id 主键',
	user_name varchar(30) DEFAULT '' NOT NULL COMMENT '用户名',
	mobile_number varchar(11) NOT NULL COMMENT '手机号码',
	email varchar(30) NOT NULL COMMENT '邮箱',
	password varchar(50) NOT NULL COMMENT '密码',
	salt varchar(64) NOT NULL COMMENT '加密盐',
	user_type tinyint NOT NULL COMMENT '用户类型 : 0 普通用户 1 管理用户',
	register_time date COMMENT '注册时间',
	validity tinyint NOT NULL COMMENT '是否有效 0 有效 1 无效',
	create_date datetime NOT NULL COMMENT '创建时间 : 创建时间',
	update_date datetime NOT NULL COMMENT '更新时间 : 更新时间',
	remarks varchar(255) COMMENT '备注信息 : 备注信息',
	del_flag char(1) DEFAULT '0' NOT NULL COMMENT '删除标记 : 删除标记（0：正常；1：删除）',
	PRIMARY KEY (id)
) COMMENT = '用户';


-- 用户-角色 : 用户-角色
CREATE TABLE user_role
(
	id varchar(32) NOT NULL COMMENT '主键',
	user_id varchar(32) NOT NULL COMMENT '用户ID : 用户编号',
	role_id varchar(32) NOT NULL COMMENT '角色ID : 角色编号',
	create_date datetime NOT NULL COMMENT '创建时间 : 创建时间',
	update_date datetime NOT NULL COMMENT '更新时间 : 更新时间',
	remarks varchar(255) COMMENT '备注信息 : 备注信息',
	del_flag char(1) DEFAULT '0' NOT NULL COMMENT '删除标记 : 删除标记（0：正常；1：删除）',
	PRIMARY KEY (id)
) COMMENT = '用户-角色 : 用户-角色';



