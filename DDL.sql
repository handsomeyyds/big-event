create table big_event.user (
                                id int unsigned primary key auto_increment comment 'ID',
                                username varchar(20) not null unique comment '用户名',
                                password varchar(32) comment '密码',
                                nickname varchar(10) default '' comment '昵称',
                                email varchar(128) default '' comment '邮箱',
                                user_pic varchar(128) default '' comment '头像',
                                create_time datetime not null comment '创建时间',
                                update_time datetime not null comment '修改时间'
) comment '用户表';

create table big_event.category(
                                   id int unsigned primary key auto_increment comment 'ID',
                                   category_name varchar(32) not null comment '分类名词',
                                   category_alias varchar(32) not null comment '分类别名',
                                   create_user int unsigned not null comment '创建人ID',
                                   create_time datetime not null comment '创建时间',
                                   update_time datetime not null comment '修改时间'
) comment '分类表';

create table big_event.article(
                                  id int unsigned primary key auto_increment comment 'ID',
                                  title varchar(30) not null comment '标题',
                                  cover_img varchar(128) not null comment '封面',
                                  state varchar(3) default '草稿' comment '状态，已发布或草稿',
                                  category_id int unsigned comment '分类ID',
                                  create_user int unsigned not null comment '作者',
                                  content text not null comment '内容',
                                  create_time datetime not null comment '创建时间',
                                  update_time datetime not null comment '更新时间'
) comment '文章表';