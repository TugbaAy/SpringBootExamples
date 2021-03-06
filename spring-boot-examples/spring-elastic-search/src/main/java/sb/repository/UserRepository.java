package sb.repository;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import sb.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends ElasticsearchRepository<User,String> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    List<User> getByCustomSearching(String searchingVal);

    List<User> findAllByNameLikeOrSurnameLike(String name, String surname);
}
