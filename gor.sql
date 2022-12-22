/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 100427
 Source Host           : localhost:3306
 Source Schema         : gor

 Target Server Type    : MySQL
 Target Server Version : 100427
 File Encoding         : 65001

 Date: 20/12/2022 01:09:27
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
  `LastOrder` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`IdCustomer`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1670 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of customer
-- ----------------------------

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

-- ----------------------------
-- Table structure for lapangan
-- ----------------------------
DROP TABLE IF EXISTS `lapangan`;
CREATE TABLE `lapangan`  (
  `IdLapangan` int NOT NULL AUTO_INCREMENT,
  `NamaLapangan` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`IdLapangan`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10006 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of lapangan
-- ----------------------------
INSERT INTO `lapangan` VALUES (10001, 'Lapangan 1');
INSERT INTO `lapangan` VALUES (10002, 'Lapangan 2');
INSERT INTO `lapangan` VALUES (10005, 'Lapangan 1 & 2');

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
) ENGINE = InnoDB AUTO_INCREMENT = 13025 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of pesanan
-- ----------------------------
INSERT INTO `pesanan` VALUES (12928, 10006, 10002, 2, 1, '2022-12-19 20:14:17', '2022-12-20 11:00:00', '2022-12-20 13:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12929, 10006, 10002, 2, 1, '2022-12-19 20:14:17', '2022-12-27 11:00:00', '2022-12-27 13:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12930, 10006, 10002, 2, 1, '2022-12-19 20:14:18', '2023-01-03 11:00:00', '2023-01-03 13:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12931, 10006, 10002, 2, 1, '2022-12-19 20:14:18', '2023-01-10 11:00:00', '2023-01-10 13:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12932, 10001, 10001, 1, 1648, '2022-12-19 20:14:36', '2022-12-20 12:00:00', '2022-12-20 13:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12933, 10002, 10002, 1, 1649, '2022-12-19 20:15:47', '2022-12-23 08:00:00', '2022-12-23 10:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12934, 10002, 10002, 1, 1650, '2022-12-19 23:36:11', '2022-12-22 10:00:00', '2022-12-22 12:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12935, 10002, 10001, 1, 1651, '2022-12-19 23:36:49', '2022-12-27 08:00:00', '2022-12-27 10:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12936, 10002, 10001, 1, 1651, '2022-12-19 23:36:49', '2022-12-27 08:00:00', '2022-12-27 10:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12937, 10001, 10001, 1, 1652, '2022-12-19 23:37:35', '2022-12-27 12:00:00', '2022-12-27 13:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12938, 10001, 10001, 1, 1652, '2022-12-19 23:37:35', '2022-12-27 12:00:00', '2022-12-27 13:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12939, 10003, 10001, 1, 1, '2022-12-19 23:39:05', '2022-12-27 14:00:00', '2022-12-27 17:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12940, 10003, 10001, 1, 1, '2022-12-19 23:39:05', '2022-12-27 14:00:00', '2022-12-27 17:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12941, 10003, 10001, 1, 1, '2022-12-19 23:39:05', '2023-01-03 14:00:00', '2023-01-03 17:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12942, 10003, 10001, 1, 1, '2022-12-19 23:39:05', '2023-01-03 14:00:00', '2023-01-03 17:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12943, 10003, 10001, 1, 1, '2022-12-19 23:39:06', '2023-01-10 14:00:00', '2023-01-10 17:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12944, 10003, 10001, 1, 1, '2022-12-19 23:39:06', '2023-01-10 14:00:00', '2023-01-10 17:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12945, 10003, 10001, 1, 1, '2022-12-19 23:39:06', '2023-01-17 14:00:00', '2023-01-17 17:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12946, 10003, 10001, 1, 1, '2022-12-19 23:39:06', '2023-01-17 14:00:00', '2023-01-17 17:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12947, 10002, 10002, 1, 1653, '2022-12-19 23:41:24', '2022-12-31 10:00:00', '2022-12-31 12:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12948, 10002, 10002, 1, 1653, '2022-12-19 23:41:24', '2022-12-31 10:00:00', '2022-12-31 12:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12949, 10003, 10002, 1, 1654, '2022-12-19 23:42:24', '2022-12-31 14:00:00', '2022-12-31 17:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12950, 10003, 10002, 1, 1654, '2022-12-19 23:42:24', '2022-12-31 14:00:00', '2022-12-31 17:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12951, 10003, 10005, 1, 1657, '2022-12-20 00:09:02', '2022-12-22 09:00:00', '2022-12-22 12:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12952, 10003, 10005, 1, 1657, '2022-12-20 00:09:02', '2022-12-22 09:00:00', '2022-12-22 12:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12953, 10001, 10002, 1, 1, '2022-12-20 00:11:51', '2022-12-31 10:00:00', '2022-12-31 11:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12954, 10001, 10002, 1, 1, '2022-12-20 00:11:51', '2022-12-31 10:00:00', '2022-12-31 11:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12955, 10001, 10002, 1, 1, '2022-12-20 00:11:51', '2023-01-07 10:00:00', '2023-01-07 11:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12956, 10001, 10002, 1, 1, '2022-12-20 00:11:51', '2023-01-07 10:00:00', '2023-01-07 11:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12957, 10001, 10002, 1, 1, '2022-12-20 00:11:51', '2023-01-14 10:00:00', '2023-01-14 11:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12958, 10001, 10002, 1, 1, '2022-12-20 00:11:51', '2023-01-14 10:00:00', '2023-01-14 11:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12959, 10001, 10002, 1, 1, '2022-12-20 00:11:52', '2023-01-21 10:00:00', '2023-01-21 11:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12960, 10001, 10002, 1, 1, '2022-12-20 00:11:52', '2023-01-21 10:00:00', '2023-01-21 11:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12961, 10002, 10001, 1, 1, '2022-12-20 00:14:53', '2022-12-20 10:00:00', '2022-12-20 12:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12962, 10002, 10001, 1, 1, '2022-12-20 00:14:53', '2022-12-20 10:00:00', '2022-12-20 12:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12963, 10002, 10001, 1, 1, '2022-12-20 00:14:53', '2022-12-27 10:00:00', '2022-12-27 12:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12964, 10002, 10001, 1, 1, '2022-12-20 00:14:53', '2022-12-27 10:00:00', '2022-12-27 12:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12965, 10002, 10001, 1, 1, '2022-12-20 00:14:53', '2023-01-03 10:00:00', '2023-01-03 12:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12966, 10002, 10001, 1, 1, '2022-12-20 00:14:53', '2023-01-03 10:00:00', '2023-01-03 12:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12967, 10002, 10001, 1, 1, '2022-12-20 00:14:53', '2023-01-10 10:00:00', '2023-01-10 12:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12968, 10002, 10001, 1, 1, '2022-12-20 00:14:53', '2023-01-10 10:00:00', '2023-01-10 12:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12969, 10003, 10001, 1, 1658, '2022-12-20 00:18:23', '2022-12-20 13:00:00', '2022-12-20 16:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12970, 10003, 10001, 1, 1658, '2022-12-20 00:18:23', '2022-12-20 13:00:00', '2022-12-20 16:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12971, 10003, 10002, 1, 1659, '2022-12-20 00:19:27', '2022-12-30 10:00:00', '2022-12-30 13:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12972, 10003, 10002, 1, 1659, '2022-12-20 00:19:27', '2022-12-30 10:00:00', '2022-12-30 13:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12973, 10004, 10001, 1, 1660, '2022-12-20 00:22:57', '2022-12-23 08:00:00', '2022-12-23 12:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12974, 10004, 10001, 1, 1660, '2022-12-20 00:22:57', '2022-12-23 08:00:00', '2022-12-23 12:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12975, 10002, 10002, 1, 1661, '2022-12-20 00:23:46', '2022-12-20 13:00:00', '2022-12-20 15:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12976, 10002, 10002, 1, 1661, '2022-12-20 00:23:46', '2022-12-20 13:00:00', '2022-12-20 15:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12977, 10003, 10001, 1, 1662, '2022-12-20 00:25:15', '2022-12-25 09:00:00', '2022-12-25 12:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12978, 10003, 10001, 1, 1662, '2022-12-20 00:25:15', '2022-12-25 09:00:00', '2022-12-25 12:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12979, 10002, 10002, 1, 1663, '2022-12-20 00:26:27', '2022-12-23 11:00:00', '2022-12-23 13:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12980, 10004, 10001, 1, 1664, '2022-12-20 00:29:30', '2023-01-16 10:00:00', '2023-01-16 14:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12981, 10002, 10001, 1, 1665, '2022-12-20 00:31:38', '2022-12-31 09:00:00', '2022-12-31 11:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12982, 10001, 10002, 1, 1666, '2022-12-20 00:33:20', '2022-12-20 21:00:00', '2022-12-20 22:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12983, 10003, 10001, 1, 1667, '2022-12-20 00:47:18', '2022-12-30 09:00:00', '2022-12-30 12:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12984, 10003, 10001, 1, 1667, '2022-12-20 00:47:18', '2022-12-30 09:00:00', '2022-12-30 12:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12985, 10002, 10001, 1, 1668, '2022-12-20 00:54:16', '2022-12-29 09:00:00', '2022-12-29 11:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12986, 10002, 10001, 1, 1668, '2022-12-20 00:54:16', '2022-12-29 09:00:00', '2022-12-29 11:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12987, 10002, 10002, 1, 1, '2022-12-20 00:55:14', '2022-12-31 08:00:00', '2022-12-31 10:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12988, 10002, 10002, 1, 1, '2022-12-20 00:55:14', '2022-12-31 08:00:00', '2022-12-31 10:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12989, 10002, 10002, 1, 1, '2022-12-20 00:55:14', '2023-01-07 08:00:00', '2023-01-07 10:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12990, 10002, 10002, 1, 1, '2022-12-20 00:55:14', '2023-01-07 08:00:00', '2023-01-07 10:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12991, 10002, 10002, 1, 1, '2022-12-20 00:55:14', '2023-01-14 08:00:00', '2023-01-14 10:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12992, 10002, 10002, 1, 1, '2022-12-20 00:55:14', '2023-01-14 08:00:00', '2023-01-14 10:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12993, 10002, 10002, 1, 1, '2022-12-20 00:55:14', '2023-01-21 08:00:00', '2023-01-21 10:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12994, 10002, 10002, 1, 1, '2022-12-20 00:55:14', '2023-01-21 08:00:00', '2023-01-21 10:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12995, 10001, 10002, 1, 1, '2022-12-20 00:56:17', '2022-12-28 11:00:00', '2022-12-28 12:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12996, 10001, 10002, 1, 1, '2022-12-20 00:56:17', '2022-12-28 11:00:00', '2022-12-28 12:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12997, 10001, 10002, 1, 1, '2022-12-20 00:56:17', '2023-01-04 11:00:00', '2023-01-04 12:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12998, 10001, 10002, 1, 1, '2022-12-20 00:56:17', '2023-01-04 11:00:00', '2023-01-04 12:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (12999, 10001, 10002, 1, 1, '2022-12-20 00:56:17', '2023-01-11 11:00:00', '2023-01-11 12:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (13000, 10001, 10002, 1, 1, '2022-12-20 00:56:17', '2023-01-11 11:00:00', '2023-01-11 12:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (13001, 10001, 10002, 1, 1, '2022-12-20 00:56:17', '2023-01-18 11:00:00', '2023-01-18 12:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (13002, 10001, 10002, 1, 1, '2022-12-20 00:56:17', '2023-01-18 11:00:00', '2023-01-18 12:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (13003, 10002, 10002, 1, 1, '2022-12-20 00:58:24', '2022-12-27 14:00:00', '2022-12-27 16:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (13004, 10002, 10002, 1, 1, '2022-12-20 00:58:24', '2023-01-03 14:00:00', '2023-01-03 16:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (13005, 10002, 10002, 1, 1, '2022-12-20 00:58:25', '2023-01-10 14:00:00', '2023-01-10 16:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (13006, 10002, 10002, 1, 1, '2022-12-20 00:58:25', '2023-01-17 14:00:00', '2023-01-17 16:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (13007, 10003, 10002, 1, 1, '2022-12-20 00:59:29', '2023-01-20 08:00:00', '2023-01-20 11:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (13008, 10003, 10002, 1, 1, '2022-12-20 00:59:29', '2023-01-27 08:00:00', '2023-01-27 11:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (13009, 10003, 10002, 1, 1, '2022-12-20 00:59:29', '2023-02-03 08:00:00', '2023-02-03 11:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (13010, 10003, 10002, 1, 1, '2022-12-20 00:59:29', '2023-02-10 08:00:00', '2023-02-10 11:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (13011, 10001, 10001, 1, 1, '2022-12-20 01:00:31', '2022-12-20 12:00:00', '2022-12-20 13:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (13012, 10001, 10001, 1, 1, '2022-12-20 01:00:31', '2022-12-27 12:00:00', '2022-12-27 13:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (13013, 10001, 10001, 1, 1, '2022-12-20 01:00:32', '2023-01-03 12:00:00', '2023-01-03 13:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (13014, 10001, 10001, 1, 1, '2022-12-20 01:00:32', '2023-01-10 12:00:00', '2023-01-10 13:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (13015, 10001, 10002, 1, 1, '2022-12-20 01:03:37', '2022-12-20 16:00:00', '2022-12-20 17:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (13016, 10001, 10002, 1, 1, '2022-12-20 01:03:37', '2022-12-27 16:00:00', '2022-12-27 17:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (13017, 10001, 10002, 1, 1, '2022-12-20 01:03:37', '2023-01-03 16:00:00', '2023-01-03 17:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (13018, 10001, 10002, 1, 1, '2022-12-20 01:03:37', '2023-01-10 16:00:00', '2023-01-10 17:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (13019, 10001, 10001, 1, NULL, '2022-12-20 01:04:09', '2022-12-29 08:00:00', '2022-12-29 09:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (13020, 10001, 10001, 1, NULL, '2022-12-20 01:04:09', '2023-01-05 08:00:00', '2023-01-05 09:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (13021, 10001, 10001, 1, NULL, '2022-12-20 01:04:09', '2023-01-12 08:00:00', '2023-01-12 09:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (13022, 10001, 10001, 1, NULL, '2022-12-20 01:04:09', '2023-01-19 08:00:00', '2023-01-19 09:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (13023, 10002, 10001, 1, 1657, '2022-12-20 01:06:36', '2023-01-17 10:00:00', '2023-01-17 12:00:00', 'Menunggu Antrian');
INSERT INTO `pesanan` VALUES (13024, 10001, 10001, 1, 1669, '2022-12-20 01:06:55', '2023-01-16 08:00:00', '2023-01-16 09:00:00', 'Menunggu Antrian');

-- ----------------------------
-- Table structure for sewa
-- ----------------------------
DROP TABLE IF EXISTS `sewa`;
CREATE TABLE `sewa`  (
  `IdSewa` int NOT NULL AUTO_INCREMENT,
  `NamaSewa` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Harga` int NULL DEFAULT NULL,
  `Durasi` time NULL DEFAULT NULL,
  `isMember` int NULL DEFAULT 0,
  PRIMARY KEY (`IdSewa`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10010 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sewa
-- ----------------------------
INSERT INTO `sewa` VALUES (10001, '1 Jam', 30000, '01:00:00', 0);
INSERT INTO `sewa` VALUES (10002, '2 Jam', 60000, '02:00:00', 0);
INSERT INTO `sewa` VALUES (10003, '3 Jam', 90000, '03:00:00', 0);
INSERT INTO `sewa` VALUES (10004, '4 Jam', 120000, '04:00:00', 0);
INSERT INTO `sewa` VALUES (10005, '5 Jam', 150000, '05:00:00', 0);
INSERT INTO `sewa` VALUES (10006, 'Member', 50000, '02:00:00', 1);

-- ----------------------------
-- Table structure for transaksi
-- ----------------------------
DROP TABLE IF EXISTS `transaksi`;
CREATE TABLE `transaksi`  (
  `IdTrx` int NOT NULL AUTO_INCREMENT,
  `IdTipeTrx` int NULL DEFAULT NULL,
  `IdPesanan` int NULL DEFAULT NULL,
  `Subtotal` bigint NULL DEFAULT NULL,
  `DP` bigint NULL DEFAULT NULL,
  `GrandTotal` bigint NULL DEFAULT NULL,
  `Tanggal` datetime NULL DEFAULT current_timestamp ON UPDATE CURRENT_TIMESTAMP,
  `StatusTransaksi` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`IdTrx`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10240 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of transaksi
-- ----------------------------
INSERT INTO `transaksi` VALUES (10178, 2, 12928, 50000, 0, 50000, '2022-12-19 23:11:10', 'Selesai');
INSERT INTO `transaksi` VALUES (10179, 2, 12929, 50000, 0, 50000, '2022-12-19 23:11:02', 'Pending');
INSERT INTO `transaksi` VALUES (10180, 2, 12930, 50000, 0, 50000, '2022-12-19 23:12:23', 'Selesai');
INSERT INTO `transaksi` VALUES (10181, 2, 12931, 50000, 0, 50000, '2022-12-19 23:11:02', 'Pending');
INSERT INTO `transaksi` VALUES (10182, 1, 12932, 30000, 30000, 0, '2022-12-19 23:12:35', 'Selesai');
INSERT INTO `transaksi` VALUES (10183, 1, 12933, 60000, 30000, 30000, '2022-12-19 23:11:15', 'Selesai');
INSERT INTO `transaksi` VALUES (10184, 1, 12935, 60000, 30000, 30000, '2022-12-19 23:36:49', 'Pending');
INSERT INTO `transaksi` VALUES (10185, 1, 12937, 30000, 30000, 0, '2022-12-19 23:37:35', 'Pending');
INSERT INTO `transaksi` VALUES (10186, 2, 12939, 90000, 0, 60000, '2022-12-19 23:39:05', 'Selesai');
INSERT INTO `transaksi` VALUES (10187, 2, 12941, 90000, 0, 60000, '2022-12-19 23:39:06', 'Selesai');
INSERT INTO `transaksi` VALUES (10188, 2, 12943, 90000, 0, 60000, '2022-12-19 23:39:06', 'Selesai');
INSERT INTO `transaksi` VALUES (10189, 2, 12945, 90000, 0, 60000, '2022-12-19 23:39:06', 'Selesai');
INSERT INTO `transaksi` VALUES (10190, 1, 12947, 60000, 30000, 30000, '2022-12-19 23:41:24', 'Pending');
INSERT INTO `transaksi` VALUES (10191, 1, 12949, 90000, 30000, 60000, '2022-12-19 23:42:24', 'Pending');
INSERT INTO `transaksi` VALUES (10192, 1, 12951, 180000, 30000, 150000, '2022-12-20 00:09:02', 'Pending');
INSERT INTO `transaksi` VALUES (10193, 2, 12953, 30000, 0, 0, '2022-12-20 00:11:51', 'Selesai');
INSERT INTO `transaksi` VALUES (10194, 2, 12955, 30000, 0, 0, '2022-12-20 00:11:51', 'Selesai');
INSERT INTO `transaksi` VALUES (10195, 2, 12957, 30000, 0, 0, '2022-12-20 00:11:51', 'Selesai');
INSERT INTO `transaksi` VALUES (10196, 2, 12959, 30000, 0, 0, '2022-12-20 00:11:52', 'Selesai');
INSERT INTO `transaksi` VALUES (10197, 2, 12961, 60000, 0, 30000, '2022-12-20 00:14:53', 'Selesai');
INSERT INTO `transaksi` VALUES (10198, 2, 12963, 60000, 0, 30000, '2022-12-20 00:14:53', 'Selesai');
INSERT INTO `transaksi` VALUES (10199, 2, 12965, 60000, 0, 30000, '2022-12-20 00:14:53', 'Selesai');
INSERT INTO `transaksi` VALUES (10200, 2, 12967, 60000, 0, 30000, '2022-12-20 00:14:53', 'Selesai');
INSERT INTO `transaksi` VALUES (10201, 1, 12969, 90000, 30000, 60000, '2022-12-20 00:18:23', 'Pending');
INSERT INTO `transaksi` VALUES (10202, 1, 12971, 90000, 30000, 60000, '2022-12-20 00:19:27', 'Pending');
INSERT INTO `transaksi` VALUES (10203, 1, 12973, 120000, 30000, 90000, '2022-12-20 00:22:57', 'Pending');
INSERT INTO `transaksi` VALUES (10204, 1, 12975, 60000, 30000, 30000, '2022-12-20 00:23:46', 'Pending');
INSERT INTO `transaksi` VALUES (10205, 1, 12977, 90000, 30000, 60000, '2022-12-20 00:25:15', 'Pending');
INSERT INTO `transaksi` VALUES (10206, 1, 12980, 120000, 30000, 90000, '2022-12-20 00:29:30', 'Pending');
INSERT INTO `transaksi` VALUES (10207, 1, 12981, 60000, 30000, 30000, '2022-12-20 00:31:38', 'Pending');
INSERT INTO `transaksi` VALUES (10208, 1, 12983, 90000, 30000, 60000, '2022-12-20 00:47:18', 'Pending');
INSERT INTO `transaksi` VALUES (10209, 1, 12985, 60000, 30000, 30000, '2022-12-20 00:54:16', 'Pending');
INSERT INTO `transaksi` VALUES (10210, 2, 12987, 60000, 0, 30000, '2022-12-20 00:55:14', 'Selesai');
INSERT INTO `transaksi` VALUES (10211, 2, 12989, 60000, 0, 30000, '2022-12-20 00:55:14', 'Selesai');
INSERT INTO `transaksi` VALUES (10212, 2, 12991, 60000, 0, 30000, '2022-12-20 00:55:14', 'Selesai');
INSERT INTO `transaksi` VALUES (10213, 2, 12993, 60000, 0, 30000, '2022-12-20 00:55:14', 'Selesai');
INSERT INTO `transaksi` VALUES (10214, 2, 12995, 30000, 0, 0, '2022-12-20 00:56:17', 'Selesai');
INSERT INTO `transaksi` VALUES (10215, 2, 12997, 30000, 0, 0, '2022-12-20 00:56:17', 'Selesai');
INSERT INTO `transaksi` VALUES (10216, 2, 12999, 30000, 0, 0, '2022-12-20 00:56:17', 'Selesai');
INSERT INTO `transaksi` VALUES (10217, 2, 13001, 30000, 0, 0, '2022-12-20 00:56:17', 'Selesai');
INSERT INTO `transaksi` VALUES (10218, 2, 13003, 60000, 0, 30000, '2022-12-20 00:58:24', 'Selesai');
INSERT INTO `transaksi` VALUES (10219, 2, 13004, 60000, 0, 30000, '2022-12-20 00:58:25', 'Selesai');
INSERT INTO `transaksi` VALUES (10220, 2, 13005, 60000, 0, 30000, '2022-12-20 00:58:25', 'Selesai');
INSERT INTO `transaksi` VALUES (10221, 2, 13006, 60000, 0, 30000, '2022-12-20 00:58:25', 'Selesai');
INSERT INTO `transaksi` VALUES (10222, 2, 13007, 90000, 0, 60000, '2022-12-20 00:59:29', 'Selesai');
INSERT INTO `transaksi` VALUES (10223, 2, 13008, 90000, 0, 60000, '2022-12-20 00:59:29', 'Selesai');
INSERT INTO `transaksi` VALUES (10224, 2, 13009, 90000, 0, 60000, '2022-12-20 00:59:29', 'Selesai');
INSERT INTO `transaksi` VALUES (10225, 2, 13010, 90000, 0, 60000, '2022-12-20 00:59:29', 'Selesai');
INSERT INTO `transaksi` VALUES (10226, 2, 13011, 30000, 0, 0, '2022-12-20 01:00:31', 'Selesai');
INSERT INTO `transaksi` VALUES (10227, 2, 13012, 30000, 0, 0, '2022-12-20 01:00:32', 'Selesai');
INSERT INTO `transaksi` VALUES (10228, 2, 13013, 30000, 0, 0, '2022-12-20 01:00:32', 'Selesai');
INSERT INTO `transaksi` VALUES (10229, 2, 13014, 30000, 0, 0, '2022-12-20 01:00:32', 'Selesai');
INSERT INTO `transaksi` VALUES (10230, 2, 13015, 30000, 0, 0, '2022-12-20 01:03:37', 'Selesai');
INSERT INTO `transaksi` VALUES (10231, 2, 13016, 30000, 0, 0, '2022-12-20 01:03:37', 'Selesai');
INSERT INTO `transaksi` VALUES (10232, 2, 13017, 30000, 0, 0, '2022-12-20 01:03:37', 'Selesai');
INSERT INTO `transaksi` VALUES (10233, 2, 13018, 30000, 0, 0, '2022-12-20 01:03:37', 'Selesai');
INSERT INTO `transaksi` VALUES (10234, 2, 13019, 30000, 0, 0, '2022-12-20 01:04:09', 'Selesai');
INSERT INTO `transaksi` VALUES (10235, 2, 13020, 30000, 0, 0, '2022-12-20 01:04:09', 'Selesai');
INSERT INTO `transaksi` VALUES (10236, 2, 13021, 30000, 0, 0, '2022-12-20 01:04:09', 'Selesai');
INSERT INTO `transaksi` VALUES (10237, 2, 13022, 30000, 0, 0, '2022-12-20 01:04:09', 'Selesai');
INSERT INTO `transaksi` VALUES (10238, 1, 13023, 60000, 30000, 30000, '2022-12-20 01:06:36', 'Pending');
INSERT INTO `transaksi` VALUES (10239, 1, 13024, 30000, 30000, 0, '2022-12-20 01:06:55', 'Pending');

SET FOREIGN_KEY_CHECKS = 1;
