package net.itinajero.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.itinajero.model.Vehiculo;
;

public interface IVehiculoService {

	void guardar(Vehiculo infoVehiculo);
	void eliminar(Integer idVehiculo);
	List<Vehiculo> buscarTodas();
	Vehiculo buscarPorId(Integer idVehiculo);
	Page<Vehiculo> buscarTodas(Pageable page);
}
