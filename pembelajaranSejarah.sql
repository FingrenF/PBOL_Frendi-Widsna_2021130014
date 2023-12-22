-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.30 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for db_sejarah
CREATE DATABASE IF NOT EXISTS `db_sejarah` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `db_sejarah`;

-- Dumping structure for table db_sejarah.hubungan
CREATE TABLE IF NOT EXISTS `hubungan` (
  `kodeHubungan` char(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `kodeNegara` char(3) NOT NULL DEFAULT '',
  `kodeKejadian` char(5) NOT NULL DEFAULT '',
  `deskripsiHubungan` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`kodeHubungan`) USING BTREE,
  KEY `FK_sejarah_negara` (`kodeNegara`),
  KEY `FK_sejarah_kejadian` (`kodeKejadian`),
  CONSTRAINT `FK_sejarah_kejadian` FOREIGN KEY (`kodeKejadian`) REFERENCES `kejadian` (`kodeKejadian`),
  CONSTRAINT `FK_sejarah_negara` FOREIGN KEY (`kodeNegara`) REFERENCES `negara` (`kodeNegara`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table db_sejarah.hubungan: ~2 rows (approximately)
INSERT INTO `hubungan` (`kodeHubungan`, `kodeNegara`, `kodeKejadian`, `deskripsiHubungan`) VALUES
	('S0001', 'IDN', 'K0002', 'Kemerdekaan indonesia datang setelah kejadian ini selesai'),
	('S0002', 'JPN', 'K0002', 'L JAPAN');

-- Dumping structure for table db_sejarah.kejadian
CREATE TABLE IF NOT EXISTS `kejadian` (
  `kodeKejadian` char(5) NOT NULL DEFAULT '',
  `namaKejadian` varchar(50) NOT NULL DEFAULT ' ',
  `tahunAwal` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0000',
  `tahunAkhir` varchar(10) DEFAULT NULL,
  `deskripsi` text NOT NULL,
  PRIMARY KEY (`kodeKejadian`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table db_sejarah.kejadian: ~2 rows (approximately)
INSERT INTO `kejadian` (`kodeKejadian`, `namaKejadian`, `tahunAwal`, `tahunAkhir`, `deskripsi`) VALUES
	('K0001', 'Perang Dunia Pertama', '1914', '1918', 'Perang besar pertama yang meilbatkan jutaan rakyat'),
	('K0002', 'Perang Dunia Ke 2', '1939', '1945', 'Perang dunia yang sangat besar');

-- Dumping structure for table db_sejarah.negara
CREATE TABLE IF NOT EXISTS `negara` (
  `kodeNegara` char(3) NOT NULL DEFAULT '',
  `namaNegara` varchar(50) NOT NULL DEFAULT ' ',
  `tahunDitemukan` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0000',
  `ditemukanSesudahMasehi` set('false','true') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'true' COMMENT 'True sesudah masehi, False Sebelum masehi',
  `bendera` varchar(50) NOT NULL,
  PRIMARY KEY (`kodeNegara`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table db_sejarah.negara: ~4 rows (approximately)
INSERT INTO `negara` (`kodeNegara`, `namaNegara`, `tahunDitemukan`, `ditemukanSesudahMasehi`, `bendera`) VALUES
	('IDN', 'Indonesia', '1945', 'true', 'src\\images\\IDN.png'),
	('JPN', 'Japan', '660', 'false', 'src\\images\\JPN.png'),
	('MYS', 'Malaysia', '1957', 'true', 'src\\images\\MYS.png'),
	('USA', 'United States of America', '1776', 'true', 'src\\images\\USA.png');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
