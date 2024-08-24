package com.kh.laptopshop.controller.admin;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.laptopshop.domain.Roles;
import com.kh.laptopshop.domain.User;
import com.kh.laptopshop.service.UploadService;
import com.kh.laptopshop.service.UserService;

import jakarta.validation.Valid;

@Controller
public class UserController {

  private final UserService userService;

  private final UploadService uploadService;

  private final PasswordEncoder passwordEncoder;

  public UserController(
      UserService userService,
      UploadService uploadService,
      PasswordEncoder passwordEncoder) {
    this.userService = userService;
    this.uploadService = uploadService;
    this.passwordEncoder = passwordEncoder;
  }

  @RequestMapping("/")
  public String home(Model model) {
    return "Home";
  }

  @RequestMapping("/admin/user")
  public String getUserPage(Model model) {
    List<User> users = this.userService.getAllUsers();
    model.addAttribute("users", users);
    return "admin/user/table-user";
  }

  @RequestMapping("/admin/user/{id}")
  public String getUserDetailPage(Model model, @PathVariable Long id) {
    User user = this.userService.getUserById(id);
    model.addAttribute("user", user);
    model.addAttribute("id", id);
    return "admin/user/user-detail";
  }

  @RequestMapping("/admin/user/create")
  public String getCreateUserPage(Model model) {
    model.addAttribute("newUser", new User());
    return "admin/user/create";
  }

  @PostMapping("/admin/user/create")
  public String createUserPage(
      Model model,
      @ModelAttribute("newUser") @Valid User user, BindingResult newUserBindingResult,
      @RequestParam("AvatarFiles") MultipartFile file) {

    // List<FieldError> errors = newUserBindingResult.getFieldErrors();
    // for (FieldError error : errors) {
    // System.out.println(">>>>>" + error.getField() + " " +
    // error.getDefaultMessage());
    // }

    // Validate

    if (newUserBindingResult.hasErrors()) {
      // ko redirect de giu gia tri tai input
      return "/admin/user/create";
    }

    String avatar = this.uploadService.handleSaveUploadFile(file, "avatar");
    String hashPassword = this.passwordEncoder.encode(user.getPassword());

    user.setAvatar(avatar);
    user.setPassword(hashPassword);
    user.setRole(this.userService.getRoleByName(user.getRole().getName()));
    // save
    userService.handleSaveUser(user);
    return "redirect:/admin/user";
  }

  @GetMapping("/admin/user/update/{id}")
  public String getUpdateUserPage(Model model, @PathVariable Long id) {
    model.addAttribute("id", id);
    User currentUser = this.userService.getUserById(id);
    model.addAttribute("newUser", currentUser);
    return "admin/user/update";
  }

  @PostMapping("/admin/user/update") // get
  public String postUpdateUser(Model model, @ModelAttribute("newUser") User user) {
    User currentUser = this.userService.getUserById(user.getId());
    if (currentUser != null) {
      currentUser.setAddress(user.getAddress());
      currentUser.setFullName(user.getFullName());
      currentUser.setPhone(user.getPhone());

      this.userService.handleSaveUser(currentUser);
    }

    return "redirect:/admin/user";
  }

  @GetMapping("/admin/user/delete/{id}")
  public String getDeleteUserPage(Model model, @PathVariable Long id) {
    User currentUser = this.userService.getUserById(id);
    model.addAttribute("newUser", currentUser);
    return "/admin/user/delete";
  }

  @PostMapping("/admin/user/delete")
  public String DeleteUserPage(Model model, @ModelAttribute("newUser") User user) {
    this.userService.deleteUserById(user.getId());
    return "redirect:/admin/user";
  }
}
