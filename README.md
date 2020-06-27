# Java2SQLServerviaJavaSEProject
Based on Simple Java Project it will connect to SQL Server Database and perform Insert, Select operations to it.
1. If you have windows 7: then install MS SQL Express Server 2012. If you have wndows 10 you can use latest version as well.
2. Install MS SQL Management Studio.
3. After Installing Go to: Microsoft SQL Server Configuration---> SQL Server Network Configuration---> protocols for MSSQLSErver----> TCP/IP--> Enable It.
4. If your java project is normal Java SE application then down Microsoft JDBC Driver downloads: 8.2.2.0
5. Once you create the project make sure that your Java Compiler version and JDBC driver version should be in sync.
6. Once you define the Connection String then follow below example: Here // is important sympol:
  String url= "jdbc:sqlserver://InstanceName;databaseName=";
7. If you just want to fetch result then use executeQuery() method it will return you resultset of array.
8. If you use prepared statement then use executeUpdate() method.
9. If you use normal INSERT method without prepared stmt then use executeUpdate(String query) will return you integer number.
