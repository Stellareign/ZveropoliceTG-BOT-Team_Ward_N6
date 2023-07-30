package entity.shelters;

import entity.pets.Pet;

import java.util.Map;

public class DogsShelter extends PetShelter{
    private String takeDog = getTakePet() +
            "<b>Рекомендации по транспортировке:</b> Собак всех возрастов рекомендуется НЕ кормить перед поездкой. Последний прием пищи за 10-12 часов. Собаки маленьких пород перевозятся в специальных переносках. Собаки средних и крупных пород перевозятся в специальных авто-гамаках, либо также в переносках. " +
            "<b>Рекомендации по обустройству дома для животного:</b> Щенки: необходимо обустроить его место (лежанка, коврик) и снабдить его игрушками, в т.ч. «грызунками» (на период прорезывания зубов). Также необходимо разместить миски для корма и воды. " +
            "Взрослые собаки: необходимо обустроить место (лежанка, коврик) и снабдить его игрушками. Также необходимо разместить миски для корма и воды. " +
            "<b>Для получения рекомендаций по работе с кинологом, пожалуйста, обращайтесь к Борису, +77894561230.</b> " +
            getProhibitedTakePet();
    public DogsShelter(String shelterName, String shelterAdress, Map<Integer, Pet> petsInSelter) {
        super(shelterName, shelterAdress, petsInSelter);
    }

    public DogsShelter() {
    }
}
