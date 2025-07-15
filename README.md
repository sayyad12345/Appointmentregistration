💻 Created By: 1.Dhiraj Kajale 2.Aryan Deshmukhe

# 🩺 Patient Appointment Registration System
A Java console application that demonstrates basic appointment booking operations using Hibernate (JPA).
Users can register, book appointments, view all appointments, and manage records — all via a clean command-line interface.

# 🚀 Features
🧍 Patient Registration: Register new patients with basic info (name, contact, address).

📅 Book Appointment: Schedule an appointment with date and time.

📋 View Appointments: See all stored appointments from the database.

❌ Cancel Appointment: Delete appointments by ID.

🧾 Auto ID Management: Appointment IDs are generated automatically.

# 🛠️ Technologies Used
1.Java 17+

2.Hibernate (JPA)

3.MySQL/PostgreSQL	

4.Maven

5.Console I/O

# Structure

![Appointment Screen](https://github.com/sayyad12345/Appointmentregistration/blob/main/Structure%20(2).png)


# ⚙️ Setup Instructions

1.Database Setup Create a database called apointmentdetails.
Ensure tables for menu, orders, and users exist or let Hibernate create them.

2.Configure persistence.xml Place the following config under src/main/resources/META-INF/persistence.xml:
xml

# persistent file

<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="https://jakarta.ee/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="https://jakarta.ee/xml/ns/persistence https://jakarta.ee/xml/ns/persistence/persistence_3_0.xsd"
             version="3.0">
    <persistence-unit name="myPersistence" transaction-type="RESOURCE_LOCAL">
        
       <class>entity.ApointmentEntity</class>
        <properties>
            <property name="jakarta.persistence.jdbc.driver" value="org.postgresql.Driver"/>
            <property name="jakarta.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/sayyad"/>
            <property name="jakarta.persistence.jdbc.user" value="postgres"/>
            <property name="jakarta.persistence.jdbc.password" value="123"/>
            <property name="hibernate.dialect" value="org.hibernate.dialect.PostgreSQLDialect"/>
            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.format_sql" value="true"/>
            <property name="jakarta.persistence.schema-generation.database.action" value="update"/>
        </properties>
    </persistence-unit>
</persistence>

# Output
![Appointment Screen](https://github.com/sayyad12345/Appointmentregistration/blob/main/Output1.png)
![Appointment Screen]()

