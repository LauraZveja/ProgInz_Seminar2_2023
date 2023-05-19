package lv.venta.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "grade_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Grade {
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Idg")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idg;
	
	
	@Column(name = "GradeValue")
	@Min(value = 0)
	@Max(value = 10)
	private int gradeValue;
	
	@ManyToOne
	@JoinColumn(name = "Idpe")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "Idc") //otrās klases primary key
	private Course course;

	public Grade(@Min(0) @Max(10) int gradeValue, Student student, Course course) {
		
		this.gradeValue = gradeValue;
		this.student = student;
		this.course = course;
	}
	
	

}
