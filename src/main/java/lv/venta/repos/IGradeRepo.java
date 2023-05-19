package lv.venta.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.models.Grade;

public interface IGradeRepo extends CrudRepository<Grade, Long>{
	
	//TODO atlasīt visu studentu atzīmes, ja zināms studentu id
	ArrayList<Grade> findByStudentIds(long ids);
	
	//TODO atlasīt visa kursa atzīmes, ja ir zināms kursa nosaukums. 
	//Uztaisīsies select, kas apvieno divas tabulas
	ArrayList<Grade> findByCourseTitle(String title);

}
