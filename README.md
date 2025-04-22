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

======================
Why We Use @JsonIgnore
======================
➤ Main Purpose:
@JsonIgnore is used to exclude a property from JSON serialization and deserialization.

When you're exposing your entity as JSON (e.g., in a REST API response), you might not want to include certain fields—like sensitive data or fields that cause infinite recursion.

The Recursive Problem in Bidirectional Relationships:->
Entities :
@Entity
public class Student {
    @Id
    private Long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
}

@Entity
public class Address {
    @Id
    private Long id;
    private String city;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Student student; // 👈
}

❗ Problem Without @JsonIgnore
When you try to return a Student from a REST API:

Student → Address is serialized.
Then Address → Student is serialized again.
That again leads to Student → Address.
… and so on → ❌ Infinite Recursion!

Which causes:
com.fasterxml.jackson.databind.JsonMappingException:
Infinite recursion (StackOverflowError)

✅ How @JsonIgnore Solves It
------------------------------
@OneToOne(mappedBy = "address")
@JsonIgnore
private Student student;

This tells Jackson:
“Hey, don’t try to serialize this student field when converting Address to JSON.”

So, when serializing:
Student → Address gets serialized.
Address → Student is ignored due to @JsonIgnore.

💡 Result: No infinite loop. ✅ JSON is clean and API is stable.

===========================================
🚀 Why Do We Use DTOs Instead of Entities?
===========================================
1. Separation of Concerns
Entities represent the database structure (tables, relations).

🔐 2. Security Reasons
You don’t want to expose your full entity (like passwords, internal IDs, timestamps, etc.) to the outside world.
// Entity
class User {
    private Long id;
    private String name;
    private String email;
    private String password;
}
// Response DTO
class UserResponseDTO {
    private String name;
    private String email;
}

🛠 3. Custom Request Shapes
Sometimes, your API request/response shape doesn't match your entity.
// Request payload to register a user
{
    "name": "Akash",
    "email": "akash@example.com",
    "password": "xyz123",
    "confirmPassword": "xyz123"
}

This kind of structure doesn't map directly to an entity—confirmPassword is just for validation. Hence, you use a Request DTO.

🔄 4. Better Control Over Data Flow
Using DTOs allows you to:
-> Add computed fields (e.g., fullName = firstName + " " + lastName)
-> Format dates
-> Map nested entities to flat fields or vice versa