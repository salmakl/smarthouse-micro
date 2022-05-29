package com.youcode.deviceService.repositories;

import com.youcode.deviceService.entities.Device;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeviceRepository extends MongoRepository<Device,String> {
}