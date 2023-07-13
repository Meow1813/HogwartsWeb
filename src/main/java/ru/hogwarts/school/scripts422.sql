/*Описание структуры: у каждого человека есть машина.
    Причем несколько человек могут пользоваться одной машиной.
    У каждого человека есть имя, возраст и признак того,
    что у него есть права (или их нет). У каждой машины есть марка,
    модель и стоимость. Также не забудьте добавить таблицам первичные ключи
    и связать их.*/
CREATE TABLE driver(
    Id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    age INTEGER CHECK (age > 0),
    licensed BOOLEAN,
    car_id INTEGER REFERENCES car(Id)
);

CREATE TABLE car(
    Id SERIAL PRIMARY KEY,
    brand VARCHAR(50),
    model VARCHAR(100),
    price MONEY
)