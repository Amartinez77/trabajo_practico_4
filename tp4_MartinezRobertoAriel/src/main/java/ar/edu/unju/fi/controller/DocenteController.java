package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.CollectionDocente;
import ar.edu.unju.fi.model.Docente;

@Controller
@RequestMapping("/docente")
public class DocenteController {

    @Autowired
    private Docente docente;

    @GetMapping("/listado")
    public String getDocentesPage(Model model) {
        model.addAttribute("docentes", CollectionDocente.getDocentes());
        model.addAttribute("titulo", "Listado de Docentes");
        return "docentes";
    }

    @GetMapping("/nuevo")
    public String getNuevoDocentePage(Model model) {
        boolean edicion = false;
        model.addAttribute("docente", docente);
        model.addAttribute("edicion", edicion);
        model.addAttribute("titulo", "Nuevo Docente");
        return "docente";
    }

    @PostMapping("/guardar")
    public ModelAndView postGuardarDocente(@ModelAttribute("docente") Docente docente) {
        ModelAndView modelView = new ModelAndView("docentes");
        CollectionDocente.agregarDocente(docente);
        modelView.addObject("docentes", CollectionDocente.getDocentes());
        return modelView;
    }

    @GetMapping("/modificar/{legajo}")
    public String getModificarDocentePage(Model model, @PathVariable(value = "legajo") Integer legajo) {
        System.out.println("Legajo recibido: " + legajo);
        Docente docenteEncontrado = CollectionDocente.buscarDocente(legajo);
        if (docenteEncontrado != null) {
            System.out.println("Docente encontrado: " + docenteEncontrado.getNombre());
            model.addAttribute("docente", docenteEncontrado);
            model.addAttribute("edicion", true);
            model.addAttribute("titulo", "Modificar Docente");
            return "docente";
        }
        System.out.println("Docente no encontrado, redirigiendo a listado");
        return "redirect:/docente/listado";
    }

    @PostMapping("/modificar")
    public String modificarDocente(@ModelAttribute("docente") Docente docente) {
        CollectionDocente.modificarDocente(docente);
        return "redirect:/docente/listado";
    }

    @GetMapping("/eliminar/{legajo}")
    public String eliminarDocente(@PathVariable(value = "legajo") Integer legajo) {
        CollectionDocente.eliminarDocente(legajo);
        return "redirect:/docente/listado";
    }
}

