CREATE TABLE IF NOT EXISTS ocupation( id int not null auto_increment primary key,
                    version int,
                    name varchar(45) );

CREATE TABLE IF NOT EXISTS employee( id int not null auto_increment primary key,
                          version int,
                          ocupation_id int not null,
                          username varchar(70),
                          password char(60),
                          name varchar(45),
                          foreign key (ocupation_id) references ocupation(id) );

CREATE TABLE IF NOT EXISTS authority (id int not null auto_increment primary key,
                             authority varchar_ignorecase(50) not null
);
CREATE TABLE IF NOT EXISTS authorities_employee (
                            employee_id varchar_ignorecase(50) not null,
                            authority_id varchar_ignorecase(50) not null,
                            constraint fk_authorities_authority foreign key(authority_id) references authority(id),
                            constraint fk_authorities_employee foreign key(employee_id) references employee(id)
);
CREATE TABLE IF NOT EXISTS client(id int not null auto_increment primary key,
                     version int,
                     name varchar(45),
                     email varchar(70),
                     cpf VARCHAR(20) ,
                     phone VARCHAR(20)
);
CREATE TABLE IF NOT EXISTS budget(id int not null auto_increment primary key,
                                  version int,
                                  date date,
                                  total_value decimal(13,2),
                                  expected_hours int,
                                  approved int,
                                  created_by int not null,
                                  client_id int not null,
                                  foreign key (created_by) references employee(id),
                                  foreign key (client_id) references client(id)
);
CREATE TABLE IF NOT EXISTS service_order(id int not null auto_increment primary key,
                          version int,
                          budget_id int not null,
                          status varchar,
                          name varchar(45),
                          started_at date,
                          last_updated date,
                          foreign key (budget_id) references budget(id) );
CREATE TABLE IF NOT EXISTS service_type(id int not null auto_increment primary key,
                         version int,
                         description varchar(45),
                         service_value decimal(13,2) );
CREATE TABLE IF NOT EXISTS service_type_budget(id int not null auto_increment primary key,
                                   version int,
                                   service_type_id int not null,
                                   budget_id int not null,
                                   foreign key (budget_id) references budget(id),
                                   foreign key (service_type_id) references service_type(id)
);