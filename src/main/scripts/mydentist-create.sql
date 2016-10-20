create sequence hibernate_sequence start 1 increment 1;

    

    create table users (
        userId int4 not null,
        userEmail varchar(255),
        userPassword varchar(255),
        userType varchar(255),
        username varchar(255),
        primary key (userId)
    );

    