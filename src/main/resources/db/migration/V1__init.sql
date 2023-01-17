create table users
(
    id       bigserial,
    username varchar(30) not null unique,
    password varchar(80) not null,
    email    varchar(50) unique,
    primary key (id)
);

create table roles
(
    id   serial,
    name varchar(50) not null,
    primary key (id)
);

create table rights
(
    id   serial,
    name varchar(50) not null,
    primary key (id)
);

create table users_roles
(
     user_id bigint REFERENCES users (id),
     role_id integer REFERENCES roles (id)
);

create table roles_rights
(
    role_id integer REFERENCES roles (id),
    right_id integer REFERENCES rights (id)
);

insert into users (username, password, email)
values
('user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'user@gmail.com'),
('admin', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'admin@gmail.com');

insert into roles (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');


insert into rights (name)
values ('READ_USER_DATA'),
       ('READ_ADMIN_DATA'),
       ('DELETE_ADMIN_DATA'),
       ('DELETE_USER_DATA');

insert into users_roles (user_id, role_id)
values (1, 1),
       (2, 2),
       (2, 1);




insert into roles_rights (role_id, right_id)
VALUES (1,1),
       (1,4),
       (2,2),
       (2,3);


