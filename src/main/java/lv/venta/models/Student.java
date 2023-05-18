package lv.venta.models;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

@Table(name = "student_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student {
	
	
	//TODO uzlikt Data JPA anotācijas
	//TODO uzlikt atbilstošās validāciju anotācijas
	//TODO izveidot Student, Course, Grade
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Ids")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ids;
	
	@Column(name = "Name")
	@Size(min = 3, max =15)
	@NotNull
	@Pattern(regexp = "[A-ZĒŪĻĶ]{1}[a-zēūļķ]+", message = "Pirmajam burtam jābūt lielajam")
	private String name;
	
	@Column(name = "Surname")
	@Pattern(regexp = "[A-ZĒŪĻĶ]{1}[a-zēūļķ]+", message = "Pirmajam burtam jābūt lielajam")
	@NotNull
	private String surname;
	
	@Column(name = "Programme")
	@NotBlank
	private Programme programme;
	
	
	@OneToMany(mappedBy = "student") //mapē uz mainīgo
	@ToString.Exclude
	private Collection<Grade> grades;

	public Student(String name, String surname, Programme programme) {
		
		this.name = name;
		this.surname = surname;
		this.programme = programme;
	}
	
	
	

}
