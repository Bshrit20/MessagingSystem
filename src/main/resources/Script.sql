

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `class_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` longtext NOT NULL,
  `created_by` longtext NOT NULL,
  `created_dtm` datetime NOT NULL,
  `modify_by` longtext NOT NULL,
  `modify_dtm` datetime NOT NULL,
  PRIMARY KEY (`class_id`)
);

--
-- Table structure for table `group`
--

DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` longtext NOT NULL,
  `description` longtext ,
  `status` longtext NOT NULL,
  `group_created_by` longtext NOT NULL,
  `group_created_dtm` datetime NOT NULL,
  `modify_by` longtext NOT NULL,
  `modify_dtm` datetime NOT NULL,
  PRIMARY KEY (`group_id`)
);


--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `message_description` longtext NOT NULL,
  `message_created_by` longtext NOT NULL,
  `message_created_dtm` datetime NOT NULL,
  `modify_by` longtext NOT NULL,
  `modify_dtm` datetime NOT NULL,
  PRIMARY KEY (`message_id`)
);

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` longtext NOT NULL,
  PRIMARY KEY (`role_id`)
) ;

--
-- Table structure for table `school`
--

DROP TABLE IF EXISTS `school`;
CREATE TABLE `school` (
  `school_id` int(11) NOT NULL AUTO_INCREMENT,
  `school_name` longtext NOT NULL,
  `school_address` longtext NOT NULL,
  `school_emailid` longtext NOT NULL,
  `school_phone` longtext NOT NULL,
  `school_created_by` longtext NOT NULL,
  `school_created_dtm` datetime NOT NULL,
  `school_modified_by` longtext NOT NULL,
  `school_modified_dtm` datetime NOT NULL,
  PRIMARY KEY (`school_id`)
) ;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `subject_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` longtext NOT NULL,
  `created_by` longtext NOT NULL,
  `created_dtm` datetime NOT NULL,
  `modify_by` longtext NOT NULL,
  `modify_dtm` datetime NOT NULL,
  PRIMARY KEY (`subject_id`)
) ;



--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
CREATE TABLE `notification` (
  `notification_id` int(11) NOT NULL AUTO_INCREMENT,
  `notification_details` longtext NOT NULL,
  `notification_created_by` longtext NOT NULL,
  `notification__created_dtm` datetime NOT NULL,
  `notification_modified_by` longtext NOT NULL,
  `notification__modified_dtm` datetime NOT NULL,
  PRIMARY KEY (`notification_id`)
) ;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `person_id` int(11) NOT NULL AUTO_INCREMENT,
  `person_name` longtext NOT NULL,
  `person_phone` longtext NOT NULL,
  `person_email` longtext NOT NULL,
  `guardian` varchar(1) NOT NULL,
  `role_id` int(11) NOT NULL,
  `person_created_by` longtext NOT NULL,
  `person_created_dtm` datetime NOT NULL,
  `person_modify_by` longtext NOT NULL,
  `person_modify_dtm` datetime NOT NULL,
  `school_id` int(11) NOT NULL,
  PRIMARY KEY (`person_id`),
  KEY `role_id_idx` (`role_id`),
  KEY `school_id_idx` (`school_id`),
  CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `school_id` FOREIGN KEY (`school_id`) REFERENCES `school` (`school_id`)
);

--
-- Table structure for table `personalmessage`
--

DROP TABLE IF EXISTS `personalmessage`;
CREATE TABLE `personalmessage` (
  `personalmessage_id` int(11) NOT NULL AUTO_INCREMENT,
  `message_id` int(11) NOT NULL,
  `person_id` int(11) NOT NULL,
  `personalmessage_created_by` datetime NOT NULL,
  `personalmessage_created_dtm` datetime NOT NULL,
  `personalmessage_modify_by` datetime NOT NULL,
  `personalmessage_modify_dtm` datetime NOT NULL,
  PRIMARY KEY (`personalmessage_id`),
  KEY `message_id_idx` (`message_id`),
  KEY `person_id_idx` (`person_id`),
  CONSTRAINT `message_id_fk` FOREIGN KEY (`message_id`) REFERENCES `message` (`message_id`),
  CONSTRAINT `person_id_fk` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`)
);



--
-- Table structure for table `groupmessage`
--

DROP TABLE IF EXISTS `groupmessage`;
CREATE TABLE `groupmessage` (
  `groupmessage_id` int(11) NOT NULL AUTO_INCREMENT,
  `message_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  `groupmessage_created_by` datetime NOT NULL,
  `groupmessage_created_dtm` datetime NOT NULL,
  `groupmessage_modify_by` datetime NOT NULL,
  `groupmessage_modify_dtm` datetime NOT NULL,
  PRIMARY KEY (`groupmessage_id`),
  KEY `message_id_idx` (`message_id`),
  KEY `group_id_idx` (`group_id`),
  CONSTRAINT `group_id_fk` FOREIGN KEY (`group_id`) REFERENCES `group` (`group_id`),
  CONSTRAINT `message_id` FOREIGN KEY (`message_id`) REFERENCES `message` (`message_id`)
) ;

--
-- Table structure for table `groupparticipents`
--

DROP TABLE IF EXISTS `groupparticipents`;
CREATE TABLE `groupparticipents` (
  `groupparticipant_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL,
  `person_id` int(11) NOT NULL,
  `groupparticipant_created_by` longtext NOT NULL,
  `groupparticipant_created_dtm` datetime NOT NULL,
  `groupparticipant_modified_by` longtext NOT NULL,
  `groupparticipant_modified_dtm` datetime NOT NULL,
  PRIMARY KEY (`groupparticipant_id`),
  KEY `person_id_idx` (`person_id`),
  KEY `group_id_idx` (`group_id`),
  CONSTRAINT `group_id` FOREIGN KEY (`group_id`) REFERENCES `group` (`group_id`),
  CONSTRAINT `person_id` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`)
);

