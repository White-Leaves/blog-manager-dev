create table `writer` (
    `id` int AUTO_INCREMENT,
    `writer_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    KEY idx_writer_name (writer_name) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

create table `article`(
    `id` int AUTO_INCREMENT,
    `writer_id` int,
    `title` varchar(225) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `content` longtext,
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
    `status` varchar(225) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY idx_writer_id (writer_id) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

create table `category`(
    `id` int AUTO_INCREMENT,
    `category_name` varchar(225) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    KEY idx_category_name (category_name) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

create table `category_article`(
    `id` int auto_increment,
    `article_id` int not null,
    `category_id` int not null,
    PRIMARY KEY (`id`),
    KEY idx_article_id (article_id) USING BTREE,
    KEY idx_category_id (category_id) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;
