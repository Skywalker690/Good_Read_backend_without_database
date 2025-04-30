# Book Schema

```
create table book (
   id INT PRIMARY KEY AUTO_INCREMENT,
   name varchar(255),
   imageUrl varchar(255)
);

```


# Insert Books

```
insert into book(name, imageUrl) values('Harry Potter and the Philosopher''s Stone', 'harry_potter_1.jpg');
insert into book(name, imageUrl) values('Harry Potter and the Chamber of Secrets','harry_potter_2.jpg');
insert into book(name, imageUrl) values('Harry Potter and the Goblet of Fire', 'harry_potter_3.jpg');
insert into book(name, imageUrl) values('Harry Potter and the Cursed Child','harry_potter_4.jpg');
insert into book(name, imageUrl) values('The 3 Mistakes of My Life', 'mistakes_life.jpg');

```

# data.sql File

```
insert into book(name, imageUrl) values('Life of Pi', 'life_of_pi.jpg');
insert into book(name, imageUrl) values('One Night at the Call Center','one_night_acc.jpg');
insert into book(name, imageUrl) values('Half Girlfriend', 'half_gf.jpg');
insert into book(name, imageUrl) values('The Secret', 'secret.jpg');
insert into book(name, imageUrl) values('Rise', 'rise.jpg');

```


