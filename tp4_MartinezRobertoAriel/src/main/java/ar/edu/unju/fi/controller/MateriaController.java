package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.CollectionMateria;
import ar.edu.unju.fi.collections.CollectionDocente;
import ar.edu.unju.fi.collections.CollectionCarrera;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Carrera;

import java.util.List;

@Controller
@RequestMapping("/materia")
public class MateriaController {

    @Autowired
    private Materia materia;

    @GetMapping("/listado")
    public String getMateriasPage(Model model) {
        model.addAttribute("materias", CollectionMateria.getMaterias());
        model.addAttribute("titulo", "Listado de Materias");
        return "materias";
    }

    @GetMapping("/nuevo")
    public String getNuevaMateriaPage(Model model) {
        boolean edicion = false;
        List<Docente> docentes = CollectionDocente.getDocentes();
        List<Carrera> carreras = CollectionCarrera.getCarreras();
        
        model.addAttribute("materia", materia);
        model.addAttribute("edicion", edicion);
        model.addAttribute("docentes", docentes);
        model.addAttribute("carreras", carreras);
        model.addAttribute("titulo", "Nueva Materia");
        return "materia";
    }

    /* 
    @PostMapping("/guardar")
    public ModelAndView postGuardarMateria(@ModelAttribute("materia") Materia materia) {
        ModelAndView modelView = new ModelAndView("materias");
        CollectionMateria.agregarMateria(materia);
        modelView.addObject("materias", CollectionMateria.getMaterias());
        return modelView;
    }
    
    */
    
    @PostMapping("/guardar")
    public ModelAndView postGuardarMateria(@ModelAttribute("materia") Materia materia, @RequestParam("docenteId") Integer docenteId, @RequestParam("carreraId") Integer carreraId) {
        ModelAndView modelView = new ModelAndView("materias");

        // Busca el docente y la carrera usando los IDs
        Docente docente = CollectionDocente.buscarDocente(docenteId);
        Carrera carrera = CollectionCarrera.buscarCarrera(carreraId);

        // Asigna el docente y la carrera a la materia
        materia.setDocente(docente);
        materia.setCarrera(carrera);

        // Guarda la materia
        CollectionMateria.agregarMateria(materia);
        modelView.addObject("materias", CollectionMateria.getMaterias());
        return modelView;
    }

    @GetMapping("/modificar/{codigo}")
    public String getModificarMateriaPage(Model model, @PathVariable(value = "codigo") String codigo) {
        Materia materiaEncontrada = CollectionMateria.buscarMateria(codigo);
        boolean edicion = true;
        List<Docente> docentes = CollectionDocente.getDocentes();
        List<Carrera> carreras = CollectionCarrera.getCarreras();

        model.addAttribute("edicion", edicion);
        model.addAttribute("materia", materiaEncontrada);
        model.addAttribute("docentes", docentes);
        model.addAttribute("carreras", carreras);
        model.addAttribute("titulo", "Modificar Materia");
        return "materia";
    }

    /*
    @PostMapping("/modificar")
    public String modificarMateria(@ModelAttribute("materia") Materia materia) {
        CollectionMateria.modificarMateria(materia);
        return "redirect:/materia/listado";
    }
    
    */
    
    
    @PostMapping("/modificar")
    public String modificarMateria(@ModelAttribute("materia") Materia materia, @RequestParam("docenteId") Integer docenteId, @RequestParam("carreraId") Integer carreraId) {
        // Busca el docente y la carrera usando los IDs
        Docente docente = CollectionDocente.buscarDocente(docenteId);
        Carrera carrera = CollectionCarrera.buscarCarrera(carreraId);

        // Asigna el docente y la carrera a la materia
        materia.setDocente(docente);
        materia.setCarrera(carrera);

        // Modifica la materia
        CollectionMateria.modificarMateria(materia);
        return "redirect:/materia/listado";
    }

    @GetMapping("/eliminar/{codigo}")
    public String eliminarMateria(@PathVariable(value = "codigo") String codigo) {
        CollectionMateria.eliminarMateria(codigo);
        return "redirect:/materia/listado";
    }
}