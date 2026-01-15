package com.mfs.Emailverification.Service;

import com.mfs.Emailverification.Entity.ConfirmationToken;
import com.mfs.Emailverification.Entity.User;
import com.mfs.Emailverification.Repository.ConfirmationTokenRepository;
import com.mfs.Emailverification.Repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final EmailService emailService;

    public UserServiceImpl(UserRepository userRepository, ConfirmationTokenRepository confirmationTokenRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.confirmationTokenRepository = confirmationTokenRepository;
        this.emailService = emailService;
    }

    @Override
    public ResponseEntity<?> saveUser(User user) {

        if (userRepository.existsByUserEmail(user.getUserEmail())) {
            return ResponseEntity.badRequest().body("Error: Email is already in use!");
        }

        // User must be disabled until email verification
        user.setEnabled(false);
        userRepository.save(user);

        ConfirmationToken confirmationToken = new ConfirmationToken(user);
        confirmationTokenRepository.save(confirmationToken);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getUserEmail());
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setText("To confirm your account, please click here : " + "http://localhost:8085/confirm-account?token=" + confirmationToken.getConfirmationToken());
        emailService.sendEmail(mailMessage);
        return ResponseEntity.ok("Verify email by the link sent to your email address");
    }

    @Override
    public ResponseEntity<?> confirmEmail(String confirmationToken) {

        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if (token == null) {
            return ResponseEntity.badRequest().body("Invalid token");
        }

        if (token.getExpiryDate().before(new Date())) {
            return ResponseEntity.badRequest().body("Token expired");
        }

        User user = token.getUser();
        user.setEnabled(true);
        userRepository.save(user);
        confirmationTokenRepository.delete(token);
        return ResponseEntity.ok("Email verified successfully!");
    }
}
