package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "activation_codes")
@NoArgsConstructor
@AllArgsConstructor

public class ActivationCode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "activation_codes")
	private String activationCode;
	
	@Column(name = "is_confirmed")
	private boolean isComfirmed;
	
	@Column(name = "confirm_date", columnDefinition = "Date Default CURRENT_DATE")
	private Date confirmDate;
}
