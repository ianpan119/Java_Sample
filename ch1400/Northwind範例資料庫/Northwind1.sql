CREATE DATABASE  Northwind Collate Chinese_Taiwan_Stroke_CI_AS
GO

USE Northwind

CREATE TABLE [Categories] (
	[CategoryID] [int] IDENTITY (1, 1) NOT NULL ,
	[CategoryName] [nvarchar] (15) COLLATE Chinese_Taiwan_Stroke_CI_AS NOT NULL ,
	[Description] [ntext] COLLATE Chinese_Taiwan_Stroke_CI_AS NULL ,
	CONSTRAINT [PK_Categories] PRIMARY KEY  CLUSTERED 
	(
		[CategoryID]
	)  ON [PRIMARY] 
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

INSERT INTO CATEGORIES VALUES('Beverages','Soft drinks, coffees, teas, be')
INSERT INTO CATEGORIES VALUES('Condiments','Sweet and savory sauces, relis')
INSERT INTO CATEGORIES VALUES('Confections','Desserts, candies, and sweet b')
INSERT INTO CATEGORIES VALUES('Dairy Products','Cheeses')
INSERT INTO CATEGORIES VALUES('Grains/Cereals','Breads, crackers, pasta, and c')
INSERT INTO CATEGORIES VALUES('Meat/Poultry','Prepared meats')
INSERT INTO CATEGORIES VALUES('Produce','Dried fruit and bean curd')
INSERT INTO CATEGORIES VALUES('Seafood','Seaweed and fish')

CREATE TABLE [Products] (
	[ProductID] [int] IDENTITY (1, 1) NOT NULL ,
	[ProductName] [nvarchar] (40) COLLATE Chinese_Taiwan_Stroke_CI_AS NOT NULL ,
	[CategoryID] [int] NULL ,
	[UnitPrice] [money] NULL CONSTRAINT [DF_Products_UnitPrice] DEFAULT (0),
	[UnitsInStock] [smallint] NULL CONSTRAINT [DF_Products_UnitsInStock] DEFAULT (0),
	CONSTRAINT [PK_Products] PRIMARY KEY  CLUSTERED 
	(
		[ProductID]
	)  ON [PRIMARY] ,
	CONSTRAINT [FK_Products_Categories] FOREIGN KEY 
	(
		[CategoryID]
	) REFERENCES [Categories] (
		[CategoryID]
	),
	CONSTRAINT [CK_Products_UnitPrice] CHECK ([UnitPrice] >= 0),
	CONSTRAINT [CK_UnitsInStock] CHECK ([UnitsInStock] >= 0),
	
) ON [PRIMARY]

INSERT INTO PRODUCTS VALUES('Chai',1,18.00,39)
INSERT INTO PRODUCTS VALUES('Chang',1,19.00,17)
INSERT INTO PRODUCTS VALUES('Aniseed Syrup',2,10.00,13)
INSERT INTO PRODUCTS VALUES('Chef Anton''s Cajun Seasoning',2,22.00,53)
INSERT INTO PRODUCTS VALUES('Chef Anton''s Gumbo Mix',2,21.35,0)
INSERT INTO PRODUCTS VALUES('Grandma''s Boysenberry Spread',2,25.00,120)
INSERT INTO PRODUCTS VALUES('Uncle Bob''s Organic Dried Pears',7,30.00,15)
INSERT INTO PRODUCTS VALUES('Northwoods Cranberry Sauce',2,40.00,6)
INSERT INTO PRODUCTS VALUES('Mishi Kobe Niku',6,97.00,29)
INSERT INTO PRODUCTS VALUES('Ikura',8,31.00,31)
INSERT INTO PRODUCTS VALUES('Queso Cabrales',4,21.00,22)
INSERT INTO PRODUCTS VALUES('Queso Manchego La Pastora',4,38.00,86)
INSERT INTO PRODUCTS VALUES('Konbu',8,6.00,24)
INSERT INTO PRODUCTS VALUES('Tofu',7,23.25,35)
INSERT INTO PRODUCTS VALUES('Genen Shouyu',2,15.50,39)
INSERT INTO PRODUCTS VALUES('Pavlova',3,17.45,29)
INSERT INTO PRODUCTS VALUES('Alice Mutton',6,39.00,0)
INSERT INTO PRODUCTS VALUES('Carnarvon Tigers',8,62.50,42)
INSERT INTO PRODUCTS VALUES('Teatime Chocolate Biscuits',3,9.20,25)
INSERT INTO PRODUCTS VALUES('Sir Rodney''s Marmalade',3,81.00,40)
INSERT INTO PRODUCTS VALUES('Sir Rodney''s Scones',3,10.00,3)
INSERT INTO PRODUCTS VALUES('Gustaf''s Knackebrod',5,21.00,104)
INSERT INTO PRODUCTS VALUES('Tunnbrod',5,9.00,61)
INSERT INTO PRODUCTS VALUES('Guarana Fantastica',1,4.50,20)
INSERT INTO PRODUCTS VALUES('NuNuCa Nus-Nougat-Creme',3,14.00,76)
INSERT INTO PRODUCTS VALUES('Gumbar Gummibarchen',3,31.23,15)
INSERT INTO PRODUCTS VALUES('Schoggi Schokolade',3,43.90,49)
INSERT INTO PRODUCTS VALUES('Rossle Sauerkraut',7,45.60,26)
INSERT INTO PRODUCTS VALUES('Thuringer Rostbratwurst',6,123.79,0)
INSERT INTO PRODUCTS VALUES('Nord-Ost Matjeshering',8,25.89,10)
INSERT INTO PRODUCTS VALUES('Gorgonzola Telino',4,12.50,0)
INSERT INTO PRODUCTS VALUES('Mascarpone Fabioli',4,32.00,9)
INSERT INTO PRODUCTS VALUES('Geitost',4,2.50,112)
INSERT INTO PRODUCTS VALUES('Sasquatch Ale',1,14.00,111)
INSERT INTO PRODUCTS VALUES('Steeleye Stout',1,18.00,20)
INSERT INTO PRODUCTS VALUES('Inlagd Sill',8,19.00,112)
INSERT INTO PRODUCTS VALUES('Gravad lax',8,26.00,11)
INSERT INTO PRODUCTS VALUES('Cote de Blaye',1,263.50,17)
INSERT INTO PRODUCTS VALUES('Chartreuse verte',1,18.00,69)
INSERT INTO PRODUCTS VALUES('Boston Crab Meat',8,18.40,123)
INSERT INTO PRODUCTS VALUES('Jack''s New England Clam Chowder',8,9.65,85)
INSERT INTO PRODUCTS VALUES('Singaporean Hokkien Fried Mee',5,14.00,26)
INSERT INTO PRODUCTS VALUES('Ipoh Coffee',1,46.00,17)
INSERT INTO PRODUCTS VALUES('Gula Malacca',2,19.45,27)
INSERT INTO PRODUCTS VALUES('Rogede sild',8,9.50,5)
INSERT INTO PRODUCTS VALUES('Spegesild',8,12.00,95)
INSERT INTO PRODUCTS VALUES('Zaanse koeken',3,9.50,36)
INSERT INTO PRODUCTS VALUES('Chocolade',3,12.75,15)
INSERT INTO PRODUCTS VALUES('Maxilaku',3,20.00,10)
INSERT INTO PRODUCTS VALUES('Valkoinen suklaa',3,16.25,65)
INSERT INTO PRODUCTS VALUES('Manjimup Dried Apples',7,53.00,20)
INSERT INTO PRODUCTS VALUES('Filo Mix',5,7.00,38)
INSERT INTO PRODUCTS VALUES('Perth Pasties',6,32.80,0)
INSERT INTO PRODUCTS VALUES('Tourtiere',6,7.45,21)
INSERT INTO PRODUCTS VALUES('Pate chinois',6,24.00,115)
INSERT INTO PRODUCTS VALUES('Gnocchi di nonna Alice',5,38.00,21)
INSERT INTO PRODUCTS VALUES('Ravioli Angelo',5,19.50,36)
INSERT INTO PRODUCTS VALUES('Escargots de Bourgogne',8,13.25,62)
INSERT INTO PRODUCTS VALUES('Raclette Courdavault',4,55.00,79)
INSERT INTO PRODUCTS VALUES('Camembert Pierrot',4,34.00,19)
INSERT INTO PRODUCTS VALUES('Sirop derable',2,28.50,113)
INSERT INTO PRODUCTS VALUES('Tarte au sucre',3,49.30,17)
INSERT INTO PRODUCTS VALUES('Vegie-spread',2,43.90,24)
INSERT INTO PRODUCTS VALUES('Wimmers gute Semmelknodel',5,33.25,22)
INSERT INTO PRODUCTS VALUES('Louisiana Fiery Hot Pepper Sauce',2,21.05,76)
INSERT INTO PRODUCTS VALUES('Louisiana Hot Spiced Okra',2,17.00,4)
INSERT INTO PRODUCTS VALUES('Laughing Lumberjack Lager',1,14.00,52)
INSERT INTO PRODUCTS VALUES('Scottish Longbreads',3,12.50,6)
INSERT INTO PRODUCTS VALUES('Gudbrandsdalsost',4,36.00,26)
INSERT INTO PRODUCTS VALUES('Outback Lager',1,15.00,15)
INSERT INTO PRODUCTS VALUES('Flotemysost',4,21.50,26)
INSERT INTO PRODUCTS VALUES('Mozzarella di Giovanni',4,34.80,14)
INSERT INTO PRODUCTS VALUES('Rod Kaviar',8,15.00,101)
INSERT INTO PRODUCTS VALUES('Longlife Tofu',7,10.00,4)
INSERT INTO PRODUCTS VALUES('Rhonbrau Klosterbier',1,7.75,125)
INSERT INTO PRODUCTS VALUES('Lakkalikoori',1,18.00,57)
INSERT INTO PRODUCTS VALUES('Original Frankfurter grune Sose',2,13.00,32)

CREATE TABLE [Customers] (
	[CustomerID] [nchar] (5) COLLATE Chinese_Taiwan_Stroke_CI_AS NOT NULL ,
	[CompanyName] [nvarchar] (40) COLLATE Chinese_Taiwan_Stroke_CI_AS NOT NULL ,
	[ContactName] [nvarchar] (30) COLLATE Chinese_Taiwan_Stroke_CI_AS NULL ,
	[ContactTitle] [nvarchar] (30) COLLATE Chinese_Taiwan_Stroke_CI_AS NULL ,
	[Address] [nvarchar] (60) COLLATE Chinese_Taiwan_Stroke_CI_AS NULL ,
	[City] [nvarchar] (15) COLLATE Chinese_Taiwan_Stroke_CI_AS NULL ,
	[Region] [nvarchar] (15) COLLATE Chinese_Taiwan_Stroke_CI_AS NULL ,
	[PostalCode] [nvarchar] (10) COLLATE Chinese_Taiwan_Stroke_CI_AS NULL ,
	[Country] [nvarchar] (15) COLLATE Chinese_Taiwan_Stroke_CI_AS NULL ,
	[Phone] [nvarchar] (24) COLLATE Chinese_Taiwan_Stroke_CI_AS NULL ,
	[Fax] [nvarchar] (24) COLLATE Chinese_Taiwan_Stroke_CI_AS NULL ,
	CONSTRAINT [PK_Customers] PRIMARY KEY  CLUSTERED 
	(
		[CustomerID]
	)  ON [PRIMARY] 
) ON [PRIMARY]

INSERT INTO CUSTOMERS VALUES('OLDWO','Old World Delicatessen','Rene Phillips','Sales Representative','2743 Bering St.','Anchorage','AK','99508','USA','(907) 555-7584','(907) 555-2880')
INSERT INTO CUSTOMERS VALUES('BOTTM','Bottom-Dollar Markets','Elizabeth Lincoln','Accounting Manager','23 Tsawassen Blvd.','Tsawassen','BC','T2F 8M4','Canada','(604) 555-4729','(604) 555-3745')
INSERT INTO CUSTOMERS VALUES('LAUGB','Laughing Bacchus Wine Cellars','Yoshi Tannamuri','Marketing Assistant','1900 Oak St.','Vancouver','BC','V3F 2K1','Canada','(604) 555-3392','(604) 555-7293')
INSERT INTO CUSTOMERS VALUES('LETSS','Let''s Stop N Shop','Jaime Yorres','Owner','87 Polk St. Suite 5','San Francisco','CA','94117','USA','(415) 555-5938','N/A')
INSERT INTO CUSTOMERS VALUES('HUNGO','Hungry Owl All-Night Grocers','Patricia McKenna','Sales Associate','8 Johnstown Road','Cork','Co. Cork','N/A','Ireland','2967 542','2967 3333')
INSERT INTO CUSTOMERS VALUES('GROSR','GROSELLA-Restaurante','Manuel Pereira','Owner','5a Ave. Los Palos Grandes','Caracas','DF','1081','Venezuela','(2) 283-2951','(2) 283-3397')
INSERT INTO CUSTOMERS VALUES('SAVEA','Save-a-lot Markets','Jose Pavarotti','Sales Representative','187 Suffolk Ln.','Boise','ID','83720','USA','(208) 555-8097','N/A')
INSERT INTO CUSTOMERS VALUES('ISLAT','Island Trading','Helen Bennett','Marketing Manager','Garden House Crowther Way','Cowes','Isle of Wight','PO31 7PJ','UK','(198) 555-8888','N/A')
INSERT INTO CUSTOMERS VALUES('LILAS','LILA-Supermercado','Carlos Gonzalez','Accounting Manager','Carrera 52 con Ave. Bolivar #65-98 Llano Largo','Barquisimeto','Lara','3508','Venezuela','(9) 331-6954','(9) 331-7256')
INSERT INTO CUSTOMERS VALUES('THECR','The Cracker Box','Liu Wong','Marketing Assistant','55 Grizzly Peak Rd.','Butte','MT','59801','USA','(406) 555-5834','(406) 555-8083')
INSERT INTO CUSTOMERS VALUES('RATTC','Rattlesnake Canyon Grocery','Paula Wilson','Assistant Sales Representative','2817 Milton Dr.','Albuquerque','NM','87110','USA','(505) 555-5939','(505) 555-3620')
INSERT INTO CUSTOMERS VALUES('LINOD','LINO-Delicateses','Felipe Izquierdo','Owner','Ave. 5 de Mayo Porlamar','I. de Margarita','Nueva Esparta','4980','Venezuela','(8) 34-56-12','(8) 34-93-93')
INSERT INTO CUSTOMERS VALUES('GREAL','Great Lakes Food Market','Howard Snyder','Marketing Manager','2732 Baker Blvd.','Eugene','OR','97403','USA','(503) 555-7555','N/A')
INSERT INTO CUSTOMERS VALUES('HUNGC','Hungry Coyote Import Store','Yoshi Latimer','Sales Representative','City Center Plaza 516 Main St.','Elgin','OR','97827','USA','(503) 555-6874','(503) 555-2376')
INSERT INTO CUSTOMERS VALUES('LONEP','Lonesome Pine Restaurant','Fran Wilson','Sales Manager','89 Chiaroscuro Rd.','Portland','OR','97219','USA','(503) 555-9573','(503) 555-9646')
INSERT INTO CUSTOMERS VALUES('THEBI','The Big Cheese','Liz Nixon','Marketing Manager','89 Jefferson Way Suite 2','Portland','OR','97201','USA','(503) 555-3612','N/A')
INSERT INTO CUSTOMERS VALUES('MEREP','Mere Paillarde','Jean Fresniere','Marketing Assistant','43 rue St. Laurent','Montreal','Quebec','H1J 1C3','Canada','(514) 555-8054','(514) 555-8055')
INSERT INTO CUSTOMERS VALUES('HANAR','Hanari Carnes','Mario Pontes','Accounting Manager','Rua do Paco, 67','Rio de Janeiro','RJ','05454-876','Brazil','(21) 555-0091','(21) 555-8765')
INSERT INTO CUSTOMERS VALUES('QUEDE','Que Delicia','Bernardo Batista','Accounting Manager','Rua da Panificadora, 12','Rio de Janeiro','RJ','02389-673','Brazil','(21) 555-4252','(21) 555-4545')
INSERT INTO CUSTOMERS VALUES('RICAR','Ricardo Adocicados','Janete Limeira','Assistant Sales Agent','Av. Copacabana, 267','Rio de Janeiro','RJ','02389-890','Brazil','(21) 555-3412','N/A')
INSERT INTO CUSTOMERS VALUES('COMMI','Comercio Mineiro','Pedro Afonso','Sales Associate','Av. dos Lusiadas, 23','Sao Paulo','SP','05432-043','Brazil','(11) 555-7647','N/A')
INSERT INTO CUSTOMERS VALUES('FAMIA','Familia Arquibaldo','Aria Cruz','Marketing Assistant','Rua Oros, 92','Sao Paulo','SP','05442-030','Brazil','(11) 555-9857','N/A')
INSERT INTO CUSTOMERS VALUES('GOURL','Gourmet Lanchonetes','Andre Fonseca','Sales Associate','Av. Brasil, 442','Campinas','SP','04876-786','Brazil','(11) 555-9482','N/A')
INSERT INTO CUSTOMERS VALUES('QUEEN','Queen Cozinha','Lucia Carvalho','Marketing Assistant','Alameda dos Canarios, 891','Sao Paulo','SP','05487-020','Brazil','(11) 555-1189','N/A')
INSERT INTO CUSTOMERS VALUES('TRADH','Tradicao Hipermercados','Anabela Domingues','Sales Representative','Av. Ines de Castro, 414','Sao Paulo','SP','05634-030','Brazil','(11) 555-2167','(11) 555-2168')
INSERT INTO CUSTOMERS VALUES('WELLI','Wellington Importadora','Paula Parente','Sales Manager','Rua do Mercado, 12','Resende','SP','08737-363','Brazil','(14) 555-8122','N/A')
INSERT INTO CUSTOMERS VALUES('HILAA','HILARION-Abastos','Carlos Hernandez','Sales Representative','Carrera 22 con Ave. Carlos Soublette #8-35','San Cristobal','Tachira','5022','Venezuela','(5) 555-1340','(5) 555-1948')
INSERT INTO CUSTOMERS VALUES('LAZYK','Lazy K Kountry Store','John Steel','Marketing Manager','12 Orchestra Terrace','Walla Walla','WA','99362','USA','(509) 555-7969','(509) 555-6221')
INSERT INTO CUSTOMERS VALUES('TRAIH','Trail''s Head Gourmet Provisioners','Helvetius Nagy','Sales Associate','722 DaVinci Blvd.','Kirkland','WA','98034','USA','(206) 555-8257','(206) 555-2174')
INSERT INTO CUSTOMERS VALUES('WHITC','White Clover Markets','Karl Jablonski','Owner','305 - 14th Ave. S. Suite 3B','Seattle','WA','98128','USA','(206) 555-4112','(206) 555-4115')
INSERT INTO CUSTOMERS VALUES('SPLIR','Split Rail Beer & Ale','Art Braunschweiger','Sales Manager','P.O. Box 555','Lander','WY','82520','USA','(307) 555-4680','(307) 555-6525')

INSERT INTO CUSTOMERS VALUES('ALFKI','Alfreds Futterkiste','Maria Anders','Sales Representative','Obere Str. 57','Berlin',NULL,'12209','Germany','030-0074321','030-0076545')
INSERT INTO CUSTOMERS VALUES('ANATR','Ana Trujillo Emparedados y helados','Ana Trujillo','Owner','Avda. de la Constitucion 2222','Mexico D.F.',NULL,'05021','Mexico','(5) 555-4729','(5) 555-3745')
INSERT INTO CUSTOMERS VALUES('ANTON','Antonio Moreno Taqueria','Antonio Moreno','Owner','Mataderos  2312','Mexico D.F.',NULL,'05023','Mexico','(5) 555-3932','N/A')
INSERT INTO CUSTOMERS VALUES('AROUT','Around the Horn','Thomas Hardy','Sales Representative','120 Hanover Sq.','London',NULL,'WA1 1DP','UK','(171) 555-7788','(171) 555-6750')
INSERT INTO CUSTOMERS VALUES('BERGS','Berglunds snabbkop','Christina Berglund','Order Administrator','Berguvsvagen  8','Lulea',NULL,'S-958 22','Sweden','0921-12 34 65','0921-12 34 67')
INSERT INTO CUSTOMERS VALUES('BLAUS','Blauer See Delikatessen','Hanna Moos','Sales Representative','Forsterstr. 57','Mannheim',NULL,'68306','Germany','0621-08460','0621-08924')
INSERT INTO CUSTOMERS VALUES('BLONP','Blondesddsl pere et fils','Frederique Citeaux','Marketing Manager','24, place Kleber','Strasbourg',NULL,'67000','France','88.60.15.31','88.60.15.32')
INSERT INTO CUSTOMERS VALUES('BOLID','Bolido Comidas preparadas','Martin Sommer','Owner','C/ Araquil, 67','Madrid',NULL,'28023','Spain','(91) 555 22 82','(91) 555 91 99')
INSERT INTO CUSTOMERS VALUES('BONAP','Bon app''','Laurence Lebihan','Owner','12, rue des Bouchers','Marseille',NULL,'13008','France','91.24.45.40','91.24.45.41')
INSERT INTO CUSTOMERS VALUES('BSBEV','B''s Beverages','Victoria Ashworth','Sales Representative','Fauntleroy Circus','London',NULL,'EC2 5NT','UK','(171) 555-1212','N/A')
INSERT INTO CUSTOMERS VALUES('CACTU','Cactus Comidas para llevar','Patricio Simpson','Sales Agent','Cerrito 333','Buenos Aires',NULL,'1010','Argentina','(1) 135-5555','(1) 135-4892')
INSERT INTO CUSTOMERS VALUES('CENTC','Centro comercial Moctezuma','Francisco Chang','Marketing Manager','Sierras de Granada 9993','Mexico D.F.',NULL,'05022','Mexico','(5) 555-3392','(5) 555-7293')
INSERT INTO CUSTOMERS VALUES('CHOPS','Chop-suey Chinese','Yang Wang','Owner','Hauptstr. 29','Bern',NULL,'3012','Switzerland','0452-076545','N/A')
INSERT INTO CUSTOMERS VALUES('CONSH','Consolidated Holdings','Elizabeth Brown','Sales Representative','Berkeley Gardens 12  Brewery','London',NULL,'WX1 6LT','UK','(171) 555-2282','(171) 555-9199')
INSERT INTO CUSTOMERS VALUES('DRACD','Drachenblut Delikatessen','Sven Ottlieb','Order Administrator','Walserweg 21','Aachen',NULL,'52066','Germany','0241-039123','0241-059428')
INSERT INTO CUSTOMERS VALUES('DUMON','Du monde entier','Janine Labrune','Owner','67, rue des Cinquante Otages','Nantes',NULL,'44000','France','40.67.88.88','40.67.89.89')
INSERT INTO CUSTOMERS VALUES('EASTC','Eastern Connection','Ann Devon','Sales Agent','35 King George','London',NULL,'WX3 6FW','UK','(171) 555-0297','(171) 555-3373')
INSERT INTO CUSTOMERS VALUES('ERNSH','Ernst Handel','Roland Mendel','Sales Manager','Kirchgasse 6','Graz',NULL,'8010','Austria','7675-3425','7675-3426')
INSERT INTO CUSTOMERS VALUES('FISSA','FISSA Fabrica Inter. Salchichas S.A.','Diego Roel','Accounting Manager','C/ Moralzarzal, 86','Madrid',NULL,'28034','Spain','(91) 555 94 44','(91) 555 55 93')
INSERT INTO CUSTOMERS VALUES('FOLIG','Folies gourmandes','Martine Rance','Assistant Sales Agent','184, chaussee de Tournai','Lille',NULL,'59000','France','20.16.10.16','20.16.10.17')
INSERT INTO CUSTOMERS VALUES('FOLKO','Folk och fa HB','Maria Larsson','Owner','Akergatan 24','Bracke',NULL,'S-844 67','Sweden','0695-34 67 21','N/A')
INSERT INTO CUSTOMERS VALUES('FRANK','Frankenversand','Peter Franken','Marketing Manager','Berliner Platz 43','Munchen',NULL,'80805','Germany','089-0877310','089-0877451')
INSERT INTO CUSTOMERS VALUES('FRANR','France restauration','Carine Schmitt','Marketing Manager','54, rue Royale','Nantes',NULL,'44000','France','40.32.21.21','40.32.21.20')
INSERT INTO CUSTOMERS VALUES('FRANS','Franchi S.p.A.','Paolo Accorti','Sales Representative','Via Monte Bianco 34','Torino',NULL,'10100','Italy','011-4988260','011-4988261')
INSERT INTO CUSTOMERS VALUES('FURIB','Furia Bacalhau e Frutos do Mar','Lino Rodriguez','Sales Manager','Jardim das rosas n. 32','Lisboa',NULL,'1675','Portugal','(1) 354-2534','(1) 354-2535')
INSERT INTO CUSTOMERS VALUES('GALED','Galeria del gastronomo','Eduardo Saavedra','Marketing Manager','Rambla de Cataluna, 23','Barcelona',NULL,'08022','Spain','(93) 203 4560','(93) 203 4561')
INSERT INTO CUSTOMERS VALUES('GODOS','Godos Cocina Tipica','Jose Pedro Freyre','Sales Manager','C/ Romero, 33','Sevilla',NULL,'41101','Spain','(95) 555 82 82','N/A')
INSERT INTO CUSTOMERS VALUES('KOENE','Koniglich Essen','Philip Cramer','Sales Associate','Maubelstr. 90','Brandenburg',NULL,'14776','Germany','0555-09876','N/A')
INSERT INTO CUSTOMERS VALUES('LACOR','La corne d''abondance','Daniel Tonini','Sales Representative','67, avenue de l''Europe','Versailles',NULL,'78000','France','30.59.84.10','30.59.85.11')
INSERT INTO CUSTOMERS VALUES('LAMAI','La maison d''Asie','Annette Roulet','Sales Manager','1 rue Alsace-Lorraine','Toulouse',NULL,'31000','France','61.77.61.10','61.77.61.11')
INSERT INTO CUSTOMERS VALUES('LEHMS','Lehmanns Marktstand','Renate Messner','Sales Representative','Magazinweg 7','Frankfurt a.M.',NULL,'60528','Germany','069-0245984','069-0245874')
INSERT INTO CUSTOMERS VALUES('MAGAA','Magazzini Alimentari Riuniti','Giovanni Rovelli','Marketing Manager','Via Ludovico il Moro 22','Bergamo',NULL,'24100','Italy','035-640230','035-640231')
INSERT INTO CUSTOMERS VALUES('MAISD','Maison Dewey','Catherine Dewey','Sales Agent','Rue Joseph-Bens 532','Bruxelles',NULL,'B-1180','Belgium','(02) 201 24 67','(02) 201 24 68')
INSERT INTO CUSTOMERS VALUES('MORGK','Morgenstern Gesundkost','Alexander Feuer','Marketing Assistant','Heerstr. 22','Leipzig',NULL,'04179','Germany','0342-023176','N/A')
INSERT INTO CUSTOMERS VALUES('NORTS','North/South','Simon Crowther','Sales Associate','South House 300 Queensbridge','London',NULL,'SW7 1RZ','UK','(171) 555-7733','(171) 555-2530')
INSERT INTO CUSTOMERS VALUES('OCEAN','Oceano Atlantico Ltda.','Yvonne Moncada','Sales Agent','Ing. Gustavo Moncada 8585 Piso 20-A','Buenos Aires',NULL,'1010','Argentina','(1) 135-5333','(1) 135-5535')
INSERT INTO CUSTOMERS VALUES('OTTIK','Ottilies Kaseladen','Henriette Pfalzheim','Owner','Mehrheimerstr. 369','Koln',NULL,'50739','Germany','0221-0644327','0221-0765721')
INSERT INTO CUSTOMERS VALUES('PARIS','Paris specialites','Marie Bertrand','Owner','265, boulevard Charonne','Paris',NULL,'75012','France','(1) 42.34.22.66','(1) 42.34.22.77')
INSERT INTO CUSTOMERS VALUES('PERIC','Pericles Comidas clasicas','Guillermo Fernandez','Sales Representative','Calle Dr. Jorge Cash 321','Mexico D.F.',NULL,'05033','Mexico','(5) 552-3745','(5) 545-3745')
INSERT INTO CUSTOMERS VALUES('PICCO','Piccolo und mehr','Georg Pipps','Sales Manager','Geislweg 14','Salzburg',NULL,'5020','Austria','6562-9722','6562-9723')
INSERT INTO CUSTOMERS VALUES('PRINI','Princesa Isabel Vinhos','Isabel de Castro','Sales Representative','Estrada da saude n. 58','Lisboa',NULL,'1756','Portugal','(1) 356-5634','N/A')
INSERT INTO CUSTOMERS VALUES('QUICK','QUICK-Stop','Horst Kloss','Accounting Manager','Taucherstrase 10','Cunewalde',NULL,'01307','Germany','0372-035188','N/A')
INSERT INTO CUSTOMERS VALUES('RANCH','Rancho grande','Sergio Gutierrez','Sales Representative','Av. del Libertador 900','Buenos Aires',NULL,'1010','Argentina','(1) 123-5555','(1) 123-5556')
INSERT INTO CUSTOMERS VALUES('REGGC','Reggiani Caseifici','Maurizio Moroni','Sales Associate','Strada Provinciale 124','Reggio Emilia',NULL,'42100','Italy','0522-556721','0522-556722')
INSERT INTO CUSTOMERS VALUES('RICSU','Richter Supermarkt','Michael Holz','Sales Manager','Grenzacherweg 237','Geneve',NULL,'1203','Switzerland','0897-034214','N/A')
INSERT INTO CUSTOMERS VALUES('ROMEY','Romero y tomillo','Alejandra Camino','Accounting Manager','Gran Via, 1','Madrid',NULL,'28001','Spain','(91) 745 6200','(91) 745 6210')
INSERT INTO CUSTOMERS VALUES('SANTG','Sante Gourmet','Jonas Bergulfsen','Owner','Erling Skakkes gate 78','Stavern',NULL,'4110','Norway','07-98 92 35','07-98 92 47')
INSERT INTO CUSTOMERS VALUES('SEVES','Seven Seas Imports','Hari Kumar','Sales Manager','90 Wadhurst Rd.','London',NULL,'OX15 4NB','UK','(171) 555-1717','(171) 555-5646')
INSERT INTO CUSTOMERS VALUES('SIMOB','Simons bistro','Jytte Petersen','Owner','Vinbaltet 34','Kobenhavn',NULL,'1734','Denmark','31 12 34 56','31 13 35 57')
INSERT INTO CUSTOMERS VALUES('SPECD','Specialites du monde','Dominique Perrier','Marketing Manager','25, rue Lauriston','Paris',NULL,'75016','France','(1) 47.55.60.10','(1) 47.55.60.20')
INSERT INTO CUSTOMERS VALUES('SUPRD','Supremes delices','Pascale Cartrain','Accounting Manager','Boulevard Tirou, 255','Charleroi',NULL,'B-6000','Belgium','(071) 23 67 22 20','(071) 23 67 22 21')
INSERT INTO CUSTOMERS VALUES('TOMSP','Toms Spezialitaten','Karin Josephs','Marketing Manager','Luisenstr. 48','Munster',NULL,'44087','Germany','0251-031259','0251-035695')
INSERT INTO CUSTOMERS VALUES('TORTU','Tortuga Restaurante','Miguel Angel Paolino','Owner','Avda. Azteca 123','Mexico D.F.',NULL,'05033','Mexico','(5) 555-2933','N/A')
INSERT INTO CUSTOMERS VALUES('VAFFE','Vaffeljernet','Palle Ibsen','Sales Manager','Smagsloget 45','Arhus',NULL,'8200','Denmark','86 21 32 43','86 22 33 44')
INSERT INTO CUSTOMERS VALUES('VICTE','Victuailles en stock','Mary Saveley','Sales Agent','2, rue du Commerce','Lyon',NULL,'69004','France','78.32.54.86','78.32.54.87')
INSERT INTO CUSTOMERS VALUES('VINET','Vins et alcools Chevalier','Paul Henriot','Accounting Manager','59 rue de l''Abbaye','Reims',NULL,'51100','France','26.47.15.10','26.47.15.11')
INSERT INTO CUSTOMERS VALUES('WANDK','Die Wandernde Kuh','Rita Muller','Sales Representative','Adenauerallee 900','Stuttgart',NULL,'70563','Germany','0711-020361','0711-035428')
INSERT INTO CUSTOMERS VALUES('WARTH','Wartian Herkku','Pirkko Koskitalo','Accounting Manager','Torikatu 38','Oulu',NULL,'90110','Finland','981-443655','981-443655')
INSERT INTO CUSTOMERS VALUES('WILMK','Wilman Kala','Matti Karttunen','Owner/Marketing Assistant','Keskuskatu 45','Helsinki',NULL,'21240','Finland','90-224 8858','90-224 8858')
INSERT INTO CUSTOMERS VALUES('WOLZA','Wolski  Zajazd','Zbyszek Piestrzeniewicz','Owner','ul. Filtrowa 68','Warszawa',NULL,'01-012','Poland','(26) 642-7012','(26) 642-7012')

CREATE TABLE [Employees] (
	[EmployeeID] [int] IDENTITY (1, 1) NOT NULL ,
	[LastName] [nvarchar] (20) COLLATE Chinese_Taiwan_Stroke_CI_AS NOT NULL ,
	[FirstName] [nvarchar] (10) COLLATE Chinese_Taiwan_Stroke_CI_AS NOT NULL ,
	[Title] [nvarchar] (30) COLLATE Chinese_Taiwan_Stroke_CI_AS NULL ,
	[TitleOfCourtesy] [nvarchar] (25) COLLATE Chinese_Taiwan_Stroke_CI_AS NULL ,
	[BirthDate] [datetime] NULL ,
	[HireDate] [datetime] NULL ,
	[Address] [nvarchar] (60) COLLATE Chinese_Taiwan_Stroke_CI_AS NULL ,
	[City] [nvarchar] (15) COLLATE Chinese_Taiwan_Stroke_CI_AS NULL ,
	[Region] [nvarchar] (15) COLLATE Chinese_Taiwan_Stroke_CI_AS NULL ,
	[PostalCode] [nvarchar] (10) COLLATE Chinese_Taiwan_Stroke_CI_AS NULL ,
	[Country] [nvarchar] (15) COLLATE Chinese_Taiwan_Stroke_CI_AS NULL ,
	[HomePhone] [nvarchar] (24) COLLATE Chinese_Taiwan_Stroke_CI_AS NULL ,
	[Extension] [nvarchar] (4) COLLATE Chinese_Taiwan_Stroke_CI_AS NULL ,
	[Photo] [image] NULL ,
	[Notes] [ntext] COLLATE Chinese_Taiwan_Stroke_CI_AS NULL ,
	[ReportsTo] [int] NULL ,
	[PhotoPath] [nvarchar] (255) COLLATE Chinese_Taiwan_Stroke_CI_AS NULL ,
	CONSTRAINT [PK_Employees] PRIMARY KEY  CLUSTERED 
	(
		[EmployeeID]
	)  ON [PRIMARY] ,
	CONSTRAINT [FK_Employees_Employees] FOREIGN KEY 
	(
		[ReportsTo]
	) REFERENCES [Employees] (
		[EmployeeID]
	),
	CONSTRAINT [CK_Birthdate] CHECK ([BirthDate] < getdate())
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

SET IDENTITY_INSERT EMPLOYEES ON
INSERT INTO EMPLOYEES (EmployeeID, LastName, FirstName, Title, TitleOfCourtesy, BirthDate, HireDate, Address, City, Region, PostalCode, Country, HomePhone, Extension, Photo, Notes, ReportsTo, PhotoPath) VALUES(2,'Fuller','Andrew','Vice President, Sales','Dr.','1952/02/19','1992/08/14','908 W. Capital Way','Tacoma','WA','98401','USA','(206) 555-9482','3457',NULL,'Andrew received his BTS commer',NULL,'http://accweb/emmployees/fuller.bmp')

INSERT INTO EMPLOYEES (EmployeeID, LastName, FirstName, Title, TitleOfCourtesy, BirthDate, HireDate, Address, City, Region, PostalCode, Country, HomePhone, Extension, Photo, Notes, ReportsTo, PhotoPath) VALUES(1,'Davolio','Nancy','Sales Representative','Ms.','1948/12/08','1992/05/01','507 - 20th Ave. E. Apt. 2A','Seattle','WA','98122','USA','(206) 555-9857','5467',NULL,'Education includes a BA in psy',2,'http://accweb/emmployees/davolio.bmp')
INSERT INTO EMPLOYEES (EmployeeID, LastName, FirstName, Title, TitleOfCourtesy, BirthDate, HireDate, Address, City, Region, PostalCode, Country, HomePhone, Extension, Photo, Notes, ReportsTo, PhotoPath) VALUES(3,'Leverling','Janet','Sales Representative','Ms.','1963/08/30','1992/04/01','722 Moss Bay Blvd.','Kirkland','WA','98033','USA','(206) 555-3412','3355',NULL,'Janet has a BS degree in chemi',2,'http://accweb/emmployees/leverling.bmp')
INSERT INTO EMPLOYEES (EmployeeID, LastName, FirstName, Title, TitleOfCourtesy, BirthDate, HireDate, Address, City, Region, PostalCode, Country, HomePhone, Extension, Photo, Notes, ReportsTo, PhotoPath) VALUES(4,'Peacock','Margaret','Sales Representative','Mrs.','1937/09/19','1993/05/03','4110 Old Redmond Rd.','Redmond','WA','98052','USA','(206) 555-8122','5176',NULL,'Margaret holds a BA in English',2,'http://accweb/emmployees/peacock.bmp')
INSERT INTO EMPLOYEES (EmployeeID, LastName, FirstName, Title, TitleOfCourtesy, BirthDate, HireDate, Address, City, Region, PostalCode, Country, HomePhone, Extension, Photo, Notes, ReportsTo, PhotoPath) VALUES(5,'Buchanan','Steven','Sales Manager','Mr.','1955/03/04','1993/10/17','14 Garrett Hill','London','N/A','SW1 8JR','UK','(71) 555-4848','3453',NULL,'Steven Buchanan graduated from',2,'http://accweb/emmployees/buchanan.bmp')
INSERT INTO EMPLOYEES (EmployeeID, LastName, FirstName, Title, TitleOfCourtesy, BirthDate, HireDate, Address, City, Region, PostalCode, Country, HomePhone, Extension, Photo, Notes, ReportsTo, PhotoPath) VALUES(6,'Suyama','Michael','Sales Representative','Mr.','1963/07/02','1993/10/17','Coventry House Miner Rd.','London','N/A','EC2 7JR','UK','(71) 555-7773','428',NULL,'Michael is a graduate of Susse',5,'http://accweb/emmployees/davolio.bmp')
INSERT INTO EMPLOYEES (EmployeeID, LastName, FirstName, Title, TitleOfCourtesy, BirthDate, HireDate, Address, City, Region, PostalCode, Country, HomePhone, Extension, Photo, Notes, ReportsTo, PhotoPath) VALUES(7,'King','Robert','Sales Representative','Mr.','1960/05/29','1994/01/02','Edgeham Hollow Winchester Way','London','N/A','RG1 9SP','UK','(71) 555-5598','465',NULL,'Robert King served in the Peac',5,'http://accweb/emmployees/davolio.bmp')
INSERT INTO EMPLOYEES (EmployeeID, LastName, FirstName, Title, TitleOfCourtesy, BirthDate, HireDate, Address, City, Region, PostalCode, Country, HomePhone, Extension, Photo, Notes, ReportsTo, PhotoPath) VALUES(8,'Callahan','Laura','Inside Sales Coordinator','Ms.','1958/01/09','1994/03/05','4726 - 11th Ave. N.E.','Seattle','WA','98105','USA','(206) 555-1189','2344',NULL,'Laura received a BA in psychol',2,'http://accweb/emmployees/davolio.bmp')
INSERT INTO EMPLOYEES (EmployeeID, LastName, FirstName, Title, TitleOfCourtesy, BirthDate, HireDate, Address, City, Region, PostalCode, Country, HomePhone, Extension, Photo, Notes, ReportsTo, PhotoPath) VALUES(9,'Dodsworth','Anne','Sales Representative','Ms.','1966/01/27','1994/11/15','7 Houndstooth Rd.','London','N/A','WG2 7LT','UK','(71) 555-4444','452',NULL,'Anne has a BA degree in Englis',5,'http://accweb/emmployees/davolio.bmp')
SET IDENTITY_INSERT EMPLOYEES OFF

UPDATE EMPLOYEES SET REGION=NULL WHERE REGION='N/A'
GO