-- 用户表
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `iphone` varchar(255) DEFAULT NULL COMMENT '电话',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '昵称',
  `pass_word` varchar(255) DEFAULT NULL COMMENT '密码',
  `sex` varchar(255) DEFAULT '1' COMMENT '性别 1-男 2-女',
  `user_id` varchar(255) DEFAULT NULL COMMENT '用户ID',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户真实姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;