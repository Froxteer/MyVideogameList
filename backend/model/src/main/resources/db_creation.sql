drop database if exists myvideogamelist;
create database myvideogamelist;
use myvideogamelist;

create table video_games(
    id integer primary key auto_increment,
    title varchar(50) not null,
    release_date date
);

create table genres(
    id integer primary key auto_increment,
    name varchar(50) not null
);

create table companies(
    id integer primary key auto_increment,
    name varchar(50) not null,
    foundation_date date not null,
    localization varchar(50) not null
);

create table platforms(
    id integer primary key auto_increment,
    name varchar(50) not null,
    release_date date,
    developer integer not null,
    foreign key (developer) references companies(id)
);

create table video_game_genre(
    video_game_id integer,
    genre_id integer,
    foreign key (video_game_id) references video_games(id),
    foreign key (genre_id) references genres(id),
    primary key(video_game_id, genre_id)
);

create table video_game_platform(
    video_game_id integer,
    platform_id integer,
    foreign key (video_game_id) references video_games(id),
    foreign key (platform_id) references platforms(id),
    primary key(video_game_id, platform_id)
);

create table video_game_company(
    video_game_id integer,
    company_id integer,
    foreign key (video_game_id) references video_games(id),
    foreign key (company_id) references companies(id),
    primary key (video_game_id, company_id)
);