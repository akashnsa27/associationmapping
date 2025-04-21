# One-to-One Association Mapping 

One-to-One Mapping
===================
Use Case:
One Student has one Address.
One Address belongs to only one Student 

1. @OneToOne
This annotation is used to map a one-to-one relationship between two entities.

2. @JoinColumn
Defines the foreign key column in the owning table (here: Student).
Student is the owning side of the relationship. The foreign key column address_id will be created in the student table

3. mappedBy
Indicates that the relationship is bidirectional and is mapped by the other entity.
This side is the inverse side (doesn’t hold the foreign key).
No @JoinColumn here.

4. cascade = CascadeType.ALL: Any operation on Student (save/delete/update) will also apply to Address.

5. fetch = FetchType.EAGER: When we fetch a student, it will also fetch its associated address.

====Create SpringBoot application with below Dependencies=====
Spring Web
Spring Data Jpa
Postgress Driver
