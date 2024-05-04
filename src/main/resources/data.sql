insert into users
(username,password,enabled)
values('user1','$2a$12$6D.dCUrpTShk8FAedIHJruGdS.rC1s341Cj1MrLbtO1B/c7/hbPUy',1);

insert into authorities
(username,authority)
values 
('user1','ROLE_USER');

insert into users
(username,password,enabled)
values('admin1','$2a$12$6D.dCUrpTShk8FAedIHJruGdS.rC1s341Cj1MrLbtO1B/c7/hbPUy',1);

insert into authorities
(username,authority)
values 
('admin1','ROLE_ADMİN');