drop table if exists `address`;

CREATE TABLE `address` (
   `address_id` varchar(36) NOT NULL COMMENT '地址id',
   `user_id` varchar(36) NOT NULL COMMENT '用户id',
   `receiver_name` varchar(20) NOT NULL DEFAULT '未填写' COMMENT '收货人姓名',
   `receiver_phone` varchar(20) NOT NULL DEFAULT '未填写' COMMENT '收货人电话',
   `address_country` varchar(20) NOT NULL DEFAULT '未填写' COMMENT '国家',
   `address_province` varchar(20) NOT NULL DEFAULT '未填写' COMMENT '省',
   `address_city` varchar(20) NOT NULL DEFAULT '未填写' COMMENT '城市',
   `detail` varchar(100) NOT NULL DEFAULT '未填写' COMMENT '地址细节',
   `version` int NOT NULL DEFAULT '1' COMMENT 'version乐观锁',
   `deleted` int NOT NULL DEFAULT '0' COMMENT '逻辑删除',
   `create_time` datetime NOT NULL COMMENT '创建时间',
   `update_time` datetime NOT NULL COMMENT '修改时间',
   PRIMARY KEY (`address_id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
drop table if exists `comment`;
 
 CREATE TABLE `comment` (
   `comment_id` varchar(36) NOT NULL COMMENT '评论id',
   `parent_id` varchar(36) NOT NULL DEFAULT '0' COMMENT '父评论id',
   `goods_id` varchar(36) NOT NULL COMMENT '商品id',
   `user_id` varchar(36) NOT NULL COMMENT '用户id',
   `comment_text` varchar(255) NOT NULL COMMENT '评论内容',
   `comment_score` int NOT NULL DEFAULT '5' COMMENT '商品分数',
   `version` int NOT NULL DEFAULT '1' COMMENT 'version乐观锁',
   `deleted`int NOT NULL DEFAULT '0' COMMENT '逻辑删除',
   `create_time` datetime NOT NULL COMMENT '创建时间',
   `update_time` datetime NOT NULL COMMENT '更新时间',
   PRIMARY KEY (`comment_id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
 drop table if exists `goods`;
 
 CREATE TABLE `goods` (
   `goods_id` varchar(36) NOT NULL COMMENT '商品id',
   `goods_name` varchar(50) DEFAULT '未填写' COMMENT '商品名称',
   `goods_type_id` varchar(36) DEFAULT '未填写' COMMENT '商品类型id',
   `goods_price` double DEFAULT '0' COMMENT '商品价格',
   `goods_image` varchar(1024) DEFAULT '' COMMENT '商品图片路径',
   `goods_simple_des` varchar(100) DEFAULT '未填写' COMMENT '商品简单描述',
   `goods_description` text COMMENT '商品详情',
   `goods_inventory` int NOT NULL DEFAULT '0' COMMENT '商品库存',
   `sold_count` int NOT NULL DEFAULT '0' COMMENT '已售数量',
   `retailer_id` varchar(36) NOT NULL COMMENT '商家id',
   `goods_stars_count` int NOT NULL DEFAULT '0' COMMENT '喜爱数',
   `views` int NOT NULL DEFAULT '0' COMMENT '浏览量',
   `version` int NOT NULL DEFAULT '1' COMMENT 'version乐观锁',
   `deleted` int NOT NULL DEFAULT '0' COMMENT '逻辑删除',
   `create_time` datetime NOT NULL COMMENT '创建时间',
   `update_time` datetime NOT NULL COMMENT '修改时间',
   PRIMARY KEY (`goods_id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
drop table if exists `goods_type`;

CREATE TABLE `goods_type` (
   `goods_type_id` varchar(36) NOT NULL COMMENT '商品类型id',
   `goods_type` varchar(50) NOT NULL COMMENT '商品类型',
   `version` int DEFAULT '1' COMMENT 'version乐观锁',
   `deleted` int DEFAULT '0' COMMENT '逻辑删除',
   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
   `update_time` datetime DEFAULT NULL COMMENT '修改时间',
   PRIMARY KEY (`goods_type_id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
 drop table if exists `login`;
 
CREATE TABLE `login` (
   `user_id` varchar(36) NOT NULL COMMENT '用户id',
   `user_name` varchar(20) NOT NULL COMMENT '用户名',
   `user_pwd` varchar(255) NOT NULL COMMENT '用户密码',
   `version` int DEFAULT '1' COMMENT 'version乐观锁',
   `deleted` int DEFAULT '0' COMMENT '逻辑删除',
   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
   `update_time` datetime DEFAULT NULL COMMENT '修改时间',
   PRIMARY KEY (`user_id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
  drop table if exists `order`;
 
 CREATE TABLE `order` (
   `order_id` varchar(36) NOT NULL COMMENT '订单id',
   `goods_id` varchar(36) NOT NULL COMMENT '商品id',
   `user_id` varchar(36) NOT NULL COMMENT '用户id',
   `retailer_id` varchar(36) NOT NULL COMMENT '商家id',
   `goods_count` int DEFAULT NULL COMMENT '商品数量',
   `goods_price` double DEFAULT NULL COMMENT '商品单价',
   `order_price` double NOT NULL COMMENT '订单总价',
   `order_state` varchar(1) NOT NULL DEFAULT '0' COMMENT '订单状态',
   `version` int DEFAULT '1' COMMENT 'version乐观锁',
   `deleted` int DEFAULT '0' COMMENT '逻辑删除',
   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
   `update_time` datetime DEFAULT NULL COMMENT '修改时间',
   PRIMARY KEY (`order_id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

  drop table if exists `user`;

CREATE TABLE `user` (
   `user_id` varchar(36) NOT NULL COMMENT '用户id',
   `user_realname` varchar(10) DEFAULT '未填写' COMMENT '用户真实姓名',
   `user_nickname` varchar(30) DEFAULT '未填写' COMMENT '用户昵称',
   `user_image` varchar(150) DEFAULT '' COMMENT '用户头像路径',
   `user_phone` varchar(20) DEFAULT '未填写' COMMENT '用户手机',
   `user_email` varchar(30) DEFAULT '未填写' COMMENT '用户邮箱',
   `user_gender` varchar(1) DEFAULT '0' COMMENT '用户性别',
   `user_birth` date DEFAULT '1970-01-01' COMMENT '出生日期',
   `user_type` varchar(1) DEFAULT '0' COMMENT '用户类型',
   `user_address_id` varchar(36) DEFAULT '' COMMENT '用户默认地址id',
   `version` int NOT NULL DEFAULT '1' COMMENT 'version乐观锁',
   `deleted` int NOT NULL DEFAULT '0' COMMENT '逻辑删除',
   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
   `update_time` datetime DEFAULT NULL COMMENT '修改时间',
   PRIMARY KEY (`user_id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

