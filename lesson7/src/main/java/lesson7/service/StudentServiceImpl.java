package lesson7.service;

import lesson7.domain.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lesson7.repository.StudentJpaDao;

import java.util.List;

//3. Создать репозиторий для вставки, удаления, изменения и просмотра студентов.
@Service
public class StudentServiceImpl {

    StudentJpaDao studentJpaDao;
    public StudentServiceImpl(StudentJpaDao studentJpaDao) {
        this.studentJpaDao = studentJpaDao;
    }

    @Transactional
    public void saveAndSet(Student student){
        studentJpaDao.save(student);
    }

    @Transactional(readOnly = true)
    public Student findById(Integer id){
        return studentJpaDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Student> findAll(){
        return studentJpaDao.findAll();
    }

    @Transactional
    public void delete(Student student){
        studentJpaDao.delete(student);
    }

    @Transactional
    public void deleteById(Integer id){
        studentJpaDao.deleteById(id);
    }

    @Transactional
    public void updateAge(Integer id, Integer age){
        Student student = studentJpaDao.findById(id).orElse(null);
        student.setAge(age);
        studentJpaDao.save(student);
    }

    @Transactional
    public void updateName(Integer id, String name){
        Student student = studentJpaDao.findById(id).orElse(null);
        student.setName(name);
        studentJpaDao.save(student);
    }
    
}
