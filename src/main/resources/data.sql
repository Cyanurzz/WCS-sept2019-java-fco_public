INSERT INTO user (id, username, firstname, lastname, password, email, role) VALUES
(1, 'superadmin', 'Quentin', 'Liger', '$2a$10$k.gGzFaNHZWqtK1/Rlacj.e7S1xHhH0QgA5zEqg8zWx6C0qSjluE.', 'superadmin@gmail.com', 'SUPERADMIN'),
(2, 'admin', 'Housseyn', 'Attafi', '$2a$10$k.gGzFaNHZWqtK1/Rlacj.e7S1xHhH0QgA5zEqg8zWx6C0qSjluE.', 'admin@gmail.com', 'ADMIN'),
(3, 'manager', 'Nicolas', 'Delamache', '$2a$10$3TtLLyln6AV1ppYghjG4JeSNMLlhAUDWNVRU0jSTjZJKDcCPpF6sq', 'manager@gmail.com', 'MANAGER'),
(4, 'membre', 'Clément', 'Jamin', '$2a$10$jGDkp5oX7lzFF.SVRUD1V.tlG9eMl6w4TEPPq1ORtRTuW5SIksJ0C', 'membre@gmail.com', 'MEMBRE');

INSERT INTO pole VALUES
(1, 'seniors'), (2, 'formation'), (3, 'pre-formation'), (4, 'ecole-de-foot'), (5, 'feminines'), (6, 'futsal');

INSERT INTO training (id, monday_start,monday_end,tuesday_start,tuesday_end,wednesday_start,wednesday_end,thursday_start,thursday_end,friday_start,friday_end,saturday_start,saturday_end,sunday_start,sunday_end) VALUES 
(1, '09:00:00','10:00:00','16:00:00','18:00:00','09:00:00','10:00:00','09:00:00','10:00:00','09:00:00','10:00:00','09:00:00','10:00:00','09:00:00','10:00:00'),
(2, '14:00:00','15:00:00','16:00:00','18:00:00','09:00:00','10:00:00','09:00:00','10:00:00','09:00:00','10:00:00','09:00:00','10:00:00','09:00:00','10:00:00');

INSERT INTO team (id, name, image, pole_id, training_id) VALUES
(1, 'U19', '', 2, 1), (2, 'U17', '', 2, 2), (3, 'U16', '', 2, null), (4, 'U15', '', 2, null), (5, 'U14', '', 2, null),
(6, 'U13', '', 3, null), (7, 'U12', '', 3, null), (8, 'U11', '', 3, null), (9, 'U10', '', 3, null),
(10, 'U9', '', 4, null), (11, 'U8', '', 4, null), (12, 'U7', '', 4, null), (13, 'U6', '', 4, null),
(14, 'Seniors 1', '', 1, null), (15, 'Seniors 2', '', 1, null), (16, 'Féminines U15', '', 5, null), (17, 'Futsal U15', '', 6, null);

INSERT INTO `player` VALUES
(1,'Joueur','carjaval','carvajal',3,'0612345678','/uploads/img/photoJoueur/player_carvajal_carjaval.png','défenseur',NULL,14),
(2,'Joueur','karim','karim',8,'0612345678','/uploads/img/photoJoueur/player_karim_karim.png','attaquant',NULL,14),
(3,'Joueur','luka','luka',5,'0612345678','/uploads/img/photoJoueur/player_luka_luka.png','défenseur',NULL,14),
(4,'Joueur','marcilo','marcilo',6,'0612345678','/uploads/img/photoJoueur/player_marcilo_marcilo.png','défenseur',NULL,14),
(5,'Joueur','sergio','sergio',3,'0612345678','/uploads/img/photoJoueur/player_sergio_sergio.png','défenseur',NULL,14),
(6,'Joueur','keylor','keylor',1,'0612345678','/uploads/img/photoJoueur/player_keylor_keylor.png','gardien',NULL,14),
(7,'Joueur','luca','luca',1,'0612345678','/uploads/img/photoJoueur/player_luca_luca.png','gardien',NULL,14),
(8,'staff','zidane','zidane',NULL,'0612345678','/uploads/img/photoJoueur/player_zidane_zidane.png','educateur',NULL,14),
(9,'staff','mauricio','mauricio',NULL,'0612345678','/uploads/img/photoJoueur/player_mauricio_mauricio.png','responsable',NULL,14),
(10,'staff','guardiola','guardiola',NULL,'0612345678','/uploads/img/photoJoueur/player_guardiola_guardiola.png','educateur',NULL,15),
(11,'staff','mauricio','mauricio',NULL,'0612345678','/uploads/img/photoJoueur/player_mauricio_mauricio.png','responsable',NULL,15),
(12,'Joueur','messi','messi',10,'0612345678','/uploads/photoJoueur/player_messi_messi.png','attaquant',NULL,15),
(13,'Joueur','naymar','naymar',9,'0612345678','/uploads/img/photoJoueur/player_naymar_naymar.png','attaquant',NULL,15),
(14,'Joueur','piqué','piqué',3,'0612345678','/uploads/img/photoJoueur/player_piqué_piqué.png','défenseur',NULL,15),
(15,'Joueur','surez','surez',9,'0612345678','/uploads/img/photoJoueur/player_surez_surez.png','attaquant',NULL,15),
(16,'Joueur','xavi','xavi',7,'0612345678','/uploads/img/photoJoueur/player_xavi_xavi.png','attaquant',NULL,15),
(17,'Joueur','johan','johan',1,'0612345678','/uploads/img/photoJoueur/player_johan_johan.png','gardien',NULL,15),
(18,'Joueur','diego','diego',1,'0612345678','/uploads/img/photoJoueur/player_diego_diego.png','gardien',NULL,15),
(19,'Joueur','carjaval','carvajal',3,'0612345678','/uploads/img/photoJoueur/player_carvajal_carjaval.png','défenseur',NULL,1),
(20,'Joueur','karim','karim',8,'0612345678','/uploads/img/photoJoueur/player_karim_karim.png','attaquant',NULL,1),
(21,'Joueur','luka','luka',5,'0612345678','/uploads/img/photoJoueur/player_luka_luka.png','défenseur',NULL,1),
(22,'Joueur','marcilo','marcilo',6,'0612345678','/uploads/img/photoJoueur/player_marcilo_marcilo.png','défenseur',NULL,1),
(23,'Joueur','sergio','sergio',3,'0612345678','/uploads/img/photoJoueur/player_sergio_sergio.png','défenseur',NULL,1),
(24,'Joueur','keylor','keylor',1,'0612345678','/uploads/img/photoJoueur/player_keylor_keylor.png','gardien',NULL,1),
(25,'Joueur','luca','luca',1,'0612345678','/uploads/img/photoJoueur/player_luca_luca.png','gardien',NULL,1),
(26,'staff','zidane','zidane',NULL,'0612345678','/uploads/img/photoJoueur/player_zidane_zidane.png','educateur',NULL,1),
(27,'staff','mauricio','mauricio',NULL,'0612345678','/uploads/img/photoJoueur/player_mauricio_mauricio.png','responsable',NULL,1),
(28,'staff','guardiola','guardiola',NULL,'0612345678','/uploads/img/photoJoueur/player_guardiola_guardiola.png','educateur',NULL,2),
(29,'staff','mauricio','mauricio',NULL,'0612345678','/uploads/img/photoJoueur/player_mauricio_mauricio.png','responsable',NULL,2),
(30,'Joueur','messi','messi',10,'0612345678','/uploads/img/photoJoueur/player_messi_messi.png','attaquant',NULL,2),
(31,'Joueur','naymar','naymar',9,'0612345678','/uploads/img/photoJoueur/player_naymar_naymar.png','attaquant',NULL,2),
(32,'Joueur','piqué','piqué',3,'0612345678','/uploads/img/photoJoueur/player_piqué_piqué.png','défenseur',NULL,2),
(33,'Joueur','surez','surez',9,'0612345678','/uploads/img/photoJoueur/player_surez_surez.png','attaquant',NULL,2),
(34,'Joueur','xavi','xavi',7,'0612345678','/uploads/img/photoJoueur/player_xavi_xavi.png','attaquant',NULL,2),
(35,'Joueur','johan','johan',1,'0612345678','/uploads/img/photoJoueur/player_johan_johan.png','gardien',NULL,2),
(36,'Joueur','diego','diego',1,'0612345678','/uploads/img/photoJoueur/player_diego_diego.png','gardien',NULL,2),
(37,'Joueur','carjaval','carvajal',3,'0612345678','/uploads/img/photoJoueur/player_carvajal_carjaval.png','défenseur',NULL,6),
(38,'Joueur','karim','karim',8,'0612345678','/uploads/img/photoJoueur/player_karim_karim.png','attaquant',NULL,6),
(39,'Joueur','luka','luka',5,'0612345678','/uploads/img/photoJoueur/player_luka_luka.png','défenseur',NULL,6),
(40,'Joueur','marcilo','marcilo',6,'0612345678','/uploads/img/photoJoueur/player_marcilo_marcilo.png','défenseur',NULL,6),
(41,'Joueur','sergio','sergio',3,'0612345678','/uploads/img/photoJoueur/player_sergio_sergio.png','défenseur',NULL,6),
(42,'Joueur','keylor','keylor',6,'0612345678','/uploads/img/photoJoueur/player_keylor_keylor.png','gardien',NULL,6),
(43,'Joueur','luca','luca',6,'0612345678','/uploads/img/photoJoueur/player_luca_luca.png','gardien',NULL,6),
(44,'staff','zidane','zidane',NULL,'0612345678','/uploads/img/photoJoueur/player_zidane_zidane.png','educateur',NULL,6),
(45,'staff','mauricio','mauricio',NULL,'0612345678','/uploads/img/photoJoueur/player_mauricio_mauricio.png','responsable',NULL,6),
(46,'staff','guardiola','guardiola',NULL,'0612345678','/uploads/img/photoJoueur/player_guardiola_guardiola.png','educateur',NULL,7),
(47,'staff','mauricio','mauricio',NULL,'0612345678','/uploads/img/photoJoueur/player_mauricio_mauricio.png','responsable',NULL,7),
(48,'Joueur','messi','messi',60,'0612345678','/uploads/img/photoJoueur/player_messi_messi.png','attaquant',NULL,7),
(49,'Joueur','naymar','naymar',9,'0612345678','/uploads/img/photoJoueur/player_naymar_naymar.png','attaquant',NULL,7),
(50,'Joueur','piqué','piqué',3,'0612345678','/uploads/img/photoJoueur/player_piqué_piqué.png','défenseur',NULL,7),
(51,'Joueur','surez','surez',9,'0612345678','/uploads/img/photoJoueur/player_surez_surez.png','attaquant',NULL,7),
(52,'Joueur','xavi','xavi',7,'0612345678','/uploads/img/photoJoueur/player_xavi_xavi.png','attaquant',NULL,7),
(53,'Joueur','johan','johan',6,'0612345678','/uploads/img/photoJoueur/player_johan_johan.png','gardien',NULL,7),
(54,'Joueur','diego','diego',6,'0612345678','/uploads/img/photoJoueur/player_diego_diego.png','gardien',NULL,7),
(55,'Joueur','carjaval','carvajal',3,'0612345678','/uploads/img/photoJoueur/player_carvajal_carjaval.png','défenseur',NULL,10),
(56,'Joueur','karim','karim',8,'0612345678','/uploads/img/photoJoueur/player_karim_karim.png','attaquant',NULL,10),
(57,'Joueur','luka','luka',5,'0612345678','/uploads/img/photoJoueur/player_luka_luka.png','défenseur',NULL,10),
(58,'Joueur','marcilo','marcilo',10,'0612345678','/uploads/img/photoJoueur/player_marcilo_marcilo.png','défenseur',NULL,10),
(59,'Joueur','sergio','sergio',3,'0612345678','/uploads/img/photoJoueur/player_sergio_sergio.png','défenseur',NULL,10),
(60,'Joueur','keylor','keylor',10,'0612345678','/uploads/img/photoJoueur/player_keylor_keylor.png','gardien',NULL,10),
(61,'Joueur','luca','luca',10,'0612345678','/uploads/img/photoJoueur/player_luca_luca.png','gardien',NULL,10),
(62,'staff','zidane','zidane',NULL,'0612345678','/uploads/img/photoJoueur/player_zidane_zidane.png','educateur',NULL,10),
(63,'staff','mauricio','mauricio',NULL,'0612345678','/uploads/img/photoJoueur/player_mauricio_mauricio.png','responsable',NULL,10),
(64,'staff','guardiola','guardiola',NULL,'0612345678','/uploads/img/photoJoueur/player_guardiola_guardiola.png','educateur',NULL,11),
(65,'staff','mauricio','mauricio',NULL,'0612345678','/uploads/img/photoJoueur/player_mauricio_mauricio.png','responsable',NULL,11),
(66,'Joueur','messi','messi',100,'0612345678','/uploads/img/photoJoueur/player_messi_messi.png','attaquant',NULL,11),
(67,'Joueur','naymar','naymar',9,'0612345678','/uploads/img/photoJoueur/player_naymar_naymar.png','attaquant',NULL,11),
(68,'Joueur','piqué','piqué',3,'0612345678','/uploads/img/photoJoueur/player_piqué_piqué.png','défenseur',NULL,11),
(69,'Joueur','surez','surez',9,'0612345678','/uploads/img/photoJoueur/player_surez_surez.png','attaquant',NULL,11),
(70,'Joueur','xavi','xavi',11,'0612345678','/uploads/img/photoJoueur/player_xavi_xavi.png','attaquant',NULL,11),
(71,'Joueur','johan','johan',10,'0612345678','/uploads/img/photoJoueur/player_johan_johan.png','gardien',NULL,11),
(72,'Joueur','diego','diego',10,'0612345678','/uploads/img/photoJoueur/player_diego_diego.png','gardien',NULL,11);

INSERT INTO card (lastname, firstname, url, picture) VALUES
('Barul','Patrick','https://www.google.com/',''),
('Belmiloud','Tiphaine','https://www.google.com/',''),
('Cisse ','Kalifa','https://www.google.com/',''),
('Cissokho','Aly','https://www.google.com/',''),
('El Kanchaf','Aziz','https://www.google.com/',''),
('Jebali','Hakim','https://www.google.com/',''),
('Kantari','Ahmed','https://www.google.com/',''),
('Kassai','Ferander','https://www.google.com/',''),
('Luyindula','Pegguy','https://www.google.com/',''),
('Menager','Adrien','https://www.google.com/',''),
('Plessis','Damien','https://www.google.com/',''),
('Plessis','Guillaume','https://www.google.com/',''),
('Rabbah','Aziz','https://www.google.com/',''),
('Rodrigues','Michaël','https://www.google.com/',''),
('Zerka','Moncef','https://www.google.com/',''),
('Thauvin','Florian','https://www.google.com/','');

INSERT INTO `product` VALUES
(1,'In imperdiet lectus quam, vel dictum tellus aliquam id. Maecenas et efficitur est. Vivamus sed tincidunt augue. Pellentesque condimentum ornare magna sed tempus.','Maillot du club','/uploads/img/photoProduit/product_maillot du club.jpg',60,NULL,10,15,14,20,12,8),
(2,'Suspendisse efficitur dapibus ex, non condimentum urna maximus sit amet. Integer volutpat est in neque cursus, a efficitur risus rhoncus. Mauris faucibus magna et ultrices dignissim.','Short du club','/uploads/img/photoProduit/product_short du club.jpg',20,NULL,10,14,7,11,10,14),
(3,'Sed pulvinar nibh nec egestas varius. Sed cursus et risus at vulputate. Donec finibus porta lacus. In nec ex nunc. Duis porttitor congue ligula, molestie euismod erat eleifend vitae.','Mug','/uploads/img/photoProduit/product_mug.jpg',8,139,NULL,NULL,NULL,NULL,NULL,NULL);

INSERT INTO background VALUES
(1, 'accueil', '/uploads/img/backgrounds/accueil.jpg'),
(2, 'match', '/uploads/img/backgrounds/match.jpeg'),
(3, 'poles', '/uploads/img/backgrounds/poles.jpeg'),
(4, 'organigramme', '/uploads/img/backgrounds/black.png'),
(5, 'article', '/uploads/img/backgrounds/article.jpeg');

INSERT INTO `sponsor` VALUES
(1,'Umbro',1,'https://www.umbro.fr/','/uploads/img/photoSponsor/sponsor_umbro.png'),
(2,'St Jean de la Ruelle',2,'http://www.ville-saintjeandelaruelle.fr/','/uploads/img/photoSponsor/sponsor_st jean de la ruelle.png');

INSERT INTO contact (id, address, mail, phone, facebook, instagram, youtube) VALUES
(1, 'Stade Guy Gallier, impasse Paul Bert, 45140 St Jean de la Ruelle', 'coordination.fco@gmail.com', '09 86 16 00 34', 'https://www.facebook.com/ForceCourageObstination/', 'https://www.instagram.com/fco_officiel/', '');

INSERT INTO video VALUES (1, 'https://www.youtube.com/embed/8x4MCmplQ3s');

INSERT INTO `encounter` VALUES (1,'Régionale 1','Equipe Futsal',1581166800000,'/uploads/img/logoClub/visitorLogo.png','Paris');

INSERT INTO `paragraph` VALUES
(1,'/uploads/img/photoHistoire/paragraph_Le.jpeg','Le F.C.O. est né en 1968 de la fusion entre l’Entente O.C.O. Rossat et de l’Entente Sportivedes Halles d’Orléans. L’Entente O.C.O. Rossat avait été, quant à elle, constituée en 1962 à la suite du rapprochement du Club Orléanais Olympique et du club de Saint Jean de la Ruelle, le cercle Louis Rossat. En 1982, pour affirmer son intégration totale à Saint Jean de la Ruelle, le Football Club Orléanais est devenu le Football Club Olympique de Saint Jean de la Ruelle (Journal Officiel du 14/03/1982). L’équipe 1ère a longtemps évolué au plus haut niveau régional (DH) avant d’être reléguée en DHR au cours de la saison 2005/06 et retrouve le niveau DH dès la saison suivante.'),
(2,'/uploads/img/photoHistoire/paragraph_Depuis.jpeg','Depuis sa création, le Football Club Olympique de Saint Jean de la Ruelle a participé à 11 finales de Coupe du Loiret, en la remportant 7 fois. Mais le plus grand événement que le club est connu, a été, sans aucun doute, la qualification pour les 32èmes de finale de la Coupe de France. Face à l’équipe professionnelle de l’ A.S. BEAUVAIS (2ème Division), le F.C.O. s’est incliné sur le score de 3 à 2, à l’issue d’un match plein. Cette rencontre avait été suivie par près de 4000 spectateurs au stade de la Source à Orléans. Avec son équipe réserve le club remporte le titre de champion régional PH en 1989 et de PL en 2009.'),
(3,'/uploads/img/photoHistoire/paragraph_Mais.jpeg','Mais le club a également suivi une politique de formation qui a porté ses fruits au fil des années. En effet, durant plusieurs saisons le club a été représenté au niveau national par ces équipes 15 et 17 Ans et bon nombre de joueurs ayant évolué au F.C.O. ont pu grâce à ces compétitions intégrer des Centres de Formation. La reconnaissance du travail des éducateurs aura été d’être classé 2ème club formateur de la Ligue du Centre de Football derrière la Berrichonne de Châteauroux, et d’être au 7ème rang national des clubs amateurs en 1998. Cette reconnaissance est également intervenue au niveau professionnel puisque le club a signé un accord de partenariat avec les Girondins de Bordeaux qui aura duré 2 saisons.');

INSERT INTO `galerie` VALUES
(1,'/uploads/img/photoGalerie/soc14.jpg.jpg','Photo du club'),
(2,'/uploads/img/photoGalerie/soc13.jpg.jpg','Photo du club'),
(3,'/uploads/img/photoGalerie/soc12.jpg.jpg','Photo du club'),
(4,'/uploads/img/photoGalerie/soc11.jpg.jpg','Photo du club'),
(5,'/uploads/img/photoGalerie/soc10.jpg.jpg','Photo du club'),
(6,'/uploads/img/photoGalerie/soc9.jpg.jpg','Photo du club'),
(7,'/uploads/img/photoGalerie/soc8.jpg.jpg','Photo du club'),
(8,'/uploads/img/photoGalerie/soc7.jpg.jpg','Photo du club'),
(9,'/uploads/img/photoGalerie/soc6.jpg.jpg','Photo du club'),
(10,'/uploads/img/photoGalerie/soc5.jpg.jpg','Photo du club'),
(11,'/uploads/img/photoGalerie/soc4.jpg.jpg','Photo du club'),
(12,'/uploads/img/photoGalerie/soc3.jpg.jpg','Photo du club'),
(13,'/uploads/img/photoGalerie/soc2.jpg.jpg','Photo du club'),
(14,'/uploads/img/photoGalerie/soc1.jpg.jpg','Photo du club');

INSERT INTO `event` VALUES
(1,'Vestibulum vel sem maximus, finibus nibh eu, interdum tellus. Mauris tincidunt odio sit amet diam suscipit ultricies. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Maecenas sit amet pulvinar felis. Phasellus metus nisi, scelerisque sed magna vel, fermentum ullamcorper sapien. Sed volutpat interdum metus, non euismod elit consectetur vel. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Suspendisse efficitur tellus sem, varius luctus lectus pretium non. In ac leo suscipit, elementum sapien quis, egestas purus. Ut iaculis turpis malesuada eros ultricies rhoncus. Morbi sed urna ut velit sodales ultrices. Mauris interdum malesuada augue, id elementum sapien porttitor nec. Vestibulum aliquam dui eu justo faucibus ullamcorper. Nunc sagittis lobortis mi id ornare. Vivamus in ex tortor. Morbi eu luctus ipsum, non dictum tellus. ','2020-02-12 14:00:00','/uploads/img/photoEvent/event_coupe nationale futsal.jpg',210,'Coupe Nationale Futsal'),
(2,'Pellentesque sodales tortor at arcu tempus, id convallis ante accumsan. Nam et finibus lorem. Donec rhoncus, urna convallis tincidunt pretium, nulla lorem suscipit odio, quis ultrices ex dolor mollis arcu. In hac habitasse platea dictumst. Integer vitae arcu quis nisl pharetra molestie et vitae risus. Cras bibendum enim nec faucibus consectetur. Maecenas laoreet vitae tellus quis mollis. Interdum et malesuada fames ac ante ipsum primis in faucibus. Morbi malesuada turpis ut justo placerat mattis. Nullam lacinia velit at aliquam euismod. In cursus quis purus non finibus. Vivamus aliquet elit sed leo faucibus fermentum. Etiam nec odio sollicitudin, lobortis velit quis, auctor purus. ','2020-02-10 14:00:00','/uploads/img/photoEvent/event_evenement unique.jpg',1,'Evenement unique'),
(3,'Nulla diam augue, facilisis ac tincidunt id, accumsan sit amet nunc. Donec risus mauris, pellentesque nec lorem quis, dapibus sodales leo. Aliquam imperdiet purus neque, ut lacinia ex elementum quis. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nam lobortis diam a auctor pellentesque. Fusce gravida facilisis massa vitae aliquam. Fusce augue mi, finibus id magna sed, consectetur vestibulum diam. Curabitur turpis purus, aliquam at tincidunt non, congue laoreet nibh.','2019-12-25 14:00:00','/uploads/img/photoEvent/event_tournois de noel.jpg',40,'Tournois de Noel');

INSERT INTO `entrant` VALUES
(1,19,'Quentin','Liger','01 23 45 67 89',1),
(2,241,'JeanChristophe','Rocher','04 89 52 46 31',1);

INSERT INTO `staff` VALUES
(1,'president','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed mollis nisl nulla, porttitor condimentum lacus tempus nec. Suspendisse potenti.','MANIONGUI','Président','MBOKO',''),
(2,'bureau','Integer pharetra sollicitudin nisl, non maximus ligula tempus non. Curabitur urna augue, efficitur sit amet convallis sed, hendrerit nec leo. Nulla facilisi.','Jeanne','Trésorier','Eleou',''),
(3,'bureau','Mauris dictum tristique lacinia. Ut placerat ex nec nulla sollicitudin, et pulvinar leo sagittis. Sed gravida, quam non tincidunt egestas, nulla orci ullamcorper tortor, vitae facilisis justo justo pulvinar nunc.','Michel','Responsable d’équipes','Michel','');

INSERT INTO `article` VALUES
(1,'','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum mollis ultrices scelerisque. Nam sed nisi orci. Aliquam at est vitae velit bibendum consectetur. Nunc laoreet convallis augue bibendum porta. Donec at elementum leo, sit amet semper nulla. Etiam sit amet malesuada nisl, quis facilisis nibh. Mauris blandit, nisi aliquam consectetur iaculis, enim nisl vehicula libero, ac porta ante metus a velit. Pellentesque sed tristique magna. Donec a hendrerit est, eu dignissim velit. ','2020-01-23 17:07:17','Séniors','/uploads/img/photoArticle/article_rencontres du week-end.jpg',1,'Rencontres du week-end'),
(2,'','Morbi convallis gravida viverra. Suspendisse potenti. Fusce vel lorem ac purus fermentum hendrerit id euismod velit. Nulla facilisi. Maecenas tristique lacinia lacus. Sed pellentesque fringilla enim at maximus. In rutrum tempus accumsan. ','2020-01-23 17:08:17','Toutes Catégories','/uploads/img/photoArticle/article_résultats de janvier.jpg',1,'Résultats de Janvier'),
(3,'','Duis convallis, velit vitae convallis dictum, orci enim porttitor ligula, non vestibulum nibh lorem vitae velit. Proin convallis arcu vel odio volutpat varius. Nulla vestibulum interdum nunc, eu vulputate mi tincidunt vitae. Suspendisse potenti. Etiam ornare tellus dolor, sed pretium risus gravida eu. Sed hendrerit ante metus, id tempus metus hendrerit a. Aenean ut dignissim mauris, eu hendrerit erat. Curabitur pulvinar ipsum ut aliquam posuere.','2020-01-23 17:08:55','Toutes Catégories','/uploads/img/photoArticle/article_coupe du monde.jpg',1,'Coupe du Monde'),
(4,'','Donec elementum felis sit amet cursus faucibus. Proin lacus odio, maximus ut mauris quis, finibus elementum est. Integer ac eros nec ex suscipit consequat. Sed quam justo, mollis et commodo non, lobortis nec mi. Cras sit amet dictum nunc. Proin placerat, leo et dignissim imperdiet, tortor velit cursus orci, at sollicitudin est lectus nec massa. Integer ornare nulla nec ex sagittis sagittis. Quisque fringilla neque id tellus tempus, vitae suscipit libero sodales. ','2020-01-23 17:09:22','U19','/uploads/img/photoArticle/article_première place pour les u19.jpg',2,'Première place pour les U19'),
(5,'','Etiam eget aliquam leo. Pellentesque a ligula eleifend magna tempor iaculis sed nec massa. Etiam sodales sem tortor, vitae ornare ipsum faucibus a. Curabitur quis maximus purus, at feugiat magna. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Etiam auctor leo eget metus efficitur elementum. Aliquam a purus posuere, semper ligula imperdiet, imperdiet nisl. Nunc facilisis sagittis ligula, at dapibus lorem cursus nec.','2020-01-23 17:10:17','U10','/uploads/img/photoArticle/article_stage de paques.jpg',3,'Stage de Paques'),
(6,'','Suspendisse potenti. Nulla placerat rutrum nunc, non faucibus augue efficitur eu. Phasellus placerat molestie lorem, eu varius tortor rhoncus id. Maecenas consectetur porta eros, et fermentum dui. Morbi eu rhoncus odio. In varius feugiat enim et iaculis. ','2020-01-23 17:11:05','Féminines','/uploads/img/photoArticle/article_victoire pour les féminines.jpg',3,'Victoire pour les Féminines'),
(7,'','Quisque auctor, erat non consequat hendrerit, eros sapien iaculis velit, vulputate lacinia nunc eros a eros. Phasellus at blandit turpis, et feugiat ex. Fusce rhoncus felis vitae scelerisque efficitur. Cras luctus ut ligula sed lacinia. Integer finibus elementum metus, ac tristique leo lobortis in. Nam commodo enim sit amet sodales tincidunt. In hac habitasse platea dictumst. Aliquam sit amet ipsum mauris. Mauris quis pulvinar arcu. In elementum turpis vitae vestibulum molestie. Nullam ultrices sodales nibh, a luctus est laoreet quis. Integer bibendum ex velit, nec dapibus elit eleifend et. ','2020-01-23 17:11:50','U9','/uploads/img/photoArticle/article_stage de détection.jpg',3,'Stage de Détection'),
(8,'','Ut enim magna, volutpat sit amet sapien in, facilisis porta augue. Nunc nulla urna, euismod a lobortis ornare, ultricies non lacus. Maecenas eu varius orci, vel porta arcu. Sed maximus nisi vehicula, lacinia enim vel, tincidunt massa. Duis bibendum aliquam erat in commodo. Donec nec lorem dolor. Donec eget gravida est, nec auctor tortor. ','2020-01-23 17:15:38','Autres','/uploads/img/photoArticle/article_refonte du site par la wildcodeschool.jpg',3,'Refonte du site par la WildCodeSchool');