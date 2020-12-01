drop database if exists blog;

create database blog character set utf8mb4;

drop table user;
create table user(
    id int primary key auto_increment,
    username varchar(20) not null unique,
    password varchar(20) not null,
    nickname varchar(20),
    sex bit,
    birthday date,
    head varchar(50)
);

drop table article;
create table article(
    id int primary key auto_increment,
    title varchar(20) not null,
    content mediumtext not null,
    create_time timestamp default now(),
    view_count int default 0,
    user_id int,
    foreign key(user_id) references user(id)
);

insert into user(username,password) values
('a','1'),
('b','12'),
('c','12'),
('d','1'),
('e','13');

insert into article(title, content, user_id) value
('快速排序', 'public...',1),
('冒泡排序', 'public...',2),
('选择排序', 'public...',3),
('归并排序', 'public...',1),
('插入排序', 'public...',2),
('希尔排序', 'public...',3),
('堆排序', 'public...',1);

-- 主外键关联的表，默认创建的主外键约束是restrict严格模式
-- 比如从表中有数据关联到主表某一行数据X,那么X不能删
-- 真实的设计上 是不删除物理结构,在每一张表上设计一个字段，表示是否有效