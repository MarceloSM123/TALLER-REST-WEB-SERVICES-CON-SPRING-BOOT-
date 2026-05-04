package com.krakedev.asistencias.services;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

import com.krakedev.asistencias.entidades.Estudiante;

@Service
public class ServicioEstudiantes {
	 private ArrayList<Estudiante> estudiantes = new ArrayList<>();
	    
	    
	    public void agregar(Estudiante estudiante) {
	        
	        for (Estudiante e : estudiantes) {
	            if (e.getCedula().equals(estudiante.getCedula())) {
	                throw new RuntimeException("Ya existe un estudiante con la cédula: " + estudiante.getCedula());
	            }
	        }
	        estudiantes.add(estudiante);
	    }
	    
	    public Estudiante buscarPorCedula(String cedula) {
	        for (Estudiante e : estudiantes) {
	            if (e.getCedula().equals(cedula)) {
	                return e;
	            }
	        }
	        return null;
	    }
	    
	    public void eliminar(String cedula) {
	        Estudiante estudiante = buscarPorCedula(cedula);
	        if (estudiante != null) {
	            estudiantes.remove(estudiante);
	        } else {
	            throw new RuntimeException("No existe estudiante con cédula: " + cedula);
	        }
	    }
	    
	    public void actualizar(String cedula, Estudiante nuevo) {
	        Estudiante estudiante = buscarPorCedula(cedula);
	        if (estudiante != null) {
	            estudiante.setNombre(nuevo.getNombre());
	            estudiante.setApellido(nuevo.getApellido());
	        } else {
	            throw new RuntimeException("No existe estudiante con cédula: " + cedula);
	        }
	    }
	    
	    public ArrayList<Estudiante> listar() {
	        return estudiantes;
	    }
}
