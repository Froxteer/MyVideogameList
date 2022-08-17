insert into mvl.genres(name) values
    ('Action'),
    ('RPG'),
    ('Multiplayer'),
    ('Party');

insert into mvl.developers(name, foundation_date, localization) values
    ('From Software', '1986-11-01', 'Japan'),
    ('Microsoft', '1975-04-04', 'USA'),
    ('Sony', '1993-11-16', 'Japan'),
    ('MediaTonic', '2005-09-01', 'England'),
    ('Nintendo', '1889-09-23', 'Japan'),
    ('Capcom', '1979-05-30', 'Japan'),
    ('Grinding Gear Games', '2006-01-01', 'New Zealand');

insert into mvl.platforms(name, release_date, developer) values
    ('PC', '1900-01-01', 2),
    ('PS4', '2013-11-15', 3),
    ('PS5', '2020-11-12', 3),
    ('Xbox One', '2013-11-22', 2),
    ('Xbox Series X', '2020-11-10', 2),
    ('Nintendo Switch', '2017-03-03', 5);

insert into mvl.video_games(title, description, main_image, release_date, developer) values
    ('Elden Ring',
    'Elden Ring is an action role-playing game played in a third person perspective, with gameplay focusing on combat and exploration; it features elements similar to those found in other games developed by FromSoftware, such as the Souls series, Bloodborne, and Sekiro: Shadows Die Twice. Set in an open world, players are allowed to freely explore the Lands Between and its six main areas; These locations range from Limgrave, an area featuring grassy plains and ancient ruins, to Caelid, a wasteland home to undead monsters. Open world areas are explorable using the character''s mount, Torrent, as the primary mode of transportation, along with the ability to fast travel outside of combat. Throughout the game, players encounter non-player characters (NPCs) and enemies alike, including the demigods who rule each main area and serve as the game''s main bosses. Aside from open world areas, Elden Ring also features hidden dungeons, such as catacombs, tunnels, and caves where players can fight bosses and gather helpful items',
    'https://cdn.cdkeys.com/700x700/media/catalog/product/e/l/elden_ring_deluxe_edition_xbox_one_xbox_series_x_s_uk__1_1_1_1.jpg',
    '2022-02-25',
    1),
    ('Fall Guys',
    'Up to 60 players compete in matches with battle royale-style gameplay. Players, represented as jellybean-like figures, move around a three-dimensional playing field, with additional moves such as jumping, grabbing/climbing, or diving to assist gameplay. The aim is to qualify for subsequent rounds by successfully completing each of the randomly selected mini-games. Certain mini-games involve running towards a finish line at the end of the map, playing tag with other players, while others add elements of teamwork. On every mini-game, obstacles appear around the map for added complexity. Players who are too slow, who fall into pink slime, or who fail certain requirements for a mini-game, are eliminated. On the final round, the remaining few players compete in a final match with a randomised mini-game designed for a smaller player size. The winner of the match is the last player standing',
    'https://cdn.cdkeys.com/700x700/media/catalog/product/n/e/new_project_6__4.jpg',
    '2020-08-04',
    4),
    ('Monster Hunter Rise',
    'As with previous Monster Hunter titles, Monster Hunter Rise has the player take the role of a Hunter, tasked with slaying or capturing large monsters using a variety of weapons, tools, and environmental features to damage and weaken them while surviving their attacks. Successful completion of the offered quests provides loot, typically in the form of various monster parts from the monster, which are used to forge new armor and weapons that can be used to take on more powerful monsters, forming the series'' notable core loop. Several of the series'' monsters return along with a host of new monsters developed for Rise. All fourteen weapon types that have been present in both Monster Hunter Generations and World, which mix archetypes of swords, shields, staves, bows, and guns, are present in Rise',
    'https://cdn.cdkeys.com/500x706/media/catalog/product/m/o/monster_hunter_rise_pc.jpg',
    '2021-03-26',
    6),
    ('Path of Exile',
    'The game is set in a dark fantasy world. The player starts the game waking up on the shores of Wraeclast, a continent that once was the center of a mighty empire but is now a cursed land which serves as a penal colony for criminals and other unwanted individuals from the nearby Island of Oriath. Regardless of the reasons for their exile, players must now face the unforgiving wilderness and its dangerous inhabitants amidst the crumbling ruins and bloody secrets of the Eternal Empire and the Vaal civilization that came before, and band together with other exiles to survive.',
    'https://e.snmc.io/lk/f/x/e9a0c019638d17e05a964452e2428c78/5288895',
    '2013-10-23',
    7);

insert into mvl.video_game_genre values
    (1, 1),
    (1, 2),
    (2, 3),
    (2, 4),
    (3, 1),
    (3, 2),
    (4, 1),
    (4, 2),
    (4, 3);

insert into mvl.video_game_platform values
    (1, 1),
    (1, 2),
    (1, 3),
    (1, 4),
    (1, 5),
    (2, 1),
    (2, 2),
    (2, 3),
    (2, 4),
    (2, 5),
    (2, 6),
    (3, 1),
    (3, 6),
    (4, 1),
    (4, 2),
    (4, 4);