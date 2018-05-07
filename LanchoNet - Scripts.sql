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

-- Dumping structure for table lanchonete.categorias
CREATE TABLE IF NOT EXISTS `categorias` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Chave primária referente a tabela de categorias',
  `nome` varchar(50) NOT NULL COMMENT 'Nome referente a categoria',
  `atividade` smallint(1) NOT NULL DEFAULT '0' COMMENT 'Ativo ou Inativo',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1 COMMENT='Tabela do projeto da Lanchonete do Bruno';

-- Dumping data for table lanchonete.categorias: ~0 rows (approximately)
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;

-- Dumping structure for table lanchonete.clientes
CREATE TABLE IF NOT EXISTS `clientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Chave primária referente a clientes',
  `nome_completo` varchar(255) NOT NULL COMMENT 'Nome completo do cliente',
  `cpf` varchar(17) NOT NULL COMMENT 'CPF do cliente',
  `data_nascimento` date NOT NULL COMMENT 'Data de nascimento do cliente',
  `pontos` int(11) NOT NULL DEFAULT '0' COMMENT 'Quantidade de pontos que o cliente possui',
  `atividade` smallint(1) NOT NULL DEFAULT '1' COMMENT 'Ativo ou Inativo',
  `telefone` int(11) NOT NULL COMMENT 'Telefone do cliente',
  `id_funcionario` int(11) NOT NULL COMMENT 'Referente ao funcionário que fez a ultima modificação no cliente',
  PRIMARY KEY (`id`),
  KEY `funcionario` (`id_funcionario`),
  CONSTRAINT `funcionario` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='Tabela clientes do projeto de Lanchonete do Bruno';

-- Dumping data for table lanchonete.clientes: ~0 rows (approximately)
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;

-- Dumping structure for table lanchonete.funcionarios
CREATE TABLE IF NOT EXISTS `funcionarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Chave primária referente à funcionários',
  `nome_completo` varchar(255) NOT NULL COMMENT 'Nome completo do funcionário',
  `data_nascimento` date NOT NULL COMMENT 'Data de nascimento do funcionário',
  `cpf` varchar(14) NOT NULL COMMENT 'CPF do funcionário',
  `telefone` int(13) NOT NULL COMMENT 'Telefone do funcionário',
  `salario` float NOT NULL DEFAULT '0' COMMENT 'Salário do funcionário',
  `email` varchar(100) NOT NULL COMMENT 'E-mail do funcionário',
  `senha` varchar(10) NOT NULL COMMENT 'Senha para login',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabela referente aos Funcionários cadastrados no sistema LanchoNet';

-- Dumping data for table lanchonete.funcionarios: ~0 rows (approximately)
/*!40000 ALTER TABLE `funcionarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionarios` ENABLE KEYS */;

-- Dumping structure for table lanchonete.ingredienteproduto
CREATE TABLE IF NOT EXISTS `ingredienteproduto` (
  `id_ingrediente` int(11) DEFAULT NULL COMMENT 'ID do ingrediente que está no produto',
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Chave primaria referente à tabela proposta',
  `id_produto` int(11) DEFAULT NULL COMMENT 'ID do produto que está o ingrediente',
  `quantidade` float DEFAULT NULL COMMENT 'Quantidade do ingrediente usado no produto',
  PRIMARY KEY (`id`),
  KEY `ingredientes` (`id_ingrediente`),
  KEY `produtos` (`id_produto`),
  CONSTRAINT `ingredientes` FOREIGN KEY (`id_ingrediente`) REFERENCES `ingredientes` (`id`),
  CONSTRAINT `produtos` FOREIGN KEY (`id_produto`) REFERENCES `produtos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabela referente as tabelas Ingredientes e Produtos do sistema LanchoNet';

-- Dumping data for table lanchonete.ingredienteproduto: ~0 rows (approximately)
/*!40000 ALTER TABLE `ingredienteproduto` DISABLE KEYS */;
/*!40000 ALTER TABLE `ingredienteproduto` ENABLE KEYS */;

-- Dumping structure for table lanchonete.ingredientes
CREATE TABLE IF NOT EXISTS `ingredientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Chave primária referente à ingredientes',
  `descricao` varchar(255) NOT NULL COMMENT 'Descrição do ingrediente',
  `quantidade` float NOT NULL DEFAULT '0' COMMENT 'Quantidade em estoque',
  `data_ultima_compra` date NOT NULL COMMENT 'Data da última compra',
  `valor_ultima_compra` float NOT NULL COMMENT 'Valor referente à última compra',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COMMENT='Tabela de Ingredientes referente ao sistema LanchoNet\r\n';

-- Dumping data for table lanchonete.ingredientes: ~0 rows (approximately)
/*!40000 ALTER TABLE `ingredientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `ingredientes` ENABLE KEYS */;

-- Dumping structure for table lanchonete.pedidoproduto
CREATE TABLE IF NOT EXISTS `pedidoproduto` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Chave primária referente à pedidoproduto',
  `produto_id` int(11) NOT NULL DEFAULT '0' COMMENT 'ID do produto pedido',
  `quantidade` int(11) NOT NULL DEFAULT '0' COMMENT 'Quantidade do produto pedido',
  `pedido_id` int(11) NOT NULL DEFAULT '0' COMMENT 'ID referente ao pedido',
  PRIMARY KEY (`id`),
  KEY `prod` (`produto_id`),
  KEY `pedi` (`pedido_id`),
  CONSTRAINT `pedi` FOREIGN KEY (`pedido_id`) REFERENCES `pedidos` (`id`),
  CONSTRAINT `prod` FOREIGN KEY (`produto_id`) REFERENCES `produtos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabela referente a pedido e produto do sistema LanchoNet';

-- Dumping data for table lanchonete.pedidoproduto: ~0 rows (approximately)
/*!40000 ALTER TABLE `pedidoproduto` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedidoproduto` ENABLE KEYS */;

-- Dumping structure for table lanchonete.pedidos
CREATE TABLE IF NOT EXISTS `pedidos` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Chave Primária de Pedidos',
  `data` varchar(10) NOT NULL COMMENT 'Data referente do pedido',
  `valor` float DEFAULT NULL COMMENT 'Valor final do pedido',
  `id_cliente` int(11) NOT NULL COMMENT 'ID do cliente que esta pedindo',
  `id_funcionario` int(11) DEFAULT NULL COMMENT 'ID do funcionário que está fazendo o pedido',
  PRIMARY KEY (`id`),
  KEY `funcionarios` (`id_funcionario`),
  KEY `clientes` (`id_cliente`),
  CONSTRAINT `clientes` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `funcionarios` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabela referente à Pedidos do sistema LanchoNet\r\n';

-- Dumping data for table lanchonete.pedidos: ~0 rows (approximately)
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;

-- Dumping structure for table lanchonete.produtos
CREATE TABLE IF NOT EXISTS `produtos` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Chave primaria referente a Produtos',
  `descricao` varchar(255) NOT NULL COMMENT 'Descricao do produto',
  `id_categoria` int(11) NOT NULL DEFAULT '0' COMMENT 'Vincula uma categoria ao produto',
  `id_funcionario` int(10) NOT NULL DEFAULT '0' COMMENT 'Vincula um usuário ao produto',
  `quantidade` int(11) NOT NULL DEFAULT '0' COMMENT 'Quantidade de produtos no estoque',
  `valor` float NOT NULL DEFAULT '0' COMMENT 'Valor unitário do produto',
  `atividade` smallint(1) NOT NULL DEFAULT '0' COMMENT 'Atividade do usuário',
  PRIMARY KEY (`id`),
  KEY `FK__categorias` (`id_categoria`),
  KEY `FK_funcionario` (`id_funcionario`),
  CONSTRAINT `FK__categorias` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id`),
  CONSTRAINT `FK_funcionario` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1 COMMENT='Tabela refente à Produtos do sistema LanchoNet\r\n\r\n';

-- Dumping data for table lanchonete.produtos: ~0 rows (approximately)
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
