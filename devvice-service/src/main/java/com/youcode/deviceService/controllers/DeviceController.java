package com.youcode.deviceService.controllers;

import com.youcode.deviceService.Services.DeviceService;
import com.youcode.deviceService.entities.Device;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/V1/device")
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @GetMapping
    public List<Device> getAll(){
        log.info("Retrieving data");
        return deviceService.getAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Device device){
        log.info("Adding data");
        deviceService.create(device);
    }


    @DeleteMapping
    public void delete(@RequestParam String id){
        log.warn("device deleted");
        deviceService.delete(id);
    }


}