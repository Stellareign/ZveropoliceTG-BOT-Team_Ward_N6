package com.ward_n6.entity.owners;
<<<<<<< HEAD
=======

>>>>>>> origin/feture-TimurA
import com.ward_n6.entity.pets.Pet;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
<<<<<<< HEAD
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
=======

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
>>>>>>> origin/feture-TimurA

@Entity
@NoArgsConstructor
@Table(name = "pet_owners")
@Getter
@Setter
<<<<<<< HEAD
@Inheritance(strategy = InheritanceType.JOINED) // позволяет классам наследникам сопоставляться со своей собственной таблицей
=======
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // позволяет классам наследникам сопоставляться со своей собственной таблицей
>>>>>>> origin/feture-TimurA
// общий класс для владельцев (нужно ли его делать АБСТРАКТНЫМ?)
public abstract class PetOwner { // хозяин животного, его свойства
// закончился испыталка? что делать
    // через сколько времени удалять из базы
    // нужен ли чёрный список усыновителей

<<<<<<< HEAD

=======
>>>>>>> origin/feture-TimurA
    @javax.persistence.Id
    @Column(name = "owner_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

<<<<<<< HEAD
//    @Column(name = "owner_id",nullable = false)
//    private long ownerId;


=======
>>>>>>> origin/feture-TimurA
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "owner_phone")
    private String phoneNumber;

<<<<<<< HEAD
    private String eMale;

    @Column(name = "adoption_start_date")
    private LocalDateTime dateOfPetAdoption;
    private LocalDateTime endOfOwnerProbationPeriod;
    private boolean probationPeriodIsPositive;

   @OneToMany(mappedBy = "petOwner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pet> petOwnersList = new ArrayList<>();

    public PetOwner(int ownerId, String firstName, String lastName, List<Pet> petOwnersList) {
       // this.ownerId = ownerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.petOwnersList = petOwnersList;
    }


    public Long getId() {
        return id;
    }
//    public long getOwnerId() {
//        return ownerId;
//    }
//
//    public PetOwner setOwnerId(int ownerId) {
//        this.ownerId = ownerId;
//        return this;
//    }

    public String getFirstName() {
        return firstName;
    }

    public PetOwner setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public PetOwner setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public List<Pet> getPetOwnersList() {
        return petOwnersList;
    }

    public PetOwner setPetOwnersList(List<Pet> petOwnersList) {
        this.petOwnersList = petOwnersList;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public PetOwner setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEMale() {
        return eMale;
    }

    public PetOwner setEMale(String eMale) {
        this.eMale = eMale;
        return this;
    }

    public LocalDateTime getDateOfPetAdoption() {
        return dateOfPetAdoption;
    }


    public LocalDateTime getEndOfOwnerProbationPeriod() {
        return endOfOwnerProbationPeriod;
    }

    public PetOwner setEndOfOwnerProbationPeriod(LocalDateTime endOfOwnerProbationPeriod) {
        this.endOfOwnerProbationPeriod = endOfOwnerProbationPeriod;
        return this;
=======
//    private String eMale;

//    @Column(name = "adoption_start_date")
//    private LocalDateTime dateOfPetAdoption;
//    private LocalDateTime endOfOwnerProbationPeriod;
//    private boolean probationPeriodIsPositive;

    @OneToMany(mappedBy = "petOwner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pet> petsOfOwnerList = new ArrayList<>();
//    @Column(name = "pets_type")
//    private PetsType petsType;


    public PetOwner(Long id, String firstName, String lastName, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
>>>>>>> origin/feture-TimurA
    }



<<<<<<< HEAD
    public boolean isProbationPeriodIsPositive() {
        return probationPeriodIsPositive;
    }

    public PetOwner setProbationPeriodIsPositive(boolean probationPeriodIsPositive) {
        this.probationPeriodIsPositive = probationPeriodIsPositive;
        return this;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof PetOwner)) return false;
//        PetOwner petOwner = (PetOwner) o;
//        return getOwnerId() == petOwner.getOwnerId() && Objects.equals(getFirstName(), petOwner.getFirstName()) && Objects.equals(getLastName(), petOwner.getLastName()) && Objects.equals(getPhoneNumber(), petOwner.getPhoneNumber());
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(getOwnerId(), getFirstName(), getLastName(), getPhoneNumber());
//    }

    @Override
    public String toString() {
        return "PetOwner{" +
                "ownerId=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", eMale='" + eMale +
                ", pets=" + petOwnersList + '\'' +
                '}';
    }

=======

//    @Override
//    public String toString() {
//        return "PetOwner{" +
//                "ownerId=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                ", eMale='" + eMale +
//                ", pets=" + petsOfOwnerList + '\'' +
//                '}';
//    }

>>>>>>> origin/feture-TimurA

    public void setId(Long id) {
        this.id = id;
    }


}
