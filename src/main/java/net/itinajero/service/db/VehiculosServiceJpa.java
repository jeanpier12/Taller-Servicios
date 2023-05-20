package net.itinajero.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import net.itinajero.model.Vehiculo;
import net.itinajero.repository.VehiculosRepository;
import net.itinajero.service.IVehiculoService;
@Service
public class VehiculosServiceJpa implements IVehiculoService {
	
	@Autowired
	private VehiculosRepository VehiculoRepo;

	//Guarda el vehicuo en el base de datos 
	@Override
	public void guardar(Vehiculo infoVehiculo) {
		VehiculoRepo.save(infoVehiculo);
		
	}

	@Override
	public void eliminar(Integer idVehiculo) {
		VehiculoRepo.deleteById(idVehiculo);
		
	}

	@Override
	public List<Vehiculo> buscarTodas() {
		
		return VehiculoRepo.findAll();
	}

	@Override
	public Vehiculo buscarPorId(Integer idVehiculo) {
		Optional<Vehiculo> optional = VehiculoRepo.findById(idVehiculo);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public Page<Vehiculo> buscarTodas(Pageable page) {
		
		return VehiculoRepo.findAll(page);
	}

	
}
