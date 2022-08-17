create schema mvl;

create table mvl.developers(
    id serial primary key,
    name varchar(50) not null,
    foundation_date date not null,
    localization varchar(50) not null
);

create table mvl.genres(
    id serial primary key,
    name varchar(50) not null
);

create table mvl.video_games(
    id serial primary key,
    title varchar(50) not null,
    description text,
    main_image text,
    release_date date,
    developer integer not null,
    foreign key (developer) references mvl.developers(id)
);

create table mvl.platforms(
    id serial primary key,
    name varchar(50) not null,
    release_date date,
    developer integer not null,
    foreign key (developer) references mvl.developers(id)
);

create table mvl.video_game_genre(
    video_game_id integer,
    genre_id integer,
    foreign key (video_game_id) references mvl.video_games(id),
    foreign key (genre_id) references mvl.genres(id),
    primary key(video_game_id, genre_id)
);

create table mvl.video_game_platform(
    video_game_id integer,
    platform_id integer,
    foreign key (video_game_id) references mvl.video_games(id),
    foreign key (platform_id) references mvl.platforms(id),
    primary key(video_game_id, platform_id)
);