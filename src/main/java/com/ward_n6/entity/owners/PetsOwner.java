package com.ward_n6.entity.owners;
import com.ward_n6.entity.pets.Pet;
import com.ward_n6.enums.PetsSex;
import com.ward_n6.enums.PetsType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


    @Entity
    @NoArgsConstructor
    @Table(name = "pets_owner")
    @Getter
    @Setter
    public abstract class PetsOwner {

        @javax.persistence.Id
        @Column(name = "id",nullable = false)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "owner", insertable = false, updatable = false)
        private Owner owner;

        @ManyToOne
        @JoinColumn(name = "pet", insertable = false, updatable = false)
        private Pet pet;

        @Column(name = "start_date")
        private LocalDate startDate;

        @Column(name = "end_date")
        private LocalDate endDate;

        public PetsOwner(Owner owner, Pet pet) {
            this.owner = owner;
            this.pet = pet;
        }

        public PetsOwner(Owner owner, Pet pet, LocalDate startDate, LocalDate endDate) {
            this.owner = owner;
            this.pet = pet;
            this.startDate = startDate;
            this.endDate = endDate;
        }
    }
