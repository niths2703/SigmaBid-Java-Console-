# maxed-wilderness-6454
<img width="289" alt="Screenshot_20221213_155353" src="https://user-images.githubusercontent.com/107460190/208251158-c1f62ecd-dcb8-40c9-9235-8617eab4c0c7.png">

SIGMABID - because service means opportunity!

The e-tendering software is a tool that supports run tenders and requests for proposals further efficiently than email and phone. It helps create and publish tenders, communicate with suppliers, evaluates bids and selects the best vendor.

There are 2 users in the system:

Administrator
Vendor
The Role of Administrator is:

Login with his account.
Register new Vendor. (assign a new username and password to him)
View all the vendors.
Create new tenders.
View All the Tenders.
View All the Bids of a tender.
Assign tender to a vendor.
The Role of a Vendor is:

Login with his account (username and password given by admin)
View all the current Tenders.
Place a Bid against a Tender.
View status of a Bid(Whether Selected or Not)
View his own Bid History.

![Application flow](https://user-images.githubusercontent.com/107460190/208251199-da2ecd2d-f34c-4740-979c-6bf452b41c00.png)

<img width="441" alt="er" src="https://user-images.githubusercontent.com/107460190/208251172-ac2da0f9-a445-41b9-bbc2-95ace69d404d.png">


Database

mysql> desc tender;
+------------+--------------+------+-----+---------+----------------+
| Field      | Type         | Null | Key | Default | Extra          |
+------------+--------------+------+-----+---------+----------------+
| t_id       | int          | NO   | PRI | NULL    | auto_increment |
| t_name     | varchar(40)  | YES  |     | NULL    |                |
| t_type     | varchar(20)  | YES  |     | NULL    |                |
| t_price    | int          | YES  |     | NULL    |                |
| t_desc     | varchar(300) | YES  |     | NULL    |                |
| t_deadline | date         | YES  |     | NULL    |                |
| t_location | varchar(20)  | YES  |     | NULL    |                |
+------------+--------------+------+-----+---------+----------------+
7 rows in set (0.00 sec)

mysql> desc tenderstatus;
+---------------+------------+------+-----+---------+-------+
| Field         | Type       | Null | Key | Default | Extra |
+---------------+------------+------+-----+---------+-------+
| tender_id     | int        | NO   | PRI | NULL    |       |
| tender_status | tinyint(1) | YES  |     | NULL    |       |
| vendor_id     | int        | YES  |     | NULL    |       |
+---------------+------------+------+-----+---------+-------+
3 rows in set (0.00 sec)

mysql> desc vendor;
+----------+--------------+------+-----+---------+----------------+
| Field    | Type         | Null | Key | Default | Extra          |
+----------+--------------+------+-----+---------+----------------+
| v_id     | int          | NO   | PRI | NULL    | auto_increment |
| password | varchar(20)  | YES  |     | NULL    |                |
| v_name   | varchar(30)  | YES  |     | NULL    |                |
| v_mob    | bigint       | YES  |     | NULL    |                |
| v_email  | varchar(20)  | YES  |     | NULL    |                |
| company  | varchar(20)  | YES  |     | NULL    |                |
| address  | varchar(100) | YES  |     | NULL    |                |
+----------+--------------+------+-----+---------+----------------+
7 rows in set (0.00 sec)

mysql> desc bid;
+------------+------------+------+-----+---------+----------------+
| Field      | Type       | Null | Key | Default | Extra          |
+------------+------------+------+-----+---------+----------------+
| b_id       | int        | NO   | PRI | NULL    | auto_increment |
| v_id       | int        | NO   | PRI | NULL    |                |
| t_id       | int        | YES  | MUL | NULL    |                |
| bid_value  | bigint     | YES  |     | NULL    |                |
| bid_status | tinyint(1) | YES  |     | NULL    |                |
+------------+------------+------+-----+---------+----------------+
5 rows in set (0.01 sec)


