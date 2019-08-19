package hansol.springelasticsearch.repository;

import hansol.springelasticsearch.model.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import java.util.List;

public interface PhoneRepository extends ElasticsearchCrudRepository<Phone, Integer> {
    Page<Phone> findByAuthor(String author, Pageable pageable);
    List<Phone> findByNumber(String number);
}
