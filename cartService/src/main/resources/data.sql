CREATE TABLE 'item'  (
  'id' bigint(20) NOT NULL,
  'name' varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
   'price' bigint(20) NULL DEFAULT NULL,
   'itemTotal' bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY ('id') USING BTREE
);

CREATE TABLE 'cart'  (
  'cartid' bigint(20) NOT NULL,
  'id' bigint(20) NOT NULL,
  'qty' bigint(20) NOT NULL,
  'user' varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY ('cartid') USING BTREE
);

CREATE TABLE 'order'  (
  'id' bigint(20) NOT NULL,
   'amount' bigint(20) NULL DEFAULT NULL,
   'date' datetime(0) NULL DEFAULT NULL,
  'user' varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY ('id') USING BTREE
);