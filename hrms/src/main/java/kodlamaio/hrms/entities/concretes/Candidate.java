package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="candidates")
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name="user_id" ,referencedColumnName = "id")
public class Candidate extends User{

	@Column(name="first_name")
	private String FirstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="identity_number")
	private String identityNumber;
	
	@Column(name = "birth_of_date")
	private LocalDate dateOfBirth;
}
