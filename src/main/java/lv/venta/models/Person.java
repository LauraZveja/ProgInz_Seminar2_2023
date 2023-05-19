package lv.venta.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//Šī klase nebūs datubāzē, no šīs mantos
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Person {
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Idpe")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idpe;
	
	@Column(name = "Name")
	@Size(min = 3, max =15)
	@NotNull
	@Pattern(regexp = "[A-ZĒŪĻĶ]{1}[a-zēūļķ]+", message = "Pirmajam burtam jābūt lielajam")
	private String name;
	
	@Column(name = "Surname")
	@Pattern(regexp = "[A-ZĒŪĻĶ]{1}[a-zēūļķ]+", message = "Pirmajam burtam jābūt lielajam")
	@NotNull
	private String surname;

	public Person(
			@Size(min = 3, max = 15) @NotNull @Pattern(regexp = "[A-ZĒŪĻĶ]{1}[a-zēūļķ]+", message = "Pirmajam burtam jābūt lielajam") String name,
			@Pattern(regexp = "[A-ZĒŪĻĶ]{1}[a-zēūļķ]+", message = "Pirmajam burtam jābūt lielajam") @NotNull String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}
	
	
	

}
