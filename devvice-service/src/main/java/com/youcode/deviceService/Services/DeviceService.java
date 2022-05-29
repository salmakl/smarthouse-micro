package com.youcode.deviceService.Services;

import com.youcode.deviceService.entities.Device;
import com.youcode.deviceService.repositories.DeviceRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@AllArgsConstructor
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public List<Device> getAll() {
        try {
            log.info("get all devices");
            return deviceRepository.findAll();
        } catch (Exception e) {
            log.error("error getting all devices {}", e.getMessage());
            return null;
        }
    }

    public Device create(Device device) {
        try {
            log.info("create device {}", device.getId());
            deviceRepository.save(device);
            return device;
        } catch (Exception e) {
            log.error("error creating device {}", e.getMessage());
            return null;
        }
    }

    public Device getDevice(String id) {
        try {
            log.info("get device {}", id);
            return deviceRepository.findById(id).orElseThrow(() -> new RuntimeException("Device not found"));
        } catch (Exception e) {
            log.error("error getting device {}", e.getMessage());
            return null;
        }

    }

    public Device update(Device device) {
        try {
            log.info("update device {}", device.getId());
            deviceRepository.save(device);
            return device;
        } catch (Exception e) {
            log.error("error updating device {}", e.getMessage());
            return null;
        }
    }


    public String delete(String id) {
        try {
            log.info("delete device {}", id);
            deviceRepository.deleteById(id);
            return "Device deleted";
        } catch (Exception e) {
            log.error("error deleting device {}", e.getMessage());
            return "Error deleting device";
        }
    }

}

