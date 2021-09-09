-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Φιλοξενητής: 127.0.0.1
-- Χρόνος δημιουργίας: 01 Οκτ 2018 στις 08:27:29
-- Έκδοση διακομιστή: 5.6.21
-- Έκδοση PHP: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Βάση δεδομένων: `examsdata`
--
CREATE DATABASE IF NOT EXISTS `examsdata` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `examsdata`;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `exam`
--

DROP TABLE IF EXISTS `exam`;
CREATE TABLE IF NOT EXISTS `exam` (
`ex_id` int(10) unsigned NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `ec_id` int(10) unsigned NOT NULL,
  `started` int(10) unsigned NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `exam`
--

INSERT INTO `exam` (`ex_id`, `date`, `time`, `ec_id`, `started`) VALUES
(1, '2018-09-06', '19:00:00', 1, 1),
(2, '2018-09-08', '11:00:00', 1, 1),
(3, '2018-09-23', '20:00:00', 1, 1),
(4, '2018-09-09', '12:00:00', 1, 0),
(5, '2018-09-13', '16:00:00', 1, 1),
(6, '2018-09-13', '17:00:00', 1, 0),
(7, '2018-09-25', '23:20:00', 3, 1),
(8, '2018-10-01', '18:00:00', 1, 1),
(9, '2018-10-01', '12:00:00', 1, 0),
(10, '2018-10-01', '11:30:00', 1, 0);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `exams_center`
--

DROP TABLE IF EXISTS `exams_center`;
CREATE TABLE IF NOT EXISTS `exams_center` (
`ec_id` int(10) unsigned NOT NULL,
  `name` varchar(100) NOT NULL,
  `address` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `exams_center`
--

INSERT INTO `exams_center` (`ec_id`, `name`, `address`) VALUES
(1, 'Ilioupoli', 'Posidonos 41'),
(2, 'Patra', 'Korinthou 35'),
(3, 'Thessaloniki', 'Aristotelous 33'),
(4, 'Iraklio', 'Agiou Nikolaou 25'),
(6, 'Alexandroupoli', 'Pafou 6');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `log_elena1234_13`
--

DROP TABLE IF EXISTS `log_elena1234_13`;
CREATE TABLE IF NOT EXISTS `log_elena1234_13` (
`ua_id` int(10) unsigned NOT NULL,
  `q_id` int(10) unsigned NOT NULL,
  `user_answer` int(10) unsigned NOT NULL,
  `ans_date` date NOT NULL,
  `ans_time` time NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `log_elena1234_13`
--

INSERT INTO `log_elena1234_13` (`ua_id`, `q_id`, `user_answer`, `ans_date`, `ans_time`) VALUES
(1, 42, 2, '2018-10-01', '05:18:19'),
(2, 27, 2, '2018-10-01', '05:18:40'),
(3, 3, 3, '2018-10-01', '05:18:26'),
(4, 16, 2, '2018-10-01', '05:18:32'),
(5, 48, 3, '2018-10-01', '05:18:52');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `log_hellend_10`
--

DROP TABLE IF EXISTS `log_hellend_10`;
CREATE TABLE IF NOT EXISTS `log_hellend_10` (
`ua_id` int(10) unsigned NOT NULL,
  `q_id` int(10) unsigned NOT NULL,
  `user_answer` int(10) unsigned NOT NULL,
  `ans_date` date NOT NULL,
  `ans_time` time NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `log_hellend_10`
--

INSERT INTO `log_hellend_10` (`ua_id`, `q_id`, `user_answer`, `ans_date`, `ans_time`) VALUES
(1, 2, 3, '2018-09-26', '21:13:46'),
(2, 12, 1, '2018-09-26', '21:14:37'),
(3, 13, 3, '2018-09-26', '21:14:17'),
(4, 8, 3, '2018-09-26', '21:14:23'),
(5, 36, 3, '2018-09-26', '21:14:33');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `log_user1_1`
--

DROP TABLE IF EXISTS `log_user1_1`;
CREATE TABLE IF NOT EXISTS `log_user1_1` (
`ua_id` int(10) unsigned NOT NULL,
  `q_id` int(10) unsigned NOT NULL,
  `user_answer` int(10) unsigned NOT NULL,
  `ans_date` date NOT NULL,
  `ans_time` time NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `log_user1_1`
--

INSERT INTO `log_user1_1` (`ua_id`, `q_id`, `user_answer`, `ans_date`, `ans_time`) VALUES
(1, 23, 1, '2018-09-06', '19:08:35'),
(2, 11, 2, '2018-09-06', '19:08:39'),
(3, 26, 3, '2018-09-06', '19:08:44'),
(4, 15, 4, '2018-09-06', '19:08:47'),
(5, 37, 1, '2018-09-06', '19:08:50');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `log_user2_3`
--

DROP TABLE IF EXISTS `log_user2_3`;
CREATE TABLE IF NOT EXISTS `log_user2_3` (
`ua_id` int(10) unsigned NOT NULL,
  `q_id` int(10) unsigned NOT NULL,
  `user_answer` int(10) unsigned NOT NULL,
  `ans_date` date NOT NULL,
  `ans_time` time NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `log_user2_3`
--

INSERT INTO `log_user2_3` (`ua_id`, `q_id`, `user_answer`, `ans_date`, `ans_time`) VALUES
(1, 2, 2, '2018-09-23', '20:14:01'),
(2, 14, 3, '2018-09-23', '20:14:07'),
(3, 43, 4, '2018-09-23', '20:14:12'),
(4, 51, 1, '2018-09-23', '20:14:15'),
(5, 45, 2, '2018-09-23', '20:14:20');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `log_user3_4`
--

DROP TABLE IF EXISTS `log_user3_4`;
CREATE TABLE IF NOT EXISTS `log_user3_4` (
`ua_id` int(10) unsigned NOT NULL,
  `q_id` int(10) unsigned NOT NULL,
  `user_answer` int(10) unsigned NOT NULL,
  `ans_date` date NOT NULL,
  `ans_time` time NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `log_user3_4`
--

INSERT INTO `log_user3_4` (`ua_id`, `q_id`, `user_answer`, `ans_date`, `ans_time`) VALUES
(1, 51, 3, '2018-09-23', '20:14:43'),
(2, 50, 4, '2018-09-23', '20:14:46'),
(3, 27, 1, '2018-09-23', '20:14:51'),
(4, 46, 2, '2018-09-23', '20:14:55'),
(5, 23, 3, '2018-09-23', '20:14:59');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `questions`
--

DROP TABLE IF EXISTS `questions`;
CREATE TABLE IF NOT EXISTS `questions` (
`q_id` int(10) unsigned NOT NULL,
  `question` text NOT NULL,
  `answer1` text NOT NULL,
  `answer2` text NOT NULL,
  `answer3` text NOT NULL,
  `answer4` text NOT NULL,
  `correct` int(10) unsigned NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `questions`
--

INSERT INTO `questions` (`q_id`, `question`, `answer1`, `answer2`, `answer3`, `answer4`, `correct`) VALUES
(1, 'Which is a valid statement', '1 KB = 1024 Bytes', '1 MB = 1024 Bytes', '1 KB = 1000 Bytes', '1 MB = 1000 Bytes', 1),
(2, 'The abbreviation PDF stands for', 'Printable Document File', 'Portable Document File', 'Printable Document Format', 'Portable Document Format', 4),
(3, 'Which is not consisted in a processor', 'ALU', 'CU', 'Memory', 'Registers', 3),
(4, 'Which of the following are the two main components of the CPU', 'Control Unit and Registers', 'Registers and Main Memory', 'Control unit and ALU', 'ALU and bus', 3),
(5, 'The computer that process both analog and digital is called', 'Analog computer', 'Digital computer', 'Hybrid computer', 'Mainframe computer', 3),
(6, 'The expansion of HTTP is', 'Hypertext Transfer Programme', 'Hypertest Transfer Programme', 'Hypertest Transfer Protocol', 'Hypertext Transfer Protocol', 4),
(7, 'Which of the following is a search engine', 'Alta Vista', 'Google', 'Both A and B', 'None of these', 3),
(8, 'Which of the following is not an example of Operating System', 'Windows 98', 'Fox-Pro', 'Microsoft Office', 'Linux', 2),
(9, 'ALU is', 'Array Logic Unit', 'Arithmetic Logic Unit', 'Application Logic Unit', 'None of above', 2),
(10, 'What is the full form of www', 'World Wide World', 'World Wide Web', 'Word Widening Works', 'Words Wide Spiderman Web', 2),
(11, 'Which of the following is not a computer language', 'BASIC', 'COBOL', 'LOTUS', 'FORTRAN', 3),
(12, 'The brain of a computer is', 'CPU', 'CD', 'Floppy disc', 'Megabyte', 1),
(13, 'VIRUS stands for', 'Very Important Resource Under Search', 'Virtual Information Resource Under Seize', 'Verify Interchange Result until Source', 'Very Important Record User Searched', 2),
(14, 'First generation computer systems used', 'Transistors', 'Vacuum tubes', 'Magnetic cores', 'Silicon chips', 2),
(15, 'A computer programmer', 'enters data into computer', 'repairs a Computer', 'changes flow chart into instructions', 'writes programs', 4),
(16, 'The term bugs refers to', 'encoding of data', 'transmission of data', 'errors in a computer program', 'decoding of data', 3),
(17, 'Register is a', 'Set of capacitors used to register input instructions in a digital computer', 'Set of paper tapes and cards put in a file', 'Temporary storage unit within the CPU having dedicated or general purpose use', 'Part of the auxiliary memory', 3),
(18, 'WAN means', 'Wide Area Network', 'Wider Area Network', 'World Area Network', 'Wide Allen Network', 1),
(19, 'MAN is a', 'Microchip', 'Software Company', 'Network', 'Internet Service Provider', 3),
(20, 'The operating system is the most common type of', 'Client Software', 'Application Software', 'Utility Software', 'System Software', 4),
(21, 'Which of the following is not an output device', 'Monitor', 'Touch-screen', 'Printer', 'Plotter', 2),
(22, 'Linux is an Operating System initially conceived by', 'Richard Stallman', 'Linus Torvalds', 'Eric Raimonds', 'Bill Gates', 2),
(23, 'Spamming is the act of', 'Sending unsolicited messages', 'Blocking a website', 'Internet time theft', 'Talking a person through the cyberspace', 1),
(24, 'Which of the following is an example of a political cybercrime', 'Cyber Stalking', 'Spamming', 'Cyber Terrorism', 'Phishing', 3),
(25, 'Metadata is', 'the name given to the data found within a relational database', 'a term given to data that provides information about other data', 'used in data modeling', 'contained within a CSV file', 2),
(26, 'When designing a relational database, the first step of data modeling is known as the', 'Conceptual Model', 'Physical Model', 'Context Model', 'Logical Model', 1),
(27, 'Which of the following is a central repository for data from various sources within the organization', 'Electronic Health Record', 'Hospital-Wide System', 'Data Warehouse', 'Data Mine', 3),
(28, 'Computer Architectur refers to', 'Overall size of the computer', 'Physical space requirements of the computer', 'Physical construction of hardware components and their relationship to one another', 'Physical equipment that makes up the information system', 3),
(29, 'In the controls that are used to protect the integrity and security of data stored within a database encompasses', 'Database integrity', 'Database recovery', 'Database maintenance', 'Interface Communication', 3),
(30, 'When data elements are moved from an old system to a newer one, lines are determined and data is converted, the process is called', 'Data Mining', 'Data Flow', 'Data Mapping', 'Data Modeling', 3),
(31, 'The variable that uniquely identifies a record in a given table within a relational data base is called a', 'Foreign Key', 'Primary Key', 'Primary Field', 'Logical Key', 2),
(32, 'Cardinality in a relational database is defined as', 'The concept of the relationship between tables', 'The name given to a tables in a relational database that have a many to many relationship', 'The process that prevents redundancy in a relational database', 'The mapping out of business process in easy to understand terms when planning a database', 1),
(33, 'A tool used in the modeling stage of database planning is known as a', 'Gantt Chart', 'Normalization Table', 'Data Flow Diagram', 'Data Dictionary', 3),
(34, 'The moving of computer data from one format to another in order to comply with changing standards for data and file handling is known as', 'Data Mapping', 'Data Conversion', 'Data Flow', 'Data Adapting', 2),
(35, 'A more flexible method of developing systems is known as the', 'Flexible SDLC', 'Dexterous SDLC', 'Active SDLC', 'Agile SDLC', 4),
(36, 'The human-computer interface that allows for data to be entered into and retrieved from a system is known as the', 'Supporting Layer', 'Presentation Layer', 'Connection Layer', 'Infrastructure Layer', 2),
(37, 'Discrete data that is entered into formatted fields rather than entered in free text is known as', 'Structured Data', 'Data Integrity', 'Quantitative Data', 'Continuous Data', 1),
(38, 'A process that scrambles sensitive data so that it can be safely transmitted is known as', 'Conglomeration', 'Encryption', 'Authentication', 'Access Control', 2),
(39, 'A process of reviewing a system by an external organization in order to ensure that it meets standards set by that organization is known as', 'Administrative Safeguards', 'Physical Security Controls', 'Access Controls', 'Authentication Tools', 3),
(40, 'Which of the following is an example of an authentication tool', 'Audit Trails', 'Passwords', 'Log files', 'Encryption', 2),
(41, 'Serves as the central repository for all information about the database and functions as a catalogue for identifying the nature of all data in the system', 'Database', 'Data Dictionary', 'Data Model', 'Data Repository', 2),
(42, 'Which of the following is not a category of computer based on size', 'Mainframe Computer', 'Micro Computer', 'Mini Computer', 'Digital Computer', 4),
(43, 'Which of the following is a fixed disk', 'Hard Disks', 'Flash Disks', 'Compact Disks', 'DVDs', 1),
(44, 'Cursor is a', 'Pixel', 'Pointing Device', 'Thin blinking line', 'None of these', 2),
(45, 'Which of the following items are examples of storage devices', 'Floppy Disks', 'CD-ROMs', 'Hard Disks', 'All of the above', 4),
(46, 'What ASCII stand for', 'American Stable Code for International Interchange', 'American Standard Case for International Interchange', 'American Standard Code for Information Interchange', 'American Standard Code for for Interchange Information', 3),
(47, 'Which of the following is an input device', 'scanner', 'speaker', 'monitor', 'projector', 1),
(48, 'In which language is source program written', 'English', 'Symbolic', 'High Level', 'Temporary', 3),
(49, 'A song being played on computer speaker is', 'hard output', 'soft output', 'both hard and soft output', 'neither hard nor soft output', 2),
(50, 'When we look at the cost which of the following computer is most expensive', 'Mainframe Computers', 'Mini Computers', 'Micro Computers', 'Super Computers', 4),
(51, 'Which device is used as the standard pointing device in a Graphical User Environment', 'Keyboard', 'Mouse', 'Joystick', 'Track ball', 2);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `sys_admin`
--

DROP TABLE IF EXISTS `sys_admin`;
CREATE TABLE IF NOT EXISTS `sys_admin` (
`sa_id` int(10) unsigned NOT NULL,
  `uname` varchar(100) NOT NULL,
  `pass` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `sys_admin`
--

INSERT INTO `sys_admin` (`sa_id`, `uname`, `pass`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
`u_id` int(10) unsigned NOT NULL,
  `name` varchar(150) NOT NULL,
  `uname` varchar(100) NOT NULL,
  `pass` varchar(100) NOT NULL,
  `ex_id` int(10) unsigned DEFAULT NULL,
  `ec_id` int(10) unsigned DEFAULT NULL,
  `admin` int(1) unsigned NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `user`
--

INSERT INTO `user` (`u_id`, `name`, `uname`, `pass`, `ex_id`, `ec_id`, `admin`) VALUES
(1, 'Marina Akrivopoulou', 'user1', 'user1', 1, NULL, 0),
(3, 'George Koroneos', 'user2', 'user2', 3, NULL, 0),
(4, 'Mary Pangiotou', 'user3', 'user3', 3, NULL, 0),
(5, 'Victoria Latsi', 'user4', 'user4', 3, NULL, 0),
(6, 'Marina Nikolaou', 'MarNik', 'usermarina', NULL, NULL, 0),
(7, 'maria drosou', 'user7', 'user7', 4, NULL, 0),
(10, 'Hellen Drosou', 'hellend', '1234', 7, NULL, 0),
(11, 'Alexander Papakonstantinou', 'user', 'user', NULL, 1, 1),
(12, 'George Marinos', 'george', '1234', NULL, 3, 1),
(13, 'Elena Papagianopoulou', 'elena1234', '1234', 7, NULL, 0),
(14, 'George Marinopoulos', 'usermarin', '1234', NULL, NULL, 0),
(16, 'Hellen Dourou', 'hellend1', '1234', NULL, 6, 1);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `user_answers`
--

DROP TABLE IF EXISTS `user_answers`;
CREATE TABLE IF NOT EXISTS `user_answers` (
  `user_log_id` varchar(150) NOT NULL,
  `u_id` int(10) unsigned NOT NULL,
  `ex_id` int(10) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `user_answers`
--

INSERT INTO `user_answers` (`user_log_id`, `u_id`, `ex_id`) VALUES
('log_elena1234_13', 13, 7),
('log_hellend_10', 10, 7),
('log_user1_1', 1, 1),
('log_user2_3', 3, 3),
('log_user3_4', 4, 3);

--
-- Ευρετήρια για άχρηστους πίνακες
--

--
-- Ευρετήρια για πίνακα `exam`
--
ALTER TABLE `exam`
 ADD PRIMARY KEY (`ex_id`), ADD KEY `ec_id` (`ec_id`);

--
-- Ευρετήρια για πίνακα `exams_center`
--
ALTER TABLE `exams_center`
 ADD PRIMARY KEY (`ec_id`), ADD UNIQUE KEY `name` (`name`);

--
-- Ευρετήρια για πίνακα `log_elena1234_13`
--
ALTER TABLE `log_elena1234_13`
 ADD PRIMARY KEY (`ua_id`);

--
-- Ευρετήρια για πίνακα `log_hellend_10`
--
ALTER TABLE `log_hellend_10`
 ADD PRIMARY KEY (`ua_id`);

--
-- Ευρετήρια για πίνακα `log_user1_1`
--
ALTER TABLE `log_user1_1`
 ADD PRIMARY KEY (`ua_id`);

--
-- Ευρετήρια για πίνακα `log_user2_3`
--
ALTER TABLE `log_user2_3`
 ADD PRIMARY KEY (`ua_id`);

--
-- Ευρετήρια για πίνακα `log_user3_4`
--
ALTER TABLE `log_user3_4`
 ADD PRIMARY KEY (`ua_id`);

--
-- Ευρετήρια για πίνακα `questions`
--
ALTER TABLE `questions`
 ADD PRIMARY KEY (`q_id`);

--
-- Ευρετήρια για πίνακα `sys_admin`
--
ALTER TABLE `sys_admin`
 ADD PRIMARY KEY (`sa_id`), ADD UNIQUE KEY `uname` (`uname`);

--
-- Ευρετήρια για πίνακα `user`
--
ALTER TABLE `user`
 ADD PRIMARY KEY (`u_id`), ADD UNIQUE KEY `uname` (`uname`), ADD KEY `ex_id` (`ex_id`), ADD KEY `ec_id` (`ec_id`);

--
-- Ευρετήρια για πίνακα `user_answers`
--
ALTER TABLE `user_answers`
 ADD PRIMARY KEY (`user_log_id`), ADD KEY `u_id` (`u_id`), ADD KEY `ex_id` (`ex_id`);

--
-- AUTO_INCREMENT για άχρηστους πίνακες
--

--
-- AUTO_INCREMENT για πίνακα `exam`
--
ALTER TABLE `exam`
MODIFY `ex_id` int(10) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT για πίνακα `exams_center`
--
ALTER TABLE `exams_center`
MODIFY `ec_id` int(10) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT για πίνακα `log_elena1234_13`
--
ALTER TABLE `log_elena1234_13`
MODIFY `ua_id` int(10) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT για πίνακα `log_hellend_10`
--
ALTER TABLE `log_hellend_10`
MODIFY `ua_id` int(10) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT για πίνακα `log_user1_1`
--
ALTER TABLE `log_user1_1`
MODIFY `ua_id` int(10) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT για πίνακα `log_user2_3`
--
ALTER TABLE `log_user2_3`
MODIFY `ua_id` int(10) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT για πίνακα `log_user3_4`
--
ALTER TABLE `log_user3_4`
MODIFY `ua_id` int(10) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT για πίνακα `questions`
--
ALTER TABLE `questions`
MODIFY `q_id` int(10) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=56;
--
-- AUTO_INCREMENT για πίνακα `sys_admin`
--
ALTER TABLE `sys_admin`
MODIFY `sa_id` int(10) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT για πίνακα `user`
--
ALTER TABLE `user`
MODIFY `u_id` int(10) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
--
-- Περιορισμοί για άχρηστους πίνακες
--

--
-- Περιορισμοί για πίνακα `exam`
--
ALTER TABLE `exam`
ADD CONSTRAINT `exam_ibfk_1` FOREIGN KEY (`ec_id`) REFERENCES `exams_center` (`ec_id`);

--
-- Περιορισμοί για πίνακα `user`
--
ALTER TABLE `user`
ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`ex_id`) REFERENCES `exam` (`ex_id`) ON DELETE SET NULL ON UPDATE SET NULL,
ADD CONSTRAINT `user_ibfk_2` FOREIGN KEY (`ec_id`) REFERENCES `exams_center` (`ec_id`);

--
-- Περιορισμοί για πίνακα `user_answers`
--
ALTER TABLE `user_answers`
ADD CONSTRAINT `user_answers_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`),
ADD CONSTRAINT `user_answers_ibfk_2` FOREIGN KEY (`ex_id`) REFERENCES `exam` (`ex_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
