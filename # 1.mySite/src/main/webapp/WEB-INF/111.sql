create table service_user (
	id bigserial primary key,
	first_name varchar(20),
	last_name varchar(20),
	age integer,
	phone varchar(20) unique ,
	email varchar(100) unique,
	login varchar(100) unique,
	password varchar(100),
	role varchar(10)
);

create table cookie (
  id bigserial primary key,
  value VARCHAR(200),
  user_id bigint,
  foreign key (user_id) references service_user(id)
);

create table carts (
  id bigserial primary key,
  item VARCHAR(100),
  cost VARCHAR(100),
);

create table cart (
  id bigserial primary key,
  owner_id BIGINT,
  FOREIGN KEY (owner_id) references service_user(id)
);

create table productsINcart (
  id bigserial primary key,
  cart_id bigint,
  products_id bigint,
  FOREIGN KEY (cart_id) references cart(id),
  FOREIGN key (products_id) references carts(id)
);