package tn.iteam.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Builder
@Setter @Getter
@NoArgsConstructor  @AllArgsConstructor
public class Customer {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;
     private String firstName;
     private String lastEmail;
     private String email;
}
