package com.career.platform;

import com.career.platform.entity.Appointment;
import com.career.platform.entity.CareerResource;
import com.career.platform.repository.AppointmentRepository;
import com.career.platform.repository.CareerResourceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatformApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(CareerResourceRepository repository, AppointmentRepository appointmentRepository) {
        return args -> {
            // Check if seeding is needed (e.g., if we don't have enough entries or specific ones)
            if (repository.count() < 10) { 
                // Clear and re-seed to ensure all new items are present
                repository.deleteAll();
                
                repository.save(CareerResource.builder()
                        .title("Full Stack Developer")
                        .category("Tech")
                        .description("Master front-end and back-end development with React and Spring Boot.")
                        .rating(4.8)
                        .link("https://roadmap.sh/full-stack")
                        .build());

                repository.save(CareerResource.builder()
                        .title("UX/UI Designer")
                        .category("Design")
                        .description("Learn the art of creating user-centric digital experiences.")
                        .rating(4.9)
                        .link("https://roadmap.sh/ux-design")
                        .build());

                repository.save(CareerResource.builder()
                        .title("Data Scientist")
                        .category("Tech")
                        .description("Harness the power of data to derive meaningful insights.")
                        .rating(4.7)
                        .link("https://roadmap.sh/data-scientist")
                        .build());

                repository.save(CareerResource.builder()
                        .title("Marketing Strategist")
                        .category("Business")
                        .description("Develop campaigns that captivate and convert audiences.")
                        .rating(4.6)
                        .link("https://roadmap.sh/content-marketing")
                        .build());
                        
                repository.save(CareerResource.builder()
                        .title("Cloud Architect")
                        .category("Tech")
                        .description("Design and manage scalable cloud infrastructure.")
                        .rating(4.8)
                        .link("https://roadmap.sh/cloud-architect")
                        .build());

                repository.save(CareerResource.builder()
                        .title("Android Developer")
                        .category("Tech")
                        .description("Build beautiful, high-performance apps for the Android platform using Kotlin.")
                        .rating(4.7)
                        .link("https://roadmap.sh/android")
                        .build());

                repository.save(CareerResource.builder()
                        .title("Cyber Security Analyst")
                        .category("Tech")
                        .description("Protect systems and networks from digital attacks and data breaches.")
                        .rating(4.9)
                        .link("https://roadmap.sh/cyber-security")
                        .build());

                repository.save(CareerResource.builder()
                        .title("Product Manager")
                        .category("Business")
                        .description("Lead the development and launch of successful products through market research.")
                        .rating(4.5)
                        .link("https://roadmap.sh/product-management")
                        .build());

                repository.save(CareerResource.builder()
                        .title("DevOps Engineer")
                        .category("Tech")
                        .description("Bridge the gap between development and operations through automation.")
                        .rating(4.8)
                        .link("https://roadmap.sh/devops")
                        .build());

                repository.save(CareerResource.builder()
                        .title("Java Spring Boot Course")
                        .category("Learning")
                        .description("Comprehensive guide to building enterprise applications with Spring Boot.")
                        .rating(4.9)
                        .link("https://spring.io/projects/spring-boot")
                        .build());

                repository.save(CareerResource.builder()
                        .title("Python for Data Science")
                        .category("Learning")
                        .description("Master Python for data analysis, visualization, and machine learning.")
                        .rating(4.8)
                        .link("https://www.coursera.org/specializations/python-3-programming")
                        .build());

                repository.save(CareerResource.builder()
                        .title("Figma UI/UX Mastery")
                        .category("Materials")
                        .description("Design stunning user interfaces and prototypes using Figma.")
                        .rating(4.9)
                        .link("https://www.figma.com/resources/")
                        .build());

                repository.save(CareerResource.builder()
                        .title("AWS Cloud Essentials")
                        .category("Learning")
                        .description("Foundational knowledge of Amazon Web Services and cloud computing.")
                        .rating(4.7)
                        .link("https://aws.amazon.com/training/essentials/")
                        .build());
            }

            if (appointmentRepository.count() == 0) {
                appointmentRepository.save(Appointment.builder()
                        .studentId(1L)
                        .counselorName("Dr. Sarah Wilson")
                        .topic("Career Strategy Review")
                        .date("2026-04-15")
                        .time("10:00 AM")
                        .status("SCHEDULED")
                        .build());

                appointmentRepository.save(Appointment.builder()
                        .studentId(1L)
                        .counselorName("Mr. James Chen")
                        .topic("Mock Interview - Tech")
                        .date("2026-04-18")
                        .time("02:30 PM")
                        .status("SCHEDULED")
                        .build());
            }
        };
    }
}
