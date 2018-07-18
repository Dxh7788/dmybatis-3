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

DROP TABLE author IF EXISTS;
DROP TABLE blog IF EXISTS;

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
;

CREATE TABLE `blog` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`author_id` INT(11) NOT NULL DEFAULT '0',
	`title` VARCHAR(255) NULL DEFAULT '0',
	PRIMARY KEY (`id`)
)
ENGINE=InnoDB
;
