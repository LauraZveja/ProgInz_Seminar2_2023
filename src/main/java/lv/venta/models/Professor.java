package lv.venta.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "professor_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Professor {
	
	
	//TODO uzlikt Data JPA anotācijas
	//TODO uzlikt atbilstošās validāciju anotācijas
	//TODO izveidot Student, Course, Grade
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Idp")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idp;
	
	@Column(name = "Name")
	@Size(min = 3, max =15)
	@NotNull
	@Pattern(regexp = "[A-ZĒŪĻĶ]{1}[a-zēūļķ]+", message = "Pirmajam burtam jābūt lielajam")
	private String name;
	
	@Column(name = "Surname")
	@Pattern(regexp = "[A-ZĒŪĻĶ]{1}[a-zēūļķ]+", message = "Pirmajam burtam jābūt lielajam")
	@NotNull
	private String surname;
	
	@Column(name = "Degree")
	@NotBlank
	private Degree degree;
	
	@OneToOne(mappedBy = "professor") // sasaiste ar mainīgo
	private Course course;

	public Professor(String name, String surname, Degree degree) {
		
		this.name = name;
		this.surname = surname;
		this.degree = degree;
	}
	
	
	

}
