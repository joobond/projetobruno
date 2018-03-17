-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 16-Mar-2018 às 23:24
-- Versão do servidor: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `lanchonete`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `categorias`
--

CREATE TABLE IF NOT EXISTS `categorias` (
`id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `atividade` smallint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1 COMMENT='Tabela do projeto da Lanchonete do Bruno';

--
-- Extraindo dados da tabela `categorias`
--

INSERT INTO `categorias` (`id`, `nome`, `atividade`) VALUES
(1, 'Assados', 1),
(2, 'Bebidas em lata', 1),
(3, 'Massas e Pizzas', 0),
(4, 'Fritos', 0),
(5, 'Teste', 0),
(6, 'Teste2', 0),
(7, 'testetrue', 1),
(8, 'asdads', 0),
(9, 'asdsafdas', 0),
(10, '', 0),
(11, 'testeprobond', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE IF NOT EXISTS `clientes` (
`id` int(11) NOT NULL,
  `nome_completo` varchar(255) NOT NULL,
  `cpf` varchar(17) NOT NULL,
  `data_nascimento` varchar(10) NOT NULL,
  `pontos` int(11) NOT NULL DEFAULT '0',
  `atividade` smallint(1) NOT NULL DEFAULT '1',
  `telefone` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT='Tabela clientes do projeto de Lanchonete do Bruno';

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`id`, `nome_completo`, `cpf`, `data_nascimento`, `pontos`, `atividade`, `telefone`) VALUES
(1, 'João Bond', '1234567', '01/09/1998', 0, 0, 992019585);

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionarios`
--

CREATE TABLE IF NOT EXISTS `funcionarios` (
`id` int(11) NOT NULL,
  `nome_completo` varchar(255) NOT NULL,
  `data_nascimento` varchar(10) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `telefone` int(13) NOT NULL,
  `salario` float NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabela refetenre aos Funcionários cadastrados no programa de Lanchonete do Bruno';

-- --------------------------------------------------------

--
-- Estrutura da tabela `ingredientes`
--

CREATE TABLE IF NOT EXISTS `ingredientes` (
`id` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `quantidade` float NOT NULL DEFAULT '0',
  `data_ultima_compra` varchar(10) NOT NULL,
  `valor_ultima_compra` float NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COMMENT='Tabela de ingredientes';

--
-- Extraindo dados da tabela `ingredientes`
--

INSERT INTO `ingredientes` (`id`, `nome`, `quantidade`, `data_ultima_compra`, `valor_ultima_compra`) VALUES
(1, 'Batata Doce', 3, '28/02/2018', 15),
(3, 'Calabresa', 3, '14/02/2018', 4.5);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE IF NOT EXISTS `produtos` (
`id` int(11) NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `id_categoria` int(11) NOT NULL DEFAULT '0',
  `quantidade` int(11) NOT NULL DEFAULT '0',
  `valor` float NOT NULL DEFAULT '0',
  `atividade` smallint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1 COMMENT='Tabela refente a produtos do projeto do Bruno\r\n';

--
-- Extraindo dados da tabela `produtos`
--

INSERT INTO `produtos` (`id`, `descricao`, `id_categoria`, `quantidade`, `valor`, `atividade`) VALUES
(1, 'Torta de Frango', 1, 5, 5, 1),
(3, 'Fanta Laranja 350ml', 2, 2, 3.5, 1),
(4, 'Fanta Laranja 350ml', 2, 2, 3.5, 1),
(5, 'Fanta Laranja 350ml', 2, 2, 3.5, 1),
(6, 'Fanta Laranja 350ml', 2, 2, 3.5, 1),
(7, 'Fanta Laranja 350ml', 2, 2, 3.5, 1),
(8, 'Fanta Laranja 350ml', 2, 2, 3.5, 1),
(9, 'Fanta Laranja 350ml', 2, 2, 3.5, 1),
(10, 'Fanta Laranja 350ml', 2, 2, 3.5, 1),
(11, 'Fanta Laranja 350ml', 2, 2, 3.5, 1),
(12, 'Fanta Laranja 350ml', 2, 2, 3.5, 1),
(13, 'Fanta Laranja 350ml', 2, 2, 3.5, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
`id` int(10) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `senha` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`id`, `usuario`, `senha`) VALUES
(1, 'arthur', 'arthur'),
(2, 'joao', 'joao'),
(3, '', ''),
(4, 'root', 'root');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categorias`
--
ALTER TABLE `categorias`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `clientes`
--
ALTER TABLE `clientes`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `funcionarios`
--
ALTER TABLE `funcionarios`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ingredientes`
--
ALTER TABLE `ingredientes`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `produtos`
--
ALTER TABLE `produtos`
 ADD PRIMARY KEY (`id`), ADD KEY `FK__categorias` (`id_categoria`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categorias`
--
ALTER TABLE `categorias`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `clientes`
--
ALTER TABLE `clientes`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `funcionarios`
--
ALTER TABLE `funcionarios`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `ingredientes`
--
ALTER TABLE `ingredientes`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `produtos`
--
ALTER TABLE `produtos`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
MODIFY `id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `produtos`
--
ALTER TABLE `produtos`
ADD CONSTRAINT `FK__categorias` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
