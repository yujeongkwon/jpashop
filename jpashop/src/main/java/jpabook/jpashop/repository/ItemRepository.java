package jpabook.jpashop.repository;
import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    //식별자 값이 없으면( null ) 새로운 엔티티로 판단해서 영속화(persist)하고
    //식별자가 있으면 병합(merge)
    //지금처럼 준영속 상태인 상품 엔티티를 수정할 때는 id 값이 있으므로 병합 수행
    public void save(Item item) { //신규데이터 저장뿐만아니라 변경데이터저장 포함
        if (item.getId() == null) {
            em.persist(item);
        } else {
            em.merge(item);
        }
    } // 오히려 실무에서 귀찮 : 실무에선 보통 변경가능한 데이터만 노출
        // 병합은 다 변경해서 번거로움
    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i",Item.class).getResultList();
    }
}