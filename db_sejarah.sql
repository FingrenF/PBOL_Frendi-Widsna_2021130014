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

-- Dumping data for table db_sejarah.hubungan: ~30 rows (approximately)
INSERT INTO `hubungan` (`kodeHubungan`, `kodeNegara`, `kodeKejadian`, `deskripsiHubungan`) VALUES
	('S0001', 'IDN', 'K0002', 'Proklamasi Kemerdekaan Indonesia diumumkan setelah berakhirnya Perang Dunia II.'),
	('S0002', 'JPN', 'K0002', 'Jepang mendukung Indonesia setelah berakhirnya Perang Dunia II.'),
	('S0003', 'IDN', 'K0003', 'Pernyataan kemerdekaan Indonesia yang monumental setelah berakhirnya Perang Dunia II.'),
	('S0004', 'AUS', 'K0004', 'Australia berkembang pesat setelah Revolusi Industri.'),
	('S0005', 'CHN', 'K0004', 'Perubahan ekonomi signifikan terjadi di China selama Revolusi Industri.'),
	('S0006', 'BRA', 'K0005', 'Brazil dan penjelajahan antariksa.'),
	('S0007', 'RUS', 'K0004', 'Pengaruh Revolusi Industri di Russia.'),
	('S0008', 'USA', 'K0005', 'Peran penting Amerika dalam penjelajahan antariksa.'),
	('S0009', 'IDN', 'K0004', 'Dampak Revolusi Industri terhadap perkembangan industri di Indonesia.'),
	('S0010', 'JPN', 'K0005', 'Kerjasama antara Jepang dan negara-negara lain dalam penjelajahan antariksa.'),
	('S0011', 'MYS', 'K0004', 'Malaysia dan Revolusi Industri.'),
	('S0012', 'USA', 'K0004', 'Hubungan Amerika dengan Revolusi Industri.'),
	('S0013', 'CHN', 'K0005', 'Kolaborasi China dalam penjelajahan antariksa.'),
	('S0014', 'AUS', 'K0004', 'Pengaruh Revolusi Industri di Australia.'),
	('S0015', 'RUS', 'K0005', 'Kerjasama antara Rusia dan negara-negara lain dalam penjelajahan antariksa.'),
	('S0016', 'BRA', 'K0004', 'Pengaruh Revolusi Industri di Brazil.'),
	('S0017', 'ZAF', 'K0005', 'Peran Afrika Selatan dalam penjelajahan antariksa.'),
	('S0018', 'MYS', 'K0005', 'Kolaborasi Malaysia dalam penjelajahan antariksa.'),
	('S0019', 'MYS', 'K0003', 'Malaysia berkolaborasi dengan negara-negara tetangga untuk membangun stabilitas pasca Perang Dunia II.'),
	('S0020', 'USA', 'K0003', 'Hubungan Amerika dengan sekutu-sekutunya dalam upaya rekonstruksi pasca Perang Dunia II.'),
	('S0021', 'RUS', 'K0003', 'Kerjasama internasional dengan Uni Soviet untuk mengatasi dampak pasca Perang Dunia II.'),
	('S0022', 'CHN', 'K0003', 'China berperan dalam pembangunan ekonomi dan politik pasca Perang Dunia II.'),
	('S0024', 'GBR', 'K0001', 'Inggris menjadi sekutu utama bersama dengan negara-negara lain dalam Perang Dunia Pertama.'),
	('S0025', 'FRA', 'K0001', 'Prancis bersatu dengan sekutu-sekutunya untuk melawan kekuatan sentral selama Perang Dunia Pertama.'),
	('S0026', 'DEU', 'K0001', 'Hubungan Jerman dengan kekuatan sentral lainnya selama Perang Dunia Pertama.'),
	('S0027', 'RUS', 'K0001', 'Peran Rusia dalam sekutu melawan kekuatan sentral selama Perang Dunia Pertama.'),
	('S0028', 'ITA', 'K0001', 'Hubungan Italia dengan kekuatan sentral dalam perang tersebut.'),
	('S0029', 'USA', 'K0002', 'Amerika Serikat berperan besar dalam Perang Dunia II dan pasca Perang Dunia II.'),
	('S0030', 'GBR', 'K0002', 'Inggris adalah sekutu utama dalam Perang Dunia II dan memiliki hubungan erat pasca perang.'),
	('S0031', 'RUS', 'K0002', 'Uni Soviet memiliki dampak signifikan pada Perang Dunia II dan membentuk dinamika pasca perang.');

-- Dumping structure for table db_sejarah.kejadian
CREATE TABLE IF NOT EXISTS `kejadian` (
  `kodeKejadian` char(5) NOT NULL DEFAULT '',
  `namaKejadian` varchar(50) NOT NULL DEFAULT ' ',
  `tahunAwal` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0000',
  `tahunAkhir` varchar(10) DEFAULT NULL,
  `deskripsi` text NOT NULL,
  PRIMARY KEY (`kodeKejadian`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table db_sejarah.kejadian: ~5 rows (approximately)
INSERT INTO `kejadian` (`kodeKejadian`, `namaKejadian`, `tahunAwal`, `tahunAkhir`, `deskripsi`) VALUES
	('K0001', 'Perang Dunia Pertama', '1914', '1918', 'Perang Dunia Pertama, konflik global yang mempengaruhi jutaan orang dan menciptakan perubahan besar di panggung dunia.'),
	('K0002', 'Perang Dunia Ke 2', '1939', '1945', 'Perang Dunia Ke 2, konflik paling besar dalam sejarah manusia yang melibatkan kekuatan besar di seluruh dunia.'),
	('K0003', 'Pasca Perang Dunia 2', '1945', '1949', 'Pasca Perang Dunia 2, periode transisi yang melibatkan rekonstruksi dan perubahan besar di banyak negara setelah berakhirnya Perang Dunia II.'),
	('K0004', 'Revolusi Industri', '1760', '1840', 'Perubahan besar dalam produksi dan teknologi selama abad ke-18 dan ke-19.'),
	('K0005', 'Penjelajahan Antariksa', '1957', NULL, 'Manusia mulai menjelajahi luar angkasa dengan peluncuran satelit pertama, Sputnik 1.');

-- Dumping structure for table db_sejarah.kuncijawaban
CREATE TABLE IF NOT EXISTS `kuncijawaban` (
  `nosoal` int NOT NULL,
  `jawaban` text,
  PRIMARY KEY (`nosoal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table db_sejarah.kuncijawaban: ~5 rows (approximately)
INSERT INTO `kuncijawaban` (`nosoal`, `jawaban`) VALUES
	(1, 'Jepang mendukung kemerdekaan Indonesia.'),
	(2, 'Revolusi Industri'),
	(3, 'Indonesia'),
	(4, '1957'),
	(5, 'Mengembangkan teknologi antariksa');

-- Dumping structure for table db_sejarah.negara
CREATE TABLE IF NOT EXISTS `negara` (
  `kodeNegara` char(3) NOT NULL DEFAULT '',
  `namaNegara` varchar(50) NOT NULL DEFAULT ' ',
  `tahunDitemukan` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0000',
  `ditemukanSesudahMasehi` set('false','true') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'true' COMMENT 'True sesudah masehi, False Sebelum masehi',
  `bendera` varchar(50) NOT NULL,
  PRIMARY KEY (`kodeNegara`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table db_sejarah.negara: ~15 rows (approximately)
INSERT INTO `negara` (`kodeNegara`, `namaNegara`, `tahunDitemukan`, `ditemukanSesudahMasehi`, `bendera`) VALUES
	('AUS', 'Australia', '1788', 'true', 'src\\images\\AUS.png'),
	('BRA', 'Brazil', '1822', 'true', 'src\\images\\BRA.png'),
	('CHN', 'China', '221', 'false', 'src\\images\\CHN.png'),
	('DEU', 'Germany', '1871', 'true', 'src\\images\\DEU.png'),
	('ESP', 'Spain', '1469', 'true', 'src\\images\\ESP.png'),
	('FRA', 'France', '843', 'true', 'src\\images\\FRA.png'),
	('GBR', 'United Kingdom', '1707', 'true', 'src\\images\\GBR.png'),
	('IDN', 'Indonesia', '1945', 'true', 'src\\images\\IDN.png'),
	('ITA', 'Italy', '1861', 'true', 'src\\images\\ITA.png'),
	('JPN', 'Japan', '660', 'false', 'src\\images\\JPN.png'),
	('MYS', 'Malaysia', '1957', 'true', 'src\\images\\MYS.png'),
	('NLD', 'Netherlands', '1581', 'true', 'src\\images\\NLD.png'),
	('RUS', 'Russia', '862', 'true', 'src\\images\\RUS.png'),
	('USA', 'United States of America', '1776', 'true', 'src\\images\\USA.png'),
	('ZAF', 'South Africa', '1910', 'true', 'src\\images\\ZAF.png');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
