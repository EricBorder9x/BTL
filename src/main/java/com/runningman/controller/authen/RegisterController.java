package com.runningman.controller.authen;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.runningman.model.RoleDTO;
import com.runningman.model.UserDTO;
import com.runningman.service.RoleService;
import com.runningman.service.UserService;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private MailSender mailSender;
    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/register")
    public String register() {
        return "authen/register";
    }

    @PostMapping(value = "/register")
    public String userCreate(HttpServletRequest request, @RequestParam(name = "email") String email,
            @RequestParam(name = "fullName", required = false) String userName,
            @RequestParam(name = "gender") boolean sex, @RequestParam(name = "phone") String phone,
            @RequestParam(name = "address") String address, @RequestParam(name = "roleId") long roleId,
            @RequestParam(name = "password") String password, @RequestParam(name = "repassword") String repassword,
             MultipartFile avatarFile) throws IOException {

        if (userService.findByEmail(email) != null) {

            request.setAttribute("message", "Email đã tồn tại!");
            return "authen/register";
        } else {

            UserDTO userDTO = new UserDTO();
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setRoleId(roleId);

            userDTO.setEmail(email);
            userDTO.setUserName(userName);
            userDTO.setSex(sex);
            userDTO.setPhone(phone);
            userDTO.setAddress(address);
            userDTO.setRoleDTO(roleDTO);
            userDTO.setVerify(true);
            

            if (password.equals(repassword)) {
                userDTO.setPassword(new BCryptPasswordEncoder().encode(repassword));

                userService.insert(userDTO, null);
                return "authen/login";
            } else {
                request.setAttribute("message", "Mật khẩu không khớp!");
                request.setAttribute("roles", roleService.findAll());
                return "authen/register";
            }
        }

    }

//    @GetMapping(value = "/resend-code")
//    public String resendCode(HttpSession session, HttpServletRequest request) {
//        String code = randomString(8);
//        String email = (String) session.getAttribute("emailRegister");
//        sendEmail("hieuheo2310@gmail.com", email, "Chao mung ban den voi 3T SPORT EQUIPMENTS!",
//                "Xin chao, " + email.split("@")[0] + "! Vui long xac nhan rang ban la nguoi da tao tai khoan nay!" + " Ma xac nhan cua ban la: " + code);
//        request.setAttribute("resend", "resend");
//        session.setAttribute("codeVerify", code);
//        return "authen/verify";
//    }
//
//    @PostMapping(value = "/verify")
//    public String verify(HttpServletRequest request, HttpSession session) {
//        String code = request.getParameter("code");
//        String codeVerify = (String) session.getAttribute("codeVerify");
//        if (!code.equals(codeVerify)) {
//            request.setAttribute("verifyFail", "Code không đúng, Vui lòng thử lại!");
//        } else {
//            String email = (String) session.getAttribute("emailRegister");
//            UserDTO userDTO = userService.findByEmail(email);
//            userDTO.setVerify(true);
//            request.setAttribute("verifySuccess", "Xác thực thành công!");
//            request.setAttribute("active", "active");
//            userService.update(userDTO, null);
//        }
//        return "authen/verify";
//    }
//
//    public void sendEmail(String from, String to, String subject, String content) {
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailMessage.setFrom(from);
//        mailMessage.setTo(to);
//        mailMessage.setSubject(subject);
//        mailMessage.setText(content);
//
//        mailSender.send(mailMessage);
//    }
//
//    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
//    static SecureRandom rnd = new SecureRandom();
//
//    String randomString(int len) {
//        StringBuilder sb = new StringBuilder(len);
//        for (int i = 0; i < len; i++) {
//            sb.append(AB.charAt(rnd.nextInt(AB.length())));
//        }
//        return sb.toString();
//    }

}
