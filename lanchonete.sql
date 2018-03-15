-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               5.7.19 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for lanchonete
CREATE DATABASE IF NOT EXISTS `lanchonete` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `lanchonete`;

-- Dumping structure for table lanchonete.clientes
CREATE TABLE IF NOT EXISTS `clientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome_completo` varchar(255) NOT NULL,
  `cpf` varchar(17) NOT NULL,
  `data_nascimento` varchar(10) NOT NULL,
  `pontos` int(11) NOT NULL DEFAULT '0',
  `atividade` smallint(1) NOT NULL DEFAULT '1',
  `telefone` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='Tabela clientes do projeto de Lanchonete do Bruno';

-- Dumping data for table lanchonete.clientes: ~1 rows (approximately)
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` (`id`, `nome_completo`, `cpf`, `data_nascimento`, `pontos`, `atividade`, `telefone`) VALUES
	(1, 'João Bond', '1234567', '01/09/1998', 0, 0, 992019585);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;

-- Dumping structure for table lanchonete.funcionarios
CREATE TABLE IF NOT EXISTS `funcionarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome_completo` varchar(255) NOT NULL,
  `data_nascimento` varchar(10) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `telefone` int(13) NOT NULL,
  `salario` float NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='Tabela refetenre aos Funcionários cadastrados no programa de Lanchonete do Bruno';

-- Dumping data for table lanchonete.funcionarios: ~0 rows (approximately)
/*!40000 ALTER TABLE `funcionarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionarios` ENABLE KEYS */;

-- Dumping structure for table lanchonete.ingredientes
CREATE TABLE IF NOT EXISTS `ingredientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `quantidade` float NOT NULL DEFAULT '0',
  `data_ultima_compra` varchar(10) NOT NULL,
  `valor_ultima_compra` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COMMENT='Tabela de ingredientes';

-- Dumping data for table lanchonete.ingredientes: ~2 rows (approximately)
/*!40000 ALTER TABLE `ingredientes` DISABLE KEYS */;
INSERT INTO `ingredientes` (`id`, `nome`, `quantidade`, `data_ultima_compra`, `valor_ultima_compra`) VALUES
	(1, 'Batata Doce', 3, '28/02/2018', 15),
	(3, 'Calabresa', 3, '14/02/2018', 4.5);
/*!40000 ALTER TABLE `ingredientes` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
