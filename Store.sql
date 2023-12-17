-- MySQL dump 10.13  Distrib 8.0.34, for macos13 (arm64)
--
-- Host: localhost    Database: shopping
-- ------------------------------------------------------
-- Server version	8.2.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Nam','Trang phục nam'),(2,'Nữ','Trang phục nữ'),(3,'Giày dép','Giày, sandal, ...'),(4,'Đồng hồ','Đeo tay, thông minh, ...'),(5,'Kính','Kính cận, kính thời trang, ...');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `history` (
  `id_history` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `bought_date` timestamp NULL DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id_history`),
  KEY `fk_history_product` (`product_id`) USING BTREE,
  KEY `fk_history_user` (`user_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
/*!40000 ALTER TABLE `history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `category_id` int DEFAULT NULL,
  `product_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `product_image` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `product_price` double DEFAULT NULL,
  `manufactor` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `information` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `fk_product_category` (`category_id`)
) ENGINE=MyISAM AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,1,'Bộ đồ Nam AVIANO','product_100.jpeg',189000,'AVIANO','Đang cập nhật...'),(2,1,'Áo giữ nhiệt Nam dài tay cao cấp','product_101.jpeg',43000,'VESCAN','Đang cập nhật...'),(3,1,'Quần tây nam Hàn Quốc','product_102.jpeg',155000,'JBaggy','Đang cập nhật...'),(4,1,'Áo polo nam MATANO','product_103.jpeg',58500,'MATANO','Đang cập nhật...'),(5,1,'Quần short nam Essential','product_104.jpeg',70000,'Essential','Đang cập nhật...'),(6,1,'Áo sơ mi trắng Nam','product_105.jpeg',139000,'MemoTOP','Đang cập nhật...'),(7,1,'Quần âu nam Ikemen','product_106.jpeg',125000,'Ikemen','Đang cập nhật...'),(8,1,'Áo hoodie DON\'T SHOP','product_107.jpeg',144000,'Will','Đang cập nhật...'),(9,1,'Áo sơ mi nam','product_108.jpeg',81250,'Unisex','Đang cập nhật...'),(10,1,'Quần dài nam','product_109.jpeg',269000,'Cool Mates','Đang cập nhật...'),(11,2,'Chân váy KaKi chữ A','product_200.jpeg',85000,'GemiStore','Đang cập nhật...'),(12,2,'Áo croptop ba lỗ nữ','product_201.jpeg',46000,'Guvia','Đang cập nhật...'),(13,2,'Đầm nữ tiêu thư tay bổng','product_202.jpeg',169000,'Golana','Đang cập nhật...'),(14,2,'Áo thun Croptop bigsize dây rút tay ngắn','product_203.jpeg',79000,'GiselleLocal','Đang cập nhật...'),(15,2,'Quần shorts nữ ống loe','product_204.jpeg',69000,'MiuMiu Fashion','Đang cập nhật...'),(16,2,'Quần Legging nữ cạp cao hai khuy','product_205.jpeg',95000,'Umi','Đang cập nhật'),(17,2,'Áo dạ tweed kẻ dáng dài','product_206.jpeg',219000,'Golana','Đang cập nhật...'),(18,2,'Chân váy ngắn xếp ly','product_207.jpeg',126650,'Tennis','Đang cập nhật...'),(19,2,'Quần Jogger nữ trơn','product_208.jpeg',118000,'Bom House','Đang cập nhật...'),(20,2,'Áo len cộc tay trơn','product_209.jpeg',99000,'Sutano','Đang cập nhật...'),(21,3,'Giày Nike Jordan 1 Low Panda','product_300.png',350000,'Nike','Đang cập nhật...'),(22,3,'Giày Nike Air Force 1','product_301.png',320000,'Nike','Đang cập nhật...'),(23,3,'Giày Converse Chuck Taylor 1970s đen trắng','product_302.png',310000,'Converse','Đang cập nhật...'),(24,3,'Giày Adidas Forum 84 Trắng','product_303.png',249000,'Adidas','Đang cập nhật...'),(25,3,'Giày Balenciaga Speed đen','product_304.png',450000,'Balenciaga','Đang cập nhật...'),(26,3,'Dép Nike Calm Slide','product_305.png',300000,'Nike','Đang cập nhật...'),(27,3,'Dép Balenciaga nữ','product_306.png',250000,'Balenciaga','Đang cập nhật...'),(28,3,'Giày Biti\'s Hunter Street Americano 2k20','product_307.png',400000,'Biti\'s','Đang cập nhật...'),(29,3,'Sandal Si Cao Su Nam Biti\'s','product_308.png',300000,'Biti\'s','Đang cập nhật...'),(30,3,'Dép Eva Phun Biti\'s Nam','product_309.png',177000,'Biti\'s','Đang cập nhật...');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `date_of_birth` date DEFAULT NULL,
  `sex` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `phone_number` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `role` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'hieupt','hieupt','2023-12-16','Nam','trunghieupham03@gmail.com','0978177429','Danang','2'),(2,'bachnv','bachnv','2023-12-17','Nam','nvbach@gmail.com','0977177429','Hanoi','2'),(3,'namdn','namdn','2023-12-16','Nam','sdgm2003@gmail.com','0976177429','Danang','2');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-17 22:35:21
