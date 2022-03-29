create table ocupation( id int not null auto_increment primary key,
                    name varchar(45) );

create table employee( id int not null auto_increment primary key,
                          ocupation_id int not null,
                          email varchar(70),
                          password char(60),
                          name varchar(45),
                          foreign key (ocupation_id) references ocupation(id) );

create table client(id int not null auto_increment primary key,
                     name varchar(45),
                     email varchar(70),
                     cpf VARCHAR(20) ,
                     phone VARCHAR(20)
);

create table budget( id int not null auto_increment primary key,
                        date date,
                        value decimal(13,2),
                        expected_hours int,
                        approved int,
                        created_by int not null,
                        client_id int not null,
                        foreign key (created_by) references employee(id),
                        foreign key (client_id) references client(id) );

create table service_order(id int not null auto_increment primary key,
                          budget_id int not null,
                          status int,
                          name varchar(45),
                          started_at date,
                          last_updated date,
                          foreign key (budget_id) references budget(id) );

create table service_type(id int not null auto_increment primary key,
                         description varchar(45),
                         value decimal(13,2) );

create table service_type_budget(id int not null auto_increment primary key,
                                   service_type_id int not null,
                                   budget_id int not null,
                                   foreign key (budget_id) references budget(id),
                                   foreign key (service_type_id) references service_type(id) );