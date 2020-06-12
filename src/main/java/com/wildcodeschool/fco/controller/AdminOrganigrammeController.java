package com.wildcodeschool.fco.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wildcodeschool.fco.entity.Staff;
import com.wildcodeschool.fco.repository.ClientRepository;
import com.wildcodeschool.fco.repository.MessageRepository;
import com.wildcodeschool.fco.repository.StaffRepository;
import com.wildcodeschool.fco.service.FileUpload;

@Controller
public class AdminOrganigrammeController {
	

  @Autowired
  private ClientRepository clientRepository;

	private String DIR = "photoStaff";

	@Autowired
	private FileUpload fileUpload;
	
	@Autowired
	private StaffRepository staffRepository;
	
	@Autowired
	private MessageRepository messageRepository;
	
	
	@GetMapping("/admin/staff")
	public String toAdminOrganigrammePage(Model model) {
		model.addAttribute("orderCount", clientRepository.findByIsValid(false).size()); 
		model.addAttribute("messageCount", messageRepository.count());
		model.addAttribute("staff", staffRepository.findAll());
		return "AdminOrganigramme";
	}
	
	@GetMapping("/admin/staff/update")
	public String toUpdateOrganigramme(Model model, @RequestParam(required = false) Integer id) {
        Staff staff = new Staff();
        if (id != null) {
        	Optional<Staff> optionalStaff = staffRepository.findById(id);
        	if (optionalStaff.isPresent()) {
        		staff = optionalStaff.get();
        	}
        }
        model.addAttribute("orderCount", clientRepository.findByIsValid(false).size()); 
        model.addAttribute("messageCount", messageRepository.count());
        model.addAttribute("staff", staff);
		return "AdminOrganigrammeUpdate";
	}
	
	@PostMapping("/admin/staff/update")
	public String postOrganigramme(
			RedirectAttributes redirAttrs,
			@RequestParam ("id") Integer id,
			@RequestParam ("firstname") String firstname,
			@RequestParam ("lastname") String lastname,
			@RequestParam ("fonction") String fonction,
			@RequestParam ("category") String category,
			@RequestParam ("description") String description,
			@RequestParam (name = "picture", required = false) MultipartFile imageFile
			) {
		String path = "";
		if (id != null) {
			path = staffRepository.findById(id).get().getPicture();
		}
		if (!imageFile.isEmpty()) {
			String fileName = "staff_" + lastname;
			path = fileUpload.writeFile(imageFile, DIR, fileName);
		}
		Staff staff = new Staff(id, firstname, lastname, fonction, category, path, description);
		staffRepository.save(staff);
		if (id != null) {
			redirAttrs.addFlashAttribute("successMessage", "Le membre a bien été modifié.");
		} else {
			redirAttrs.addFlashAttribute("successMessage", "Le membre a bien été ajouté.");
		}
		return "redirect:/admin/staff";
	}
	
	@GetMapping("/admin/staff/delete{id}")
	public String deleteStaff(RedirectAttributes redirAttrs, @PathVariable Integer id) {
		Staff staffToDelete = staffRepository.findById(id).get();
		fileUpload.deleteFile(staffToDelete.getPicture());
		staffRepository.delete(staffToDelete);
		redirAttrs.addFlashAttribute("successMessage", "Le membre a bien été supprimé.");
		return "redirect:/admin/staff";
	}
}
