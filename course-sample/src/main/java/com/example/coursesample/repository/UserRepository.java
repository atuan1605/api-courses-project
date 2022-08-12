package com.example.coursesample.repository;

import com.example.coursesample.database.FakeDB;
import com.example.coursesample.model.Supporter;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public Supporter getSupporter(int id){
        return FakeDB.supporters.stream()
                .filter(supporter -> supporter.getId()==id)
                .findFirst().get();
    }
}
