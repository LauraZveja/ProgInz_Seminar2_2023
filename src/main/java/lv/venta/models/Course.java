package lv.venta.models;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "course_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Idc")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idc;
	
	@Column(name = "Title")
	@Size(min = 3, max =25)
	@NotNull
	@Pattern(regexp = "[A-ZĒŪĻĶ]{1}[a-zēūļķ]+", message = "Pirmajam burtam jābūt lielajam")
	private String title;
	
	@Column(name = "CreditPoints")
	@NotNull
	@Min(value = 1)
	@Max(value = 20)
	private int creditPoints;
	
	@ManyToMany
	@ToString.Exclude
	@JoinTable(name = "course_prof_table", 
	joinColumns = @JoinColumn(name="Idp"),
	inverseJoinColumns = @JoinColumn(name="Idc"))
	private Collection<Professor> professors = new ArrayList<>();
	
	@OneToMany(mappedBy = "course") //mapē uz mainīgo
	@ToString.Exclude
	private Collection<Grade> grades;

	public Course(
			@Size(min = 3, max = 25) @NotNull @Pattern(regexp = "[A-ZĒŪĻĶ]{1}[a-zēūļķ]+", message = "Pirmajam burtam jābūt lielajam") String title,
			@NotNull @Min(1) @Max(20) int creditPoints, ArrayList<Professor> professors) {
		
		this.title = title;
		this.creditPoints = creditPoints;
		this.professors = professors;
	}
	
	
	public void addProfessor(Professor inputProfessor) {
		if(!professors.contains(inputProfessor)) {
			professors.add(inputProfessor);
		}
		
		//TODO, izveidot dzēšanas funkciju
		
		
		
	}
	
	

}
