package com.fixingsolutions.serviceType.service;

import com.fixingsolutions.serviceType.ServiceTypeMapper;
import com.fixingsolutions.serviceType.dto.request.CreateServiceTypeRequest;
import com.fixingsolutions.serviceType.dto.request.UpdateServiceTypeRequest;
import com.fixingsolutions.serviceType.dto.response.ServiceTypeResponse;
import com.fixingsolutions.serviceType.entity.ServiceType;
import com.fixingsolutions.serviceType.repository.ServiceTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ServiceTypeService {

    private ServiceTypeRepository serviceTypeRepository;

    public ServiceTypeResponse createServiceType(CreateServiceTypeRequest request) {
        var serviceType = serviceTypeRepository
                .save(ServiceTypeMapper.buildNewServiceType(request.getDescription(), request.getValue()));
        return ServiceTypeMapper.serviceTypeResponse(serviceType);
    }

    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }

    public void delete(Integer id) throws Exception {
        var serviceType = findById(id);
        serviceTypeRepository.delete(serviceType);
    }

    public ServiceType findById(Integer id) throws Exception {
        return serviceTypeRepository.findById(id)
                .orElseThrow(() -> new Exception("No service type found"));
    }

    public ServiceTypeResponse update(UpdateServiceTypeRequest request) throws Exception {
        var serviceType = findById(request.getId());
        serviceType.setDescription(request.getDescription());
        serviceType.setValue(request.getValue());
        return ServiceTypeMapper.serviceTypeResponse(serviceTypeRepository.save(serviceType));
    }
}
