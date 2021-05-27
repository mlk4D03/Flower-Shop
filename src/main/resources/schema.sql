CREATE TABLE IF NOT EXISTS CANDY (
  id INT PRIMARY KEY auto_increment,
  name VARCHAR(20),
  price DOUBLE
);

create table if not exists candy_delivery (
   candy_id bigint not null,
   delivery_id bigint not null
);