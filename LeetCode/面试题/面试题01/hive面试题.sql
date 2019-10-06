1、用一条SQL语句查询出每门课都大于80分的学生姓名
name	kehceng	fenshu
张三	语文	81
张三	数学	75
李四	语文	76
李四	数学	90
王五	语文	81
王五	数学	100
王五	英语	90

创建表
CREATE TABLE IF NOT EXISTS score(
name STRING,
kecheng STRING,
fenshu STRING
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY '\t';

装在数据
LOAD DATA LOCAL inpath '/home/lan/Desktop/score.txt' overwrite INTO TABLE score;

查询语句
SELECT DISTINCT score.name
  FROM score
  LEFT OUTER JOIN
      (SELECT DISTINCT name
         FROM score
        WHERE  fenshu < 80
      )AS less_80
    ON score.name = less_80.name
 WHERE less_80.name IS NULL;

1、首先查询出来分数小于80的学生的名字
2、然后通过左外连接判断，然后less_80表（右表）中没有的数据（也就是分数大于80的）为NULL,所以判断less_80.name IS NULL
