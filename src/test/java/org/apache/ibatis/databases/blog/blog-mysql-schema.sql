--
--    Copyright 2009-2016 the original author or authors.
--
--    Licensed under the Apache License, Version 2.0 (the "License");
--    you may not use this file except in compliance with the License.
--    You may obtain a copy of the License at
--
--       http://www.apache.org/licenses/LICENSE-2.0
--
--    Unless required by applicable law or agreed to in writing, software
--    distributed under the License is distributed on an "AS IS" BASIS,
--    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
--    See the License for the specific language governing permissions and
--    limitations under the License.
--

DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS blog;
DROP TABLE IF EXISTS post;
DROP TABLE IF EXISTS tag;
DROP TABLE IF EXISTS post_tag;
DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS node;
CREATE TABLE `author` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(255) NULL DEFAULT '0',
	`password` VARCHAR(255) NULL DEFAULT '0',
	`email` VARCHAR(255) NULL DEFAULT '0',
	`bio` LONGTEXT NULL,
	`favourite_section` VARCHAR(25) NULL DEFAULT '0',
	PRIMARY KEY (`id`)
)
ENGINE=InnoDB
AUTO_INCREMENT=8
;

CREATE TABLE `blog` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`author_id` INT(11) NOT NULL DEFAULT '0',
	`title` VARCHAR(255) NULL DEFAULT '0',
	PRIMARY KEY (`id`)
)
ENGINE=InnoDB
AUTO_INCREMENT=8
;
CREATE TABLE `post` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`blog_id` INT(11) NULL DEFAULT NULL,
	`author_id` INT(11) NOT NULL,
	`created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`section` VARCHAR(25) NOT NULL,
	`subject` VARCHAR(255) NOT NULL,
	`body` LONGTEXT NOT NULL,
	`draft` INT(11) NOT NULL,
	PRIMARY KEY (`id`),
	INDEX `blog_id` (`blog_id`),
	CONSTRAINT `post_ibfk_1` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`id`)
)
ENGINE=InnoDB
AUTO_INCREMENT=8
;
CREATE TABLE `tag` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`id`)
)
ENGINE=InnoDB
AUTO_INCREMENT=8
;
CREATE TABLE `post_tag` (
	`post_id` INT(11) NOT NULL,
	`tag_id` INT(11) NOT NULL,
	PRIMARY KEY (`post_id`, `tag_id`)
)
ENGINE=InnoDB
AUTO_INCREMENT=8
;
CREATE TABLE `comment` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`post_id` INT(11) NOT NULL,
	`name` MEDIUMTEXT NOT NULL,
	`comment` MEDIUMTEXT NOT NULL,
	PRIMARY KEY (`id`)
)
ENGINE=InnoDB
AUTO_INCREMENT=8
;
CREATE TABLE `node` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`parent_id` INT(11) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)
ENGINE=InnoDB
AUTO_INCREMENT=8
;