
--
-- Base de données :  `baseprojet`
--

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

DROP TABLE IF EXISTS `Article`;
CREATE TABLE IF NOT EXISTS `Article` (
  `NOM` varchar(255) NOT NULL,
  `NUM_SERIE` varchar(255) NOT NULL,
  `QUANTITE` int(11) DEFAULT NULL,
  PRIMARY KEY (`NOM`,`NUM_SERIE`)
) ;

--
-- Déchargement des données de la table `article`
--

INSERT INTO `Article` (`NOM`, `NUM_SERIE`, `QUANTITE`) VALUES
('SOUPE', 'T1-1', 12),
('OASIS', 'T1-1', 25),
('EAU', 'T1-1', 35),
('SPRITE', 'T1-1', 15),
('KINDER', 'T1-1', 10),
('MARS', 'T1-3', 9),
('COCA', 'T1-3', 8),
('TROPICO', 'T1-3', 10),
('LIPTON ', 'T1-3', 6),
('PEPSI', 'T2-5', 8),
('SNICKERS', 'T2-5', 17),
('MONSTER', 'T2-5', 20),
('POWERHORSE', 'T2-5', 14),
('KINDER', 'T2-7', 30),
('LIPTON ', 'T2-7', 12),
('ICE TEA ', 'T2-7', 45),
('TWIX', 'T2-7', 12);


-- --------------------------------------------------------

--
-- Structure de la table `automate`
--

DROP TABLE IF EXISTS `Automate`;
CREATE TABLE IF NOT EXISTS `Automate` (
  `NumSerie` varchar(255) NOT NULL,
  `TypeT` varchar(255) NOT NULL,
  `Adresse_Insta` varchar(255) DEFAULT NULL,
  `DATE` varchar(255) DEFAULT NULL,
  `EMPLACEMENT` varchar(255) DEFAULT NULL,
  `GpsLatitude` double DEFAULT NULL,
  `GpsLongitude` double DEFAULT NULL,
  `NOTES` varchar(255) DEFAULT NULL,
  `TYPE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`NumSerie`),
  UNIQUE KEY `NumSerie` (`NumSerie`)
);

--
-- Déchargement des données de la table `automate`
--

INSERT INTO `Automate` (`NumSerie`,`TypeT`, `Adresse_Insta`, `DATE`, `EMPLACEMENT`, `GpsLatitude`, `GpsLongitude`, `NOTES`, `TYPE`) VALUES
('T1-1','T1', '11, avenue Denise Moulin', '09/05/20', 'FRANPRIX', 2.698745, 37.217987, '', ' ENCAS'),
('T1-3','T1', '4, impasse de Marty', '07/08/20', 'SUPGALILE  ', 0.556744, 32.346967, '', ' THE '),
('T1-9','T1', '862, impasse Marchal 15 424', '03/06/20', 'GARE DU NORD ', 0.556744, 25.336987, '', 'SOUPE'),
('T1-10','T1', '594 Kianna Landing Apt 938 ', '30/01/20', 'GARE DE L\'\'EST', 2.556744, 40.312693, '', 'ENCAS'),
('T2-1','T2', '29, rue Paulette Delahaye', '31/11/20', 'GARE DU NORD', 2.556744, 65.256849, '', 'BOISSON CHAUDE'),
('T2-3','T2', 'rue Neveu', '15/10/20', 'CENTRE OPARINOR ', 11.556744, 36.346957, '', 'ENCAS'),
('T2-6','T2', '7, impasse Perret', '23/08/20', 'CENTRE QUARTZ ', 73.556744, 75.346125, '', 'THE '),
('T2-9','T2', '38, impasse Claire Legros', '20/06/20', 'ORLY  ', 34.645978, 15.364978, '', 'SOUPE'),
('T2-11','T2', '89, chemin de Leclercq', '17/09/20', 'CDG ', 14.316459, 45.265498, '', 'BOISSON FROIDE');

-- --------------------------------------------------------

--
-- Structure de la table `rapport`
--

DROP TABLE IF EXISTS `Rapport`;
CREATE TABLE IF NOT EXISTS `Rapport` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CARTE` varchar(255) DEFAULT NULL,
  `DATE` varchar(255) DEFAULT NULL,
  `ERREURS` varchar(255) DEFAULT NULL,
  `ETAT` varchar(255) DEFAULT NULL,
  `MONAIE` varchar(255) DEFAULT NULL,
  `MONTANT` int(11) DEFAULT NULL,
  `NumSerie` varchar(255) DEFAULT NULL,
  `SansContact` varchar(255) DEFAULT NULL,
  `STATUT` varchar(255) DEFAULT NULL,
  `TEMPERATURE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`)
);


INSERT INTO `Rapport` (`ID`,`CARTE`, `DATE`, `ERREURS`, `ETAT`, `MONAIE`, `MONTANT`, `NumSerie`, `SansContact`, `STATUT`, `TEMPERATURE`) VALUES
(1,'NORMAL', '16/05/20', '','OK', 'NORMAL', '20', 'T1-1',' NORMAL',' EN SERCICE',35),
(2,'NORMAL', '19/08/20', '','ATTENTION', 'NORMAL', '30', 'T1-3',' NORMAL',' HORS SERVICE',10),
(3,'NORMAL', '10/06/20', '','NORMAL', 'PLEIN', '10', 'T1-9',' ERREUR',' HORS SERVICE',19),
(4,'NORMAL', '15/05/20', '','NORMAL', 'VIDE', '18', 'T1-10',' NORMAL',' EN SERVICE',27),
(5,'NORMAL', '14/12/20', '','ERREUR', 'NORMAL', '24', 'T2-1',' NORMAL',' EN SERVICE',26),
(6,'NORMAL', '19/10/20', '','ALARME', 'NORMAL', '10', 'T2-3',' ERREUR',' HORS SERVICE',14),
(7,'NORMAL', '23/19/20', '','NORMAL', 'VIDE', '15', 'T2-6',' NORMAL',' EN SERVICE',30),
(8,'NORMAL', '30/06/20', '','ERREUR', 'NORMAL', '22', 'T2-9',' NORMAL',' EN SERVICE',23),
(9,'NORMAL', '26/09/20', '','ALARME', 'NORMAL', '16', 'T2-11',' ERREUR',' HORS SERVICE',17);

-- --------------------------------------------------------

--
-- Structure de la table `rapport_article`
--

DROP TABLE IF EXISTS `Rapport_Article`;
CREATE TABLE IF NOT EXISTS `Rapport_Article` (
  `Rapport_IDRAPP` int(11) NOT NULL,
  `articles_NOM` varchar(255) NOT NULL,
  `articles_NUM_SERIE` varchar(255) NOT NULL,
  UNIQUE KEY `articles_NOM` (`articles_NOM`,`articles_NUM_SERIE`),
  KEY `FK5F5DD999184A63EB` (`articles_NOM`,`articles_NUM_SERIE`),
  KEY `FK5F5DD99988EB013` (`Rapport_IDRAPP`)
);
COMMIT;

