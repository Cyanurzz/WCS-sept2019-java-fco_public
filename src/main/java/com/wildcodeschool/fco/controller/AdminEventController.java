package com.wildcodeschool.fco.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.wildcodeschool.fco.entity.Entrant;
import com.wildcodeschool.fco.entity.Event;
import com.wildcodeschool.fco.repository.ClientRepository;
import com.wildcodeschool.fco.repository.EventRepository;
import com.wildcodeschool.fco.repository.MessageRepository;
import com.wildcodeschool.fco.service.FileUpload;
import com.wildcodeschool.fco.service.FormatDate;

@Controller
public class AdminEventController {
	
	private String DIR = "photoEvent";
	
	@Autowired
	private FileUpload fileUpload;
	
	@Autowired
	private FormatDate formatDate;
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private MessageRepository messageRepository;
	
    @Autowired
    private ClientRepository clientRepository;
	
	@GetMapping("/admin/event")
	public String toEventAdmin(Model model) {
		model.addAttribute("orderCount", clientRepository.findByIsValid(false).size()); 
		model.addAttribute("messageCount", messageRepository.count());
		model.addAttribute("events", eventRepository.findAll());
		return "adminEvent";
	}
	
	@GetMapping("/admin/event/delete{id}")
	private String removeEvent(RedirectAttributes redirAttrs, @PathVariable Integer id) {
		Event eventToDelete = eventRepository.findById(id).get();
		fileUpload.deleteFile(eventToDelete.getPicture());
		eventRepository.delete(eventToDelete);
		redirAttrs.addFlashAttribute("successMessage", "L'évènement a bien été supprimé.");
		return "redirect:/admin/event";
	}
	
	@GetMapping("/admin/event/update")
	private String toUpdateEvent(Model model, @RequestParam (required = false) Integer id) {
		Event event = new Event();
		if (id != null) {
			Optional<Event> optionalEvent = eventRepository.findById(id);
        	if (optionalEvent.isPresent()) {
        		event = optionalEvent.get();
        	}
		}
        model.addAttribute("messageCount", messageRepository.count());
        model.addAttribute("event", event);
		return "adminEventUpdate";
	}
	
	@PostMapping("/admin/event/update")
	private String eventUpdate(
			RedirectAttributes redirAttrs,
			@RequestParam ("id") Integer id,
			@RequestParam ("title") String title,
			@RequestParam ("picture") MultipartFile imageFile,
			@RequestParam ("content") String content,
			@RequestParam ("date") String eventDate,
			@RequestParam ("time") String eventHour,
			@RequestParam ("places") Integer places
			) {
		Date date = formatDate.dateAndTimeToFull(eventDate, eventHour);
		String path = "";
		if (id != null) {
			path = eventRepository.findById(id).get().getPicture();
		}
		if (!imageFile.isEmpty()) {
			String fileName = "event_" + title.replaceAll(" ", "_").toLowerCase();
			path = fileUpload.writeFile(imageFile, DIR, fileName);
		}
		Event event = new Event(id, title, path, content, date, places);
		eventRepository.save(event);
		if (id != null) {
			redirAttrs.addFlashAttribute("successMessage", "L'évènement a bien été modifié.");
		} else {
			redirAttrs.addFlashAttribute("successMessage", "L'évènement a bien été ajouté.");
		}
		
		return "redirect:/admin/event";
	}
	
	@GetMapping("/admin/event/{id}/registered")
	public String toEventRegistered(@PathVariable Integer id, Model model) {
		model.addAttribute("event", eventRepository.findById(id).get());
		return "eventRegistered";
	}
	
	@GetMapping("/download/inscriptions.csv")
	public void downloadCsv(HttpServletResponse response, @RequestParam Integer id) throws IOException {
		String fileName = "inscriptions.csv";
		List<Entrant> entrants = eventRepository.findById(id).get().getEntrants();
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; file=" + fileName);
		
        StatefulBeanToCsv<Entrant> writer = new StatefulBeanToCsvBuilder<Entrant>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false)
                .build();
        try {
			writer.write(entrants);
		} catch (CsvDataTypeMismatchException e) {
			e.printStackTrace();
		} catch (CsvRequiredFieldEmptyException e) {
			e.printStackTrace();
		}
        
	}
	
}
