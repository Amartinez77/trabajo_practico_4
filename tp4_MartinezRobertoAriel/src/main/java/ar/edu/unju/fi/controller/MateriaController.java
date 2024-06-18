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
    
    /**
     * Maneja la solicitud POST para guardar una nueva materia.
     * 
     * Este método recibe los datos de una nueva materia desde el formulario y procesa
     * los identificadores del docente y la carrera seleccionados. Luego, busca las
     * instancias correspondientes de Docente y Carrera y las asigna a la materia.
     * Finalmente, agrega la materia a la colección de materias y retorna la vista
     * actualizada con el listado de materias.
     * 
     * @param materia El objeto Materia que se va a guardar.
     * @param docenteId El identificador del docente seleccionado en el formulario.
     * @param carreraId El identificador de la carrera seleccionada en el formulario.
     * @return Un objeto ModelAndView que contiene la vista "materias" y la lista de todas las materias.
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
    
    
    /**
     * Maneja la solicitud POST para modificar una materia existente.
     * 
     * Este método recibe los datos actualizados de una materia desde el formulario y 
     * procesa los identificadores del docente y la carrera seleccionados. Luego, busca 
     * las instancias correspondientes de Docente y Carrera y las asigna a la materia.
     * Finalmente, actualiza la materia en la colección de materias y redirige al usuario
     * a la página de listado de materias.
     * 
     * @param materia El objeto Materia que se va a modificar.
     * @param docenteId El identificador del docente seleccionado en el formulario.
     * @param carreraId El identificador de la carrera seleccionada en el formulario.
     * @return Una cadena que redirige a la página de listado de materias.
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