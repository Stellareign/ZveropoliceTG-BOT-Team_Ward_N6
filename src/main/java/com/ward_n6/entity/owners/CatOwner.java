package com.ward_n6.entity.owners;

//@Entity
//@Table(name = "cat_owner") // отдельная таблица
//@PrimaryKeyJoinColumn(name = "pets_type")
//@DiscriminatorValue("pets_type")
//@NoArgsConstructor
//@AllArgsConstructor

public class CatOwner extends  Owner{
    public CatOwner(Long id, String firstName, String lastName, String phoneNumber) {
        super(id, firstName, lastName, phoneNumber);
    }

    public CatOwner() {
    }
}
