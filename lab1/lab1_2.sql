create table provider(
    provider_code varchar(255) primary key,
    name varchar(255),
    status int,
    city varchar(255)
);

create table detail(
    detail_code varchar(255) primary key ,
    name varchar(255),
    color varchar(255),
    size int,
    city varchar(255)
);

create table project(
    project_code varchar(255) primary key ,
    name varchar(255),
    city varchar(255)
);

create table number_of_details(
    provider_code varchar(255) references provider(provider_code),
    detail_code varchar(255) references detail(detail_code),
    project_code varchar(255) references project(project_code),
    number int
);

insert into provider (provider_code, name, status, city)
VALUES ('P1', 'Petrov', 20, 'Moscow'),
       ('P2', 'Sinicin', 10, 'Tallin'),
       ('P3', 'Federov', 30, 'Tallin'),
       ('P4', 'Chaianov', 20, 'Minsk'),
       ('P5', 'Krykov', 30, 'Kiev');

insert into detail (detail_code, name, color, size, city)
VALUES ('D1', 'Bolt', 'Red', 12, 'Moscow'),
       ('D2', 'Gaika', 'Green', 17, 'Minsk'),
       ('D3', 'Disk', 'Black', 17, 'Vilnus'),
       ('D4', 'Disk', 'Black', 14, 'Moscow'),
       ('D5', 'Korpus', 'Red', 12, 'Minsk'),
       ('D6', 'Krishki', 'Red', 19, 'Moscow');

insert into project (project_code, name, city)
VALUES ('PR1', 'IPR1', 'Minsk'),
       ('PR2', 'IPR2', 'Tallin'),
       ('PR3', 'IPR3', 'Pskov'),
       ('PR4', 'IPR4', 'Pskov'),
       ('PR5', 'IPR4', 'Moscow'),
       ('PR6', 'IPR6', 'Saratov'),
       ('PR7', 'IPR7', 'Moscow');

insert into number_of_details (provider_code, detail_code, project_code, number)
VALUES ('P1', 'D1', 'PR1', 200),
       ('P1', 'D1', 'PR2', 700),
       ('P2', 'D3', 'PR1', 400),
       ('P2', 'D2', 'PR2', 200),
       ('P2', 'D3', 'PR3', 200),
       ('P2', 'D3', 'PR4', 500),
       ('P2', 'D3', 'PR5', 600),
       ('P2', 'D3', 'PR6', 400),
       ('P2', 'D3', 'PR7', 800),
       ('P2', 'D5', 'PR2', 100),
       ('P3', 'D3', 'PR1', 200),
       ('P3', 'D4', 'PR2', 500),
       ('P4', 'D6', 'PR3', 300),
       ('P4', 'D6', 'PR7', 300),
       ('P5', 'D2', 'PR2', 200),
       ('P5', 'D2', 'PR4', 100),
       ('P5', 'D5', 'PR5', 500),
       ('P5', 'D5', 'PR7', 100),
       ('P5', 'D6', 'PR2', 200),
       ('P5', 'D1', 'PR2', 100),
       ('P5', 'D3', 'PR4', 200),
       ('P5', 'D4', 'PR4', 800),
       ('P5', 'D5', 'PR4', 400),
       ('P5', 'D6', 'PR4', 500);

/*16*/
select sum(number)
from number_of_details
where detail_code='D1' and provider_code='P1';

/*27*/
select distinct provider_code
from number_of_details
where detail_code='D1' and number>(
    select avg(number) from number_of_details where detail_code='D1'
);

/*35*/
SELECT DISTINCT p.provider_code, d.detail_code
FROM number_of_details p
CROSS JOIN (SELECT DISTINCT provider_code FROM number_of_details) s
CROSS JOIN (SELECT DISTINCT detail_code FROM number_of_details) d
WHERE NOT EXISTS (
    SELECT *
    FROM number_of_details
    WHERE provider_code = s.provider_code
    AND detail_code = d.detail_code
);

/*5*/
select distinct color, city from detail;

/*8*/
select distinct nod.provider_code, nod.detail_code, nod.project_code from number_of_details nod
join public.provider p on nod.provider_code = p.provider_code
join detail d on d.detail_code = nod.detail_code
join project pr on pr.project_code = nod.project_code
where not (p.city=d.city or p.city=pr.city or d.city=pr.city);

/*17*/
select detail_code, project_code, number from number_of_details;

/*21*/
select distinct nod.detail_code from number_of_details nod
join project p on nod.project_code = p.project_code
where p.city='Moscow';

/*12*/
select distinct nod.detail_code from number_of_details nod
join public.provider p on nod.provider_code = p.provider_code
join project pr on pr.project_code = nod.project_code
where p.city=pr.city;

/*29*/
select project_code from number_of_details
where provider_code = 'P1';

/*23*/
select distinct nod.provider_code from number_of_details nod
join detail d on nod.detail_code = d.detail_code
where d.color='Red';