

    create table appointments (
        appointmentId int4 not null,
        appointmentDate varchar(255),
        appointmentTime varchar(255),
        patientId_patientId int4,
        primary key (appointmentId)
    );

    create table doctor (
        id int4 not null,
        address varchar(255),
        contactNo varchar(255),
        dateOfBirth int4,
        designation varchar(255),
        specialization varchar(255),
        userId_userId int4,
        primary key (id)
    );

    create table patient (
        patientId int4 not null,
        address varchar(255),
        allergies varchar(255),
        billingInfo varchar(255),
        contactNo varchar(255),
        diseaseType varchar(255),
        doctorComments varchar(255),
        immunizations varchar(255),
        labResult varchar(255),
        medicines varchar(255),
        userId_userId int4,
        userName_userId int4,
        primary key (patientId)
    );

    create table patient_appointments (
        Patient_patientId int4 not null,
        patientAppId_appointmentId int4 not null
    );

    alter table patient_appointments 
        add constraint UK_c9ibmjtc8n9igk08y001borbx unique (patientAppId_appointmentId);

    alter table appointments 
        add constraint FKdbfxsqsfqjcaap1h6o3n0jb6o 
        foreign key (patientId_patientId) 
        references patient;


    alter table doctor 
        add constraint FK3jame8wdprpcv7hq8ffm4s4gk 
        foreign key (userId_userId) 
        references users;

    alter table patient 
        add constraint FKe3d1ukh6vy3qidid52280l3ki 
        foreign key (userId_userId) 
        references users;

    alter table patient 
        add constraint FK9578uwq6mtkhkmpo34d6bi11v 
        foreign key (userName_userId) 
        references users;

    alter table patient_appointments 
        add constraint FKiuvxykx8sct3xa5jgxg4u208k 
        foreign key (patientAppId_appointmentId) 
        references appointments;

    alter table patient_appointments 
        add constraint FKaexvftme9cgh2ps20ss9qjros 
        foreign key (Patient_patientId) 
        references patient;