/*
 Navicat Premium Data Transfer

 Source Server         : db
 Source Server Type    : MySQL
 Source Server Version : 100424
 Source Host           : localhost:3306
 Source Schema         : gor

 Target Server Type    : MySQL
 Target Server Version : 100424
 File Encoding         : 65001

 Date: 07/12/2022 15:37:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for accounts
-- ----------------------------
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts`  (
  `UserId` int NOT NULL,
  `Username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `RoleId` int NULL DEFAULT NULL,
  PRIMARY KEY (`UserId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of accounts
-- ----------------------------
INSERT INTO `accounts` VALUES (1, 'Aul', 'aul', 1);

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `IdCustomer` int NOT NULL AUTO_INCREMENT,
  `Nama` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `NoTelp` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Keterangan` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `CreatedAt` datetime NULL DEFAULT current_timestamp,
  PRIMARY KEY (`IdCustomer`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1613 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (1, 'Dera', '0821312', ' asa@gmail.com', 'Member', NULL);
INSERT INTO `customer` VALUES (2, 'asdas', '08087765', 'gasd', 'Member', '2022-10-18 00:13:11');
INSERT INTO `customer` VALUES (1001, 'dasd', 'ddsd', 'ffas', 'Non-Member', '2022-10-18 00:14:01');
INSERT INTO `customer` VALUES (1002, 'asd', 'fasd', 'asd', 'Non-Member', '2022-10-18 10:33:17');
INSERT INTO `customer` VALUES (1594, 'asfasd', 'asdas', 'dasd', 'Non-Member', '2022-10-20 17:04:49');
INSERT INTO `customer` VALUES (1595, 'asda', 'ffasd', 'asda', 'Non-Member', '2022-10-20 17:09:56');
INSERT INTO `customer` VALUES (1596, 'dd', 'sdasd', 'asd', 'Non-Member', '2022-11-02 20:41:17');
INSERT INTO `customer` VALUES (1597, 'ssd', 'ddds', 'ass', 'Non-Member', '2022-11-25 22:06:50');
INSERT INTO `customer` VALUES (1598, 'bbbbb', 'ddds', 'ass', 'Non-Member', '2022-11-25 22:07:14');
INSERT INTO `customer` VALUES (1599, 'zzzz', 'ddds', 'ass', 'Non-Member', '2022-11-25 22:07:49');
INSERT INTO `customer` VALUES (1600, 'asdggggg', 'xxx', 'sss', 'Non-Member', '2022-11-25 22:20:18');
INSERT INTO `customer` VALUES (1601, 'xxc', 'sdd', 'zxc', 'Non-Member', '2022-11-26 12:17:37');
INSERT INTO `customer` VALUES (1602, 'gdg', 'asdd', 'ssd', 'Non-Member', '2022-11-26 12:19:08');
INSERT INTO `customer` VALUES (1603, 'hhhhh', 'ss', 'sg', 'Non-Member', '2022-11-26 12:26:11');
INSERT INTO `customer` VALUES (1604, 'xccz', 'bbbb', 'zx', 'Non-Member', '2022-11-26 12:29:52');
INSERT INTO `customer` VALUES (1605, 'dasd', 'sss', 'a', 'Non-Member', '2022-11-26 14:09:44');
INSERT INTO `customer` VALUES (1606, 'sdd', 'ggg', 'ass', 'Non-Member', '2022-11-29 20:33:48');
INSERT INTO `customer` VALUES (1607, 'xxxdas', 'ggg', 'ass', 'Non-Member', '2022-11-29 20:34:05');
INSERT INTO `customer` VALUES (1608, 'ss', 'asd', 'd', 'Non-Member', '2022-12-04 18:12:33');
INSERT INTO `customer` VALUES (1609, 'asd', 'ssd', 'a', 'Non-Member', '2022-12-05 22:07:32');
INSERT INTO `customer` VALUES (1610, 'dasd', 'asdd', 'das', 'Non-Member', '2022-12-05 22:39:49');
INSERT INTO `customer` VALUES (1611, 'sssd', '123', 'ff', 'Non-Member', '2022-12-07 13:51:58');
INSERT INTO `customer` VALUES (1612, 'asd', 'ssd', 'sadas', 'Non-Member', '2022-12-07 14:53:58');

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item`  (
  `IdItem` int NULL DEFAULT NULL,
  `IdKategori` int NULL DEFAULT NULL,
  `NamaItem` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Harga` int NULL DEFAULT NULL,
  `Unit` int NULL DEFAULT NULL,
  `Stock` int NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES (1, 1, 'Mie Indomie', 80000, 1, 50);

-- ----------------------------
-- Table structure for jenistransaksi
-- ----------------------------
DROP TABLE IF EXISTS `jenistransaksi`;
CREATE TABLE `jenistransaksi`  (
  `IdTipeTrx` int NOT NULL,
  `JenisTransaksi` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`IdTipeTrx`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of jenistransaksi
-- ----------------------------
INSERT INTO `jenistransaksi` VALUES (1, 'Sewa Lapangan Reguler');
INSERT INTO `jenistransaksi` VALUES (2, 'Sewa Lapangan Member');
INSERT INTO `jenistransaksi` VALUES (3, 'Kantin');

-- ----------------------------
-- Table structure for kategori
-- ----------------------------
DROP TABLE IF EXISTS `kategori`;
CREATE TABLE `kategori`  (
  `IdKategori` int NOT NULL,
  `NamaKategori` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `IdTipeTrx` int NULL DEFAULT NULL,
  PRIMARY KEY (`IdKategori`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of kategori
-- ----------------------------
INSERT INTO `kategori` VALUES (1, 'Makanan', 3);

-- ----------------------------
-- Table structure for lapangan
-- ----------------------------
DROP TABLE IF EXISTS `lapangan`;
CREATE TABLE `lapangan`  (
  `IdLapangan` int NOT NULL AUTO_INCREMENT,
  `NamaLapangan` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`IdLapangan`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of lapangan
-- ----------------------------
INSERT INTO `lapangan` VALUES (1, 'Lapangan 1');
INSERT INTO `lapangan` VALUES (2, 'Lapangan 2');
INSERT INTO `lapangan` VALUES (3, 'Lapangan 1 & 2');

-- ----------------------------
-- Table structure for pesanan
-- ----------------------------
DROP TABLE IF EXISTS `pesanan`;
CREATE TABLE `pesanan`  (
  `IdPesanan` int NOT NULL AUTO_INCREMENT,
  `IdSewa` int NULL DEFAULT NULL,
  `IdLapangan` int NULL DEFAULT NULL,
  `IdTipeTrx` int NULL DEFAULT NULL,
  `IdCustomer` int NULL DEFAULT NULL,
  `Order_Date` datetime NULL DEFAULT current_timestamp,
  `Request_Date` datetime NULL DEFAULT NULL,
  `Expired` datetime NULL DEFAULT NULL,
  `Status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`IdPesanan`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12654 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of pesanan
-- ----------------------------
INSERT INTO `pesanan` VALUES (12650, 1, 1, 1, 1611, '2022-12-07 13:51:59', '2022-12-07 14:00:00', '2022-12-07 15:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12651, 2, 1, 1, 2, '2022-12-07 14:14:41', '2022-12-07 17:00:00', '2022-12-07 19:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12652, 2, 1, 1, 1612, '2022-12-07 14:53:58', '2022-12-07 15:00:00', '2022-12-07 17:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12653, 6, 2, 2, 2, '2022-12-07 15:08:58', '2022-12-07 20:00:00', '2022-12-07 22:00:00', 'Menunggu Antrian');

-- ----------------------------
-- Table structure for sewa
-- ----------------------------
DROP TABLE IF EXISTS `sewa`;
CREATE TABLE `sewa`  (
  `IdSewa` int NOT NULL AUTO_INCREMENT,
  `NamaSewa` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Harga` int NULL DEFAULT NULL,
  `Durasi` time NULL DEFAULT NULL,
  PRIMARY KEY (`IdSewa`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sewa
-- ----------------------------
INSERT INTO `sewa` VALUES (1, '1 Jam', 30000, '01:00:00');
INSERT INTO `sewa` VALUES (2, '2 Jam', 60000, '02:00:00');
INSERT INTO `sewa` VALUES (3, '3 Jam', 90000, '03:00:00');
INSERT INTO `sewa` VALUES (4, '4 Jam', 120000, '04:00:00');
INSERT INTO `sewa` VALUES (5, '5 Jam', 150000, '05:00:00');
INSERT INTO `sewa` VALUES (6, 'Member', 200000, '02:00:00');

-- ----------------------------
-- Table structure for transaksi
-- ----------------------------
DROP TABLE IF EXISTS `transaksi`;
CREATE TABLE `transaksi`  (
  `IdTrx` int NOT NULL AUTO_INCREMENT,
  `IdTipeTrx` int NULL DEFAULT NULL,
  `IdItem` int NULL DEFAULT NULL,
  `IdPesanan` int NULL DEFAULT NULL,
  `Subtotal` bigint NULL DEFAULT NULL,
  `DP` bigint NULL DEFAULT NULL,
  `GrandTotal` bigint NULL DEFAULT NULL,
  `Tanggal` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `StatusTransaksi` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`IdTrx`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10000 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of transaksi
-- ----------------------------
INSERT INTO `transaksi` VALUES (1, 3, NULL, 1, 500, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
