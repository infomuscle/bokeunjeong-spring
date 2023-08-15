package com.bokeunjeong.portfolio.service;

import com.bokeunjeong.portfolio.model.dto.EmailDto;
import com.bokeunjeong.portfolio.model.dto.PortfolioResponse;
import com.bokeunjeong.portfolio.model.dto.ProjectResult;
import com.bokeunjeong.portfolio.repository.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PortfolioApiServiceImpl implements PortfolioApiService {

    private final ResourceLoader resourceLoader;
    private final PortfolioRepository portfolioRepository;
    private final JavaMailSender javaMailSender;

    public PortfolioResponse getPortfolio() {
        PortfolioResponse response = new PortfolioResponse();
        response.setIntroductions(portfolioRepository.findIntroductions());
        response.setLinks(portfolioRepository.findLinks());
        response.setProjects(new ProjectResult(portfolioRepository.findProjets()));
        response.setSkills(portfolioRepository.findSkills());
        response.setContacts(portfolioRepository.findContacts());

        return response;
    }

    public Resource getPortfolioResume() {
        Resource resource = resourceLoader.getResource("classpath:static/resume_bokeunjeong.pdf");
        if (resource.exists()) {
            return resource;
        }

        throw new RuntimeException("Cannt find file.");
    }

    @Override
    public void sendEmail(EmailDto emailDto) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(emailDto.getEmail());
        mailMessage.setTo("infomuscle10@gmail.com");
        mailMessage.setSubject(String.format("[bokeunjeong.com] %s", emailDto.getSubject()));

        StringBuilder sb = new StringBuilder();
        sb.append("발신인: ").append("\n").append(emailDto.getName()).append(" / ").append(emailDto.getEmail());
        sb.append("\n\n");
        sb.append("내용: ").append("\n").append(emailDto.getMessage());
        mailMessage.setText(sb.toString());

        javaMailSender.send(mailMessage);
    }
}
