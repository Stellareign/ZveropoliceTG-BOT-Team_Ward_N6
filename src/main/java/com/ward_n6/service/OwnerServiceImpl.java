package com.ward_n6.service;

import com.ward_n6.entity.owners.Owner;
import com.ward_n6.exception.DeleteFromMapException;
import com.ward_n6.exception.EditMapException;
import com.ward_n6.repository.OwnerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Repository
public class OwnerServiceImpl implements com.ward_n6.service.interfaces.OwnerService {
    private final OwnerRepository ownerRepository;
    private Map<Integer, Owner> ownerMap = new HashMap<>();
    private int mapId = 0;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }


    @Override
    public Owner addOwner(Owner owner) {
        if (owner.equals(null))
            throw new NullPointerException("ОШИБКА при попытке добавить owner=Null в МАПу ownerMap");
        ownerMap.putIfAbsent(mapId++, owner);
        return owner;
    }

    @Override

    public Owner addOwnerToDB(Owner owner) {
        try {
            // Создаем подключение к базе данных
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:5432/postgres",
                    "postgres", "Sql2374");

            // Создаем запрос на добавление записи в таблицу:
            String query = "INSERT INTO owner (first_Name, last_Name, owner_Phone) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, owner.getFirstName());
            statement.setString(2, owner.getLastName());
            statement.setString(3, owner.getPhoneNumber());

            // Выполняем запрос и закрываем соединение:
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (
                SQLException e) {
            System.out.println("Ошибка при добавлении записи в базу данных: " + e.getMessage());
        }
        return owner;
    }

    @Override
    public Owner getOwnerById(int recordId) {
        return ownerMap.get(recordId);
    }

    @Override
    public List<Owner> getAllOwners() {
        return new ArrayList<>(ownerMap.values());
    }


    public Owner editOwnerById(int recordId, Owner owner) throws EditMapException {
        if (ownerMap.containsKey(recordId)) {
            ownerMap.put(recordId, owner);
            if (!ownerMap.get(recordId).equals(owner)) {
                throw new EditMapException("ОШИБКА при попытке изменить запись о госте "
                        + owner.getFirstName() + " " + owner.getLastName() + " в МАПе ownerMap под id=" + recordId);
            }
            return null;
        }
        return ownerMap.get(recordId);
    }

    @Override
    public void deleteAllFromOwner() {
        ownerMap.clear();
    }

    @Override
    public boolean deleteOwnerById(int recordId) throws DeleteFromMapException {
        if (ownerMap.containsKey(recordId)) {
            ownerMap.remove(recordId);
            return true;
        }
        throw new DeleteFromMapException("ОШИБКА при попытке удалить запись о госте в МАПе ownerMap под id=" + recordId);
    }

    @Override
    public boolean deleteOwnerByValue(Owner owner) throws DeleteFromMapException {
        if (ownerMap.containsValue(owner)) {
            ownerMap.values().remove(owner);
            return true;
        }
        throw new DeleteFromMapException("ОШИБКА при попытке удалить запись о госте "
                + owner.getFirstName() + " " + owner.getLastName() + " из МАПы ownerMap");
    }

    @Override
    public int idOwnerByValue(Owner owner) {
        for (Map.Entry<Integer, Owner> entry : ownerMap.entrySet())
            if (entry.getValue().equals(owner)) return entry.getKey();
        return -1;
    }

    @Override
    public int getId() {
        return mapId;
    }


    public List<Owner> findAll() {
        return null;
    }


    public List<Owner> findAll(Sort sort) {
        return null;
    }


    public Page<Owner> findAll(Pageable pageable) {
        return null;
    }


    public List<Owner> findAllById(Iterable<Long> longs) {
        return null;
    }


    public long count() {
        return 0;
    }


    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);

    }


    public void delete(Owner entity) {

    }


    public void deleteAllById(Iterable<? extends Long> longs) {

    }


    public void deleteAll(Iterable<? extends Owner> entities) {

    }


    public void deleteAll() {

    }

    public void save(Owner owner) {
        ownerRepository.save(owner);
    }
Owner owner;
    public Owner getOwnerById (long ownerId){
        return owner = ownerRepository.getById(ownerId);
    }
}