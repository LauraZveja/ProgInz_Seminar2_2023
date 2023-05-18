package lv.venta.models;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	
	@OneToOne
	@JoinColumn(name = "Idp") //sasaiste ar otras klases PK, tāpēc lielais burts
	private Professor professor;
	
	@OneToMany(mappedBy = "course") //mapē uz mainīgo
	private Collection<Grade> grades;
	
	//TODO jāizveido konstruktors, kad būs saite starp profesoru un kursu
	

}
