
- 用户表 `tb_person`

```sql
CREATE TABLE `tb_person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '',
  `age` int(11) NOT NULL DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
```


- 汽车表 `tb_car`

```sql
CREATE TABLE `tb_car` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`name` varchar(45) NOT NULL DEFAULT '',
`speed` float NOT NULL DEFAULT '0',
`model` varchar(64) DEFAULT NULL,
PRIMARY KEY (`id`)
) ;
```