Instructions to Run:

I have created one sh file having below commands:

mvn clean install -DskipTests

java -jar target/parkingLot.jar $1

You can run the sh file it in two ways in mac:
1) sh parking_lot
which will be running in interactive mode
2) sh parking_lot "filename" 
which will be running the code after reading from "filename"

Sample Input:

create_parking_lot 6

park KA-01-HH-1234 White

park KA-01-HH-9999 White

park KA-01-BB-0001 Black

park KA-01-HH-7777 Red

park KA-01-HH-2701 Blue

park KA-01-HH-3141 Black

leave 4

status

park KA-01-P-333 White

park DL-12-AA-9999 White

registration_numbers_for_cars_with_colour White

slot_numbers_for_cars_with_colour White

slot_number_for_registration_number KA-01-HH-3141

slot_number_for_registration_number MH-04-AY-1111

Sample Output:

Created a parking lot with 6 slots

Allocated Slot Number: 1

Allocated Slot Number: 2

Allocated Slot Number: 3

Allocated Slot Number: 4

Allocated Slot Number: 5

Allocated Slot Number: 6

Slot number 4 is free

Slot No	Registration No	Colour

1	KA-01-HH-1234	White

2	KA-01-HH-9999	White

3	KA-01-BB-0001	Black

5	KA-01-HH-2701	Blue

6	KA-01-HH-3141	Black

Allocated Slot Number: 4

Sorry, parking lot is full

KA-01-HH-1234, KA-01-HH-9999, KA-01-P-333

1, 2, 4

6

Not found

If you want the unit tests also to run while running the sh file just change mvn clean install -DskipTests to mvn clean install inside parking_lot sh file.


Environment Requirements:
1. JDK 8
2. Maven
3. Junit 5


