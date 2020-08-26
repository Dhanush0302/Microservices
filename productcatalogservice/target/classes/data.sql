CREATE TABLE 'product'  (
  'id' bigint(20) NOT NULL,
  'name' varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
   'price' bigint(20) NULL DEFAULT NULL,
  'description' varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY ('id') USING BTREE
);


CREATE TABLE 'review'  (
  'reviewId' bigint(20) NOT NULL,
  'id' bigint(20) NOT NULL,
  'stars' bigint(20) NULL DEFAULT NULL,
  'author' varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  'body' varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
   INDEX 'xyz'('id') USING BTREE,
  PRIMARY KEY ('reviewId') USING BTREE,
    CONSTRAINT 'xyz' FOREIGN KEY ('id') REFERENCES 'product' ('id') ON DELETE RESTRICT ON UPDATE RESTRICT
);